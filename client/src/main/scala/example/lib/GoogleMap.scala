package example.lib

import org.scalajs.dom.raw.Element

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("google.maps.Map")
class GoogleMap(node: Element, options: js.Dynamic = js.Dynamic.literal()) extends js.Object
