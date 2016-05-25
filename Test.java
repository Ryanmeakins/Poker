
public class Test {

	public static void main(String[] args) {
		Deck foo = new Deck();
		System.out.println(foo);
		System.out.println(foo.deal());
		foo.betterShuffle();
		System.out.println(foo);
		System.out.println(foo.deal());
		
		Player bob = new Player("Bob", 2);
		Player sue = new Player("Sue", 2);
		bob.Deal(foo);
		sue.Deal(foo);
		
		
		bob.DisplayHand();
		sue.DisplayHand();
		
	}

}
