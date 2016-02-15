package org.rixon.euler;

import java.util.ArrayList;

public class Euler086b {

	public static void main(String[] args) {

		final int M = 100;
		
		ArrayList<int[]> pq = new ArrayList<>();
		
		pq.add(new int[] { 3, 4, 5 });
		int processed = 0;
		
		while (processed < pq.size()) {
			int[] pt = pq.get(processed);
			if (pt[0] <= M &&  pt[1] <= M && pt[2] <= M) {
				pq.add(gen1(pt));
				pq.add(gen2(pt));
				pq.add(gen3(pt));
				processed++;
			} else {
				pq.remove(processed);
			}
		}
		
		for (int[] pt: pq) {
			System.out.format("%6d, %6d, %6d%n", pt[0], pt[1], pt[2]);
		}
	}

	private static int[] gen1(int[] pt) {
		int[] nt = new int[3];
		nt[0] =     pt[0] - 2 * pt[1] + 2 * pt[2];
		nt[1] = 2 * pt[0] -     pt[1] + 2 * pt[2];
		nt[2] = 2 * pt[0] - 2 * pt[1] + 3 * pt[2];
		return nt;
	}

	private static int[] gen2(int[] pt) {
		int[] nt = new int[3];
		nt[0] =     pt[0] + 2 * pt[1] + 2 * pt[2];
		nt[1] = 2 * pt[0] +     pt[1] + 2 * pt[2];
		nt[2] = 2 * pt[0] + 2 * pt[1] + 3 * pt[2];
		return nt;
	}

	private static int[] gen3(int[] pt) {
		int[] nt = new int[3];
		nt[0] = -     pt[0] + 2 * pt[1] + 2 * pt[2];
		nt[1] = - 2 * pt[0] +     pt[1] + 2 * pt[2];
		nt[2] = - 2 * pt[0] + 2 * pt[1] + 3 * pt[2];
		return nt;
	}

}
