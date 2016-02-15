package org.rixon.euler;

import java.util.Arrays;
import java.util.TreeSet;

public class Euler088c {
	final static int N = 24000;
	final static int[] kn = new int[N];

	public static void main(String[] args) {
		Arrays.fill(kn, Integer.MAX_VALUE);

		for(int m = 4; m <= N; m++) {
			go(m, m, 0, 0);
		}
		
		TreeSet<Integer> s = new TreeSet<>();
		for (int i = 2; i <= 12000; i++) {
			//System.out.format("%5d %5d%n", i, kn[i]);
			s.add(kn[i]);
		}
		
		long sum = 0;
		for (int i: s) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("************ " + sum);
	}


	private static void go(int m, int remainder, int sum, int factors) {
		if (remainder == 1) {
			int k = m - sum + factors;
			//System.out.format("m=%6d, remainder=%6d, sum=%6d, factors=%6d, k=%6d %n", m, remainder, sum, factors, k);
			if (m < kn[k]) {
				kn[k] = m;
			}
			return;
		}
		for (int i = 2; i <= remainder && i < m; i++) {
			if (remainder % i == 0) {
				go(m, remainder / i, sum + i, factors + 1);
			}
		}
	}
}
