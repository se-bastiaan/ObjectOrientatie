package qtrees.tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import qtrees.base.Bitmap;
import qtrees.base.QTree;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class QTNodeTest extends TestCase {

    private String text = "10011010001010010001010101100011000101000000";
    private QTree tree;

    @Before
    protected void setUp() throws Exception {
        StringReader input = new StringReader(text);
        try {
            tree = new QTree(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReaderToWriterConversion() {
        StringWriter output = new StringWriter();
        try {
            tree.writeQTree(output);
            assertEquals(text, output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReaderToBitmapConversion() {
        String bitmapStr = "OOOO*OOO\nOOOO**OO\nOOOO**O*\nOOOO****\nOOOOOO**\nOOOOOO**\nOOOOOOO*\nOOOOOOO*\n";
        Bitmap bitmap = new Bitmap(8,8);
        tree.fillBitmap(bitmap);
        assertEquals(bitmapStr, bitmap.toString());
    }

    @Test
    public void testBitmapToWriterConversion() {
        Bitmap bitmap = new Bitmap(8,8);
        tree.fillBitmap(bitmap);

        QTree tree1 = new QTree(bitmap);
        StringWriter output = new StringWriter();
        try {
            tree1.writeQTree(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(text, output.toString());
    }

}
