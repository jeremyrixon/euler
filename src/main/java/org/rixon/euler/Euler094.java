package org.rixon.euler;

import java.util.ArrayList;

public class Euler094 {
	public static long N = 1000000000;
	
	public static void main(String[] args) {

		ArrayList<long[]> l = new ArrayList<>();
		
		l.add(new long[] { 3, 4, 5 });
		int processed = 0;
		long total = 0;
		while (processed < l.size()) {
			long[] pt = l.get(processed);
			if (pt[2] * 3 < N) {
				if (pt[0] * 2 == pt[2] + 1) {
					total += pt[2] * 2 + pt[0] * 2;
					System.out.format("A [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] * 2 + pt[0] * 2);
				} 
				//if (pt[0] * 2 == pt[2] - 1) {
				//	total += pt[2] * 2 + pt[0] * 2;
				//	System.out.format("B [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] * 2 + pt[0] * 2);
				//} 
				if (pt[1] * 2 == pt[2] - 1) {
					total += pt[2] * 2 + pt[1] * 2;
					System.out.format("C [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] * 2 + pt[1] * 2);
				}
				/*
				if (pt[1] * 2 == pt[2] + 1) {
					total += pt[2] * 2 + pt[1] * 2;
					System.out.format("D [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] * 2 + pt[1] * 2);
				} 
				if (pt[2] % 2 == 0) {
					if (pt[0] == pt[2]/2 + 1 || pt[0]== pt[2]/2 - 1) {
						total += pt[2] + pt[0];
						System.out.format("E [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] + pt[0]);
					} 
					if (pt[1] == pt[2]/2 + 1 || pt[1] == pt[2]/2 - 1) {
						total += pt[2] + pt[1];
						System.out.format("F [%13d] %12d, %12d, %12d  --> %12d%n", total, pt[0], pt[1], pt[2], pt[2] + pt[1]);
					} 
					
				}
				*/
				l.add(gen1(pt));
				l.add(gen2(pt));
				l.add(gen3(pt));
				processed++;
			} else {
				l.remove(processed);
			}
		}
		System.out.println(total);
		
	}

	private static long[] gen1(long[] pt) {
		long[] nt = new long[3];
		nt[0] =     pt[0] - 2 * pt[1] + 2 * pt[2];
		nt[1] = 2 * pt[0] -     pt[1] + 2 * pt[2];
		nt[2] = 2 * pt[0] - 2 * pt[1] + 3 * pt[2];
		return nt;
	}

	private static long[] gen2(long[] pt) {
		long[] nt = new long[3];
		nt[0] =     pt[0] + 2 * pt[1] + 2 * pt[2];
		nt[1] = 2 * pt[0] +     pt[1] + 2 * pt[2];
		nt[2] = 2 * pt[0] + 2 * pt[1] + 3 * pt[2];
		return nt;
	}

	private static long[] gen3(long[] pt) {
		long[] nt = new long[3];
		nt[0] = -     pt[0] + 2 * pt[1] + 2 * pt[2];
		nt[1] = - 2 * pt[0] +     pt[1] + 2 * pt[2];
		nt[2] = - 2 * pt[0] + 2 * pt[1] + 3 * pt[2];
		return nt;
	}
}
