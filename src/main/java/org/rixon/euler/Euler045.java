package org.rixon.euler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.LongUnaryOperator;


public class Euler045 {
	
	static class LazySeq {
		private long seed;
		private LongUnaryOperator f;
		private long head;
		
		public LazySeq(long seed, LongUnaryOperator f) {
			this.seed = seed;
			this.f = f;
			this.head = f.applyAsLong(seed++);
		}
		
		public long get() {
			long r = head;
			head = f.applyAsLong(seed++);
			return r;
		}

		public long peek() {
			return head;
		}
	}

	public static void main(String[] args) {
		ArrayList<LazySeq> streams = new ArrayList<>();
		streams.add(new LazySeq(1, n -> n * (    n + 1) / 2));
		streams.add(new LazySeq(1, n -> n * (3 * n - 1) / 2));
		streams.add(new LazySeq(1, n -> n * (2 * n - 1)    ));

		while (true) {
			streams.sort(new Comparator<LazySeq>() {
				@Override
				public int compare(LazySeq o1, LazySeq o2) {
					return Long.compare(o1.peek(), o2.peek());
				}
			});
			if (streams.get(0).peek() == streams.get(streams.size() - 1).peek()) {
				System.out.println(streams.get(0).peek());
			}
			streams.get(0).get();
		}
		
	}

}
