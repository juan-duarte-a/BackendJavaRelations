package backendjavarelations.exercise03;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private final LinkedList<Card> cards;
    private final LinkedList<Card> discardedCards;

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Mostrando baraja:");
        deck.listAvailableCards();
        deck.shuffleDeck();
        System.out.println("\nBarajando...");
        deck.listAvailableCards();
        System.out.println("\nSiguiente carta:");
        deck.nextCard();
        System.out.println("\nSiguientes 4 cartas:");
        deck.giveCards(4);
        System.out.print("\nCartas restantes: ");
        System.out.println(deck.availableCards() + "\n");
        deck.listAvailableCards();
        System.out.println("\nCartas del montón:");
        deck.listDiscardedCards();
    }
    
    public Deck() {
        cards = new LinkedList<>();
        discardedCards = new LinkedList<>();
        createDeck();
    }

    private void createDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (int j = 1; j <= 12; j++) {
                if (j == 8) j += 2;
                cards.add(new Card(j, suit));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }
    
    public Card nextCard() {
        if (cards.isEmpty()) {
            System.out.println("No hay más cartas disponibles.");
            return null;
        } else {
            System.out.println(cards.getFirst());
            discardedCards.add(cards.peek());
            return cards.pop();
        }
    }
    
    public int availableCards() {
        return cards.size();
    }
    
    public void giveCards(int quantity) {
        if (quantity > cards.size())
            System.out.println("No hay suficientes cartas.");
        else
            for (int i = 0; i < quantity; i++) {
                System.out.println(cards.peek());
                discardedCards.add(cards.getFirst());
                cards.pop();
            }
    }
    
    public void listDiscardedCards() {
        if (cards.isEmpty())
            System.out.println("No hay cartas en el montón.");
        else
            discardedCards.forEach(System.out::println);
    }
    
    public void listAvailableCards() {
        if (cards.isEmpty())
            System.out.println("No hay cartas disponibles.");
        else
            cards.forEach(System.out::println);
    }
    
}
