package org.rixon.euler;

import java.util.Arrays;

public class Euler642 {
	public static void main(String[] args) {
		long start = System.nanoTime();

		final int N  = 100;
		final int N1 = N + 1;

		final int[] a = new int[N1];
		for (int i = 0; i < N1; i++) {
			a[i] = i;
		}

		for (int i = 2; i < N1; i++) {
			for (int j = 2 * i; j < N1; j+= i) {
				a[j] /= a[i];
			}
		}

		System.out.println(Arrays.toString(a));



		long duration = System.nanoTime() - start;
		System.out.println(duration / 1E9);
	}

}
