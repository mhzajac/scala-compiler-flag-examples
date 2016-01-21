
/** Compile with the -deprecation flag to see warnings for deprecated API in use. */
object Deprecated {

	/** Must also use -Xfuture for Scala 2.11 to see this warning. */
	def viewBounds[A <% Int](a: A): Int = a + 1

	/** There was no reason for its existence on Int. */
	def round(i: Int): Int = i.round

}
