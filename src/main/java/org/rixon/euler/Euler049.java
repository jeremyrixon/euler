package org.rixon.euler;

import java.util.Arrays;


public class Euler049 {
	

	public static void main(String[] args) {
		Primes p = new Primes();
		for (int i = 1; i < 1229; i++) {
			for (int j = 1; j < i; j++) {
				long pi = p.getPrime(i);
				long pj = p.getPrime(j);
				long pk = (pi + pj) / 2;
				if (p.isPrime(pk) && arePermutations(pi, pk, pj)) {
					System.out.println("" + pj + " " + pk + " " + pi );
				}
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
