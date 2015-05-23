package oo13.part2;

public class Tap {
	private static final int CC_PER_GLASS = 200;
	private static final int DRAW_TIME_PER_CC = 1;
	
	public synchronized Glass fillUp(Glass glass) {
		try{
			Thread.sleep(CC_PER_GLASS * DRAW_TIME_PER_CC);		
		} catch (InterruptedException e){}
		glass.fill(CC_PER_GLASS);
		return glass;
	}
}
