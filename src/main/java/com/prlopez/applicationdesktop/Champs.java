package com.prlopez.applicationdesktop;

import javax.swing.*;
import java.awt.*;

public class Champs {
    public static Box generate(String label, JComponent... listeComposants){

        Box ligne = Box.createHorizontalBox();

        ligne.setMaximumSize(new Dimension(500,30));

        JLabel jLabel = new JLabel(label);
        jLabel.setPreferredSize(new Dimension(100,30));
        ligne.add(jLabel);
//        ligne.add(new JLabel(label));
        for(Component composant : listeComposants){
            ligne.add(composant);
        }


        return ligne;
    }
}
