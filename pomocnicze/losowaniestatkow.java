//Algorytm losowania ustawienia statkow, tylko pomocniczy!

import java.util.Random;

public class test {
	public int[][] tab = new int[11][11];
	static Random rand = new Random();

	public boolean isEmpty(int x, int y) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (tab[Math.abs(x + i)][Math.abs(y + j)] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public void insertShip(int nr) {
		boolean inserted = false, direction;
		int x, y;
		while (!inserted) {
			direction = rand.nextBoolean();
			inserted = true;
			x = rand.nextInt(11 - nr);
			y = rand.nextInt(10);
			// true = pionowo, false = poziomo
			for (int i = 0; i < nr; i++) {
				if (direction) {
					if (isEmpty(x + i, y) == false) {
						inserted = false;
						break;
					}
				} else {
					if (isEmpty(y, x + i) == false) {
						inserted = false;
						break;
					}
				}
			}
			if (inserted) {
				for (int i = 0; i < nr; i++) {
					if (direction) {
						tab[x + i][y] = 1;
					} else {
						tab[y][x + i] = 1;
					}
				}
			}

		}

	}