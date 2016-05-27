package example

import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object HomePage {
  val component = ReactComponentB[RouterCtl[Page]]("Menu")
    .render_P { x =>
      <.div("TODO - Home page goes here")
    }
    .build
}
