package FactoryPattern;

public class Sedan implements Car{

    @Override
    public void assemble() {
        System.out.println("sedan assembling");
    }
}
