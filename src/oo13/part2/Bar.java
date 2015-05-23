package oo13.part2;

import java.util.ArrayList;
import java.util.List;

public class Bar {
	private final Tap tap;
	private final List<Glass> glasses;
	private final List<ParchedMan> drinkers;

	public Bar(int numberOfGlasses) {
		tap = new Tap();
		glasses = new ArrayList<>();
		for(int i = 0; i < numberOfGlasses; i++) {
			glasses.add(new Glass());
		}
		drinkers = new ArrayList<>();
	}

	public void letInGuests(int number) {
		for(int i = 0; i < number; i += 1) {
			drinkers.add(new ParchedMan(i, this, tap));
		}
	}

	public void startDrinking() {
		for(ParchedMan man : drinkers) {
			new Thread(man).start();
		}
	}

	public synchronized Glass getGlassIfAvailable() {
        if(glasses.size() > 0)
		    return glasses.remove(0);
        return null;
	}

	public synchronized void putGlass(Glass glass) {
		glasses.add(glass);
	}

	public static void main(String[] args) {
		Bar bar = new Bar(3);
		bar.letInGuests(6);
		bar.startDrinking();
	}
}
