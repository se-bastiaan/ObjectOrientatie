import java.util.ArrayList;
import java.util.List;

/**
 * @author Giel Besouw - s4483898
 * @author Sébastiaan Versteeg - s4459636
 */
public class Board {

    private int m = 6;
    private int n = 6;
    private Positie positie;
    private int teller = 1;
    private int[][] prio = new int[m][n];
    private int[][] bord = new int[m][n];

    public Board(int size1, int size2) {
        m = size1;
        n = size2;

        positie = new Positie(0, 0);
        bord[positie.getX()][positie.getY()] = 1;

        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; i < n / 2; j++) {
                prio[i][j] = i + j;
                prio[m - 1 - i][j] = i + j;
                prio[i][n - 1 - j] = i + j;
                prio[m - 1 - i][n - 1 - j] = i + j;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bord[i][j] = m * n + 1;
            }
        }
    }

    private Positie besteStap(Positie[] pa) {
        Positie p = new Positie(0, 0);
        int pr = 100000;
        for(Positie aPa : pa) {
            if (prio[aPa.getX()][aPa.getY()] < pr) {
                p = aPa;
            }
        }
        return p;
    }

    private void zoekPad(Positie p) {
        Positie[] sprong =
                {
                        new Positie(1, 2), new Positie(1, -2), new Positie(2, 1), new Positie(2, -1), new Positie(-1, 2), new Positie(-1, -2), new Positie(-2, 1), new Positie(-2, -1)
                };


        List<Positie> mogelijkheden = new ArrayList<Positie>();
        for (int i = 0; i < 8; i++) {
            Positie p2 = new Positie(p.getX(), p.getY());
            p2.add(sprong[i]);

            if (p2.getX() >= 0 && p2.getX() < m && p2.getY() >= 0 && p2.getY() < 6 && bord[p2.getX()][p2.getY()] > teller) {
                mogelijkheden.add(p2);
            }

        }
        Positie doel = besteStap((Positie[]) mogelijkheden.toArray());

        teller++;
        bord[doel.getX()][doel.getY()] = teller;
        positie = doel;
    }

    private boolean gevonden(Positie p) {
        int aantal = m * n;
        return bord[p.getX()][p.getY()] >= aantal;
    }

    public int getHeuristiek(Positie p) {
        positie = p;
        return bord[p.getX()][p.getY()];
    }

}
