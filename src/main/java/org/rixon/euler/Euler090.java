package org.rixon.euler;

public class Euler090 {

	public static void main(String[] args)  {
		int[][] dice = new int[210][];
		int[] a = new int[6];
		int count = 0;
		for (a[0] = 0; a[0] < 10; a[0]++) {
			for (a[1] = a[0] + 1; a[1] < 10; a[1]++) {
				for (a[2] = a[1] + 1; a[2] < 10; a[2]++) {
					for (a[3] = a[2] + 1; a[3] < 10; a[3]++) {
						for (a[4] = a[3] + 1; a[4] < 10; a[4]++) {
							for (a[5] = a[4] + 1; a[5] < 10; a[5]++) {
								dice[count++] = a.clone();
							}
						}
					}
				}
			}
		}
		
		count = 0;
		for (int d1 = 0; d1 < 210; d1++) {
			for (int d2 = d1 + 1; d2 < 210; d2++) {
				if (isGood(dice[d1], dice[d2])) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	private static boolean isGood(int[] a, int[] b) {
		return     isGood(0, 1, a, b) 
				&& isGood(0, 4, a, b) 
				&& isGood(0, 9, a, b) 
				&& isGood(1, 6, a, b) 
				&& isGood(2, 5, a, b) 
				&& isGood(3, 6, a, b) 
				&& isGood(4, 9, a, b) 
				&& isGood(6, 4, a, b) 
				&& isGood(8, 1, a, b);
	}

	private static boolean isGood(int i, int j, int[] a, int[] b) {
		return (contains(a, i) && contains(b, j)) || (contains(a, j) && contains(b, i));
	}

	private static boolean contains(int[] a, int i) {
		for (int n: a) {
			if (n == i) {
				return true;
			} else if (n == 6 && i == 9) {
				return true;
			} else if (n == 9 && i == 6) {
				return true;
			}
		}
		return false;
	}
}
