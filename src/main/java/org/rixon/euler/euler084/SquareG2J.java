package org.rixon.euler.euler084;

public class SquareG2J extends Square {

	public SquareG2J(String name) {
		super(name);
	}
	
	public Square getLanding(int n) {
		return n == 0 ? dests[0].getLanding(n) : super.getLanding(n);
	}

}
