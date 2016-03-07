package org.rixon.euler.euler096;

public class Sudoku implements Cloneable {
	private Cell[][] grid = new Cell[9][9];
	
	public Sudoku() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				grid[x][y] = new Cell(x, y);
			}
		}
	}

	public void set(int x, int y, int value) {
		if (value > 0) {
			grid[x][y] = grid[x][y].setValue(value);
			int xx = (x / 3) * 3;
			int yy = (y / 3) * 3;
			for(int a = 0; a < 9; a++) {
				grid[x][a] = grid[x][a].setCantBe(value);
				grid[a][y] = grid[a][y].setCantBe(value);
				grid[xx + a / 3][yy + (a % 3)] = grid[xx + a / 3][yy + (a % 3)].setCantBe(value);
			}
		}
	}
	
	Sudoku solve() {
		Cell closest = null;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				Cell c = grid[x][y];
				if (!c.hasValue()) {
					if (c.numChoices() == 0) {
						return null;
					}
					if (closest == null || c.numChoices() < closest.numChoices()) {
						closest = c;
					}
				}
			}
		}
		
		if (closest == null) {
			return this;
		}
		
		for (int a = 1; a < 10; a++) {
			if (closest.canBe(a)) {
				Sudoku s = this.clone();
				s.set(closest.getX(), closest.getY(), a);
				Sudoku solved = s.solve();
				if (solved != null) {
					return solved;
				}
			}
		}
		return null;
	}
	
	@Override public Sudoku clone() {
		try {
			Sudoku s = (Sudoku) super.clone();
			s.grid = new Cell[9][9];
			for (int x = 0; x < 9; x++) {
				for (int y = 0; y < 9; y++) {
					s.grid[x][y] = grid[x][y];
				}
			}
			return s;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				sb.append(grid[x][y].getValue());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public int get(int x, int y) {
		return grid[x][y].getValue();
	}

}