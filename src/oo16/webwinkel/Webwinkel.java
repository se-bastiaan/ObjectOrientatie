package oo16.webwinkel;

import oo16.webwinkel.artikelen.Wasmachine;
import oo16.webwinkel.artikelen.Watermeloen;
import oo16.webwinkel.artikelen.Wijnglas;
import oo16.webwinkel.betaalwijzen.PayPal;

/**
 * Representatie van een webwinkel
 */
public class Webwinkel {

    public static void main(String str[]) {
        Winkelwagen winkelwagen = new Winkelwagen();
        winkelwagen.voegToe(new Wasmachine());
        winkelwagen.voegToe(new Wijnglas());
        winkelwagen.voegToe(new Watermeloen());
        winkelwagen.veranderBetaalwijze(new PayPal("s.versteeg@student.ru.nl", "secretpassword"));
        winkelwagen.betaal();
    }

}
