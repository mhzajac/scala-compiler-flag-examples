
object ValueDiscard {
	
	// -Ywarn-value-discard
	def f(x: Int): Unit = {
		x + 1 // discarded because `f` returns `Unit`
	}

}
