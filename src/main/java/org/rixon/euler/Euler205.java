package org.rixon.euler;

import java.util.Arrays;

public class Euler205 {

	public static void main(String[] args) {
		int[] p = pow(new int[] {1, 2, 3, 4}, 9);
		int[] c = pow(new int[] {1, 2, 3, 4, 5, 6}, 6);

		System.out.println(Arrays.toString(p));
		System.out.println(Arrays.toString(c));

		double total = 0;
		double pete = 0;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < c.length; j++) {
				total++;
				if (p[i] > c[j]) {
					pete++;
				}
			}
		}
		System.out.println(pete / total);


	}

	private static int[] pow(int[] p, int n) {
		int[] r = p;
		for (int i = 1; i < n; i++) {
			r = mult(r, p);
		}
		return r;
	}

	private static int[] mult(int[] a, int[] b) {
		int[] r = new int[a.length * b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				r[i + j * a.length] = a[i] + b[j];
			}
		}
		return r;
	}
}
