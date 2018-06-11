/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SrBlimp
 */
public class DrawingBuilderTest 
{ 
    public DrawingBuilderTest() 
    {
    }
    
    @Test
    public void testComponentsAreAddedWithoutBuilder()
    {
        List<Figure> components = new ArrayList<>();
        Circle circle = new Circle(2.0, 2.0, 2.0);
        Rectangle rectangle = new Rectangle(2.0, 2.0, 2.0, 2.0);
        
        components.add(circle);
        components.add(rectangle);
        Drawing drawing = new Drawing(2.0, 2.0, components);
        
        assertEquals(drawing.getComponents().size(), 2);
    }
    
    
    @Test
    public void testCreateACircleWithBuilder()
    {
        Circle circle = new Circle(1.0, 2.0, 3.0);
        DrawingBuilder drawingBuilder = new DrawingBuilder(4.0, 5.0);
        drawingBuilder.add(circle);
        Drawing drawing = drawingBuilder.build();
        
        assertEquals(drawing.getComponents().size(), 1);
        assertTrue(drawing.getComponents().get(0).getX() == 1.0);
        assertTrue(drawing.getComponents().get(0).getY() == 2.0);
        assertTrue(( (Circle) drawing.getComponents().get(0)).getR() == 3.0);
    }
    
    @Test
    public void testCreateARectangleWithBuilder()
    {
        Rectangle rectangle = new Rectangle(4.0, 3.0, 2.0, 1.0);
        DrawingBuilder drawingBuilder = new DrawingBuilder(4.0, 5.0);
        drawingBuilder.add(rectangle);
        Drawing drawing = drawingBuilder.build();
        
        assertEquals(drawing.getComponents().size(), 1);
        assertTrue(drawing.getComponents().get(0).getX() == 4.0);
        assertTrue(drawing.getComponents().get(0).getY() == 3.0);
        assertTrue(((Rectangle)drawing.getComponents().get(0)).getHeight() == 1.0);
        assertTrue(((Rectangle)drawing.getComponents().get(0)).getWidth() == 2.0);
    }
    
    @Test
    public void testManualDrawingEqualsABuilderDrawing() 
    {
        List<Figure> components = new ArrayList<>();
        Circle circle = new Circle(2.0, 2.0, 2.0);
        Rectangle rectangle = new Rectangle(2.0, 2.0, 2.0, 2.0);
        
        components.add(circle);
        components.add(rectangle);
        Drawing manualDrawing = new Drawing(2.0, 2.0, components);
        
        assertEquals(manualDrawing.getComponents().size(), 2);
        
        DrawingBuilder drawingBuilder = new DrawingBuilder(2.0, 2.0);
        drawingBuilder.add(circle);
        drawingBuilder.add(rectangle);
        Drawing builderDrawing = drawingBuilder.build();
        
        assertEquals(builderDrawing.getComponents().size(), 2);
        assertEquals(manualDrawing.getComponents(), builderDrawing.getComponents());
        
        assertEquals(manualDrawing, builderDrawing);
    }
    
    @Test
    public void testBuildingAnEmptyDrawingWillBeEmpty() 
    {
        DrawingBuilder drawingBuilder = new DrawingBuilder(2.0, 2.0);
        Drawing builderDrawing = drawingBuilder.build();
        
        assertEquals(2.0, builderDrawing.getX(), 0);
        assertEquals(2.0, builderDrawing.getY(), 0);
        
        assertTrue(builderDrawing.getComponents().isEmpty());
        assertEquals(new ArrayList<>(), builderDrawing.getComponents());
    }
    
    
    @Test
    public void testDrawingEqualsBuilderAndDrawing() 
    {
        Figure circle = new Circle(2.0, 2.0, 2.0);
        
        List<Figure> components = new ArrayList<>();
        components.add(circle);
        
        DrawingBuilder builder = new DrawingBuilder(2.0, 2.0);
        builder.add(circle);
        
        assertEquals(new Drawing(2.0, 2.0,components), builder.build());
    }
    
}
