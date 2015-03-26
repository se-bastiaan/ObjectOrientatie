package qtrees.base;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Sjaak Smetsers
 * @version 18-03-2014
 */
public abstract class QTNode {
    public static void fillArea(int x, int y, int width, Bitmap bitmap, boolean val) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                bitmap.setBit(x + i, y + j, val);
            }
        }
    }

    public abstract void fillBitmap(int x, int y, int width, Bitmap bitmap);

    public abstract void writeNode(Writer out) throws IOException;
}
