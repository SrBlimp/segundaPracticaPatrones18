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
    private double r;
    
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
    
}
