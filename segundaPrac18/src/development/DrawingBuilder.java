/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author srblimp
 */
public class DrawingBuilder {
    private double x;
    private double y;
    private List<Figure> components;
    
    public DrawingBuilder(double x, double y) {
        this.x = x;
        this.y = y;
        components = new ArrayList<>();
    }
    
    public DrawingBuilder add(Figure figure) {
        components.add(figure);
        return this;
    }
    
    public Drawing build() {
        return new Drawing(x, y, components);
    }
}
