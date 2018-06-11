/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import visitor.FigureVisitor;

/**
 *
 * @author srblimp
 */
public class Rectangle extends Figure {
    private final double width;
    private final double height;
    
    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
    
    @Override
    public boolean equals(Object o) 
    {
        if (!(o instanceof Rectangle)) 
        {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return super.equals(o) && width == rectangle.getWidth() && height == rectangle.getHeight();
    }
}
