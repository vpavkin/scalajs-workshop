package example

import japgolly.scalajs.react.extra.router.{Redirect, Router, RouterConfigDsl, BaseUrl}
import scala.scalajs.js
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object Main extends js.JSApp {
  def main(): Unit = {
    val baseUrl = BaseUrl.fromWindowOrigin

    val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
      import dsl._

      val photoId = string("[a-z0-9]+")

      (removeTrailingSlashes
      | staticRoute(root, Page.Home)                                      ~> renderR(ctl => HomePage.component(ctl))
      | dynamicRouteCT[Page.Photo]((root / "photo" / photoId).caseClass[Page.Photo])  ~> dynRenderR((p, ctl) => <.div(s"TODO - Photo page for ${p.id} goes here"))
      )
      .notFound { x =>
        dom.console.error(s"Page not found: $x")
        redirectToPage(Page.Home)(Redirect.Replace)
      }
      .onPostRender { (prev, cur) =>
        Callback.log(s"$Page changing from $prev to $cur.")
      }
    }

    val router = Router(baseUrl, routerConfig)
    val mountNode = dom.document.getElementById("mountNode")
    router() render mountNode
  }
}
