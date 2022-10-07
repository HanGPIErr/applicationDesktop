package com.prlopez.applicationdesktop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    public Fenetre() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        setContentPane(panneau);
        JButton bouton = new JButton("Click moi :)");

        panneau.add(bouton);

        ActionListener evenement = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu m'as Cliqué !");
            }
        };

        bouton.addActionListener(evenement);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenetre();

    }
}
