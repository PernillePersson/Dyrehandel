package com.example.dyrehandel;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class DyrehandelController {

    @FXML
    private ListView ordreList;

    @FXML
    private Button addVare;

    @FXML
    private ListView bestillingsList = new ListView();

    @FXML
    private ListView ordrerList = new ListView();

    @FXML
    private ListView varerList = new ListView();

    @FXML
    private void mouseListClick(MouseEvent e)
    {
        //bestillingsList.getItems().
        ObservableList valgteIndeks = ordrerList.getSelectionModel().getSelectedIndices();
        if (valgteIndeks.size() == 0)
            System.out.println("Vælg en ordre for at få bestillingen vist");
        else
            for (Object indeks : valgteIndeks)
            {
                System.out.println("Valgt index = " + indeks + " : " + ordrerList.getItems().get((int) indeks));
                bestillingsList.getItems().add((int) indeks );
            }
    }


    public void initialize() {
        Ordre o0 = new Ordre(1, "Adman", "9/11");
        Ordre o1 = new Ordre(2, "Pernille", "6/9");
        Ordre o2 = new Ordre(3, "Sanne", "7/3");
        Ordre o3 = new Ordre(4, "Bjarne", "4/12");
        Ordre o4 = new Ordre(5, "Sigurd", "26/1");

        Vare v0 = new Vare(1, "hundefoder");
        Vare v1 = new Vare(2, "kattelem");
        Vare v2 = new Vare(3, "slange");
        Vare v3 = new Vare(4, "aquarium");
        Vare v4 = new Vare(5, "fuglebur");
        Vare v5 = new Vare(6, "bold");
        Vare v6 = new Vare(7, "madskål");
        Vare v7 = new Vare(8, "guldfisk");
        Vare v8 = new Vare(9, "terrarium");
        Vare v9 = new Vare(10, "kødben");

        ordrerList.getItems().add(o0.toString());
        ordrerList.getItems().add(o1.toString());
        ordrerList.getItems().add(o2.toString());
        ordrerList.getItems().add(o3.toString());
        ordrerList.getItems().add(o4.toString());

        varerList.getItems().add(v0.toString());
        varerList.getItems().add(v1.toString());
        varerList.getItems().add(v2.toString());
        varerList.getItems().add(v3.toString());
        varerList.getItems().add(v4.toString());
        varerList.getItems().add(v5.toString());
        varerList.getItems().add(v6.toString());
        varerList.getItems().add(v7.toString());
        varerList.getItems().add(v8.toString());
        varerList.getItems().add(v9.toString());

        o0.tilknytVare(v0);
        o0.tilknytVare(v7);
        o1.tilknytVare(v3);
        o1.tilknytVare(v9);
        o1.tilknytVare(v5);

        //bestillingsList.getItems().add(ordrerList.getSelectionModel().getSelectedIndices());


    }
}