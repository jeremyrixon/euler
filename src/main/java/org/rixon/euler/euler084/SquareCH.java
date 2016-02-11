package org.rixon.euler.euler084;

public class SquareCH extends Square {

	public SquareCH(String name) {
		super(name);
	}
	
	public Square getLanding(int n) {
		if (n != 0) {
			return super.getLanding(n);
		}
		int i = r.nextInt(16);
		return i < dests.length ? dests[i].getLanding(0) : this;
	}
}
