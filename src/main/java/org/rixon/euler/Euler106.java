package org.rixon.euler;

import java.util.Arrays;

public class Euler106 {
	static final int n = 12;

	public static void main(String[] args) {

		int[] a = new int[n];
		Arrays.fill(a,0);
		int count = 0;
		do {
			boolean nonempty = nonempty(a);
			boolean interesting = interesting(a);
			boolean crosses = crosses(a);
			if (interesting && crosses) {
				System.out.println(Arrays.toString(a));
				count++;
			}
		} while (inc(a));
		System.out.println(count/2);
	}

	private static boolean crosses(int[] a) {
		int count = 0;
		int min = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				count++;
				if (count > max) max = count;
			}
			if (a[i] == 2) {
				count--;
				if (count < min) min = count;
			}

		}
		return min < 0 && max > 0;
	}

	private static boolean interesting(int[] a) {
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] == 1) {
				count1++;
			} else if (a[i] == 2) {
				count2++;
			}
		}

		return count1 > 1 && count1 == count2;
	}

	private static boolean nonempty(int[] a) {
		boolean has1 = false, has2 = false;
		for (int i = 0; i < n && !(has1 && has2); i++) {
			has1 |= a[i] == 1;
			has2 |= a[i] == 2;
		}
		return has1 && has2;
	}

	private static boolean inc(int[] a) {
		for(int i = 0; i < n; i++) {
			if (a[i] < 2) {
				a[i]++;
				return true;
			} else {
				a[i] = 0;
			}
		}
		return false;
	}
}
