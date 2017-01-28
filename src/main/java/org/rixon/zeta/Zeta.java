package org.rixon.zeta;

import org.apache.commons.math3.complex.Complex;

public class Zeta {
	
	private static final int N = 1000;
	private static final Complex TWO = new Complex(2,0);
	
	/*
	 * See http://mathworld.wolfram.com/RiemannZetaFunction.html
	 * This is eq 20
	 * eq 21 is convergent for the entire complex plane
	 */
	public static Complex zeta(Complex s) {
		Complex r = Complex.ZERO;
		
		for (int i = 1; i <= N; i+=2) {
			Complex n = new Complex(i, 0);
			r = r.add(n.pow(s).reciprocal());
			n = new Complex(i + 1, 0);
			r = r.subtract(n.pow(s).reciprocal());
		}
		
		r = r.divide(Complex.ONE.subtract(TWO.pow(Complex.ONE.subtract(s))));
		return r;
	}

	public static void main(String[] args) {
		for (double si = 0; si < 20; si += 0.001) {
			Complex z = zeta(new Complex(0.5, si));
			System.out.format("%10f %10f %s %n", si, z.abs(), z.toString());
		}
	}
}
