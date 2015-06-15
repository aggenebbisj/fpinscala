package chapter4

object Exercise3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(97); 
  def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f;System.out.println("""lift: [A, B](f: A => B)Option[A] => Option[B]""");$skip(29); 
  val f1: Int => Int = _ + 1;System.out.println("""f1  : Int => Int = """ + $show(f1 ));$skip(23); val res$0 = 
  
  lift(f1)(Some(1));System.out.println("""res0: Option[Int] = """ + $show(res$0));$skip(143); 
  
  // Exercise 3
	def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
	  for {
	  	x <- a
	  	y <- b
	  } yield f(x, y);System.out.println("""map2: [A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C)Option[C]""");$skip(45); val res$1 = 
	  
	map2(Some(3), Some(4))((x, y) => x + y);System.out.println("""res1: Option[Int] = """ + $show(res$1));$skip(48); val res$2 = 
	map2(Some(3), None)((x: Int, y: Int) => x + y);System.out.println("""res2: Option[Int] = """ + $show(res$2));$skip(192); 
  // Exercise 3 - variant without for comprehension
	def map3[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
		a flatMap (valA =>
			b map (valB =>
				f(valA, valB)
			)
		);System.out.println("""map3: [A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C)Option[C]""");$skip(45); val res$3 = 
  
  map3(Some(3), Some(4))((x, y) => x + y);System.out.println("""res3: Option[Int] = """ + $show(res$3));$skip(48); val res$4 = 
	map3(Some(3), None)((x: Int, y: Int) => x + y)
                      
                      
  // Exercise 4
  import java.util.regex._;System.out.println("""res4: Option[Int] = """ + $show(res$4));$skip(233); 
	def pattern(s: String): Option[Pattern] =
	  try {
	    Some(Pattern.compile(s))
	  } catch {
	    case e: PatternSyntaxException => None
	  };System.out.println("""pattern: (s: String)Option[java.util.regex.Pattern]""");$skip(143); 
	  
  def mkMatcher(pat: String): Option[String => Boolean] =
	  for {
	    p <- pattern(pat)
	  } yield ((s: String) => p.matcher(s).matches);System.out.println("""mkMatcher: (pat: String)Option[String => Boolean]""");$skip(163); 
  
  
  def bothMatch(pat: String, pat2: String, s: String): Option[Boolean] =
	  for {
	    f <- mkMatcher(pat)
	    g <- mkMatcher(pat2)
	  } yield f(s) && g(s);System.out.println("""bothMatch: (pat: String, pat2: String, s: String)Option[Boolean]""");$skip(146); 
  
  def bothMatch2(pat: String, pat2: String, s: String): Option[Boolean] =
  	map2(mkMatcher(pat), mkMatcher(pat2))((m1, m2) => m1(s) && m2(s));System.out.println("""bothMatch2: (pat: String, pat2: String, s: String)Option[Boolean]""");$skip(41); val res$5 = 
  
  bothMatch("(.)*", "\\d+", "foobar");System.out.println("""res5: Option[Boolean] = """ + $show(res$5));$skip(39); val res$6 = 
  bothMatch2("(.)*", "\\d+", "foobar");System.out.println("""res6: Option[Boolean] = """ + $show(res$6));$skip(37); val res$7 = 
  bothMatch("(.)*", "\\w+", "12345");System.out.println("""res7: Option[Boolean] = """ + $show(res$7));$skip(38); val res$8 = 
  bothMatch2("(.)*", "\\w+", "12345");System.out.println("""res8: Option[Boolean] = """ + $show(res$8))}
  
}
