package org.rixon.euler;

public class Euler653 {

    public static void main(String[] args) {
//        d(5000, 3, 2);
//        d(10000, 11, 6);
//        d(100000,101,51);
        d(1000000000,1000001,500001);
    }

    public static void d(long l, int n, long j) {
        System.out.format("%n%nd(%d,%d,%d)%n%n", l, n, j);
        long[] x = new long[n];
        long[] d = new long[n];
        long r = 6563116;

        for(int i = 0; i < n; i++) {
            long m = r % 1000 + 1;
            x[i] = m + (i == 0 ? 10 : x[i-1] + 20);
            d[i] = r > 10000000 ? -1 : 1;
            r = (r * r) % 32745673;
        }

        long time = 0;
        for (int n1 = n; n1 >= j; n1--) {
            while (n1 >= j && x[n1-1] != l) {

                while(d[n1-1] == 1) {
                    System.out.format("%nMarble %10d exits at time: %10d%n", n1, time + l - x[n1-1]);
                    n1--;
                    if (n1 == 0) {
                        return;
                    }
                }


                long timestep = Long.MAX_VALUE;
                if (d[0] == -1) {
                    timestep = x[0] - 10;
                }
                if (d[n1 - 1] == 1) {
                    long tmp = l - x[n1 - 1];
                    if (tmp < timestep) {
                        timestep = tmp;
                    }
                }
                for (int i = 0; i < n1 - 1; i++) {
                    if (d[i] == 1 && d[i + 1] == -1) {
                        long tmp = (x[i + 1] - x[i] - 20 + 1) / 2;
                        if (tmp < timestep) {
                            timestep = tmp;
                        }
                    }
                }
                for (int i = 0; i < n1; i++) {
                    x[i] += timestep * d[i];
                }
                for (int i = 0; i < n1 - 1; i++) {
                    if (i == 0 && d[i] == -1 && x[i] == 10) {
                        d[i] = 1;
                    } else {
                        if (d[i] == 1 && d[i+1] == -1) {
                            long distance = x[i+1] - x[i];
                            if (distance < 21) {
                                d[i] = -1;
                                d[i + 1] = 1;
                            }
                            if (distance == 19) {
                                x[i]--;
                                x[i+1]++;
                            }
                        }
                    }
                }
                time += timestep;
            }
            System.out.format("%nMarble %10d exits at time: %10d%n", n1, time + l - x[n1-1]);
        }
    }
}
