package org.rixon.euler;

public class Euler654 {
    static int N = 5;

    private static class Tuple {
        int size;
        long[][] counts;
        long total = 0;

        public Tuple() {
            init(1);
            for (int l = 1; l < N; l++) {
                counts[l][l] = 1;
            }
        }

        public Tuple(Tuple lhs, Tuple rhs) {
            init(lhs.size + rhs.size);

            for (int ll = 1; ll < N; ll++) {
                for (int rr = 1; rr < N; rr++) {
                    for (int lr = 1; lr < N; lr++) {
                        for(int rl = 1; rl < N && rl + lr <= N; rl++) {
                            long t = (lhs.counts[ll][lr] * rhs.counts[rl][rr]) % 1000000007;
                            counts[ll][rr] = (counts[ll][rr] + t) % 1000000007;
                            total = (total + t) % 1000000007;

                        }
                    }
                }
            }
        }

        public Tuple add(Tuple rhs) {
            return new Tuple(this, rhs);
        }

        public Tuple multiply(int n) {
//            System.err.print("multiply: ");
            Tuple result = this;
            for (int i = 1; i < n; i++) {
                result = new Tuple(result, this);
//                System.err.print(" " + i);
            }
//            System.err.println();
            return result;

        }

        private void init(int s) {
            size = s;
            counts = new long[N][];
            for (int i = 0; i < N; i++) {
                counts[i] = new long[N];
            }
        }

        @Override
        public String toString() {
            String s = String.format("size=%d%n", size);
            for (int l = 0; l < N; l++) {
                for (int r = 0; r < N; r++) {
                    s += String.format("%10d ", counts[l][r]);
                }
                s += String.format("%n");
            }
            s += String.format("total=%d%n", total);
            return s;
        }
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            N=i;
            System.out.println(new Tuple().multiply(5));
        }
    }
}
