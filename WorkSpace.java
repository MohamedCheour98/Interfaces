import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class WorkSpace {

    private List<Shape> objectsList = new ArrayList<>();

    public WorkSpace() {}

    public void add(Shape shape){ objectsList.add(shape); }

    public Shape get(int index) {
        if (objectsList.size() == 0){
            return null;
        }
        else
            return objectsList.get(index); }

    public int size(){ return objectsList.size(); }

    public List<Circle> getCircles(){

        List<Circle> circlesList = new ArrayList<>();
        for (Shape s : objectsList){
            if (s instanceof Circle){
                circlesList.add((Circle)s);
            }
        }

        return circlesList;
    }

    public List<Rectangle> getRectangles(){

        List<Rectangle> rectanglesList = new ArrayList<>();
        for (Shape s : objectsList){
            if (s instanceof Rectangle){
                rectanglesList.add((Rectangle)s);
            }
        }

        return rectanglesList;
    }

    public List<Triangle> getTriangles(){

        List<Triangle> trianglesList = new ArrayList<>();
        for (Shape s : objectsList){
            if (s instanceof Triangle){
                trianglesList.add((Triangle)s);
            }
        }

        return trianglesList;

    }

    public List<Shape> getShapesByColor(Color color){

        List<Shape> commonColorList = new ArrayList<>();
        for (Shape s : objectsList){
            if (s.getColor().equals(color)){
                commonColorList.add(s);
            }
        }

        return commonColorList;
    }

    public double getAreaOfAllShapes(){

        double totalArea = 0.0;
        for (Shape s : objectsList){
            totalArea += s.getArea();
        }
        return totalArea;
    }

    public double getPerimeterOfAllShapes(){

        double totalPerimeter = 0.0;
        for (Shape s : objectsList){
            totalPerimeter += s.getPerimeter();
        }
        return totalPerimeter;
    }

}
