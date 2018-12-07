package org.rixon.euler;

import java.util.Arrays;

public class Euler124 {
	static int N = 100000;
	static Sieve s = new Sieve(N);

	private static class Entry implements Comparable<Entry> {

		int n;
		int r;

		public Entry(int n, int r) {
			this.n = n;
			this.r = r;
		}

		@Override
		public int compareTo(Entry entry) {
			int result = Integer.compare(r, entry.r);
			if (result == 0) {
				result = Integer.compare(n, entry.n);
			}
			return result;
		}

		@Override
		public String toString() {
			return String.format("n=%3d rad(n)=%3d%n", n, r);
		}
	}

	public static void main(String[] args) {
		Entry[] entries = new Entry[N+1];

		for (int i = 0; i <= N; i++) {
			entries[i] = new Entry(i, radical(i));
		}
		Arrays.sort(entries);
		System.out.println(Arrays.toString(entries));

		System.out.println(entries[10000].n);

	}

	private static int radical(int i) {
		int radical = 1;
		int p = 2;
		while (i > 1) {
			if (i % p == 0) {
				radical *= p;
				i /= p;
				while (i % p == 0) {
					i /= p;
				}
			}
			p = s.nextPrime(p+1);
		}
		return radical;
	}

}
