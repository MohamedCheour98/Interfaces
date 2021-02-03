import java.awt.Color;
import java.awt.Point;

public class Triangle implements Shape {

    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private Color color;

    public Triangle(Point a, Point b, Point c, Color color) {
        this.vertexA = a;
        this.vertexB = b;
        this.vertexC = c;
        this.color = color;
    }

    public Point getVertexA(){ return vertexA; }

    public Point getVertexB(){ return vertexB; }

    public Point getVertexC(){ return vertexC; }

    public boolean equals(Object o){

        if (o == null) { return false; }

        if (o.getClass() != this.getClass()) { return false; }

        Triangle other = (Triangle) o;

        return this.vertexA.equals(other.vertexA) && this.vertexB.equals(other.vertexB) &&
                this.vertexC.equals(other.vertexC) && this.color.equals(other.color);
    }

    public Color getColor(){ return color; }

    public void setColor(Color c){ color = c; }

    public double getArea(){

        double area;
        area = Math.abs((vertexA.x*(vertexB.y - vertexC.y) + vertexB.x*(vertexC.y - vertexA.y) +
                vertexC.x*(vertexA.y - vertexB.y)) / 2.0);
        return area;
    }
    public double getPerimeter(){

        double distanceAB = 0.0;
        double distanceBC = 0.0;
        double distanceCA = 0.0;
        double perimeter = 0.0;

        distanceAB = Math.sqrt(Math.pow((vertexB.x - vertexA.x), 2.0) + Math.pow((vertexB.y - vertexA.y), 2.0));
        distanceBC = Math.sqrt(Math.pow((vertexC.x - vertexB.x), 2.0) + Math.pow((vertexC.y - vertexB.y), 2.0));
        distanceCA = Math.sqrt(Math.pow((vertexA.x - vertexC.x), 2.0) + Math.pow((vertexA.y - vertexC.y), 2.0));

        perimeter = distanceAB + distanceBC + distanceCA;
        return perimeter;
    }

    public void translate(Point p){

        vertexA.x += p.x;
        vertexA.y += p.y;

        vertexB.x += p.x;
        vertexB.y += p.y;

        vertexC.x += p.x;
        vertexC.y += p.y;
    }
}
