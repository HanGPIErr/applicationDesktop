package com.prlopez.applicationdesktop;

import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Fenetre extends JFrame {

    public Fenetre() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        setContentPane(panneau);

        //----------- BUTTON -------------------
        JButton bouton = new JButton("Fermer l'application");

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

        //-------- COMBOBOX --------
        String[] listeCivilite = {"M.", "Me.", "Mlle.", "Non précisé"};
        JComboBox<Object> selectCivilite = new JComboBox<>(listeCivilite);
        panneau.add(selectCivilite);

        selectCivilite.addActionListener((ActionEvent e) ->{
            JComboBox comboBox = (JComboBox) e.getSource();
            System.out.println(comboBox.getSelectedItem());

        });


        //----------- autre exemple -----------------

        Utilisateur[] utilisateurs={
                new Utilisateur("BANSEPT", "Franck"),
                new Utilisateur("SNOW", "John"),
                new Utilisateur("SMITH", "Steve")
        };

        JComboBox<Utilisateur>selectUtilisateur = new JComboBox<>(utilisateurs);
        panneau.add(selectUtilisateur);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Fenetre();

    }
}
