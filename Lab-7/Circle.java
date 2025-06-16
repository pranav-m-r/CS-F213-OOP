public class Circle extends Shape   // A Circle "is-a" Shape
{
    // Each Circle "has-a" Point2D, inherited from its parent
    private int radius;

    public Circle(int x, int y, int radius)  // Constructor
    {
        super(x, y);
        this.radius = radius;
    }
    public Circle(Point2D centre, int radius)   // Overloaded Constructor
    {
        this(centre.getX(), centre.getY(), radius);
    }

    // Methods
    public int getRadius()  // Return the radius of the Circle
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public double getArea()     // Override the inherited method, Return the Area of the Circle
    {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }
    public double getPerimeter()    // Override the inherited method, Return the Perimeter of the Circle
    {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
    public boolean withinCircle(Point2D point)  // Return true if the point lies within the Circle
    {
        int x = getCentre().getX() - point.getX();
        int y = getCentre().getY() - point.getY();
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return (distance <= radius);
    }
}