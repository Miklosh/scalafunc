package scala.func.part1.chapter3

/**
 * Created by mykola.kozhemiaka on 12.05.2015.
 */
object Chapter3 {

//  List[Double] = Nil
//  List[Double] = Cons(1.2,Nil)
//  List[Int] = List(1,Nil)
//  List[String] = List("a",List("b",List("c")))

//  def product(l: List[Double]): Double = l match {
//    case Nil => 0.0
//    case l.isEmpty => 0.0
//    case x::xs => x * product(xs)
//  }

  val list1 = List(1,2,3,4)

  def getFirst(a: List[Int]): Int = a match {
    case x::xs => x
  }

  def getAllExceptFirst(a: List[Int]): List[Int] = a match {
    case x::xs if xs.nonEmpty => xs
  }

  val x = List(1,2,3,4,5) match {
//    case List(x, List(2, List(4, _))) => x
    case Nil=>42
//    case 1::2::x::y => x+y
//    case List(x, List(y, List(3, List(4, _)))) => x + y
//    case List(h, t) => h + sum(t)
    case _ => 101
  }

  //carrying helps solve some issues with type interference
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] =
    as match {
      case h::t if f(h) => dropWhile(t)(f)
      case _=>as
    }

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x::xs => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match{
    case Nil=>1.0
    case x::xs => x * product(xs)
  }

  // z - for B type definition
  def foldRight[A,B](list: List[A], z: B)(f: (A, B) => B): B = list match {
    case Nil => z
    case x::xs => f(x,foldRight(xs,z)(f))
  }

  def sumWithFOldRIght(list: List[Int]): Int = {
    foldRight(list,0)(_+_)
  }

  def productWithFoldRight(list: List[Double]): Double = {
    foldRight(list,1.0)(_*_)
  }

  def length[A](list: List[A]): Int = {
    def turnIntoIntList(list: List[A]): List[Int] = {
      var c = 0
      for(a <- list) yield c+1
    }
    val a = turnIntoIntList(list)
    foldRight(a,0)(_+_)
  }

  def main (args: Array[String]) {
    println(getFirst(list1))
    println(getAllExceptFirst(list1))
    println(x)
    val sumList: List[Int] = List(1,2,3,4,5)
    println(sum(sumList))

    val list = List(1,2,3,4).map(_*2)
    println(list)

    println(sumWithFOldRIght(list))

    var randomList = List(1,4,8,45,2,"mo")

    println(length(randomList))

  }



}
