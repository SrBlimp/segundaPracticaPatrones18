/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SrBlimp
 */
public class DrawingBuilderTest {
    
    public DrawingBuilderTest() {
    }

    @Test
    public void testCreateDrawingCorrectly() {
        Circle circle = new Circle(2.0, 2.0, 2.0);
        Rectangle rectangle = new Rectangle(2.0, 2.0, 2.0, 2.0);
        DrawingBuilder drawingBuilder = new DrawingBuilder(2.0, 2.0);
        drawingBuilder.add(circle);
        drawingBuilder.add(rectangle);
        Drawing drawing = drawingBuilder.build();
        
        assertEquals(drawing.getComponents().size(), 2);
        assertTrue(drawing.getComponents().get(0).getX() == 2.0);
        assertTrue(drawing.getComponents().get(0).getY() == 2.0);
        assertTrue(((Circle) drawing.getComponents().get(0)).getR() == 2.0);
        assertTrue(drawing.getComponents().get(1).getX() == 2.0);
        assertTrue(drawing.getComponents().get(1).getY() == 2.0);
        assertTrue(((Rectangle)drawing.getComponents().get(1)).getHeight() == 2.0);
        assertTrue(((Rectangle)drawing.getComponents().get(1)).getWidth() == 2.0);
    }
    
    @Test
    public void testCreateManualDrawingEqualsToBuilderDrawing() {
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
    }
    
    @Test
    public void testCreateDrawingBuilderWithoutComponents() {
        DrawingBuilder drawingBuilder = new DrawingBuilder(2.0, 2.0);
        Drawing builderDrawing = drawingBuilder.build();
        
        assertTrue(builderDrawing.getComponents().isEmpty());
    }
}
