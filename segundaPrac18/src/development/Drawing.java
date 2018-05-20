/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author srblimp
 */
public class Drawing extends Figure {
    
    private List<Figure> components;
    
    public Drawing(double x, double y, List<Figure> components) {
        super(x,y);
        this.components = components;
    }

    public List<Figure> getComponents() {
        return Collections.unmodifiableList(components);
    }
}
