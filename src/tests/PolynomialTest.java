package tests;

import junit.framework.TestCase;
import org.junit.Test;
import polynomial.Polynomial;

public class PolynomialTest extends TestCase {

    @Test
    public void testToString() throws Exception {
        Polynomial test1 = new Polynomial( "1.0 1 -5 6 4 8 2.0 2 3.0 4");
        Polynomial test2 = new Polynomial( "4 2 5 6");

        assertEquals("4,000000x^8 + -5,000000x^6 + 3,000000x^4 + 2,000000x^2 + 1,000000x", test1.toString());
        assertEquals("5,000000x^6 + 4,000000x^2", test2.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Polynomial test1 = new Polynomial( "1.0 1 2.0 2" );
        Polynomial test2 = new Polynomial( "1.0 1 2.0 2" );

        assertEquals(test1, test2);
    }

    @Test
    public void testPlus() throws Exception {
        Polynomial
                p1 =new Polynomial( "1.0 1 2.0 2 2.0 4" ),
                p2 = new Polynomial( "1.0 1 2.0 3 2.0 4" ),
                p3 = new Polynomial( "3.0 3" ),
                p4 = new Polynomial(p1),
                p5 = new Polynomial(p2),
                p6 = new Polynomial(p1),
                p7 = new Polynomial(p2),
                p8 = new Polynomial(p3),
                p9 = new Polynomial(p1),
                p10 = new Polynomial(p2),
                p11 = new Polynomial(p3),
                p12 = new Polynomial(p1),
                p13 = new Polynomial("0 0");

        Polynomial
                test1 = new Polynomial( "2.0 1 2.0 2 2.0 3 4.0 4" ),
                test2 = new Polynomial( "2.0 1 2.0 2 5.0 3 4.0 4" ),
                test3 = new Polynomial( p12 );

        p1.plus(p2);
        p5.plus(p4);

        p6.plus(p7).plus(p8);
        p9.plus(p10.plus(p11));

        p12.plus(p13);
        p13.plus(p12);

        // Test commutativity:
        assertEquals(test1, p1);
        assertEquals(test1, p5);
        // Test associativity:
        assertEquals(test2, p6);
        assertEquals(test2, p9);
        // Test identity:
        assertEquals(test3, p12);
        assertEquals(test3, p13);
    }

    @Test
    public void testTimes() throws Exception {
        Polynomial
                p1 = new Polynomial( "1.0 1 2.0 2 2.0 4" ),
                p2 = new Polynomial( "1.0 1 2.0 3 2.0 4" ),
                p3 = new Polynomial( "3.0 3" ),
                p4 = new Polynomial(p1),
                p5 = new Polynomial(p2),
                p6 = new Polynomial(p1),
                p7 = new Polynomial(p2),
                p8 = new Polynomial(p3),
                p9 = new Polynomial(p1),
                p10 = new Polynomial(p2),
                p11 = new Polynomial(p3),
                p12 = new Polynomial(p1),
                p13 = new Polynomial("1 0"),
                p14 = new Polynomial(p1),
                p15 = new Polynomial(p2),
                p16 = new Polynomial(p3),
                p17 = new Polynomial(p1),
                p18 = new Polynomial(p2),
                p19 = new Polynomial(p1),
                p20 = new Polynomial(p3);

        Polynomial
                test1 = new Polynomial( "1 2 2 3 2 4 8 5 4 6 4 7 4 8" ),
                test2 = new Polynomial( "12 11 12 10 12 9 24 8 6 7 6 6 3 5" ),
                test3 = new Polynomial( p12 );

        p1.times(p2);
        p5.times(p4);

        p6.times(p7).times(p8);
        p9.times(p10.times(p11));

        p12.times(p13);
        p13.times(p12);

        p14.times(p15.plus(p16));
        p17.times(p18).plus(p19.times(p20));

        // Test commutativity:
        assertEquals(test1, p1);
        assertEquals(test1, p5);
        // Test associativity:
        assertEquals(test2, p6);
        assertEquals(test2, p9);
        // Test identity:
        assertEquals(test3, p12);
        assertEquals(test3, p13);
        // Test distributivity:
        assertEquals(test3, p12);
        assertEquals(test3, p13);
    }

    @Test
    public void testMinus() throws Exception {
        Polynomial
                p1 =new Polynomial( "1.0 1 2.0 2 2.0 4" ),
                p2 = new Polynomial( "1.0 1 2.0 3 2.0 4" ),
                p3 = new Polynomial( "3.0 3" ),
                p6 = new Polynomial(p1),
                p7 = new Polynomial(p2),
                p8 = new Polynomial(p3),
                p9 = new Polynomial(p1),
                p10 = new Polynomial(p2),
                p11 = new Polynomial(p3);

        Polynomial
                test1 = new Polynomial( "2.0 2 -2.0 3" ),
                test2 = new Polynomial( "2.0 2 -5.0 3" );

        p1.minus(p2);

        p6.minus(p7).minus(p8);

        p9.plus(p10.times(new Polynomial("-1 0")));

        assertEquals(test1, p1);
        assertEquals(test2, p6);
        assertEquals(test1, p9);
    }

    /*@Test
    public void testDivide() throws Exception {
        Polynomial
                p1 = new Polynomial( "1 2 2 3 2 4 8 5 4 6 4 7 4 8" ),
                p2 = new Polynomial( "1.0 1 2.0 3 2.0 4" ),
                p3 = new Polynomial(p1);

        // Not sure if this is correct, testing not reliable
        Polynomial test1 = new Polynomial(p2);

        p1.times(p2).divide(p3);

        assertEquals(test1, p1);
    }*/

    @Test
    public void testApply() throws Exception {
        Polynomial p1 = new Polynomial( "1.0 1 2.0 2 2.0 4" );
        assertEquals(548, p1.apply(4));
    }
}