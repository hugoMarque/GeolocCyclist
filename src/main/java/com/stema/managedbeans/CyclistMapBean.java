/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package com.stema.managedbeans;

import com.stema.beans.Cyclist;
import com.stema.models.CyclistModel;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author Hugo Marque
 */
@Named
@SessionScoped
public class CyclistMapBean implements Serializable {

    //backingbean (lien entre ma classe et mon contrôleur)
    private Cyclist cyclist = new Cyclist();

    //injecter le modele dans le contrôleur
    @EJB
    private CyclistModel cyclistModel;

    //GoogleMap
    private MapModel simpleModel;

    public CyclistMapBean() {
    }

    public String map(Cyclist cyclist) {

        //cyclist courant
        this.cyclist = cyclist;
        
        //relire pour savoir si ses coordonnées ont changé
        this.cyclist = cyclistModel.find(this.cyclist.getId());


        LatLng coord = new LatLng(Float.parseFloat(this.cyclist.getLatitude()), Float.parseFloat(this.cyclist.getLongitude()));
        simpleModel = new DefaultMapModel();
        
        Marker marker=new Marker(coord, "Cyclist");  
        simpleModel.addOverlay(marker);
        
        
        return "map.jsf";
    }
   
    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }
}
