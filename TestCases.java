import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.Color;
import java.awt.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /* some sample tests but you must write more! see lab write up */
   @Test
   public void testCircleConstructor()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(5.678, c.getRadius(), DELTA);
      assertEquals(new Point (2, 3), c.getCenter());
      assertEquals(Color.BLACK, c.getColor());
   }

   @Test
   public void testRectangleConstructor()
   {
      Rectangle c = new Rectangle(5.465, 6.525, new Point(2, 3), Color.BLACK);

      assertEquals(5.465, c.getWidth(), DELTA);
      assertEquals(6.525, c.getHeight(), DELTA);
      assertEquals(new Point (2, 3), c.getTopLeft());
      assertEquals(Color.BLACK, c.getColor());
   }

   @Test
   public void testTriangleConstructor()
   {
      Triangle c = new Triangle(new Point(4, 3), new Point(2, 5), new Point(2, 3), Color.RED);

      assertEquals(new Point(4, 3), c.getVertexA());
      assertEquals(new Point(2, 5), c.getVertexB());
      assertEquals(new Point (2, 3), c.getVertexC());
      assertEquals(Color.RED, c.getColor());
   }

   @Test
   public void testCircleSetter()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(5.678, c.getRadius(), DELTA);
      assertEquals(new Point (2, 3), c.getCenter());
      assertEquals(Color.BLACK, c.getColor());
      c.setRadius(9.647);
      c.setColor(Color.BLUE);
      assertEquals(9.647, c.getRadius(), DELTA);
      assertEquals(Color.BLUE, c.getColor());
   }

   @Test
   public void testRectangleSetter()
   {
      Rectangle c = new Rectangle(5.465, 6.525, new Point(2, 3), Color.BLACK);

      c.setWidth(9.647);
      c.setColor(Color.BLUE);
      c.setHeight(9.098);
      c.translate(new Point (-1, 5));
      assertEquals(9.647, c.getWidth(), DELTA);
      assertEquals(Color.BLUE, c.getColor());
      assertEquals(9.098, c.getHeight(), DELTA);
      assertEquals(new Point (1, 8), c.getTopLeft());
   }

   @Test
   public void testTriangleTranslate()
   {
      Triangle c = new Triangle(new Point(4, 3), new Point(2, 5), new Point(2, 3), Color.RED);

      c.setColor(Color.BLUE);
      c.translate(new Point (-1, 5));
      assertEquals(new Point (3, 8), c.getVertexA());
      assertEquals(Color.BLUE, c.getColor());
      assertEquals(new Point (1, 10), c.getVertexB());
      assertEquals(new Point (1, 8), c.getVertexC());
   }

   @Test
   public void testCircleGetArea()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(101.2839543, c.getArea(), DELTA);
   }

   @Test
   public void testRectangleGetArea()
   {
      Rectangle c = new Rectangle(5.465, 6.525, new Point(2, 3), Color.BLACK);

      assertEquals(35.65912, c.getArea(), DELTA);
   }

   @Test
   public void testTriangleGetArea()
   {
      Triangle c = new Triangle(new Point(4, 3), new Point(-2, -5), new Point(2, 3), Color.RED);

      assertEquals(8.0, c.getArea(), DELTA);
   }

   @Test
   public void testCircleGetPerimeter()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(35.6759261, c.getPerimeter(), DELTA);
   }

   @Test
   public void testRectangleGetPerimeter()
   {
      Rectangle c = new Rectangle(5.465, 6.525, new Point(-2, -3), Color.BLACK);

      assertEquals(23.98, c.getPerimeter(), DELTA);
   }

   @Test
   public void testTriangleGetPerimeter()
   {
      Triangle c = new Triangle(new Point(4, 3), new Point(-2, -5), new Point(2, 3), Color.RED);

      assertEquals(20.94427, c.getPerimeter(), DELTA);
   }

   @Test
   public void testCircle()
   {
      Circle c = new Circle(4.653, new Point(-2, -3), Color.BLACK);
      Circle d = new Circle(4.653, new Point(-2, -3), Color.BLACK);

      assertEquals(4.653, c.getRadius(), DELTA);
      assertEquals(new Point (-2, -3), c.getCenter());
      assertEquals(Color.BLACK, c.getColor());
      assertEquals(68.01676, c.getArea(), DELTA);
      assertEquals(29.23566, c.getPerimeter(), DELTA);
      assertEquals(c, d);
      c.setRadius(6.647);
      c.setColor(Color.BLUE);
      assertEquals(6.647, c.getRadius(), DELTA);
      assertEquals(Color.BLUE, c.getColor());
      assertEquals(138.80375, c.getArea(), DELTA);
      assertEquals(41.76433, c.getPerimeter(), DELTA);
      assertNotEquals(c, d);
   }

   @Test
   public void testCircleEquals()
   {
      Circle c = new Circle(4.653, new Point(2, 3), Color.BLACK);
      Circle d = new Circle(4.653, new Point(-2, -3), Color.BLACK);

      assertFalse(c.equals(d));
      c.translate(new Point(-4, -6));
      assertTrue(d.equals(c));
      d.setRadius(5.987);
      assertFalse(d.equals(c));
      c.setRadius(5.987);
      assertTrue(c.equals(d));
      d.setColor(Color.BLUE);
      assertFalse(d.equals(c));
      c.setColor(Color.BLUE);
      d.translate(new Point(0, 0));
      assertTrue(c.equals(d));

   }

   @Test
   public void testRectangleEquals()
   {
      Rectangle c = new Rectangle(5.465, 6.525, new Point(2, 3), Color.BLACK);
      Rectangle d = new Rectangle(5.465, 6.525, new Point(-2, -3), Color.BLACK);

      assertFalse(c.equals(d));
      d.translate(new Point(4, 6));
      assertTrue(d.equals(c));
      d.setWidth(5.987);
      assertFalse(d.equals(c));
      c.setWidth(5.987);
      assertTrue(c.equals(d));
      d.setColor(Color.BLUE);
      assertFalse(d.equals(c));
      c.setColor(Color.BLUE);
      c.translate(new Point(0, 0));
      assertTrue(c.equals(d));
      d.setHeight(4.657);
      assertFalse(d.equals(c));
      c.setHeight(4.657);
      assertTrue(c.equals(d));

   }

   @Test
   public void testTriangleEquals()
   {
      Triangle c = new Triangle(new Point(4, 3), new Point(2, 5), new Point(2, 3), Color.RED);
      Triangle d = new Triangle(new Point(4, 3), new Point(-2, -5), new Point(2, 3), Color.RED);
      Triangle e = new Triangle(new Point(1, 8), new Point(-5, 0), new Point(-1, 8), Color.RED);
      Triangle f = new Triangle(new Point(4, 3), new Point(2, 5), new Point(2, 3), Color.BLUE);
      Triangle g = new Triangle(new Point(4, 3), new Point(2, 5), new Point(-2, 3), Color.RED);
      Triangle h = new Triangle(new Point(-4, 3), new Point(2, 5), new Point(2, 3), Color.RED);
      assertFalse(c.equals(d));
      d.translate(new Point(-3, 5));
      assertTrue(d.equals(e));
      d.setColor(Color.BLUE);
      assertFalse(d.equals(c));
      assertFalse(d.equals(e));
      assertFalse(f.equals(c));
      assertFalse(g.equals(c));
      assertFalse(h.equals(c));

   }

   @Test
   public void testWorkSpaceAreaOfAllShapes()
   {
      WorkSpace ws = new WorkSpace();

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
                 Color.BLACK));

      assertEquals(114.2906063, ws.getAreaOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpacePerimeterOfAllShapes()
   {
      WorkSpace ws = new WorkSpace();

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
              Color.BLACK));

      assertEquals(61.09516, ws.getPerimeterOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpaceGetCircles()
   {
      WorkSpace ws = new WorkSpace();
      List<Circle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle c2 = new Circle(1.11, new Point(-5, -3), Color.RED);

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(c1);
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
                 Color.BLACK));
      ws.add(c2);

      expected.add(c1);
      expected.add(c2);

      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getCircles());
   }

   @Test
   public void testWorkSpaceGetRectangles()
   {
      WorkSpace ws = new WorkSpace();
      List<Rectangle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Rectangle r = new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK);
      Triangle t = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
           Color.BLACK);

      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(r);
      ws.add(new Circle(1.11, new Point(-5, -3), Color.RED));
      ws.add(t);

      expected.add(r);
      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getRectangles());
      Rectangle r1 = new Rectangle(4.234, 10.678, new Point(4, -3), Color.BLUE);
      ws.add(r1);
      expected.add(r1);
      assertEquals(expected, ws.getRectangles());
   }

   @Test
   public void testWorkSpaceGetTriangles()
   {
      WorkSpace ws = new WorkSpace();
      List<Triangle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Rectangle r = new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK);
      Triangle t = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
              Color.BLACK);
      assertEquals(null, ws.get(0));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(r);
      assertEquals(2, ws.size());
      ws.add(new Circle(1.11, new Point(-5, -3), Color.RED));
      ws.add(t);

      expected.add(t);
      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getTriangles());
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
              Color.BLACK);
      ws.add(t1);
      expected.add(t1);
      assertEquals(expected, ws.getTriangles());
      assertEquals(5, ws.size());
   }

   @Test
   public void testWorkSpaceGetShapesByColor(){

      WorkSpace ws = new WorkSpace();
      List<Shape> expected = new LinkedList<>();
      List<Shape> expected1 = new LinkedList<>();

      Rectangle a = new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK);
      Triangle b = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), Color.RED);
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle d = new Circle(1.11, new Point(-5, -3), Color.RED);
      Rectangle e = new Rectangle(4.234, 10.678, new Point(4, -3), Color.BLUE);
      ws.add(a);
      ws.add(b);
      ws.add(c);
      ws.add(d);
      ws.add(e);
      expected.add(a);
      expected.add(c);
      expected1.add(b);
      expected1.add(d);
      assertEquals(expected, ws.getShapesByColor(Color.BLACK));
      assertEquals(expected1, ws.getShapesByColor(Color.RED));

   }

   /* HINT - comment out implementation tests for the classes that you have not
    * yet implemented */
   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getRadius", "setRadius", "getCenter", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getWidth", "setWidth", "getHeight", "setHeight", "getTopLeft", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {double.class}, 
         new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testTriangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getVertexA", "getVertexB", "getVertexC", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         Point.class, Point.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[0], new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Triangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
