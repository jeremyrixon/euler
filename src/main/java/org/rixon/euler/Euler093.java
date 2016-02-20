package org.rixon.euler;

import java.util.Arrays;
import java.util.BitSet;


/*
((A op B) op C) op D
(A op B) op (C op D)
A op (B op (C op D))
A op ((B op C) op D)
(A op (B op C)) op D
 */

public class Euler093 {

	public static void main(String[] args)  {
		int max = 0;
		String winning = "?";
		int N = 1000;
		int digits[] = new int[4];
		for (digits[0] = 1; digits[0] <= 6; digits[0]++) {
			for (digits[1] = digits[0] + 1; digits[1] <= 7; digits[1]++) {
				for (digits[2] = digits[1] + 1; digits[2] <= 8; digits[2]++) {
					for (digits[3] = digits[2] + 1; digits[3] <= 9; digits[3]++) {
						int r = f093(N, digits);
						System.out.println(Arrays.toString(digits) + " " + r);
						if (r > max) {
							max = r;
							winning = Arrays.toString(digits);
						}
					}
				}
			}
		}
		System.out.println();
		System.out.println(winning);
		System.out.println(max);
	}

	private static int f093(int N, int[] digits) {
		BitSet bs = new BitSet(N);
		for (int v1 = 0; v1 < 4; v1++) {
			for (int v2 = 0; v2 < 4; v2++) {
				if (v2 != v1) {
					for (int v3 = 0; v3 < 4; v3++) {
						if (v3 != v1 && v3 != v2) {
							for (int v4 = 0; v4 < 4; v4++) {
								if (v4 != v1 && v4 != v2 && v4 != v3) {
									for(int op1 = 0; op1 < 4; op1++) {
										for(int op2 = 0; op2 < 4; op2++) {
											for(int op3 = 0; op3 < 4; op3++) {
												f1(digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f2(digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f3(digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f4(digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f5(digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												/*
												f1(-digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f2(-digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f3(-digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f4(-digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												f5(-digits[v1], digits[v2], digits[v3], digits[v4], op1, op2, op3, bs);
												*/
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
		
		for (int i = 1; i < N; i++) {
			if (!bs.get(i)) {
				return i - 1;
			}
		}
		return N - 1;
	}

	// ((A op B) op C) op D
	private static void f1(int a, int b, int c, int d, int op1, int op2, int op3, BitSet bs) {
		LongRatio r = apply(op1, new LongRatio(a, 1), new LongRatio(b, 1));
		r = apply(op2, r, new LongRatio(c, 1));
		r = apply(op3, r, new LongRatio(d, 1));
		if (r != null && r.isInteger()) {
			long v = r.getAsLong();
			if (v >= 0 && v < bs.size()) {
				bs.set((int) v);
			}
		}
		System.out.println("(( " + a + " " + op(op1) + " " + b + " ) " + op(op2) + " " + c + " )" + " " + op(op3) + " " + d + " ) = " + r);
	}

	// (A op B) op (C op D)
	private static void f2(int a, int b, int c, int d, int op1, int op2, int op3, BitSet bs) {
		LongRatio r1 = apply(op1, new LongRatio(a, 1), new LongRatio(b, 1));
		LongRatio r2 = apply(op3, new LongRatio(c, 1), new LongRatio(d, 1));
		LongRatio r = apply(op2, r1, r2);
		if (r != null && r.isInteger()) {
			long v = r.getAsLong();
			if (v >= 0 && v < bs.size()) {
				bs.set((int) v);
			}
		}
	}
	
	// A op (B op (C op D))
	private static void f3(int a, int b, int c, int d, int op1, int op2, int op3, BitSet bs) {
		LongRatio r = apply(op3, new LongRatio(c, 1), new LongRatio(d, 1));
		r = apply(op2, new LongRatio(b, 1), r);
		r = apply(op1, new LongRatio(d, 1), r);
		if (r != null && r.isInteger()) {
			long v = r.getAsLong();
			if (v >= 0 && v < bs.size()) {
				bs.set((int) v);
			}
		}
	}

	// A op ((B op C) op D)
	private static void f4(int a, int b, int c, int d, int op1, int op2, int op3, BitSet bs) {
		LongRatio r = apply(op2, new LongRatio(b, 1), new LongRatio(c, 1));
		r = apply(op3, r, new LongRatio(d, 1));
		r = apply(op1, new LongRatio(a, 1), r);
		if (r != null && r.isInteger()) {
			long v = r.getAsLong();
			if (v >= 0 && v < bs.size()) {
				bs.set((int) v);
			}
		}
	}

	// (A op (B op C)) op D
	private static void f5(int a, int b, int c, int d, int op1, int op2, int op3, BitSet bs) {
		LongRatio r = apply(op2, new LongRatio(b, 1), new LongRatio(c, 1));
		r = apply(op1, new LongRatio(a, 1), r);
		r = apply(op3, r, new LongRatio(d, 1));
		if (r != null && r.isInteger()) {
			long v = r.getAsLong();
			if (v >= 0 && v < bs.size()) {
				bs.set((int) v);
			}
		}
	}

	
	private static LongRatio apply(int op1, LongRatio i, LongRatio j) {
		if (i == null || j == null) {
			return null;
		} else {
			switch (op1) {
			case 0:
				return i.add(j);
			case 1:
				return i.subtract(j);
			case 2:
				return j.isZero() ? null : i.divide(j);
			case 3:
				return i.multiply(j);
			case 4:
				return j.subtract(i);
			case 5:
				return i.isZero() ? null : j.divide(i);
			default:
				return null;
			}
		}
	}
	
	private static String op(int op1) {
		switch (op1) {
		case 0:
			return "+";
		case 1:
			return "-";
		case 2:
			return "/";
		case 3:
			return "*";
		case 4:
			return "--";
		case 5:
			return "//";
		default:
			return "?";
		}
	}


}
