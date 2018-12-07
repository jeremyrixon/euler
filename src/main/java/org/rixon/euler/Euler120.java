package org.rixon.euler;

public class Euler120 {
	public static void main(String[] args) {
	    long total = 0;
	    for (int a = 3; a <=1000; a++) {
	        total += rmax(a);
        }
        System.out.println(total);
	}

    private static int rmax(int a) {
	    int r1 = r(a, 1);
	    int rmax = r1;

	    for (int n = 2; ; n++) {
            int r = r(a,n);
            if (r == r1) {
                return rmax;
            }
            if (r > rmax) {
                rmax = r;
            }
        }
    }

    private static int r(int a, int n) {
	    int a2 = a * a;
        return (modpow(a-1,n,a*a) + modpow(a+1,n,a*a)) % a2;
    }

    private static int modpow(int a, int n, int m) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = (result * a) % m;
        }
        return result;
    }
}
