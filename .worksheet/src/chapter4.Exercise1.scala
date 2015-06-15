package chapter4

object Exercise1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  val a = MyOption(4);System.out.println("""a  : Product with Serializable with chapter4.MyOption[Int] = """ + $show(a ));$skip(25); 
  val b = MyOption(null);System.out.println("""b  : Product with Serializable with chapter4.MyOption[Null] = """ + $show(b ));$skip(22); 
  val c = MyOption(5);System.out.println("""c  : Product with Serializable with chapter4.MyOption[Int] = """ + $show(c ));$skip(31); 
  
  val f: Int => Int = _ * 2;System.out.println("""f  : Int => Int = """ + $show(f ));$skip(54); 
  val f2: Int => MyOption[Int] = x => MyOption(x * 3);System.out.println("""f2  : Int => chapter4.MyOption[Int] = """ + $show(f2 ));$skip(13); val res$0 = 
  
  a map f;System.out.println("""res0: chapter4.MyOption[Int] = """ + $show(res$0));$skip(18); val res$1 = 
  
  a flatMap f2;System.out.println("""res1: chapter4.MyOption[Int] = """ + $show(res$1));$skip(16); val res$2 = 
  a flatMap2 f2;System.out.println("""res2: chapter4.MyOption[Int] = """ + $show(res$2));$skip(17); val res$3 = 
   
  a orElse c;System.out.println("""res3: chapter4.MyOption[Int] = """ + $show(res$3));$skip(13); val res$4 = 
  b orElse c;System.out.println("""res4: chapter4.MyOption[Any] = """ + $show(res$4));$skip(22); val res$5 = 
  
  a filter (_ > 3);System.out.println("""res5: chapter4.MyOption[Int] = """ + $show(res$5));$skip(19); val res$6 = 
  a filter (_ < 3);System.out.println("""res6: chapter4.MyOption[Int] = """ + $show(res$6))}
  
 
  
}
