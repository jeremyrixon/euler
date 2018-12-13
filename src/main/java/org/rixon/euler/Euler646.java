package org.rixon.euler;

import java.util.Arrays;

public class Euler646 {
    private static int primes[] = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67};

	public static void main(String[] args) {

        int[] f = new int[19];
        Arrays.fill(f, 0);
        for(int i = 2; i <= 70; i++) {
            f = add(f, factor(i));
        }

        int n = 0;
        for (int m: f) {
            n += m + 1;
        }

        System.out.println(n);
        System.out.println(Arrays.toString(f));

        int sum = 0;
        for (int i = 1; i <= 1000; i*=67) {
            if (divisor(i, f)) {
                int l = l(i);
                int d = l * i;
                sum += d;
                System.out.format("%16d %s %16d%n", d, Arrays.toString(factor(i)),sum);
            }
        }
        System.out.format("%3d%n", sum);
	}

    private static boolean divisor(int i, int[] f) {
	    int[] f2 = factor(i);
	    if (f2 == null) {
	        return false;
        }
	    for (int j = 0; j < f2.length; j++) {
	        if (f2[j] > f[j]) {
	            return false;
            }
        }
        return true;
    }

    private static int[] add(int[] a, int[] b) {
	    int[] r = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
	        r[i] = a[i] + b[i];
        }
        return r;
    }

    private static int[] factor(int n) {
	    int[] f = new int[19];
	    for (int i = 0; i < 19 && n > 1; i++) {
	        final int p = primes[i];
	        while (n % p == 0) {
	            f[i]++;
	            n /= p;
            }
        }
        return n == 1 ? f : null;
    }

    private static int l(int n) {
	    int l = 1;
        for (int i = 0; i < 19 && n > 1; i++) {
            final int p = primes[i];
            while (n % p == 0) {
                l *= -1;
                n /= p;
            }
        }
        return l;
    }

}
