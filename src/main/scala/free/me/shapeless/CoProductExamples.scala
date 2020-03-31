package free.me.shapeless
import shapeless.{:+:, CNil, Generic, Inl}
object CoProductExamples extends App {
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color
  type ColorT = Red.type :+: Green.type :+: Blue.type :+: CNil
  val red: ColorT = Inl(Red)
  println(red.c)
  sealed trait Shape
  case class Rectangle(w: Double, h: Double) extends Shape
  case class Circle(r: Double) extends Shape
  val gen = Generic[Shape]
  val x = gen.to(Rectangle(3.0, 4.0))
  println(x)
  val y = gen.to(Circle(3.0))
  println(y)
}
