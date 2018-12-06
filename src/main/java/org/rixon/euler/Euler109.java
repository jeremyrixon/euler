package org.rixon.euler;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Euler109 {

	private static long max = 100;

	static class Dart implements Comparable<Dart> {
		boolean s, d, t, z;
		long value;

		Dart(long value, boolean s, boolean d, boolean t, boolean z) {
			this.value = value;
			this.s = s;
			this.d = d;
			this.t = t;
			this.z = z;
		}

		Dart(long value, boolean s, boolean d, boolean t) {
			this.value = value;
			this.s = s;
			this.d = d;
			this.t = t;
			this.z = false;
		}

		public boolean s() {
			return s;
		}

		public boolean d() {
			return d;
		}

		public boolean t() {
			return t;
		}

		public boolean z() {
			return z;
		}

		public long getValue() {
			return value;
		}

		@Override
		public String toString() {
			return String.format("{%s%2d}", s?'S':d?'D':t?'T':'Z', value);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Dart dart = (Dart) o;
			return s == dart.s &&
					d == dart.d &&
					t == dart.t &&
					z == dart.z &&
					value == dart.value;
		}

		@Override
		public int hashCode() {
			return Objects.hash(s, d, t, z, value);
		}

		@Override
		public int compareTo(Dart dart) {
			long c1 = (s ? 100 : d ? 200 : t ? 400 : z ? 800 : 0) + value;
			long c2 = (dart.s ? 100 : dart.d ? 200 : dart.t ? 400 : dart.z ? 800 : 0) + dart.value;

			return Long.compare(c1, c2);
		}

		long total() {
			int m = z ? 0 : s ? 1 : d ? 2 : t ? 3 : 0;
			return m * value;
		}
	}

	private static final Set<Dart> allDarts = new TreeSet<>();
	static {
		allDarts.add(new Dart(0,false,false,false, true));

		allDarts.add(new Dart(25,true,false,false));
		allDarts.add(new Dart(25,false,true,false));
		for (long i = 1; i <= 20; i++) {
			allDarts.add(new Dart(i,true,false,false));
			allDarts.add(new Dart(i,false,true,false));
			allDarts.add(new Dart(i,false,false,true));
		}
	}

	static class Checkout implements Comparable<Checkout> {
		Dart d1, d2, d3;

		public Checkout(Dart d1, Dart d2, Dart d3) {
			this.d1 = d1;
			this.d2 = d2;
			this.d3 = d3;
		}

		public Dart getD1() {
			return d1;
		}

		public Dart getD2() {
			return d2;
		}

		public Dart getD3() {
			return d3;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Checkout checkout = (Checkout) o;
			if (!Objects.equals(d3, checkout.d3)) {
				return false;
			}
			return (Objects.equals(d2, checkout.d2) && Objects.equals(d1, checkout.d1))
				|| (Objects.equals(d1, checkout.d2) && Objects.equals(d2, checkout.d1));
		}

		@Override
		public int hashCode() {
			return Objects.hash(d1, d2.hashCode() + d3.hashCode());
		}

		@Override
		public String toString() {
			return "Checkout{" +
					"d1=" + d1 +
					", d2=" + d2 +
					", d3=" + d3 +
					'}';
		}

		@Override
		public int compareTo(Checkout checkout) {
			int result = d3.compareTo(checkout.d3);
			if (result == 0) {
				result = d2.compareTo(checkout.d2);
				if (result == 0) {
					result = d1.compareTo(checkout.d1);
				}
			}
			return result;
		}

		long total() {
			return d1.total() + d2.total() + d3.total();
		}
	}

	private static final Set<Checkout> allCheckouts = new TreeSet<>();
	static {
		for(Dart d1: allDarts) {
			for(Dart d2: allDarts) {
				for(Dart d3: allDarts) {
					if (d3.d()) {
						if (!allCheckouts.contains(new Checkout(d2, d1, d3))) {
							Checkout c = new Checkout(d1, d2, d3);
							if (c.total() < 100) {
								allCheckouts.add(new Checkout(d1, d2, d3));
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		for(Dart d: allDarts) {
			System.out.println(d);
		}
		for(Checkout c: allCheckouts) {
			System.out.println(c);
		}
		System.out.println(allCheckouts.size());
	}

}
