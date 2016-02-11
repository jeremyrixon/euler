package org.rixon.euler.euler084;

import java.util.Random;

public class Square {

	protected static Random r = new Random();
	protected String name;
	protected Square next;
	protected Square[] dests;
	protected int myNumber = -1;
	protected double count = 0;
	protected double prevCount = 1;
	

	public Square(String name) {
		this.name = name;
	}

	public void setNext(Square next) {
		this.next = next;
	}

	public Square getNext() {
		return next;
	}

	public void setNumber(int n) {
		if (myNumber == -1) {
			myNumber = n;
			if (next != null) {
				next.setNumber(n + 1);
			}
		}
	}

	public void setDests(Square... dests) {
		this.dests = dests;
	}

	public void incCount(double d) {
		count+=d;
	}

	
	public double getCount() {
		return count;
	}

	public Square getLanding(int n) {
		return n == 0 ? this : next.getLanding(n - 1);
	}
	
	@Override
	public String toString() {
		return String.format("%5s  %2d %.2f", name, myNumber, count);
	}

	public void setPrevCount() {
		prevCount = count;
	}

	public double getPrevCount() {
		return prevCount;
	}
	
}
