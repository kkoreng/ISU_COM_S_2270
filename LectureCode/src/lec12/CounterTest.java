package lec12;

public class CounterTest {
    public static void main (String[] args) {
        // objects are kept on the heap, aliasing
        Counter t = new Counter("T");
        t.countOne();
        t.countOne();
        Counter t2 = t; // aliasing
        t.print("t");
        t2.print("t2");
        t.countOne();
        t.print("t");
        t2.print("t2"); // more aliasing, same changes seen in both
        Counter t3 = new Counter(t); // copying with copy constructor
        t3.countOne();
        t3.countOne();
        t.print("t");
        t3.print("t3"); // no aliasing, changes are seen only on t3

        // instructor -- comment out  preceding

        Counter m1 = new Counter("M1");
        int n1 = 0;
        methodA(n1, m1);
        System.out.println("n is: " + n1);
        m1.print("m1");

        Counter m2 = new Counter("M2");
        int n2 = 0;
        methodB(n2, m2);
        m2.print("m2");

        Counter m3 = new Counter("M3");
        int n3 = 0;
        methodC(n3, m3);
        m3.print("m3");

        Counter m4 = new Counter("M4");
        int n4 = 0;
        methodD(n4, m4); // note that we don't assign the return value
        System.out.println("n is: " + n4);
        n4 = methodD(n4, m4); // now we assign the return value
        System.out.println("n is: " + n4);

        Counter m5 = new Counter("M5");
        int n5 = 0;
        methodE(n5, m5);
        m5.print("m5");


        Counter m6 = new Counter("M6");
        int n6 = 0;
        m6 = methodF(n6, m6); // Note re-assignment of m6 to the
        // object reference which is returned from the method
        m6.print("m6");

        Counter m7 = new Counter("M7");
        int n7 = 0;
        methodF(n7, m7);
        m7.print("m7");
//        m7 = methodG(n7, m7);
        m7.print("m7");
    }

    // Increment both stack and heap variables.  Heap changes
    // persist, but stack ones in a stack frame don't.
    // Changes in objects made in a method call are persistent
    // if there is an external reference to the object
    public static void methodA(int n, Counter m) {
        m.countOne();
        n = n + 1;
    }

    // make a local copy of the *reference* (create local alias) and
    // modify the referenced copy --- effects persist in main.
    public static void methodB(int n, Counter m) {
        Counter tmp = m;
        m.print("m");
        tmp.print("tmp");
        tmp.countOne();
        m.print("m");
        tmp.print("tmp");
    }

    // make an object copy (clone, using copy-constructor) and modify the
    // original.  The clone is unchanged, changes to original
    // persist in main
    public static void methodC(int n, Counter m) {
        Counter tmp; // nothing allocated yet
        tmp = new Counter(m); // make a separate copy
        m.print("m");
        tmp.print("tmp");
        m.countOne();
        m.print("m");
        tmp.print("tmp");
    }

    // A way to persist simple type changes (eg. for ints, doubles, booleans,
    // chars etc) is to return the modified value and assign it at the
    // caller site
    public static int methodD(int n, Counter m) {
        n = n + 1;
        return n;
    }

    // When an object is created locally, any changes made on it are
    // not visible to the outside world.
    public static void methodE(int n, Counter m) {
        Counter tmp = new Counter("TMP5"); // this is not a clone
        // it is a completely new object
        tmp.countOne();
    }

    // ... unless the reference to the locally created object is passed
    // out to the caller of the method (and assigned there)
    // Note the difference in return type
    public static Counter methodF(int n, Counter m) {
        Counter tmp = new Counter("TMP6"); // this is not a clone,
        // it is a completely new object
        tmp.countOne();
        return tmp;
    }

    // When a reference parameter is reassigned, any changes made on it are
    // not visible to the outside world, unless returned and assigned at
    // caller location.
    public static void methodG(int n, Counter m) {
        m = new Counter("TMP7");
        m.countOne();
        // change return type to Counter, return m;
    }

}