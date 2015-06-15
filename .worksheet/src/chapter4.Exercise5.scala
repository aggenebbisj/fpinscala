package chapter4

object Exercise5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(192); 
  // Exercise 5
  def sequence[A](a: List[Option[A]]): Option[List[A]] =
    if (a contains None) None
    else Some(a map (_ match { case Some(x) => x }));System.out.println("""sequence: [A](a: List[Option[A]])Option[List[A]]""");$skip(45); 
  
	val l1 = List(Some(4), Some(3), Some(2));System.out.println("""l1  : List[Some[Int]] = """ + $show(l1 ));$skip(39); 
	val l2 = List(Some(4), None, Some(2));System.out.println("""l2  : List[Option[Int]] = """ + $show(l2 ));$skip(16); val res$0 = 
	
	sequence(l1);System.out.println("""res0: Option[List[Int]] = """ + $show(res$0));$skip(14); val res$1 = 
	sequence(l2);System.out.println("""res1: Option[List[Int]] = """ + $show(res$1));$skip(105); 
	
	// Exercise 6
	def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = sequence(a map f);System.out.println("""traverse: [A, B](a: List[A])(f: A => Option[B])Option[List[B]]""");$skip(24); 
	
	val l3 = List(1,2,3);System.out.println("""l3  : List[Int] = """ + $show(l3 ));$skip(30); val res$2 = 
	
	traverse(l3)(x => Some(x));System.out.println("""res2: Option[List[Int]] = """ + $show(res$2));$skip(173); 
	
	def traverse2[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
		Some(a flatMap (x => f(x) match {
			case Some(v) => List(v)
			case None    => List()
		}))
	};System.out.println("""traverse2: [A, B](a: List[A])(f: A => Option[B])Option[List[B]]""");$skip(31); val res$3 = 
	
	traverse2(l3)(x => Some(x));System.out.println("""res3: Option[List[Int]] = """ + $show(res$3));$skip(272); 
	
	def sequence2[A](a: List[Option[A]]): Option[List[A]] = {
		def loop(a: List[Option[A]], res: List[A]): Option[List[A]] = a match {
			case Nil           => Some(res)
			case None    :: xs => None
			case Some(x) :: xs => loop(xs, res :+ x)
		}
		
		loop(a, List())
	};System.out.println("""sequence2: [A](a: List[Option[A]])Option[List[A]]""");$skip(17); val res$4 = 
	
	sequence2(l1);System.out.println("""res4: Option[List[Int]] = """ + $show(res$4));$skip(15); val res$5 = 
	sequence2(l2);System.out.println("""res5: Option[List[Int]] = """ + $show(res$5));$skip(303); 
	
	def sequence3[A](a: List[Option[A]]): Option[List[A]] = {
		a.foldRight( Some(Nil): Option[List[A]] )( (optA, optB) => (optA, optB) match {
			case (_, None)           => return None // early termination
			case (None, _)           => return None
			case (Some(x), Some(xs)) => Some(x :: xs)
		})
	};System.out.println("""sequence3: [A](a: List[Option[A]])Option[List[A]]""");$skip(17); val res$6 = 
	
	sequence3(l1);System.out.println("""res6: Option[List[Int]] = """ + $show(res$6));$skip(15); val res$7 = 
	sequence3(l2);System.out.println("""res7: Option[List[Int]] = """ + $show(res$7))}
	
}
