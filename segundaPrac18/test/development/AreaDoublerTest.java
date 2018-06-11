package development;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AloitR
 */
public class AreaDoublerTest 
{
    
    public AreaDoublerTest() 
    {
    }

    @Test
    public void testCircleDoubler() 
    {
        Circle circle = new Circle(2, 4, 6);
        Circle doubleCircle = new Circle(2, 4, 6 * Math.sqrt(2));
        
        AreaDoubler doubler = new AreaDoubler();
       
        circle.accept(doubler);
        
        Circle result = (Circle) doubler.getFigure();
        assertEquals(doubleCircle, result);
    }
    
    @Test
    public void testRectangleDoubler() 
    {
        Rectangle rectangle = new Rectangle(2, 4, 6, 8);
        Rectangle rectangleDouble = new Rectangle(2, 4, 6* Math.sqrt(2), 8* Math.sqrt(2));
        
        AreaDoubler doubler = new AreaDoubler();
        rectangle.accept(doubler);
        
        Rectangle result = (Rectangle) doubler.getFigure();
        assertEquals(rectangleDouble, result);
    }
    
    @Test
    public void testDrawingDoubled() 
    {
        Drawing drawing = new DrawingBuilder(2, 4)
                .add(new Circle(2, 4, 6))
                .add(new Rectangle(2, 4, 6, 8))
                .build();
        
        Drawing drawingDouble = new DrawingBuilder(2, 4)
                .add(new Circle(2, 4, 6 * Math.sqrt(2)))
                .add(new Rectangle(2, 4, 6 * Math.sqrt(2), 8 * Math.sqrt(2)))
                .build();
        
        AreaDoubler doubler = new AreaDoubler();
        drawing.accept(doubler);
        
        Drawing result = (Drawing) doubler.getFigure();
        assertEquals(drawingDouble, result);
    }
}
