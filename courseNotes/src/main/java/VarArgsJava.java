import java.awt.Polygon;
import java.awt.Point;

public class VarArgsJava {
    public static Polygon polygonFrom(Point... points) {
        Polygon polygon = new Polygon();
        for (Point point: points)
           polygon.addPoint(point.x, point.y);
        return polygon;
    }

    public static void main(String[] args) {
        Polygon square = polygonFrom(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0));
        System.out.println("Bounding box of polygon is: " + square.getBounds2D());
    }
}
