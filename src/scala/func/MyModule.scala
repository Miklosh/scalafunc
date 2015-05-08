package scala.func

object MyModule {

  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def recurFact(n: Int): Int = {
    def loop(n: Int, a: Int, b: Int): Int = {
      if (n == 0) a
      else loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  def caseFact(n: Int): Int = {
    def loop(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => loop(n - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  def fib3(n: Int): Int = {
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n - 1, b, a + b)
    }
    fib_tail(n, 0, 1)
  }

  // mission: create function which will check if array is sorted

  def checkAsc(arr: Array[Int]): Boolean = {
    var result : Boolean = false
    if (arr.size > 1) {
      result = check(arr.head, arr.tail)
    } else {
      result = true
    }

    def check(a: Int, arr: Array[Int]): Boolean = {
      if (a < arr.tail(0)) {

        check(arr.head, arr.tail)
        true
      }
      else false
    }

    result
  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def iter(i: Int): Boolean = {
      if (i >= as.length - 1) true
      else !gt(as(i), as(i + 1)) && iter(i + 1)
    }
    iter(0)
  }

  def asc(a: Int, b: Int): Boolean = {
    if (a <= b) true
    else false
  }

  def sumFact(a: Int, b: Int): Int = {
    if (a > b) 0 else fact(a) + sumFact(a+1, b)
  }

  def fact(a: Int): Int = {

    if(a < 0) a
    else a + fact(a-1)

  }

  val ascArr = Array (1,7,3,4,5,6)

  //    def main(args: Array[String]) = {
  def main(args: Array[String]) = {
//    println(recurFact(5))
//    println(caseFact(5))
//    println(fib3(5))

    println(sumFact(1,5))

//    println(isSorted(ascArr, asc))

  }




}
