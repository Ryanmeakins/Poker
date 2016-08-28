
public class Deck {
	public static final int NUMCARDS = 52;
	private Card[] deckOfCards;
	private int currentCard;
	
	public Deck() {
		deckOfCards = new Card[NUMCARDS];
		int i = 0;
		for( Card.Suit suit : Card.Suit.values() ){
			for( Card.Rank rank : Card.Rank.values() ){
				deckOfCards[i++] = new Card(suit, rank);
			}
		}
		currentCard = 0;
	}
	
	public String toString() {
		String s = "";
	    int k;
	    
	    k = 0;
	    for ( int i = 0; i < 4; i++ ){
	    	for ( int j = 1; j <= 13; j++ ){
	    		s += ( deckOfCards[k++] + " " );                
	    	}
	        s += "\n";   // Add NEWLINE after 13 cards
	    }
	    return ( s );
	}
	
	public Card deal() {
		if ( currentCard < NUMCARDS ){
			return ( deckOfCards[ currentCard++ ] );
		}
		else {
			System.out.println("Out of cards error");
		    return ( null );  // Error;
		}
	}
	
	public void shuffle(int n) {
		int i, j, k;

	    for ( k = 0; k < n; k++ ) {
	    	i = (int) ( NUMCARDS * Math.random() );  // Pick 2 random cards      
	    	j = (int) ( NUMCARDS * Math.random() );  // in the deck

	         /* ---------------------------------
	             Swap these randomly picked cards
	             --------------------------------- */
	    	Card tmp = deckOfCards[i];
	        deckOfCards[i] = deckOfCards[j];
	        deckOfCards[j] = tmp;
	    }

	    currentCard = 0;   // Reset current card to deal from top of deck
	}
	 
	public void betterShuffle() {  // Fisher-Yates shuffle
		int i,j;
		
		for ( i = NUMCARDS-1; i > 0 ; i-- ){
			j = (int) ( i * Math.random() );
			
			Card tmp = deckOfCards[i];
	        deckOfCards[i] = deckOfCards[j];
	        deckOfCards[j] = tmp;
		}
		 
		currentCard = 0;   // Reset current card to deal from top of deck
	}
}
