package lec08;

public class Rectangle {
    private int height;
    private int width;

    public void setSize(int heightVal, int widthVal) {
        height = heightVal;
        width = widthVal;
    }

    public int getArea() {
        return height * width;
    }

    public int getPerimeter() {
        return (height * 2) * (width * 2); // <-- BUG!
    }
}