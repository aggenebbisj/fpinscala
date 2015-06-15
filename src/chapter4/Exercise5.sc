package chapter4

object Exercise5 {
  // Exercise 5
  def sequence[A](a: List[Option[A]]): Option[List[A]] =
    if (a contains None) None
    else Some(a map (_ match { case Some(x) => x }))
                                                  //> sequence: [A](a: List[Option[A]])Option[List[A]]
  
	val l1 = List(Some(4), Some(3), Some(2))  //> l1  : List[Some[Int]] = List(Some(4), Some(3), Some(2))
	val l2 = List(Some(4), None, Some(2))     //> l2  : List[Option[Int]] = List(Some(4), None, Some(2))
	
	sequence(l1)                              //> res0: Option[List[Int]] = Some(List(4, 3, 2))
	sequence(l2)                              //> res1: Option[List[Int]] = None
	
	// Exercise 6
	def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = sequence(a map f)
                                                  //> traverse: [A, B](a: List[A])(f: A => Option[B])Option[List[B]]
	
	val l3 = List(1,2,3)                      //> l3  : List[Int] = List(1, 2, 3)
	
	traverse(l3)(x => Some(x))                //> res2: Option[List[Int]] = Some(List(1, 2, 3))
	
	def traverse2[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
		Some(a flatMap (x => f(x) match {
			case Some(v) => List(v)
			case None    => List()
		}))
	}                                         //> traverse2: [A, B](a: List[A])(f: A => Option[B])Option[List[B]]
	
	traverse2(l3)(x => Some(x))               //> res3: Option[List[Int]] = Some(List(1, 2, 3))
	
	def sequence2[A](a: List[Option[A]]): Option[List[A]] = {
		def loop(a: List[Option[A]], res: List[A]): Option[List[A]] = a match {
			case Nil           => Some(res)
			case None    :: xs => None
			case Some(x) :: xs => loop(xs, res :+ x)
		}
		
		loop(a, List())
	}                                         //> sequence2: [A](a: List[Option[A]])Option[List[A]]
	
	sequence2(l1)                             //> res4: Option[List[Int]] = Some(List(4, 3, 2))
	sequence2(l2)                             //> res5: Option[List[Int]] = None
	
	def sequence3[A](a: List[Option[A]]): Option[List[A]] = {
		a.foldRight( Some(Nil): Option[List[A]] )( (optA, optB) => (optA, optB) match {
			case (_, None)           => return None // early termination
			case (None, _)           => return None
			case (Some(x), Some(xs)) => Some(x :: xs)
		})
	}                                         //> sequence3: [A](a: List[Option[A]])Option[List[A]]
	
	sequence3(l1)                             //> res6: Option[List[Int]] = Some(List(4, 3, 2))
	sequence3(l2)                             //> res7: Option[List[Int]] = None
	
}