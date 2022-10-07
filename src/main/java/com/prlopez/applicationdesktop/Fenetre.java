package com.prlopez.applicationdesktop;

import com.sun.nio.sctp.MessageInfo;

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


        bouton.addActionListener(e -> {
    Object[] choix = {"Oui", "Nope :("};
           int reponse= JOptionPane.showOptionDialog(
                   this,
                   "Voulez vous fermer l'application ?",
                   "confirmer",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,
                   choix,
                   choix[0]);

            if(reponse == JOptionPane.YES_OPTION){
                System.exit(0);
            };

                });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenetre();

    }
}
