package org.rixon.euler;

public class Euler645 {
	static final int D = 4;
    static final double[] i = new double[D];

	public static void main(String[] args) {
	    i[1] = 1.0;
	    i[2] = 1.0;
	    i[3] = 1.0 + 2.0 / 3.0;

	    for (int d = 3; d <= D; d++) {
            System.out.format("E(%d)=%f%n",d,e(d));
        }
	}

    private static double e(int d) {
	    return 1 + e(d, d - 1);
    }

    private static double e(int d, int j) {
        if (j < 2) {
            throw new RuntimeException("j=" + j);
        }
        if (j == 2) {
            return 1.0 + 2.0 / d;
        } else if (j == 3) {
            return 1.0 + 2.0 / d * e(d, 2) + 1.0 / d;
        } else if (j == 4) {
            return 1.0 + 2.0 / d * e(d, 2) +  2.0 / d * e(d, 3);
        } else {
            return 1.0 + 2.0 / d * e(d, 2) +  2.0 / d * e(d, 3) + (j - 4.0) / d;
        }
    }


}
