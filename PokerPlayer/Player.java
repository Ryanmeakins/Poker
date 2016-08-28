
public class Player {
	private final int handSize;
	private final String name;
	private Card[] hand;
	private int stack; // number of chips should be int?
	
	public Player( String name, int handSize, int startingStack ) {
		this.name = name;
		this.handSize = handSize;
		stack = startingStack;
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
	
	public Card[] getHand() {
		return hand;
	}
	
	public void adjustStack(int delta) {
        this.stack += delta;
    }
  
    public int getStack() {
        return ( stack );
    }
  
    public void bet( int amount ) {
        if( amount > stack ) {
            throw new IllegalArgumentException("Not enough money");
        }
        else {
            adjustStack(amount * -1);
        }
    }
}
