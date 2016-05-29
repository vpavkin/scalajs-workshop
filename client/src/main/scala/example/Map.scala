package example

import example.lib.{GoogleMap, GoogleMapMarker}
import example.model.Marker
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{Callback, ReactComponentB}
import example.styles.GlobalStyles._

import scala.scalajs.js
import scalacss.ScalaCssReact._

object Map {

  val o = js.Dynamic.literal

  case class Props(markers: List[Marker], router: RouterCtl[Page])

  val component = ReactComponentB[Props]("Map")
    .render_P { x =>
      <.div(mapStyle,
        ""
      )
    }
    .componentDidMount(scope ⇒ Callback {
      val markers = scope.props.markers
      val map = new GoogleMap(
        scope.getDOMNode(), o(
          center = o(
            lat = markers.map(_.lat).sum / markers.size,
            lng = markers.map(_.lng).sum / markers.size
          ), zoom = 12
        ))
      markers.foreach(m ⇒
        new GoogleMapMarker(o(
          position = o(lat = m.lat, lng = m.lng),
          map = map,
          icon = m.img
        ))
      )
      scope.forceUpdate.runNow()
    })
    .build
}
