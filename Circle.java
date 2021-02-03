import java.awt.Color;
import java.awt.Point;
import java.lang.Math;

public class Circle implements Shape {

    private double radius;
    private Point center;
    private Color color;

    public Circle(double radius, Point center, Color color){
        this.radius = radius;
        this.center = center;
        this.color = color;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public Point getCenter(){
        return center;
    }

    public boolean equals(Object o){

        if (o == null) { return false; }

        if (o.getClass() != this.getClass()) { return false; }

        Circle other = (Circle) o;

        return this.radius == other.radius && this.center.equals(other.center) &&
                this.color.equals(other.color);

    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color c){
        color = c;
    }

    public double getArea(){
        double area = 0.0;
        area = Math.PI * (Math.pow(radius, 2.0));
        return area;
    }

    public double getPerimeter(){
        double perimeter = 0.0;
        perimeter = 2 * Math.PI * radius;
        return perimeter;

    }

    public void translate(Point p){

        center.x += p.x;
        center.y += p.y;

    }


}
