package FunctionalInterface;

public class FunctionalInterfaceClass {

	public static void main(String[] args) {

//		Abc obj = new Abc() {
//
//		public void show() {
//
//		System.out.println("interface method");

		FunctionalInterface obj = () -> System.out.println("interface method");

		obj.show();
	}

}
