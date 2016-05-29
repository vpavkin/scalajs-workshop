package example

import example.lib.GoogleMap
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{Callback, ReactComponentB}
import example.styles.GlobalStyles._
import scala.scalajs.js
import scalacss.ScalaCssReact._

object Map {
  val component = ReactComponentB[RouterCtl[Page]]("Map")
    .render_P { x =>
      <.div(mapStyle,
        ""
      )
    }
    .componentDidMount(c ⇒ Callback {
      new GoogleMap(c.getDOMNode(), js.Dynamic.literal(center = js.Dynamic.literal(lat = -34.397, lng = 150.644), zoom = 8))
      c.forceUpdate.runNow()
    })
    .build
}
