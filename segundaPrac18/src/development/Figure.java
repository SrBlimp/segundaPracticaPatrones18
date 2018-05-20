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
    private double x;
    private double y;

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
    
}
