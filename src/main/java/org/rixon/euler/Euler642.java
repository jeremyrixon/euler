package org.rixon.euler;

public class Euler642 {
	public static void main(String[] args) {

		long start = System.nanoTime();

//		final long N = 201820182018l;
		final long N = 10000;
		final long sum = N * (N + 1) / 2 - 1;

		long duration = System.nanoTime() - start;

		System.out.println(duration / 1E9);
		System.out.println(sum);
		System.out.println(sum % 1000000000);
	}

}
