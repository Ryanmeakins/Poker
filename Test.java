
public class Test {

	public static void main(String[] args) {
		Deck foo = new Deck();
		System.out.println(foo);
		System.out.println(foo.deal());
		foo.shuffle(1);
		System.out.println(foo);
		System.out.println(foo.deal());
	}

}
