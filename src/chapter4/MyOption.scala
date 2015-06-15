package chapter4

// Hide scala Option
import scala.{None => _, Some => _}

trait MyOption[+A] {

  def map[B](f: A => B): MyOption[B] = this match {
    case Some(value) => Some(f(value)) 
    case None        => None
  }   
    
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = this match {
    case Some(value) => f(value)
    case None        => None
  }
  
  def flatMap2[B](f: A => MyOption[B]): MyOption[B] = this.map(f).getOrElse(None)
  
  def getOrElse[B >: A](default: => B): B = this match {
    case Some(value) => value
    case None        => default
  }
  
  def orElse[B >: A](ob: => MyOption[B]): MyOption[B] = this match {
    case Some(value) => this
    case None        => ob
  }
  
  def orElse2[B >: A](ob: => MyOption[B]): MyOption[B] = this map (Some(_)) getOrElse ob;  
    
  def filter(f: A => Boolean): MyOption[A] = this match {
    case Some(value) if (f(value)) => this
    case _                         => None
  }
  
  def filter2(f: A => Boolean): MyOption[A] = this flatMap (x => if (f(x)) Some(x) else None)
 
}

case class Some[+A](get: A) extends MyOption[A]
case object None extends MyOption[Nothing]

object MyOption {
  def apply[A](a: A) = if (a == null) None else Some(a)  
}