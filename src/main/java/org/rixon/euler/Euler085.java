package org.rixon.euler;

public class Euler085 {

	public static void main(String[] args) {
		long closest = Long.MAX_VALUE;
		
		for (long w = 1; ; w++) {
			for(long h = 1; h <= w; h++) {
				long count = w * (w + 1) / 2 * h * (h + 1) / 2;
				long distance = Math.abs(2000000-count);
				if (distance < closest) {
					closest = distance;
					System.out.format("%10d %10d %10d %10d %10d%n", w , h , count, distance, w * h);
				}
			}
		}
	}
	
}
