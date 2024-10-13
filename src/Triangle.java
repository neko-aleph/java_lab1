public class Triangle {
    private final Point[] points;
    private final double perimeter;

    public Triangle(Point a, Point b, Point c) {
        points = new Point[]{a, b, c};
        perimeter = a.getDistance(b) + b.getDistance(c) + c.getDistance(a);
    }

    public double getPerimeter()
    {
        return perimeter;
    }

    public Point[] getPoints()
    {
        return points;
    }
}
