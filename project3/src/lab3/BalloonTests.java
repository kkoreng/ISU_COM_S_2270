package lab3;

import balloon3.Balloon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalloonTests {

    @Test
    public void test1() {
        Balloon b = new Balloon(10);
        assertEquals(0, b.getRadius());

    }

    @Test
    public void test2() {
        Balloon b = new Balloon(5);
        b.blow(6);
        assertEquals(0, b.getRadius());
    }

    @Test
    public void test3() {
        Balloon b = new Balloon(5);
        b.blow(6);
        int r = b.getRadius();
        b.blow(3);
        assertEquals(r, b.getRadius());
    }

    @Test
    public void test4() {
        Balloon b = new Balloon(100);
        b.blow(3);
        b.blow(2);
        assertEquals(5, b.getRadius());
    }

    @Test
    public void test5() {
        Balloon b = new Balloon(10);
        b.blow(4);
        b.deflate();
        assertEquals(0, b.getRadius());
    }

    @Test
    public void test6() {
        Balloon b = new Balloon(10);
        b.blow(4);
        b.pop();
        assertEquals(0, b.getRadius());
    }

    @Test
    public void test7() {
        Balloon b = new Balloon(10);
        b.blow(0);
        assertEquals(0, b.getRadius());
        b.blow(-5);
        assertEquals(0, b.getRadius());
    }

    @Test
    public void test8() {
        Balloon b = new Balloon(10);
        b.deflate();
        assertEquals(false, b.isPopped());
    }

}