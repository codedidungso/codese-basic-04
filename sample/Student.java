/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

/**
 *
 * @author thiennd
 */
abstract class Human implements Run, Talk {

    boolean isMale;
    int age;
}

interface Run {

    void running();
}

interface Talk {

    void talking();
}

interface TachMon {

    void tachtachtach();
}

class Student extends Human implements TachMon {

    int mssv;
    String hoten;

    @Override
    public void running() {
        System.out.println("im runnnig");
    }

    @Override
    public void talking() {
        System.out.println("im talking");
    }

    @Override
    public void tachtachtach() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class CodeseStudent extends Student {

    @Override
    public void tachtachtach() {
        System.out.println("codese never tach");
    }

}

class Dog implements Run {

    @Override
    public void running() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
