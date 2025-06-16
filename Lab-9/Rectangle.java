// Rectangle.java

public class Rectangle extends Figure implements Comparable<Rectangle> {
    private double width;
    private double height;
    private int index; // To identify the rectangle

    // Constructor
    public Rectangle(double width, double height, int index) {
        this.width = width;
        this.height = height;
        this.index = index;
    }

    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public int getIndex() { return index; }

    public double getPerimeter() {
        return (height + width) * 2;
    }

    public double getArea() {
        return height * width;
    }

    public int compareTo(Rectangle r) {
        if (getArea() > r.getArea()) return -1;
        else if (getArea() < r.getArea()) return 1;
        else return 0;
    }

    public boolean canFit(Rectangle r) {
        return (this.width <= r.width && this.height <= r.height) ||
               (this.height <= r.width && this.width <= r.height);
    }
}
