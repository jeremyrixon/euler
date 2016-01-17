package org.rixon.euler;

import java.util.Arrays;

public class Euler043 {

	public static void main(String[] args) {
		int[] n = new int[10];
		long sum = 0;
		for (int i = 17; i < 1000; i+=17) {
			n[9] = i % 10;
			n[8] = (i/10) % 10;
			n[7] = (i / 100);
			if (nodupes(n, 7, 3)) {
				for (int j = 13; j < 1000; j+= 13) {
					if (n[8] == j % 10 && n[7] == (j/10) % 10) {
						n[6] = j / 100;
						if (nodupes(n, 6, 4)) {
							for (int k = 11; k < 1000; k+= 11) {
								if (n[7] == k % 10 && n[6] == (k/10) % 10) {
									n[5] = k / 100;
									if (nodupes(n, 5, 5)) {
										for (int l = 7; l < 1000; l+= 7) {
											if (n[6] == l % 10 && n[5] == (l/10) % 10) {
												n[4] = l / 100;
												if (nodupes(n, 4, 6)) {
													for (int m = 5; m < 1000; m+= 5) {
														if (n[5] == m % 10 && n[4] == (m/10) % 10) {
															n[3] = m / 100;
															if (nodupes(n, 3, 7)) {
																for (int o = 3; o < 1000; o += 3) {
																	if (n[4] == o % 10 && n[3] == (o/10) % 10) {
																		n[2] = o / 100;
																		if (nodupes(n, 2, 8)) {
																			for (int p = 2; p < 1000; p += 2) {
																				if (n[3] == p % 10 && n[2] == (p/10) % 10) {
																					n[1] = p / 100;
																					if (nodupes(n, 1, 9)) {
																						for (int q = 0; q < 10; q++) {
																							n[0] = q;
																							if (nodupes(n, 0, 10)) {
																								System.out.println(Arrays.toString(n));
																								sum += toLong(n);
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

	private static long toLong(int[] n) {
		
		long sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum = sum * 10 + n[i];
		}
		System.out.println(sum);
		return sum;
	}

	private static boolean nodupes(int[] n, int from, int count) {
		for (int i = from; i < from + count; i++) {
			for (int j = from; j < from + count; j++) {
				if (i != j && n[i] == n[j]) {
					return false;
				}
			}
			
		}
		return true;
	}

}
