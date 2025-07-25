public class Shape 
{  
    private Point2D centre;     // Represents the geometric centre of the shape
    // Each Shape "has-A" Point2D as the centre

    public Shape(int x, int y)    // Constructor
    {
        centre = new Point2D(x, y);
    }
    public Shape(Point2D centre)    // Overloaded Constructor
    {
        this(centre.getX(), centre.getY());
    }

    // Methods

    public Point2D getCentre()     // Return the centre of the shape
    {
        return centre;
    }

    // The following two methods will be overriden in the child classes, so just return 0 in both of them
    public double getArea()     // Return the area of the shape
    {
        // DO NOT CHANGE THIS METHOD
        return 0;
    }
    public double getPerimeter()    // Return the perimiter of the shape
    {
        // DO NOT CHANGE THIS METHOD
        return 0;
    }
    public void move(int x, int y)  // Move the Shape to new location
    {
        centre.move(x, y);
    }
    public void move(Point2D newCentre) // Overloaded Method
    {
        centre.move(centre.getX(), centre.getY());
    }
}
