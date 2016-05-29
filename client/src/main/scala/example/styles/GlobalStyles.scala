package example.styles

import scala.language.postfixOps
import scalacss.mutable.StyleSheet
import scalacss.Defaults._

object GlobalStyles extends StyleSheet.Inline {

  import dsl._

  val mapStyle = style(
    width(500 px),
    height(500 px)
  )

}
