package com.example.dyrehandel;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DyrehandelController {

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


    @FXML
    private TextField vareInput, nrInput;

    @FXML
    private ListView bestillingsList = new ListView();

    @FXML
    private ListView ordrerList = new ListView();

    @FXML
    private ListView varerList = new ListView();


    //Tilhører Varer
    @FXML
    void addVare(ActionEvent event) {
        try{
            Vare vare = new Vare(Integer.parseInt(nrInput.getText()),vareInput.getText());
            varerList.getItems().add(vare);
            varerList.scrollTo(varerList.getItems().size()-1);
        } catch (Exception e){
            System.out.println("Noget gik galt, tjek om der er insat et valid nr");
        }
    }

    //Tilføj en vare til en bestilling
    @FXML
    void addToOrdre(ActionEvent event) {
        Ordre ordre = (Ordre) ordrerList.getSelectionModel().getSelectedItem();
        Vare vare = (Vare) varerList.getSelectionModel().getSelectedItem();
        ordre.tilknytVare(vare);
        bestillingsList.getItems().add(vare.toString());
    }


    //Vis bestillinger fra ordre i bestillingslisten
    @FXML
    private void mouseListClick(MouseEvent e)
    {
        ObservableList valgteIndeks = ordrerList.getSelectionModel().getSelectedIndices();
        if (valgteIndeks.size() == 0)
            System.out.println("Vælg en ordre for at få bestillingen vist");
        else
            for (Object indeks : valgteIndeks)
            {
                bestillingsList.getItems().clear();
                System.out.println("Der blev klikket på " + ordrerList.getSelectionModel().getSelectedItem());
                Ordre ordre = (Ordre) ordrerList.getItems().get((int) indeks);
                for (Vare vare : ordre.getVarer())
                {
                    bestillingsList.getItems().add(vare.toString());

                }

            }
    }

    //Tilhører Ordre

    @FXML
    void OpenOrdreDialog(ActionEvent event) throws IOException {

        Dialog<ButtonType> dialog = new Dialog();

        // Her sættes vinduet op
        dialog.setTitle("Opret ny ordre");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        TextField ordreNrInput = new TextField();
        ordreNrInput.setPromptText("Ordre Nr");
        TextField kundenavnInput = new TextField();
        kundenavnInput.setPromptText("Kundenavn");
        TextField datoInput = new TextField();
        datoInput.setPromptText("Dato");
        HBox inputBox = new HBox(ordreNrInput, kundenavnInput, datoInput);
        inputBox.setSpacing(8);
        Label infoLabel = new Label("Indsæt oplysninger om ny ordre");
        VBox opsæt = new VBox(infoLabel, inputBox);
        opsæt.setSpacing(16);
        dialog.getDialogPane().setContent(opsæt);

        // Her afsluttes dialogen med at man kan trykke på OK
        Optional<ButtonType> knap = dialog.showAndWait();
        // Derefter kan vi henter felternes indhold ud og gøre hvad der skal gøres...
        if (knap.get() == ButtonType.OK)
            try{
                Ordre ordre = new Ordre(Integer.parseInt(ordreNrInput.getText()),kundenavnInput.getText(),datoInput.getText());
                ordrerList.getItems().add(ordre);
                ordrerList.scrollTo(ordrerList.getItems().size()-1);
            } catch (Exception e){
                System.err.println("Noget gik galt, tjek om der er insat et valid ordrenr");
                System.err.println("Fejl: " + e.getMessage());
            }

    }

    //Tilhører Ordre
    @FXML
    void sletOrdre(ActionEvent event) {
        // Finder selected item i ordrerList og fjerner det
        try{
            ordrerList.getItems().remove(ordrerList.getSelectionModel().getSelectedItem());
        }catch (Exception e){
            System.out.println("Vælg en ordre for at slette den");
        }

    }

    public void initialize() {

        ordrerList.getItems().add(o0);
        ordrerList.getItems().add(o1);
        ordrerList.getItems().add(o2);
        ordrerList.getItems().add(o3);
        ordrerList.getItems().add(o4);

        varerList.getItems().add(v0);
        varerList.getItems().add(v1);
        varerList.getItems().add(v2);
        varerList.getItems().add(v3);
        varerList.getItems().add(v4);
        varerList.getItems().add(v5);
        varerList.getItems().add(v6);
        varerList.getItems().add(v7);
        varerList.getItems().add(v8);
        varerList.getItems().add(v9);

        o0.tilknytVare(v0);
        o0.tilknytVare(v7);
        o1.tilknytVare(v3);
        o1.tilknytVare(v9);
        o1.tilknytVare(v5);
        o2.tilknytVare(v8);
        o3.tilknytVare(v1);
        o4.tilknytVare(v2);
    }

}