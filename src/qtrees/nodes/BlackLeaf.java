package qtrees.nodes;

import qtrees.base.Bitmap;
import qtrees.base.QTNode;

import java.io.IOException;
import java.io.Writer;

/**
 * Represents one black leaf in a {@link qtrees.base.QTree}
 */
public class BlackLeaf extends QTNode {
    /**
     * Fill {@link qtrees.base.Bitmap} with {@link qtrees.base.QTNode} contents
     * @param x int
     * @param y int
     * @param width int
     * @param bitmap {@link qtrees.base.Bitmap}
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        fillArea(x, y, width, bitmap, false);
    }

    /**
     * Write {@link qtrees.base.QTNode} to {@link java.io.Writer}
     * @param writer {@link java.io.Writer}
     */
    @Override
    public void writeNode(Writer writer) throws IOException {
        writer.append('0');
        writer.append('0');
    }
}
