package development;

import visitor.FigureVisitor;

/**
 *
 * @author SrBlimp
 */
public class AreaDoubler implements FigureVisitor {

    private static final double MATH_SQRT = Math.sqrt(2.0);
    private Figure figure;

    public Figure getFigure() {
        return figure;
    }

    @Override
    public void visit(Circle circle) {
        figure = new Circle(circle.getX(), circle.getY(), circle.getR() * MATH_SQRT);
    }

    @Override
    public void visit(Rectangle rectangle) {
        figure = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth() * MATH_SQRT, rectangle.getHeight() * MATH_SQRT);
    }

    @Override
    public void visit(Drawing drawing) 
    {
        DrawingBuilder drawingBuilder = new DrawingBuilder(drawing.getX(), drawing.getY());
        for (Figure fig: drawing.getComponents()) 
        {
            AreaDoubler areaDoubler = new AreaDoubler();
            fig.accept(this);
            drawingBuilder.add(getFigure());
        }
        figure = drawingBuilder.build();
    }
}
