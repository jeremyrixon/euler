package org.rixon.euler.euler096;

import java.util.BitSet;

public class Cell implements Cloneable {
	
	private BitSet bs = new BitSet(10);
	private int value = 0;
	private int x;
	private int y;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Cell clone() {
		try {
			Cell c = (Cell) super.clone();
			c.bs = (BitSet) bs.clone();
			return c;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public Cell setValue(int value) {
		Cell copy = clone();
		copy.value = value;
		return copy;
	}

	public Cell setCantBe(int value) {
		if (bs.get(value)) {
			return this;
		} else {
			Cell copy = clone();
			copy.bs.set(value);
			return copy;
		}
	}
	
	public boolean hasValue() {
		return value != 0;
	}
	
	public int numChoices() {
		return 9 - bs.cardinality();
	}

	public boolean canBe(int a) {
		return !bs.get(a);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getValue() {
		return value;
	}
}
