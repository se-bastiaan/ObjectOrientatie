package qtrees.nodes;

import qtrees.base.Bitmap;
import qtrees.base.QTNode;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Represents one internal node in a {@link qtrees.base.QTree}
 */
public class GreyNode extends QTNode {
    private QTNode[] nodes = new QTNode[4];

    /**
     * Construct by {@link java.io.Reader}
     * @param input {@link java.io.Reader}
     * @throws IOException
     */
    public GreyNode(Reader input) throws IOException {
        readNode(input);
    }

    /**
     * Construct by given nodes
     * @param nodes {@link qtrees.base.QTNode}
     */
    public GreyNode(QTNode[] nodes) {
        this.nodes = nodes;
    }

    /**
     * Fill {@link qtrees.base.Bitmap} with {@link qtrees.base.QTNode} contents
     * @param x int
     * @param y int
     * @param width int
     * @param bitmap {@link qtrees.base.Bitmap}
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int quadrant = width / 2;
        int xPos[] = {x, x + quadrant, x + quadrant, x};
        int yPos[] = {y, y, y + quadrant, y + quadrant};
        for(int i = 0; i < 4; i++) {
            nodes[i].fillBitmap(xPos[i], yPos[i], quadrant, bitmap);
        }
    }

    /**
     * Write {@link qtrees.base.QTNode} to {@link java.io.Writer}
     * @param writer {@link java.io.Writer}
     */
    @Override
    public void writeNode(Writer writer) throws IOException {
        writer.append('1');
        for(int i = 0; i < 4; i++) {
            nodes[i].writeNode(writer);
        }
    }

    /**
     * Read {@link qtrees.base.QTNode} from {@link java.io.Reader}
     * @param input {@link java.io.Writer}
     */
    public void readNode(Reader input) throws IOException {
        int read;
        int i = 0;
        while(i < 4 && (read = input.read()) != -1) {
            char c = (char) read;
            if(c == '0') {
                c = (char) input.read();
                if(c == '1') {
                    nodes[i] = new WhiteLeaf();
                } else {
                    nodes[i] = new BlackLeaf();
                }
            } else {
                nodes[i] = new GreyNode(input);
            }
            i++;
        }
    }
}
