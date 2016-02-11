package org.rixon.euler;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Euler075 {
	
	public static void main(String[] args) {
		
		final int N = 1500001;
		int[] counts = new int[N];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] + o1[1] + o1[2] - o2[0] - o2[1] - o2[2];
			}
		});
		
		pq.add(new int[] { 3, 4, 5 });
		
		int[] pt;
		while (!pq.isEmpty()) {
			pt = pq.poll();
			if (pt[0] + pt[1] + pt[2] < N) {
				int sum = pt[0] + pt[1] + pt[2];
				for (int l = sum; l < N; l+= sum) {
					counts[l]++;
				}
				System.out.format("%6d, %6d, %6d  (%d)%n", pt[0], pt[1], pt[2], sum);
				pq.add(gen1(pt));
				pq.add(gen2(pt));
				pq.add(gen3(pt));
			}
		}
		
		int count = 0;
		for (int c: counts) {
			if (c == 1) {
				count++;
			}
		}
		System.out.println(count);
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
