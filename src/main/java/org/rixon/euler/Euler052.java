package org.rixon.euler;

import java.util.Arrays;

public class Euler052 {

	public static void main(String[] args) {
		for (long n = 1; ; n++) {
			if (arePermutations(n, n*2, n*3, n*4, n*5, n*6)) {
				System.out.println(n +", "+ n*2+", "+ n*3+", "+ n*4+", "+ n*5+", "+ n*6);
			}
		}
	}

	private static boolean arePermutations(long... numbers) {
		int[] referenceDigitCounts = getDigitCounts(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			if (! Arrays.equals(referenceDigitCounts, getDigitCounts(numbers[i]))) {
				return false;
			}
		}
		return true;
	}

	private static int[] getDigitCounts(long l) {
		int[] digitCounts = new int[10];
		while (l > 0) {
			digitCounts[(int) (l % 10)]++;
			l /= 10;
		}
		return digitCounts;
	}
}
