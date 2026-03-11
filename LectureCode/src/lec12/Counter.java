package lec12;

// A counter is a class that can be used to count things, just like an int
// but it "knows" a name for itself.
class Counter {
    private int count;
    private String name;

    // no default constructor here because we want to always have a name
    public Counter(String name) { // initialize
        this(name, 0);
    }
    public Counter(String name, int count) { // initialize
        this.name = name;
        this.count = count;
        System.out.println("Counter " + name + " is: " + count);
    }
    public Counter(Counter other) { // copy constructor
        this.count = other.count;
        this.name = other.name;
        // this(other.name, other.count);
    }
    public void countOne() { // mutators
        count = count + 1;
        System.out.println("Increase " + name + " to count  " + count);
    }
    // not using toString because that does not allow parameter in
    public void print(String handleName) {
        System.out.println("RefName=" + handleName +
                ", ObjectName=" + name +
                ", count=" + count);
    }
}