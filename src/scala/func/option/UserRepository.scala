package scala.func.option

object UserRepository {

  private val users = Map(1-> User(1,"John","Doe", 32, Some("male")),
  2 -> User(2, "Billy", "Rubin", 21, None))

  def findById(id: Int): Option[User] = users.get(id)

  def findAll = users.values

}
