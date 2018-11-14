package org.rixon.euler;

public class Euler642 {
	public static void main(String[] args) {

		long start = System.nanoTime();
		final int N = 100000000;
		final int[] p = new int[N];
		p[0]=2; p[1]=3; p[2]=5; p[3]=7;
		int n = 4;

		for (int i = 11; n < N; i++) {
			p[n++] = i;
			for(int j = 0, k=p[j]; k*k <= i; j++, k=p[j]) {
				if (i % k == 0) {
					n--;
					break;
				}
			}
		}

		long duration = System.nanoTime() - start;

		System.out.println(duration / 1E9);
		System.out.println(p[N-1]);
	}

}
