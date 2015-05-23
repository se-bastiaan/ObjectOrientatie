package oo13.part1;

import java.util.Random;

public class Dice {
    private int pips;
	private final Random rand;
	public static final int MAX_PIPS = 6;
	
	public Dice() {
		rand = new Random();
	}
	
	public synchronized int throwDiceAndGetPips() {
		pips = rand.nextInt(MAX_PIPS) + 1;
        return pips;
	}
}