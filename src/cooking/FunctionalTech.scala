package cooking

/**
 * Created by mykola.kozhemiaka on 17.05.2015.
 */
object FunctionalTech {

  def main(args: Array[String]) {
    val list = List(1,2,3,4)
    val double = (i: Int) => i * 2
    val l2 = list.map(double)
    println(l2)


    val a1: Int => Boolean = i => i > 0 // verbose notation

    // implicit approach
    val addI  = (x: Int, y: Int) => x + y

    //explicit approach
    val addE : (Int, Int) => Int = (x,y) => x + y

    // explicit with curly
    val addAndMult: (Int, Int) => Int = (x,y) => {
      val a = x + y
      a * 2
    }


  }

}
