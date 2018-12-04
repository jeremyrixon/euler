package org.rixon.euler;

import java.util.Arrays;

public class Euler493 {

	private static int[] remaining = new int[] { 10, 10, 10, 10, 10, 10, 10 };
	private static double[] histogram = new double[] {  0,  0,  0,  0,  0,  0,  0, 0 };

	public static void main(String[] args) {
		choose(20, 1);
		System.out.println(Arrays.toString(histogram));
	}

	private static void choose(int count, long ways) {
		if (count == 0) {
			histogram[colours()] += ways;
		} else {
			for (int bucket = 0; bucket < remaining.length; bucket++) {
				if (remaining[bucket] > 0) {
					long t = ways * remaining[bucket];
					remaining[bucket]--;
					choose(count - 1, t);
					remaining[bucket]++;
				}
			}
		}
	}

	private static int colours() {
		int c = 0;
		for (long i: remaining) {
			if (i < 10) {
				c++;
			}
		}
		return c;
	}

}
