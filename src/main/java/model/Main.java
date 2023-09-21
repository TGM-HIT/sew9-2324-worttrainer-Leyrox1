package model;

import view.View;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        Worttrainer worttrainer = new Worttrainer();
        View view = new View(worttrainer);
        Wort[] woerter = worttrainer.getWoerter();



    }
}
