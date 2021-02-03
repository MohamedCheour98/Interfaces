import java.awt.Color;
import java.awt.Point;

public class Rectangle implements Shape {

    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    public Rectangle(double width, double height, Point topLeft, Color color) {
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }

    public double getWidth(){

        return width;
    }

    public void setWidth(double width){

        this.width = width;
    }

    public double getHeight(){

        return height;
    }

    public void setHeight(double height){

        this.height = height;
    }

    public Point getTopLeft(){

        return topLeft;
    }

    public boolean equals(Object o){

        if (o == null) { return false; }

        if (o.getClass() != this.getClass()) { return false; }

        Rectangle other = (Rectangle) o;

        return this.width == other.width && this.height == other.height && this.topLeft.equals(other.topLeft) &&
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
        area = width * height;
        return area;
    }

    public double getPerimeter(){

        double perimeter = 0.0;
        perimeter = 2 * (width+height);
        return perimeter;

    }

    public void translate(Point p){

        topLeft.x += p.x;
        topLeft.y += p.y;
    }

}
