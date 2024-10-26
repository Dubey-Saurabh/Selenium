package FunctionalInterface;

public class InterfaceDemo {

	public static void main(String[] args) {

//		Abc obj = new Abc() {
//
//			public void show() {
//
//				System.out.println("interface method");

		Abc obj = () -> System.out.println("interface method");

		obj.show();
	}

}
