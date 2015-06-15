package chapter4

object Exercise3 {
  def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
                                                  //> lift: [A, B](f: A => B)Option[A] => Option[B]
  val f1: Int => Int = _ + 1                      //> f1  : Int => Int = <function1>
  
  lift(f1)(Some(1))                               //> res0: Option[Int] = Some(2)
  
  // Exercise 3
	def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
	  for {
	  	x <- a
	  	y <- b
	  } yield f(x, y)                         //> map2: [A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C)Option[C]
	  
	map2(Some(3), Some(4))((x, y) => x + y)   //> res1: Option[Int] = Some(7)
	map2(Some(3), None)((x: Int, y: Int) => x + y)
                                                  //> res2: Option[Int] = None
  // Exercise 3 - variant without for comprehension
	def map3[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
		a flatMap (valA =>
			b map (valB =>
				f(valA, valB)
			)
		)                                 //> map3: [A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C)Option[C]
  
  map3(Some(3), Some(4))((x, y) => x + y)         //> res3: Option[Int] = Some(7)
	map3(Some(3), None)((x: Int, y: Int) => x + y)
                                                  //> res4: Option[Int] = None
                      
                      
  // Exercise 4
  import java.util.regex._
	def pattern(s: String): Option[Pattern] =
	  try {
	    Some(Pattern.compile(s))
	  } catch {
	    case e: PatternSyntaxException => None
	  }                                       //> pattern: (s: String)Option[java.util.regex.Pattern]
	  
  def mkMatcher(pat: String): Option[String => Boolean] =
	  for {
	    p <- pattern(pat)
	  } yield ((s: String) => p.matcher(s).matches)
                                                  //> mkMatcher: (pat: String)Option[String => Boolean]
  
  
  def bothMatch(pat: String, pat2: String, s: String): Option[Boolean] =
	  for {
	    f <- mkMatcher(pat)
	    g <- mkMatcher(pat2)
	  } yield f(s) && g(s)                    //> bothMatch: (pat: String, pat2: String, s: String)Option[Boolean]
  
  def bothMatch2(pat: String, pat2: String, s: String): Option[Boolean] =
  	map2(mkMatcher(pat), mkMatcher(pat2))((m1, m2) => m1(s) && m2(s))
                                                  //> bothMatch2: (pat: String, pat2: String, s: String)Option[Boolean]
  
  bothMatch("(.)*", "\\d+", "foobar")             //> res5: Option[Boolean] = Some(false)
  bothMatch2("(.)*", "\\d+", "foobar")            //> res6: Option[Boolean] = Some(false)
  bothMatch("(.)*", "\\w+", "12345")              //> res7: Option[Boolean] = Some(true)
  bothMatch2("(.)*", "\\w+", "12345")             //> res8: Option[Boolean] = Some(true)
  
}