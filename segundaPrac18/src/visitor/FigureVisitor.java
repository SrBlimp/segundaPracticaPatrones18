/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import development.Circle;
import development.Drawing;
import development.Rectangle;

/**
 *
 * @author srblimp
 */
public interface FigureVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Drawing drawing);
}
