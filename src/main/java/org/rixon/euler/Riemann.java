package org.rixon.euler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

public class Riemann extends JPanel implements MouseListener, KeyListener {
	private int iteration = 1;
	

	public static void main(String[] args) {
		
		Riemann r = new Riemann();
		JFrame frame = new JFrame("Riemann");
		frame.add(r);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(r);
		frame.addKeyListener(r);
		
		frame.createBufferStrategy(2);
		BufferStrategy bs = frame.getBufferStrategy();
		for (;;r.iteration++) {
			r.dopaint(bs.getDrawGraphics());
			bs.show();
			Toolkit.getDefaultToolkit().sync();
		}
		
	}

	public void dopaint(final Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int w = getWidth();
		int h = getHeight();
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, w, h);
		float scale = h / 50;
		for (int x = 0; x < w; x++) {
			double sx = ( w / 2 - x ) / scale;
			if (sx > -2 && sx < 4.0) {
				for (int y = 0; y < h; y++) {
					double sy = (h - y) / scale;
					Complex s = new Complex(sx, sy);
					Complex r = riemann(s);
					
					/*
					float hue = (float) (r.getArgument() / Math.PI / 2.0);
					float sat = 1.0f;
					float bri = 1;
					g2.setColor(Color.getHSBColor(hue, sat, bri));
					*/
					
					/*
					double a = 0.05 / Math.abs(r.getReal());
					double b = 0.05 / Math.abs(r.getImaginary());
					float c = (float) (r.getArgument() / Math.PI / 2.0 + 1.0) % 1.0f;
					Color col = new Color((float) Math.min(1.0, a), (float) Math.min(1.0, b), c);
					g2.setColor(col);
					*/
					
					
					/*
					float c = (float) Math.min(1.0, 0.01 / r.abs());
					g2.setColor(new Color(c, c, c));
					*/

					float a = (float) Math.min(0.05 / Math.abs(r.getReal() - r.getImaginary()), 1);
					Color col = new Color(a, a, a);
					g2.setColor(col);
					
					g2.fillRect(y, x, 1, 1);
				}
			}
		}
		g.dispose();
	}

	private Complex riemannOld(Complex s) {
		Complex r = Complex.ZERO;

		for (int n = 1; n < iteration; n++) {
			Complex cn = new Complex(n, 0);
			r = r.add(cn.pow(s).reciprocal());
		}
		return r;
	}

	private Complex riemann(Complex s) {
		Complex r = Complex.ZERO;

		for (int n = 1; n < iteration; n++) {
			Complex cn = new Complex(n, 0);
			Complex a = cn.divide(cn.add(1.0).pow(s));
			Complex b = cn.subtract(s).divide(cn.pow(s));
			r = r.add(a).subtract(b);
		}
		return r.divide(s.subtract(1.0));
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
