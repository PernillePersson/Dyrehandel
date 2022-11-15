package com.example.dyrehandel;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DyrehandelController {

    @FXML
    private ListView ordrerList = new ListView();


    @FXML
    private ListView varerList = new ListView();



    public void initialize(){
        Ordre o0 = new Ordre(1,"Adman","9/11");
        Ordre o1 = new Ordre(2,"Pernille","6/9");
        Ordre o2 = new Ordre(3,"Sanne","7/3");
        Ordre o3 = new Ordre(4,"Bjarne","4/12");
        Ordre o4 = new Ordre(5,"Sigurd","26/1");

        Vare v0 = new Vare(1,"hundefoder");
        Vare v1 = new Vare(2,"kattelem");
        Vare v2 = new Vare(3,"slange");
        Vare v3 = new Vare(4,"aquarium");
        Vare v4 = new Vare(5,"fuglebur");
        Vare v5 = new Vare(6,"bold");
        Vare v6 = new Vare(7,"madskål");
        Vare v7 = new Vare(8,"guldfisk");
        Vare v8 = new Vare(9,"terrarium");
        Vare v9 = new Vare(10,"kødben");

        ordrerList.getItems().add(o0.toString());
        ordrerList.getItems().add(o1.toString());
        ordrerList.getItems().add(o2.toString());
        ordrerList.getItems().add(o3.toString());
        ordrerList.getItems().add(o4.toString());

        varerList.getItems().add(v0.toString());
        varerList.getItems().add(v1.toString());
        varerList.getItems().add(v2.toString());

    }



}
