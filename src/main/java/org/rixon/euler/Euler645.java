package org.rixon.euler;

import java.util.BitSet;
import java.util.Random;

public class Euler645 {
	static final int D = 12;


	public static void main(String[] args) {
		Random r = new Random();
		long trials = 0;
		double emporers = 0;

		while (true) {
			BitSet b = new BitSet(D);
			for (int i = 0; i < 1000000; i++) {
				b.clear();
				while (b.cardinality() < D) {
					int bday = r.nextInt(D);
					b.set(bday);
					int next1 = (bday + D + 1) % D;
					int next2 = (bday + D + 2) % D;
					int prev1 = (bday + D - 1) % D;
					int prev2 = (bday + D - 2) % D;
					if (b.get(next2) && !b.get(next1)) {
						b.set(next1);
					}
					if (b.get(prev2) && !b.get(prev1)) {
						b.set(prev1);
					}
					emporers++;
				}
				trials++;
			}
			System.out.format("Trials: %10d Avg: %10.6f%n", trials, emporers / trials);
		}
	}


}
