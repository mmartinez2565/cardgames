//Exercise 13.2 The goal of this exercise is to implement the shuﬄing algorithm from this chapter.
//1. In the repository for this book, you should ﬁnd a ﬁle called Deck.java that contains the code in this chapter. Check that you can compile it in your environment.
//2. Add a Deck method called randomInt that takes two integers, low and high, and returns a random integer between low and high, including both. You can use the nextInt provided by java.util.Random, which we saw in Section 8.7. But you should avoid creating a Random object every time randomInt is invoked.
//3. Write a method called swapCards that takes two indexes and swaps the cards at the given locations.
//4. Write a method called shuffle that uses the algorithm in Section 13.2.

package Martinez.Excersize13;

import java.util.Arrays;
import java.util.Random;

public class Deck {

	private Card[] cards;

	public Deck(int i) {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[index] = new Card(rank, suit);
				index++;
			}
		}
	}

	public Card[] getDeck() {
		return this.cards;
	}

	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}

	// Displays the given deck of cards.

	public Deck(int rank, int suit) {
	}

	public void printDeck(Deck[] cards) {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	public String toString() {
		return Arrays.toString(this.cards);
	}

	public int randomInt(int low, int high) {
		Random rand = new Random();
		int here = rand.nextInt((high) + low + 1);

		return here;
	}

	public void swapCards(int i, int j) {

		Card placeholder = cards[i];
		cards[i] = cards[j];
		cards[j] = placeholder;
	}

	public void shuffle() {
		for (int index = 1; index <= cards.length - 1; index++) {
			Random rand = new Random();
			swapCards(index, rand.nextInt((cards.length - 1) + index));

		}
	}

	public void selectionSort() {
		int smallIndex = 0;
		for (int i = 0; i <= cards.length; i++) {
			smallIndex = i;
			for (int x = i; x <= cards.length; x++) {
				if (cards[smallIndex].compareTo(cards[x]) > 0) {
					this.swapCards(smallIndex, x);
				}
			}
		}
	}
	// Sequential search

	public static int search(Deck[] cards, Deck target) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	// Binary search 

	public static int binarySearch(Deck[] cards, Deck target) {
		int low = 0;
		int high = cards.length - 1;
		while (low <= high) {
			System.out.println(low + ", " + high);

			int mid = (low + high) / 2; // step 1
			int comp = cards[mid].compareTo(target);

			if (comp == 0) { // step 2 return mid;
			} else if (comp < 0) { // step 3
				low = mid + 1;
			} else { // step 4
				high = mid - 1;
			}
		}
		return -1;
	}

	// Binary search 

	public static int binarySearch(Deck[] cards, Deck target, int low, int high) {
		System.out.println(low + ", " + high);

		if (high < low) {
			return -1;
		}
		int mid = (low + high) / 2;
		int comp = cards[mid].compareTo(target);
		if (comp == 0) {
			return mid;
		} else if (comp < 0) {
			return binarySearch(cards, target, mid + 1, high);
		} else {
			return binarySearch(cards, target, low, mid - 1);
		}
	}

	private int compareTo(Deck target) {
		return 0;
	}

}
