
public class Constructor {

	public Constructor() {
		
		System.out.println("Default Constructor");
	}
	public Constructor(int x) {
		System.out.println(" Constructor 1");
	}
	public Constructor(int x, int y) {
		System.out.println(" Constructor 2");
	}
	
	public static void main (String args[]) {
		new Constructor();
	}
	

}
