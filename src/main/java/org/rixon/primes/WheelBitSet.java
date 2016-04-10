package org.rixon.primes;

import java.util.BitSet;

public class WheelBitSet {
	int wheelSize = 6;
	int wheelInnerSize = 2;
	BitSet composites;
	int[] lookup = new int[] { -1, 0, -1, -1, -1, 1 };

	public WheelBitSet(int size) {
		composites = new BitSet(size / wheelSize);
	}

	public boolean get(int n) {
		if (n == 2 || n == 3) {
			return true;
		}
		int l = lookup[n % wheelSize];
		return l == -1 ? false : !composites.get(n / wheelSize * wheelInnerSize + l);
	}

	public void clear(int n) {
		int l = lookup[n % wheelSize];
		if (l != -1) {
			composites.set(n / wheelSize * wheelInnerSize + l);
		}
	}
}
