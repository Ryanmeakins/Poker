
public class Test {

	public static void main(String[] args) {
		Deck foo = new Deck();
		System.out.println(foo);
		System.out.println(foo.deal());
		foo.betterShuffle();
		System.out.println(foo);
		System.out.println(foo.deal());
	}

}
