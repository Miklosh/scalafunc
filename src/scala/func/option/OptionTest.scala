package scala.func.option

import javax.management.remote.rmi._RMIConnection_Stub

object OptionTest {

  val user = User(3, "Kolya", "Mimimi", 48, None)

  def getUserGender(user: User): Any = user.gender match {
    case Some(gender) => println("Gender: " + gender)
    case None => println("kokoko")
  }

  def getOptionValue(a: Option[Int]): Int = a match {
    case Some(x) => x
    case None => 0
  }


  def main(args: Array[String]) = {
    println("Gender: " + user.gender.getOrElse("Not specified.")) // getOtElse method is evaluated only when value that its checking is None
    // getOrElse - evaluation by value

    getUserGender(user)

    // another case matching implementation
    val gender = user.gender match {
      case Some(gender) => gender
      case None => "not specified"
    }
    println(gender)

    UserRepository.findById(2).foreach(user => println(user.firstName))

    val age = UserRepository.findById(1).map(_.age)

    println(age)

    // some flatMap function training
    val list: List[List[String]] = List(List("a"),List("b"), List("c"))
    println(list.map((x: List[String])=> x.map(y => y.toUpperCase)))
    println(list.flatMap(x => x.map(_.toUpperCase)))

    val optionList: List[Option[String]] = List(Some("ololo"), None, Some("mimi"))

    println(optionList.flatMap(x => x.map(_.toUpperCase)))

    val result = getOptionValue(Option(1)) + getOptionValue(Option(2)) + getOptionValue(Option(3))
    println("Result: " + result)

    val foldList = List(1,2,3,4,5)

//    println(foldList.foldRight("")((x,y) => x+y))

    val forGender = for {
      user <- UserRepository.findById(1)
      gender <- user.gender
    } yield gender

    println("forGender: "+forGender)

    // rich option
//    println(Option(1)+Option(2)+Option(3))


//      Option(1).
//    val a = List(Option(1), Option(2), Option(2),Option(3)).reduceLeft(_.)

//    println("AAA: "+a)

//    def sumOptsFoldRight = (entities:List[Option[Double]]) =>
//      entities.foldRight(
//        Some(0.0):Option[Double])((accOpt,xOpt) => xOpt match {
//        case None => None
//        case Some(xVal) => accOpt.map(xVal + _)
//      })

    val ll = List(Option(1), Option(2), Option(2),Option(3)).flatten.sum

    println("ll: "+ll)

  }




//  implicit class RichOption(self: Option[Int]){
//    def +(that: Option[Int]): Option[Int] = for {
//      a <-self
//      b <-that
//    } yield a+b
//  }

}
