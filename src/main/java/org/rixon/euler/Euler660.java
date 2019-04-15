package org.rixon.euler;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class Euler660 {

    public static void main(String[] args) {
        for (int base = 6; base < 11; base++) {
            for (int a = 1; a < 10000; a++) {
                if (couldBePanDigital(base, a)) {
                    for (int b = 1; b <= a; b++) {
                        if (couldBePanDigital(base, a, b)) {
                            // a*a + b*b + a*b = c * c
                            int c = PerfectSquare(a * a + b * b + a * b);
                            if (c > 0 && isPanDigital(base, a, b, c)) {
                                System.out.format("%10d %10d %10d %10d %n", base, a, b, c);
                            }
                        }
                    }
                }
            }
        }
    }

    public static int PerfectSquare(int n)
    {
        int h = n & 0xF; // last hexadecimal "digit"
        if (h > 9)
            return -1; // return immediately in 6 cases out of 16.

        // Take advantage of Boolean short-circuit evaluation
        if ( h != 2 && h != 3 && h != 5 && h != 6 && h != 7 && h != 8 )
        {
            // take square root if you must
            int t = (int) floor( sqrt((double) n) + 0.5 );
            return t*t == n ? t : -1;
        }
        return -1;
    }

    public static boolean isPanDigital(int base, int... numbers) {
        boolean[] used = new boolean[base];
        int count = 0;
        for(int m: numbers) {
            while (m > 0) {
                int digit = m % base;
                if (used[digit]) {
                    return false;
                } else {
                    used[digit] = true;
                    count++;
                    m = m / base;
                }
            }
        }
        return count == base;
     }

    public static boolean couldBePanDigital(int base, int... numbers) {
        boolean[] used = new boolean[base];
        for(int m: numbers) {
            while (m > 0) {
                int digit = m % base;
                if (used[digit]) {
                    return false;
                } else {
                    used[digit] = true;
                    m = m / base;
                }
            }
        }
        return true;
    }


}
