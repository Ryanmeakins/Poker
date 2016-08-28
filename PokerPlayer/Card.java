
public class Card {
	public enum Suit {
		CLUB("C"),
		DIAMOND("D"),
		SPADE("S"),
		HEART("H");

		private final String mNiceName;
		private Suit(final String niceName) {
			mNiceName = niceName;
		}
 
		public String niceName() {
			return mNiceName;
		}
	}
	public enum Rank {
		A(14),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		J(11),
		Q(12),
		K(13);

		private final int mValue;
 
		private Rank(final int value) {
			mValue = value;
		}

		public int value() {
            return mValue;
        }



    }
 
    private final Suit mSuit;
    private final Rank mRank;
 
    public Card(final Suit suit, final Rank rank) {
        mSuit = suit;
        mRank = rank;
    }
 
    public Suit suit() {
        return mSuit;
    }
 
    public Rank rank() {
        return mRank;
    }
 
    public String toString() {
        return ( mRank.name() + " " + mSuit.niceName() + "," );
    }
   
    public int compareTo(final Card other) {
    	if (other == null) {
		    throw new IllegalArgumentException("Null card");
	    }
	 
    	if (other.mRank.value() > this.mRank.value()) {
		   return -1;
	    }
	    if (other.mRank.value() < this.mRank.value()) {
	        return 1;
	    }
	 
	    if (other.mSuit.ordinal() > this.mSuit.ordinal()) {
	       return -1;
	    }
	    if (other.mSuit.ordinal() < this.mSuit.ordinal()) {
	       return 1;
	    }
	 
	       return 0;
    }
}