package backendjavarelations.exercise03;

public class Card {
    
    private final int number;
    private final Suit suit;
    
    public enum Suit {
        ESPADAS ("Espadas"), 
        COPAS   ("Copas"),
        OROS   ("Oros"),
        BASTOS   ("Bastos");
        
        private final String suit;

        private Suit(String suit) {
            this.suit = suit;
        }
        
        public String getSuit() {
            return suit;
        }
    }

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }
    
    @Override
    public String toString() {
        return number + " de " + suit.getSuit();
    }
    
}
