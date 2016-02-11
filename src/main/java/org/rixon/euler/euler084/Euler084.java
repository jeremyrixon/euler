package org.rixon.euler.euler084;

import java.util.Random;

public class Euler084 {
	private static Random r = new Random();

	public static void main(String[] args) {
		System.out.println();
		
		Square GO   = new Square("GO");
		Square A1   = new Square("A1");
		SquareCC CC1  = new SquareCC("CC1");
		Square A2   = new Square("A2");
		Square T1   = new Square("T1");
		Square R1   = new Square("R1");
		Square B1   = new Square("B1");
		SquareCH CH1  = new SquareCH("CH1");
		Square B2   = new Square("B2");
		Square B3   = new Square("B3");
		Square JAIL = new Square("JAIL");
		Square C1   = new Square("C1");
		Square U1   = new Square("U1");
		Square C2   = new Square("C2");
		Square C3   = new Square("C3");
		Square R2   = new Square("R2");
		Square D1   = new Square("D1");
		SquareCC CC2  = new SquareCC("CC2");
		Square D2   = new Square("D2");
		Square D3   = new Square("D3");
		Square FP   = new Square("FP");
		Square E1   = new Square("E1");
		SquareCH CH2  = new SquareCH("CH2");
		Square E2   = new Square("E2");
		Square E3   = new Square("E3");
		Square R3   = new Square("R3");
		Square F1   = new Square("F1");
		Square F2   = new Square("F2");
		Square U2   = new Square("U2");
		Square F3   = new Square("F3");
		SquareG2J G2J  = new SquareG2J("G2J");
		Square G1   = new Square("G1");
		Square G2   = new Square("G2");
		SquareCC CC3  = new SquareCC("CC3");
		Square G3   = new Square("G3");
		Square R4   = new Square("R4");
		SquareCH CH3  = new SquareCH("CH3");
		Square H1   = new Square("H1");
		Square T2   = new Square("T2");
		Square H2   = new Square("H2");

		Square[] allSquares = toArray(GO, A1, CC1, A2, T1, R1, B1, CH1, B2, B3, JAIL, C1, U1, C2, C3, R2, D1, CC2, D2, D3, FP, E1, CH2, E2, E3, R3, F1, F2, U2, F3, G2J, G1, G2, CC3, G3, R4, CH3, H1, T2, H2);
		setNexts(allSquares);
		GO.setNumber(0);
		
		G2J.setDests(JAIL);
		CC1.setDests(GO, JAIL);
		CC2.setDests(GO, JAIL);
		CC3.setDests(GO, JAIL);
		CH1.setDests(GO, JAIL, C1, E3, H2, R1, R2, R2, U1, T1);
		CH2.setDests(GO, JAIL, C1, E3, H2, R1, R3, R3, U2, D3);
		CH3.setDests(GO, JAIL, C1, E3, H2, R1, R1, R1, U1, CC3);
		

		Square current = GO;
		int numDoubles = 0;
		for (long i = 0; i < 1000000000l; i++) {
			int d1 = r.nextInt(4) + 1;
			int d2 = r.nextInt(4) + 1;
			if (d1 == d2) {
				numDoubles++;
			} else {
				numDoubles = 0;
			}
			if (numDoubles == 3) {
				current = JAIL;
				numDoubles = 0;
			} else {
				current = current.getLanding(d1 + d2);
			}
			current.incCount();
		}
		
		dump(allSquares);
	}

	private static Square[] toArray(Square...squares) {
		return squares;
	}
	
	
	private static void setNexts(Square...squares) {
		for (int i = 0; i < squares.length; i++) {
			squares[i].setNext(i == squares.length - 1 ? squares[0] : squares[i+1]);
		}
	}
	
	private static void dump(Square...squares) {
		for (int i = 0; i < squares.length; i++) {
			System.out.println(squares[i].toString());
		}
	}

}