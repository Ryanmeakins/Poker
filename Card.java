
public class Card {
   public enum Suit {
      CLUB("c"),
      DIAMOND("d"),
      SPADE("s"),
      HEART("h");
 
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
      u2(2),
      u3(3),
      u4(4),
      u5(5),
      u6(6),
      u7(7),
      u8(8),
      u9(9),
      u10(10),
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
      return ( mRank.name() + mSuit.niceName() + "," );
   }
   
   /*public String toString() {
	   return ( mRank.name() + mSuit.niceName() );
   }*/
   
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