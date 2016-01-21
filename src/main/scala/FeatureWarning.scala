
/** Compile with the -feature flag to see warnings for deprecated language features. */
object FeatureWarning {
	
	/** Implicit conversions may eventually have to be manually enabled. */
	implicit def implicitConvesion(i: Int): List[String] = List(i.toString)

	/** Use `list.head` instead. */
	def postfixOperator(list: List[Int]): Int = {
		list head
	}

}
