package chapter4

object Test {
  val l = List(1,2,3,4)                           //> l  : List[Int] = List(1, 2, 3, 4)
  l.foldRight(0)(_ + _)                           //> res0: Int = 10
}