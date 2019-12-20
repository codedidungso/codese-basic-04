/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javax.swing.JFrame;

/**
 *
 * @author thiennd
 */
public class View extends JFrame {
    
    Control control;
    Model model;
    
    View(Control control, Model model) {
        this.control = control;
        addKeyListener(control);
        this.model = model;
        setTitle(model.title);
        setSize(500, 500);
        setVisible(true);
    }
    
}
