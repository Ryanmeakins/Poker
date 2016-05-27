
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
		int val = 0;
		if( isFours( hand ) ) {
			val = FOUR;
		}
		else if( isFullHouse( hand ) ){
			val = HOUSE;
		}
		else if( isFlush( hand ) ){
			val = FLUSH;
		}
		else if( isStraight( hand ) ) {
			val = STRAIGHT;
		}
		return val;
	}
	
	public static boolean isFlush(Card[] hand) {
		if ( hand.length != 5 ) {
	         return(false);   // Make sure we have 5 cards
		}
		
		sortBySuit(hand);      // Sort the cards by the suit values

		return( hand[0].suit() == hand[4].suit() );   // All cards has same suit  
	}
	
	public static boolean isStraight( Card[] hand ) {
		int i, testRank;

		if ( hand.length != 5 ) {
	         return(false);
		}

	    sortByRank(hand);      // Sort the poker hand by the rank of each card      

	    /*
	     Check if hand has an Ace
	    */
	    if ( hand[4].rank().value() == 14 ) {
	        /*
	            Check straight using an Ace
	        */
	    	boolean a = hand[0].rank().value() == 2 && hand[1].rank().value() == 3 &&
	                    hand[2].rank().value() == 4 && hand[3].rank().value() == 5 ;
	        boolean b = hand[0].rank().value() == 10 && hand[1].rank().value() == 11 &&        
	                    hand[2].rank().value() == 12 && hand[3].rank().value() == 13 ;

	        return  a || b ;
	    }
	    else {
	        /*
	            General case: check for increasing values
	        */
	    	testRank = hand[0].rank().value() + 1;

	        for ( i = 1; i < 5; i++ ) {
	        	if ( hand[i].rank().value() != testRank )
	        		return false;        // Straight failed...

	            testRank++;   // Next card in hand
	        }

	        return true;        // Straight found !
	    }
	}
	
	public static boolean isFours( Card[] hand ) {
		boolean a, b;

		if ( hand.length != 5 )
			return(false);

	    sortByRank(hand);         // Sort by rank first

	    /*
	    	Check for: 4 cards of the same rank + higher ranked unmatched card 
		*/     
	    a = hand[0].rank() == hand[1].rank() &&
	        hand[1].rank() == hand[2].rank() &&
	        hand[2].rank() == hand[3].rank() ;


	    /* 
	         Check for: lower ranked unmatched card + 4 cards of the same rank 
		*/   
	    b = hand[1].rank() == hand[2].rank() &&
	        hand[2].rank() == hand[3].rank() &&
	        hand[3].rank() == hand[4].rank() ;

	    return a || b ;
	}
	
	 public static boolean isFullHouse( Card[] hand ) {
		 boolean a, b;

	     if ( hand.length != 5 )
	    	 return(false);

	     sortByRank(hand);      // Sort by rank first

	     /*
	         Check for: x x x y y
		 */  
	     a = hand[0].rank() == hand[1].rank() &&
	          hand[1].rank() == hand[2].rank() &&
	          hand[3].rank() == hand[4].rank();

	     /*
	         Check for: x x y y y
		 */
	     b = hand[0].rank() == hand[1].rank() &&
	         hand[2].rank() == hand[3].rank() &&
	         hand[3].rank() == hand[4].rank();

	     return a || b ;
	 }
	
	public static void sortBySuit( Card[] hand ) {
		int i, j, min_j;
		
		for ( i = 0 ; i < hand.length ; i ++ )
	      {

	         min_j = i;   // Assume elem i (h[i]) is the minimum

	         for ( j = i+1 ; j < hand.length ; j++ )
	         {
	            if ( (hand[j].suit().ordinal()) < hand[min_j].suit().ordinal() )
	            {
	               min_j = j;    // We found a smaller suit value, update min_j     
	            }
	         }

	         Card help = hand[i];
	         hand[i] = hand[min_j];
	         hand[min_j] = help;
	      }
	}
	
	public static void sortByRank( Card[] hand ) {
		int i, j, min_j;
		
		for ( i = 0 ; i < hand.length ; i ++ )
	      {

	         min_j = i;   // Assume elem i (h[i]) is the minimum

	         for ( j = i+1 ; j < hand.length ; j++ )
	         {
	            if ( (hand[j].rank().value()) < hand[min_j].rank().value() )
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
