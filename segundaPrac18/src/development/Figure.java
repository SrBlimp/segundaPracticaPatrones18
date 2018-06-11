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
public abstract class Figure {
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public abstract void accept(FigureVisitor figureVisitor);
    
    @Override
    public boolean equals(Object o) 
    {
        if (!(o instanceof Figure)) 
        {
            return false;
        }
        Figure figure = (Figure) o;
        return x == figure.getX() && y == figure.getY();
    }
    
}
