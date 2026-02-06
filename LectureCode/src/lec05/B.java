package lec05;

public class B {
    // 1. declare instance variables
    // instance = object
    private int width;
    private int height;

    // 2. constructors
    public B(int w, int h) {
        width = Math.max(w, 0);
        height = Math.max(h, 0);
    }

    // 3. instance method(s)

    // accessor/getter
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getArea() {
        return width * height;
    }
    // mutator/setter
    public void setWidth(int w) {
        width = w;

    }
    public void setHeight(int h) {
        height = h;
    }
    public void growBy(int multiple) {
        width = width * multiple;
        height = height * multiple;
    }
}