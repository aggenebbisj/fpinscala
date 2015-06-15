package chapter4

object Exercise1 {
  val a = MyOption(4)                             //> a  : Product with Serializable with chapter4.MyOption[Int] = MySome(4)
  val b = MyOption(null)                          //> b  : Product with Serializable with chapter4.MyOption[Null] = MyNone
  val c = MyOption(5)                             //> c  : Product with Serializable with chapter4.MyOption[Int] = MySome(5)
  
  val f: Int => Int = _ * 2                       //> f  : Int => Int = <function1>
  val f2: Int => MyOption[Int] = x => MyOption(x * 3)
                                                  //> f2  : Int => chapter4.MyOption[Int] = <function1>
  
  a map f                                         //> res0: chapter4.MyOption[Int] = MySome(8)
  
  a flatMap f2                                    //> res1: chapter4.MyOption[Int] = MySome(12)
  a flatMap2 f2                                   //> res2: chapter4.MyOption[Int] = MySome(12)
   
  a orElse c                                      //> res3: chapter4.MyOption[Int] = MySome(4)
  b orElse c                                      //> res4: chapter4.MyOption[Any] = MySome(5)
  
  a filter (_ > 3)                                //> res5: chapter4.MyOption[Int] = MySome(4)
  a filter (_ < 3)                                //> res6: chapter4.MyOption[Int] = MyNone
  
 
  
}