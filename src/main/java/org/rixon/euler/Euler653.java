package org.rixon.euler;

public class Euler653 {

    public static void main(String[] args) {
//        d(5000, 3, 1);
        d(10000, 11, 6);
//        d(100000,101,51);
//        d(1000000000,1000001,500001);
    }

    public static void d(long l, int n, long j) {
        System.out.format("%n%nd(%d,%d,%d)%n%n", l, n, j);
        long[] x = new long[n];
        long[] d = new long[n];
        long[] a = new long[n];
        long r = 6563116;

        for(int i = 0; i < n; i++) {
            long m = r % 1000 + 1;
            x[i] = m + (i == 0 ? 10 : x[i-1] + 20);
            d[i] = r > 10000000 ? -1 : 1;
            r = (r * r) % 32745673;
        }

        long time = 0;
        for (int n1 = n; n1 > j; n1--) {
            while (x[n1-1] != l) {
//                System.out.format("%10d %10d %10d%n", x[0], x[1], x[2]);
                long timestep = Long.MAX_VALUE;
                if (d[0] == -1) {
                    timestep = x[0] - 10;
//                    System.out.format("Timestep [W]: %10d%n", timestep);
                }
                if (d[n1 - 1] == 1) {
                    long tmp = l - x[n1 - 1];
                    if (tmp < timestep) {
                        timestep = tmp;
//                        System.out.format("Timestep [E]: %10d%n", timestep);
                    }
                }
                for (int i = 0; i < n1 - 1; i++) {
                    if (d[i] == 1 && d[i + 1] == -1) {
                        long tmp = (x[i + 1] - x[i] - 20 + 1) / 2;
                        if (tmp < timestep) {
                            timestep = tmp;
//                            System.out.format("Timestep [C]: %10d%n", timestep);
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
                                a[i]++;
                                a[i+1]++;
                            }
                        }
                    }
                }
                time += timestep;
               // System.out.format("\r%10d %10d", time, x[n1-1]);
            }
            System.out.format("%nMarble %10d exits at time: %10d adjustment: %10d%n", n1, time, a[n1-1]);
        }
    }


}
