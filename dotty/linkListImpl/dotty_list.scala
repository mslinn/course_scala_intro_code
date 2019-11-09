object FixImpl {
  type Fix[F[_]]

  inline def fix[F[_]](f: F[Fix[F]]): Fix[F] = f.asInstanceOf[Fix[F]]
  inline def unfix[F[_]](f: Fix[F]): F[Fix[F]] = f.asInstanceOf[F[Fix[F]]]
}

import FixImpl._

type OrNull[A <: AnyRef] = A | Null
opaque type List[A] = Fix[[X] =>> OrNull[(A, X)]]

object List {
  def empty[A]: List[A] = fix(null)
}

given ListOps {
  def (head: A) ::[A](self: List[A]): List[A] =
    fix((head, self))

  def (self: List[A]) isEmpty[A] = unfix(self) == null
  def (self: List[A]) headOption[A] = {
    unfix(self) match {
      case null => None
      case (a, _) => Some(a)
    }
  }

  @annotation.tailrec
  def (self: List[A]) foldLeft[A, B](init: B)(fn: (B, A) => B): B =
    unfix(self) match {
      case null => init
      case (a, rest) => rest.foldLeft(fn(init, a))(fn)
    }
}
