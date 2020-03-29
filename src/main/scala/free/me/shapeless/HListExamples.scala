package free.me.shapeless
import shapeless.{HNil, Poly1}
/**
 * Basic HList examples.
 */
object HListExamples {
  val simpleHList = 1 :: 1L :: "Anirudh" :: 'A' :: HNil
  // poly morphic function mapping.
  simpleHList.map(PlusOne)
  object PlusOne extends Poly1 {
    implicit def caseInt = at[Int](_ + 1)
    implicit def caseString = at[String](e => s"$e+1")
    implicit def caseChar = at[Char](e => e + 1)
    implicit def caseLong = at[Long](_ + 1)
  }
}
