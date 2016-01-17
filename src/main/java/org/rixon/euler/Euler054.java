package org.rixon.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Euler054 {

	public static void main(String[] args) throws IOException {
		try (FileReader fr = new FileReader("p054_poker.txt");
			 BufferedReader br = new BufferedReader(fr);
		) {
			int wins = 0;
			for (String l = br.readLine(); l != null; l = br.readLine()) {
				String lhs = l.substring(0, 14);
				String rhs = l.substring(15, 29);
				int lhsScore = score(lhs);
				int rhsScore = score(rhs);
				if (lhsScore >= rhsScore) {
					wins++;
				}
			}
			System.out.println(wins);
		}
	}

	private static int score(String s) {
		String[] cards = s.split(" ");
		Arrays.sort(cards, new Comparator<String>() {
			@Override
			public int compare(final String o1, final String o2) {
				return cardValue(o1) - cardValue(o2);
			}
		});
		
		boolean isFlush    = isFlush(cards);
		boolean isStraight = isStraight(cards);
		
		int score = 0;
		
		if (isFlush && isStraight) {
			score += 20000000;
		} else {
			if (isFourOfAKind(cards)) {
				score += 1000000 * cardValue(cards[2]);
			} else if (isFullHouse(cards)) {
				score += 100000 * cardValue(cards[2]);
			} else if (isFlush) {
				score += 160000;
				score += cardValue(cards[4]);
			} else if (isStraight) {
				score += 150000;
				score += cardValue(cards[4]);
			} else if (isThreeOfAKind(cards)) {
				score += 10000 * cardValue(cards[2]);
			} else {
				int pairCount = countPairs(cards);
				if (pairCount > 0) {
					score += (pairCount == 2 ? 1000 : 100) *  getHighPair(cards);
					score += highestNonPair(cards);
				} else {
					score = cardValue(cards[4]);
				}
			}
		}
		
		return score;
	}

	
	private static int highestNonPair(String[] cards) {
		if (cardValue(cards[4]) != cardValue(cards[3])) {
			return cardValue(cards[4]);
		} else if (cardValue(cards[2]) != cardValue(cards[1])) {
			return cardValue(cards[2]);
		} else {
			return cardValue(cards[0]);
		}
	}

	private static int getHighPair(String[] cards) {
		int highPair = cardValue(cards[4]);
		for (int i = 3; i >= 0; i--) {
			int cardValue = cardValue(cards[i]);
			if (cardValue == highPair) {
				return cardValue;
			} 
			highPair = cardValue;
		}
		return highPair;
	}

	private static int countPairs(String[] cards) {
		int pairs = 0;
		for (int i = 0; i < 4; i++) {
			if (cardValue(cards[i]) == cardValue(cards[i+1])) {
				pairs++;
			}
		}
		return pairs;
	}

	private static boolean isThreeOfAKind(String[] cards) {
		return cardValue(cards[0]) == cardValue(cards[2])
		    || cardValue(cards[1]) == cardValue(cards[3])
		    || cardValue(cards[2]) == cardValue(cards[4]);
	}

	private static boolean isFullHouse(String[] cards) {
		return cardValue(cards[0]) == cardValue(cards[1]) &&
			   cardValue(cards[3]) == cardValue(cards[4]) &&
			   (cardValue(cards[2]) == cardValue(cards[1]) || cardValue(cards[2]) == cardValue(cards[3]));
	}

	private static boolean isFourOfAKind(String[] cards) {
		return cardValue(cards[0]) == cardValue(cards[3]) || cardValue(cards[1]) == cardValue(cards[4]);
	}

	private static boolean isStraight(String[] cards) {
		int firstCardValue = cardValue(cards[0]);
		for (int i = 1; i < 5; i++) {
			if (cardValue(cards[i]) != firstCardValue + i) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFlush(String[] cards) {
		char suit = cards[0].charAt(1);
		for (int i = 1; i < 5; i++) {
			if (cards[i].charAt(1) != suit) {
				return false;
			}
		}
		return true;
	}
	
	private static int cardValue(String card) {
		switch (card.charAt(0)) {
		case 'T':
			return 10;
		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;
		default:
			return Integer.valueOf(card.substring(0, 1));
		}
	}

}
