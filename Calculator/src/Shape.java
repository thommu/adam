/**
 * 
 */

/**
 * @author Thommu
 *
 */
class Shape{
	public static void foo() {
		System.out.println("Shape foo");
	}
}
class Rectangle extends Shape{

	public static void foo() {
		System.out.println("Rectangle foo");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Shape s = new Rectangle();									//Shape foo
		Rectangle r = new Rectangle();								//Rectangle foo
		s.foo();
		r.foo();
		
		
	}

}
