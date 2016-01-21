
// Unused
import scala.collection.mutable.ListBuffer
import scala.util.Right

/**
 *  Use -Xlint:_
 *
 *   adapted-args               Warn if an argument list is modified to match the receiver.
 *   nullary-unit               Warn when nullary methods return Unit.
 *   inaccessible               Warn about inaccessible types in method signatures.
 *   nullary-override           Warn when non-nullary `def f()' overrides nullary `def f'.
 *   infer-any                  Warn when a type argument is inferred to be `Any`.
 *   missing-interpolator       A string literal appears to be missing an interpolator id.
 *   doc-detached               A ScalaDoc comment appears to be detached from its element.
 *   private-shadow             A private field (or class parameter) shadows a superclass field.
 *   type-parameter-shadow      A local type parameter shadows a type already in scope.
 *   -implicit-overload     Parameterized overloaded implicit methods are not visible as view bounds.
 *   option-implicit            Option.apply used implicit view.
 *   delayedinit-select         Selecting member of DelayedInit.
 *   by-name-right-associative  By-name parameter of right associative operator.
 *   package-object-classes     Class or object defined in package object.
 *   unsound-match              Pattern match may not be typesafe.
 *   stars-align                Pattern sequence wildcard must align with sequence component.
 */
object Lint {
	
	// -Xlint:nullary-unit
	def nullaryUnit = println("This method has a side-effect (prints to console) but doesn't show it in the signature!")

	trait A {
		def f = 1
	}

	// -Xlint:nullary-override
	trait NullaryA extends A {
		override def f() = 1
	}

	def genericOption[A](a: Option[A]): Option[A] = a

	// -Xlint:infer-any
	def inferAny(): Unit = {
		val opt = Option(1)
		// `opt` may be defined somewhere less obvious, so it's not obvious that there is an error here
		genericOption(opt.orElse(Option("abc")))
	}

	// -Xlint:type-parameter-shadow. This is not the Int you want!
	def func[Int](i: Int) = i
	
	// -Xlint:by-name-right-associative
	class Node(x: => Int)

	class RightAssoc {
	    def ::(x: => Int) = new Node(x)
	}

	def eval = {println("evaluates right away"); 10} :: new RightAssoc

}
