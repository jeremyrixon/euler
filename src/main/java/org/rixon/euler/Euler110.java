package org.rixon.euler;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Euler110 {
	public static int N = 8;
	public static final int primes[] = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 }; // N

	public static void main(String[] args) {

		PriorityQueue<S> q = new PriorityQueue<>();
		q.add(new S(1));

		for (int i = 0; i < 100; i++) {
			S s = q.remove();
			System.out.println(s.toString());
			for (int j = 0; j < N; j++) {
				int[] f = s.factors;
				f[j]++;
				q.add(new S(f));
				f[j]--;
			}
		}
	}

	private static class S implements Comparable<S>{
		public static final double[] logs = new double[N];
		static {
			for(int i = 0; i < N; i++) {
				logs[i] = Math.log(primes[i]);
			}
		}

		public int factors[];
		public double magnitude = 0;
		public int divisors = 1;

		public S(int... factors) {
			this.factors = new int[N];
			for (int i = 0; i < factors.length; i++) {
				this.factors[i] = factors[i];
				magnitude += factors[i] * logs[i];
				divisors *=  factors[i] + 1;
			}
			for (int i = factors.length; i < this.factors.length; i++) {
				this.factors[i] = 0;
			}
		}

		@Override
		public int compareTo(S s) {
			return s.divisors == divisors ? Double.compare(magnitude, s.magnitude) : Integer.compare(s.divisors, divisors);
		}

		@Override
		public String toString() {
			return "S{" +
					"factors=" + Arrays.toString(factors) +
					", magnitude=" + magnitude +
					", divisors=" + divisors +
					'}';
		}
	}

}
