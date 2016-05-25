
public class PokerHand {
	public static int ROYFLUSH = 10;
	public static int FOUR = 9;
	public static int HOUSE = 8;
	public static int FLUSH = 7;
	public static int STRAIGHT = 6;
	public static int SET = 5;
	public static int TWOP = 4;
	public static int PAIR = 3;
	
	public static int handValue( Card[] hand) {
		
		
	}
	
	public static boolean isFlush(Card[] hand) {
		if ( hand.length != 5 ) {
	         return(false);   // Make sure we have 5 cards
		}
		
		sortBySuit(hand);      // Sort the cards by the suit values

		return( hand[0].suit() == hand[4].suit() );   // All cards has same suit  
	}
	
	public static void sortBySuit( Card[] hand ) {
		int i, j, min_j;
		
		for ( i = 0 ; i < hand.length ; i ++ )
	      {

	         min_j = i;   // Assume elem i (h[i]) is the minimum

	         for ( j = i+1 ; j < hand.length ; j++ )
	         {
	            if ( hand[j].suit() < hand[min_j].suit() )
	            {
	               min_j = j;    // We found a smaller suit value, update min_j     
	            }
	         }

	         Card help = hand[i];
	         hand[i] = hand[min_j];
	         hand[min_j] = help;
	      }
	}
}
