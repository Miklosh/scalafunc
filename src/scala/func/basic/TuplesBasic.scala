package scala.func.basic

/**
 * Created by mykola.kozhemiaka on 14.05.2015.
 */
object TuplesBasic {

  def main (args: Array[String]) {
    val t = (1,2,3,4)

    val firstValue = t._1

    //iterate over tuple values

    t.productIterator.foreach(i=> println(i))

    // convert to string

    println(t.toString())

    // swap elements of tuple

    val t1 = ("to you", "Hello")

    println(t1.swap)

    // a try to break

    val t3 = (1,2,3,"four")

    val sum = t3._1 + t3._2 + t3._3 + t3._4

    println(sum)
  }

}
