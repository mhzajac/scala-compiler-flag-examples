
trait Show[A] {
	def show(a: A): String
}

object Show {

	implicit object StringShow extends Show[String] {
		def show(a: String): String = a 
	}

	implicit object IntShow extends Show[Int] {
		def show(a: Int): String = a.toString 
	}

}

/**
 *  -Xlog-implicit-conversions     Print a message whenever an implicit conversion is inserted.
 *  -Xlog-implicits
 */
object Implicits {

	// 1 -> 2 triggers an implicit conversion to ArrowAssoc with method `->`to produce the tuple (1, 2)
	val map = Map(1 -> 2)

	implicit def optionShow[A](implicit s: Show[A]): Show[Option[A]] = new Show[Option[A]] {
		def show(a: Option[A]): String = a match {
			case Some(x) => "Some(" + s.show(x) + ")"
			case None => "None"
		}
	}

	def showOption(): Unit = {
		val s = implicitly[Show[Option[Int]]]
		println(s.show(Option(1)))
	}

	/** The Show type classes usually won't be right here, so what happened??
	 *  The compiler emits this error:
	 *
	 * 	[info] compiler-flag-examples/src/main/scala/Implicits.scala:41: optionShow is not a valid implicit value for Show[Option[Long]] because:
     *  [info] hasMatchingSymbol reported error: could not find implicit value for parameter s: Show[Long]
     *  [info]        val s = implicitly[Show[Option[Long]]]
     *  [info]                          ^
     *  [error] compiler-flag-examples/src/main/scala/Implicits.scala:41: could not find implicit value for parameter e: Show[Option[Long]]
     *  [error]        val s = implicitly[Show[Option[Long]]]
     *
     *  -Xlog-implicits is helpful for debugging implicit chains, where you're not sure where the chain has broken.
     */
	// def failShowOption(): Unit = {
	// 	val s = implicitly[Show[Option[Long]]]
	// 	println(s.show(Option(1L)))
	// }

}