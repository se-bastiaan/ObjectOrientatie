package oo13.part1;

public class Player implements Runnable {

	private final Dice dice;
    private final String name;
	private final int numberOfThrows;
	
	public Player(String name, Dice dice, int numberOfThrows) {
		this.name = name;
		this.dice = dice;
		this.numberOfThrows = numberOfThrows;
	}

	public void run() {
		for (int i = 0; i < numberOfThrows; i++) {
			int pips = dice.throwDiceAndGetPips();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

			System.out.println(name + " throws " + pips + " in turn " + i);
		}
	}

    /*
    public void run() {
        for (int i = 0; i < numberOfThrows; i++) {
            synchronized (dice) {
                dice.throwDice();
                int pips = dice.getPips();
                System.out.println(name + " throws " + pips + " in turn " + i);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    */
}