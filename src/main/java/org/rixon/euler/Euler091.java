package org.rixon.euler;

import java.util.Arrays;

public class Euler091 {
	private static int N = 50;
	public static void main(String[] args)  {
		int count = 0;
		for (int x1 = 0; x1 <= N; x1++) {
			for (int y1 = 0; y1 <= N; y1++) {
				for (int x2 = 0; x2 <= N; x2++) {
					for (int y2 = 0; y2 <= N; y2++) {
						if (isRightTriangle(x1, y1, x2, y2) ) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count / 2);
	}
	
	private static boolean isRightTriangle(int x1, int y1, int x2, int y2) {
		int dsquareds[] = new int[3];
		dsquareds[0] = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
		dsquareds[1] = x1 * x1 + y1 * y1;
		dsquareds[2] = x2 * x2 + y2 * y2;
		Arrays.sort(dsquareds);
		return dsquareds[0] != 0 && dsquareds[2] == dsquareds[0] + dsquareds[1];
	}

}
