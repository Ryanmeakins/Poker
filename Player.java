
public class Player {
	private final int handSize;
	private final String name;
	private Card[] hand;
	
	public Player( String name, int handSize) {
		this.name = name;
		this.handSize = handSize;
		hand = new Card[handSize];
	}
	
	public void Deal( Deck curDeck ) {
		for( int i = 0; i < handSize; i++ ) {
			hand[i] = curDeck.deal();
		}
	}
	
	public void DisplayHand() {
		System.out.println( name );
		for( int i = 0; i < handSize; i++ ) {
			System.out.print( hand[i] + " ");
		}	
		System.out.println();
	}
}
