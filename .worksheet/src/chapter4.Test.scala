package chapter4

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(55); 
  val l = List(1,2,3,4);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(24); val res$0 = 
  l.foldRight(0)(_ + _);System.out.println("""res0: Int = """ + $show(res$0))}
}
