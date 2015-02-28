package oo4;

import java.util.Scanner;

/**
 * @author Sébastiaan Versteeg / s4459636
 */
public class Application {

    public static void main(String[] args) {
        Loipe l = new Loipe("srrsslssllrsrrrslssslsllsslrrsss");
        AsciiArt a = new AsciiArt(l);
        a.teken();

        Scanner s = new Scanner(System.in);
        boolean done = false, start = false;
        while(!done) {
            if(s.hasNext()) {
                s.next();
                if(start) {
                    Punt p = l.stap();
                    if (p == null) {
                        done = true;
                        break;
                    }
                    a.setPosition(p);
                } else {
                    start = true;
                    a.setPosition(l.start());
                }
            }
        }
    }

}
