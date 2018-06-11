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
public class Circle extends Figure {
    private final double r;
    
    public Circle(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    public double getR() {
        return r;
    }
    
    @Override
    public void accept(FigureVisitor figureVisitor) {
        figureVisitor.visit(this);
    }
    
    @Override
    public boolean equals(Object o) 
    {
        if (!(o instanceof Circle)) 
        {
            return false;
        }
        Circle circle = (Circle) o;
        return super.equals(o) && r == circle.getR();
    }
    
}
