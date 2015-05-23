package oo13.part1;

public class OneDiceNplayers {
    private final Dice dice;
	private static final int PLAYERS = 2;
	private static final int THROWS = 100;
	
	public OneDiceNplayers() {
		dice = new Dice();
	}
	
	public void play() {
		for (int i = 0; i < PLAYERS; i++) {
			Player p = new Player("P" + i, dice, THROWS);
			Thread t = new Thread(p);
			t.start();
		}
	}
	
	public static void main(String[] args) {
		OneDiceNplayers game = new OneDiceNplayers();
		game.play();
	}
}