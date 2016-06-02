
public class Test {

	public static void main(String[] args) {
		Deck foo = new Deck();
		System.out.println(foo);
		System.out.println(foo.deal());
		foo.betterShuffle();
		System.out.println(foo);
		System.out.println(foo.deal());
		
		Player bob = new Player("Bob", 5);
		Player sue = new Player("Sue", 5);
		bob.Deal(foo);
		sue.Deal(foo);
		
		
		bob.DisplayHand();
		sue.DisplayHand();
		
		
		Card[] flush = new Card[5];
		System.out.println("FLUSH HAND");
		for( int i = 0; i<5; i++ ){
			int random =  1 + (int)(Math.random() * 12 );
			flush[i] = new Card( Card.Suit.CLUB, Card.Rank.values()[ random ] );
			System.out.print( flush[i] + " ");
		}
		
		
		
		Card[] straight = new Card[5];
		System.out.println("\nSTRAIGHT HAND");
		for( int i = 0; i<5; i++ ){
			int random =  (int)(Math.random() *  3);
			straight[i] = new Card( Card.Suit.values()[ random ], Card.Rank.values()[i] );
			System.out.print( straight[i] + " ");
		}
		
		Card[] four = new Card[5];
		four[0] = new Card( Card.Suit.CLUB, Card.Rank.A);
		four[1] = new Card( Card.Suit.HEART, Card.Rank.A);
		four[2] = new Card( Card.Suit.DIAMOND, Card.Rank.THREE);
		four[3] = new Card( Card.Suit.SPADE, Card.Rank.A);
		four[4] = new Card( Card.Suit.CLUB, Card.Rank.A);
		
		Card[] house = new Card[5];
		house[0] = new Card( Card.Suit.CLUB, Card.Rank.A);
		house[1] = new Card( Card.Suit.HEART, Card.Rank.THREE);
		house[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		house[3] = new Card( Card.Suit.SPADE, Card.Rank.THREE);
		house[4] = new Card( Card.Suit.CLUB, Card.Rank.THREE);
		
		
		Card[] three = new Card[5];
		three[0] = new Card( Card.Suit.CLUB, Card.Rank.K);
		three[1] = new Card( Card.Suit.HEART, Card.Rank.THREE);
		three[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		three[3] = new Card( Card.Suit.SPADE, Card.Rank.THREE);
		three[4] = new Card( Card.Suit.CLUB, Card.Rank.THREE);
		
		Card[] twop = new Card[5];
		twop[0] = new Card( Card.Suit.CLUB, Card.Rank.A);
		twop[1] = new Card( Card.Suit.HEART, Card.Rank.THREE);
		twop[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		twop[3] = new Card( Card.Suit.SPADE, Card.Rank.K);
		twop[4] = new Card( Card.Suit.CLUB, Card.Rank.THREE);
		
		Card[] pair = new Card[5];
		pair[0] = new Card( Card.Suit.CLUB, Card.Rank.FOUR);
		pair[1] = new Card( Card.Suit.HEART, Card.Rank.THREE);
		pair[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		pair[3] = new Card( Card.Suit.SPADE, Card.Rank.K);
		pair[4] = new Card( Card.Suit.CLUB, Card.Rank.THREE);
		
		int valBob = PokerHand.handValue( bob.getHand() );
		System.out.println( "\nBob's value " + valBob );
		
		int valFours = PokerHand.handValue( four );
		System.out.println( "Fours value " + valFours );
		
		int valHouse = PokerHand.handValue( house );
		System.out.println( "House value " + valHouse );
		
		int valFlush = PokerHand.handValue( flush );
		System.out.println( "Flush value " + valFlush );
		
		int valStraight = PokerHand.handValue( straight );
		System.out.println( "Straight value " + valStraight );
		
		int valThree = PokerHand.handValue( three );
		System.out.println( "Threes value " + valThree );
		
		int valTwop = PokerHand.handValue( twop );
		System.out.println( "Twop value " + valTwop );
		
		int valPair = PokerHand.handValue( pair );
		System.out.println( "pair value " + valPair );
	}

}
