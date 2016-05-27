package example

sealed trait Page

object Page {
  case object Home extends Page
  case class Photo(id: String) extends Page
}
