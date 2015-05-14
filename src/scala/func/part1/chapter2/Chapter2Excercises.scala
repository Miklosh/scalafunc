package scala.func.part1.chapter2

object Chapter2Excercises {

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

  def formatResult(msg: String, n: Int, f: Int => Int) = {
    val print = "The %s of %d is %d"
    print.format(msg, n, f(n))
  }


  def fibTest(n: Int): Long = {
    def loop(iter: Int, a: Long, b: Long): Long = {
      if (iter <= 0) a
      else loop(iter - 1, b, a + b)
    }
    loop(n, 0, 1)
  }

  def isSorted[a](inputArr: Array[a], sortFunc: (a,a) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(loopArr: Array[a], max: a): Boolean = {
      if (loopArr.length < 2) {
        true
      } else if (sortFunc(max, loopArr.head)) {
        loop(loopArr.tail, loopArr.head)
      } else {
        false
      }
    }
    loop(inputArr.tail, inputArr.head)
  }

  def isSorted2[A](as: Array[A], sorted: (A, A)=> Boolean): Boolean={
    if (as.length<2) true
    else (1 until as.length).forall(i=>sorted(as(i-1), as(i)))
  }

  val arrAsc = Array(1, 2, 3, 4, 5)
  val arrDesc = Array(5, 4, 3, 2, 1)

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C = (b: B) => f(a,b)

  def curry[A,B,C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C = (a:A) => f(g(a))

  val a = (x: Double) => math.Pi / x

  def main(args: Array[String]) = {
    println(a(2.0))
//    println(isSorted(arrAsc, (a: Int, b: Int) => a < b))
//    println(isSorted2(arrAsc, (a: Int, b: Int) => a < b))
    //    println(fibTest(100))
    //    println(recurFact(5))
    //    println(caseFact(5))
    //    println(fib3(5))
    //    println(formatResult("mikoko", 15, recurFact))
  }

}
