
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
		four[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		four[3] = new Card( Card.Suit.SPADE, Card.Rank.A);
		four[4] = new Card( Card.Suit.CLUB, Card.Rank.u3);
		
		Card[] house = new Card[5];
		house[0] = new Card( Card.Suit.CLUB, Card.Rank.A);
		house[1] = new Card( Card.Suit.HEART, Card.Rank.A);
		house[2] = new Card( Card.Suit.DIAMOND, Card.Rank.A);
		house[3] = new Card( Card.Suit.SPADE, Card.Rank.u3);
		house[4] = new Card( Card.Suit.CLUB, Card.Rank.u3);
		
		int valFlush = PokerHand.handValue( flush );
		System.out.println( "\nflush value " + valFlush );
		
		int valBob = PokerHand.handValue( bob.getHand() );
		System.out.println( "Bob's value " + valBob );
		
		int valStraight = PokerHand.handValue( straight );
		System.out.println( "Straight value " + valStraight );
		
		int valFours = PokerHand.handValue( four );
		System.out.println( "Fours value " + valFours );
		
		int valHouse = PokerHand.handValue( house );
		System.out.println( "House value " + valHouse );
	}

}
