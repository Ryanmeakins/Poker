
public class Player {
	private final int handSize;
	private final String name;
	private Card[] hand;
	
	public Player( String name, int handSize) {
		this.name = name;
		this.handSize = handSize;
		hand = new Card[handSize];
	}
}
