package chapter4

trait MyOption[+A] {

  def map[B](f: A => B): MyOption[B] = this match {
    case MySome(value) => MySome(f(value)) 
    case MyNone        => MyNone
  }   
    
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = this match {
    case MySome(value) => f(value)
    case MyNone        => MyNone
  }
  
  def flatMap2[B](f: A => MyOption[B]): MyOption[B] = this.map(f).getOrElse(MyNone)
  
  def getOrElse[B >: A](default: => B): B = this match {
    case MySome(value) => value
    case MyNone        => default
  }
  
  def orElse[B >: A](ob: => MyOption[B]): MyOption[B] = this match {
    case MySome(value) => this
    case MyNone        => ob
  }
  
  def orElse2[B >: A](ob: => MyOption[B]): MyOption[B] = this map (MySome(_)) getOrElse ob;  
    
  def filter(f: A => Boolean): MyOption[A] = this match {
    case MySome(value) if (f(value)) => this
    case _                         => MyNone
  }
  
  def filter2(f: A => Boolean): MyOption[A] = this flatMap (x => if (f(x)) MySome(x) else MyNone)
 
}

case class MySome[+A](get: A) extends MyOption[A]
case object MyNone extends MyOption[Nothing]

object MyOption {
  def apply[A](a: A) = if (a == null) MyNone else MySome(a)  
}