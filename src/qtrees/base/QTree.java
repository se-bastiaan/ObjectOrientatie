package qtrees.base;

import qtrees.nodes.BlackLeaf;
import qtrees.nodes.GreyNode;
import qtrees.nodes.WhiteLeaf;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Represents a Quadtree
 */
public class QTree {
    QTNode root;

    /**
     * Construct {@link qtrees.base.QTree} by {@link java.io.Reader} input
     * @param input {@link java.io.Reader}
     */
    public QTree(Reader input) throws IOException {
        root = readQTree(input);
    }

    /**
     * Construct {@link qtrees.base.QTree} from {@link qtrees.base.Bitmap}
     * @param bitmap {@link qtrees.base.Bitmap}
     */
    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }

    /**
     * Read {@link qtrees.base.QTree} from {@link java.io.Reader} input
     * @param input {@link java.io.Reader}
     * @return root {@link qtrees.base.QTNode}
     * @throws IOException
     */
    private static QTNode readQTree(Reader input) throws IOException {
        int read = input.read();
        if(read != -1) {
            char c = (char) read;
            if(c == '0') {
                c = (char) input.read();
                if(c == '1') {
                    return new WhiteLeaf();
                } else {
                    return new BlackLeaf();
                }
            } else {
                return new GreyNode(input);
            }
        }
        throw new IOException("Invalid input string");
    }

    /**
     * Convert {@link qtrees.base.Bitmap} to {@link qtrees.base.QTree}
     * @param x int
     * @param y int
     * @param width int
     * @param bitmap {@link qtrees.base.Bitmap}
     * @return {@link qtrees.base.QTNode}
     */
    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        if(width != 1) {
            QTNode nodes[] = new QTNode[4];
            int quadrant = width / 2;
            int xPos[] = {x, x + quadrant, x + quadrant, x};
            int yPos[] = {y, y, y + quadrant,  y + quadrant};
            int type = 0;
            for (int i = 0; i < 4; i++) {
                QTNode node = bitmap2QTree(xPos[i], yPos[i], quadrant, bitmap);
                nodes[i] = node;
                if(node instanceof BlackLeaf) {
                    type++;
                } else if(node instanceof WhiteLeaf) {
                    type--;
                }
            }

            if(type > 3) {
                return new BlackLeaf();
            } else if(type < -3) {
                return new WhiteLeaf();
            }
            return new GreyNode(nodes);
        } else {
            return bitmap.getBit(x, y) ? new WhiteLeaf() : new BlackLeaf();
        }
    }

    /**
     * Fill provided {@link qtrees.base.Bitmap} with {@link qtrees.base.QTree} contents
     * @param bitmap {@link qtrees.base.Bitmap}
     */
    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    /**
     * Write {@link qtrees.base.QTree} to {@link java.io.Writer}
     * @param writer {@link java.io.Writer}
     */
    public void writeQTree(Writer writer) throws IOException {
        root.writeNode(writer);
    }

}
