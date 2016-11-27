package mla

trait Symbol
final case class Diamond() extends Symbol
final case class Circle() extends Symbol
final case class Equals() extends Symbol
final case class Plus() extends Symbol
final case class Dots() extends Symbol
final case class Hash() extends Symbol
final case class Squiggles() extends Symbol
final case class Asterisk() extends Symbol


object Symbol {
  val list = List(
    Diamond(),
    Circle(),
    Equals(),
    Plus(),
    Dots(),
    Hash(),
    Squiggles(),
    Asterisk())
}