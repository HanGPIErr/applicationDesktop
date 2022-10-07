package com.prlopez.applicationdesktop;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Fenetre extends JFrame {

    protected boolean themeSombre = true;
    public Fenetre() {
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panneau = new JPanel(new BorderLayout());
        setContentPane(panneau);

        //----------- BUTTON -------------------
        JButton bouton = new JButton("Fermer l'application");




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
        // ------------ Ajout bouton switch light mode -----------------
        JButton boutonChangeTheme = new JButton("change theme");

        boutonChangeTheme.addActionListener(e -> {
            try {
                if(themeSombre){
                    themeSombre = false;
                    UIManager.setLookAndFeel( new FlatLightLaf());
                } else {
                    themeSombre = true;
                    UIManager.setLookAndFeel( new FlatDarculaLaf());
                }
                SwingUtilities.updateComponentTreeUI(this);
            } catch( Exception ex ) {
                System.out.println("Failed to initialize LaF");
            }
        });
        //-------- COMBOBOX --------
        String[] listeCivilite = {"M.", "Me.", "Mlle.", "Non précisé"};
        JComboBox<Object> selectCivilite = new JComboBox<>(listeCivilite);


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


        //-----------customiser le rendu de la liste déroulante ----------------
        selectUtilisateur.setRenderer(
                new DefaultListCellRenderer(){

                    @Override
                    public Component getListCellRendererComponent(
                            final JList<?> list,
                            final Object value,
                            final int index, final boolean isSelected,
                            final boolean cellHasFocus) {
                        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                        Utilisateur utilisateur = (Utilisateur) value;
                        if(utilisateur != null){
                            setText(utilisateur.getPrenom() + " " + utilisateur.getNom());
                        }else{
                            setText("Aucun");
                        }

//                        if(isSelected){
//                            setBackground(Color.GREEN);
//                        }else{
//                            setBackground(Color.RED);
//                        }
                        return this;
                    }
                }
        );



        //---------- bouton du formulaire --------

        JButton boutonFormulaire = new JButton("Envoyer");
        boutonFormulaire.addActionListener(e -> {

            if(selectUtilisateur.getSelectedItem() != null) {
                Utilisateur utilisateur =
                        (Utilisateur)selectUtilisateur.getSelectedItem();

                System.out.println(
                        selectCivilite.getSelectedItem() + utilisateur.getNom()
                );
            }

        });


        //------------- Positionnement de nos boutons -----------------
//        panneau.add(bouton);
//        panneau.add(boutonChangeTheme);
//        panneau.add(selectCivilite);
//        panneau.add(selectUtilisateur);
//        panneau.add(boutonFormulaire);

        Box boxPrincipal = Box.createVerticalBox();
        panneau.add(boxPrincipal, BorderLayout.CENTER);

        Box boxMenu = Box.createHorizontalBox();
        boxMenu.add(bouton);
        boxMenu.add(boutonChangeTheme);
        boxPrincipal.add(boxMenu);

        boxPrincipal.add(Box.createRigidArea(new Dimension(1,50)));

        boxPrincipal.add(
                Champs.generate("Civilite", selectCivilite, selectCivilite));
        boxPrincipal.add(
                Champs.generate("Utilisateur", selectUtilisateur, selectUtilisateur));


        panneau.add(boutonFormulaire, BorderLayout.SOUTH);




        setVisible(true);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        new Fenetre();

    }
}
