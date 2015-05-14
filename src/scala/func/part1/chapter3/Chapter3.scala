package scala.func.part1.chapter3

/**
 * Created by mykola.kozhemiaka on 12.05.2015.
 */
object Chapter3 {

//  List[Double] = Nil
//  List[Double] = Cons(1.2,Nil)
//  List[Int] = List(1,Nil)
//  List[String] = List("a",List("b",List("c")))

  def product(l: List[Double]): Double = l match {
    case Nil => 0.0
    case List(0.0, _) => 0.0
    case x::xs => x * product(xs)
  }

  val list1 = List(1,2,3,4)

  def getFirst(a: List[Int]): Int = a match {
    case x::xs => x
  }

  def getAllExceptFirst(a: List[Int]): List[Int] = a match {
    case x::xs => xs
  }

  val x = List(1,2,3,4,5) match {
//    case List(x, List(2, List(4, _))) => x
    case Nil=>42
//    case 1::2::x::y => x+y
//    case List(x, List(y, List(3, List(4, _)))) => x + y
//    case List(h, t) => h + sum(t)
    case _ => 101
  }

  def main (args: Array[String]) {
    println(getFirst(list1))
    println(getAllExceptFirst(list1))
    println(x)
  }



}
