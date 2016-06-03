
/* REEEE doesn't account for both having pair */

public class PokerHand {
	public static int FOURTPFIVE = 537824;
	public static int STRAIGHTF = 10 * FOURTPFIVE;
	public static int FOUR = 9 * FOURTPFIVE;
	public static int HOUSE = 8 * FOURTPFIVE;
	public static int FLUSH = 7 * FOURTPFIVE;
	public static int STRAIGHT = 6 * FOURTPFIVE;
	public static int SET = 5 * FOURTPFIVE;
	public static int TWOP = 4 * FOURTPFIVE;
	public static int PAIR = 3 * FOURTPFIVE;
	
	public static int handValue( Card[] hand) {
		int val = 0;
		if( isStraight( hand ) && isFlush( hand ) ) {
			val = STRAIGHTF + hand[4].rank().value();
		}
		else if( isFours( hand ) ) {
			val = FOUR  + hand[2].rank().value();
		}
		else if( isFullHouse( hand ) ){
			val = HOUSE + hand[2].rank().value();
		}
		else if( isFlush( hand ) ){
			val = FLUSH + hand[0].rank().value() + 14*hand[1].rank().value()
					+ 14*14*hand[2].rank().value() + 14*14*14*hand[3].rank().value()
					+ 14*14*14*14*hand[4].rank().value();
		}
		else if( isStraight( hand ) ) {
			val = STRAIGHT + hand[4].rank().value();
		}
		else if( isSet( hand ) ) {
			val = SET + hand[2].rank().value();
		}
		else if( isTwop( hand ) ) {
			if ( hand[0].rank().value() == hand[1].rank().value() &&
					hand[2].rank() == hand[3].rank() ) {
			         val = 14*14*hand[2].rank().value() + 14*hand[0].rank().value() + hand[4].rank().value();
			}
			else if ( hand[0].rank().value() == hand[1].rank().value() &&
			                hand[3].rank().value() == hand[4].rank().value() ) {
			         val = 14*14*hand[3].rank().value() + 14*hand[0].rank().value() + hand[2].rank().value();
			}
			else {
			         val = 14*14*hand[3].rank().value() + 14*hand[1].rank().value() + hand[0].rank().value();
			}

			val += TWOP;
		}
		else if( isPair( hand ) ) {
			if ( hand[0].rank().value() == hand[1].rank().value() ) {
		         val = 14*14*14*hand[0].rank().value() +  
		                + hand[2].rank().value() + 14*hand[3].rank().value() + 14*14*hand[4].rank().value();
			}
		    else if ( hand[1].rank().value() == hand[2].rank().value() ) {
		         val = 14*14*14*hand[1].rank().value() +  
		                + hand[0].rank().value() + 14*hand[3].rank().value() + 14*14*hand[4].rank().value();
		    }
		    else if ( hand[2].rank().value() == hand[3].rank().value() ) {
		         val = 14*14*14*hand[2].rank().value() +  
		                + hand[0].rank().value() + 14*hand[1].rank().value() + 14*14*hand[4].rank().value();
		    }
		    else {
		         val = 14*14*14*hand[3].rank().value() +  
		                + hand[0].rank().value() + 14*hand[1].rank().value() + 14*14*hand[2].rank().value();
		    }
			val += PAIR;
		}
		else {
			val = hand[4].rank().value();
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
	 
	 public static boolean isSet( Card[] hand ) {
		 boolean a, b, c;

		 if ( hand.length != 5 ) {
			 return( false );
		 }

	     if ( isFours(hand) || isFullHouse(hand) ) {
	    	 return( false );        // hand is better than 3 of a kind     
	     }

	     sortByRank(hand);

	     /*
	         Check for: x x x a b
		 */       
	     a = hand[0].rank() == hand[1].rank() &&                  
	         hand[1].rank() == hand[2].rank() ;

	     /*
	         Check for: a x x x b
		 */
	     b = hand[1].rank() == hand[2].rank() &&
	         hand[2].rank() == hand[3].rank() ;

	     /*
	         Check for: a b x x x
		 */
	     c = hand[2].rank() == hand[3].rank() &&
	         hand[3].rank() == hand[4].rank() ;

	     return( a || b || c );
	 }
	 
	 public static boolean isTwop( Card[] hand ) {
	      boolean a, b, c;

	      if ( hand.length != 5 ) {
	         return(false);
	      }

	      if ( isFours(hand) || isFullHouse(hand) || isSet(hand) ) {
	         return(false);        // better than twop  
	      }

	      sortByRank(hand);

	      /*
	         Checking: a a  b b x
		  */                       
	      a = hand[0].rank() == hand[1].rank() &&
	          hand[2].rank() == hand[3].rank() ;

	      /* ------------------------------
	         Checking: a a x  b b
		  */
	      b = hand[0].rank() == hand[1].rank() &&
	          hand[3].rank() == hand[4].rank() ;

	      /*
	         Checking: x a a  b b
	      */
	      c = hand[1].rank() == hand[2].rank() &&
	          hand[3].rank() == hand[4].rank() ;

	      return( a || b || c );
	 }
	 
	 public static boolean isPair( Card[] hand ) {
		 boolean a, b, c, d;

	     if ( hand.length != 5 ) {
	         return(false);
	     }

	     if ( isFours(hand) || isFullHouse(hand) || isSet(hand) || isTwop(hand) ) {
	         return(false);        // better than pair   
	     }

	     sortByRank(hand);

	     /*
	         Checking: a a x y z
		 */                            
	     a = hand[0].rank() == hand[1].rank() ;

	     /*
	         Checking: x a a y z
		 */
	     b = hand[1].rank() == hand[2].rank() ;

	     /*
	         Checking: x y a a z
		 */
	     c = hand[2].rank() == hand[3].rank() ;

	     /*
	         Checking: x y z a a
		 */
	     d = hand[3].rank() == hand[4].rank() ;

	     return( a || b || c || d );
	 }
	
	 public static void sortBySuit( Card[] hand ) {
		 int i, j, min_j;
		
		 for ( i = 0 ; i < hand.length ; i ++ ) {

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
