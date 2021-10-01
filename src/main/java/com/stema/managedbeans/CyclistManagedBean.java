/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package com.stema.managedbeans;

import com.stema.beans.Cyclist;
import com.stema.models.CyclistModel;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hugo Marque
 */
@Named
@RequestScoped
public class CyclistManagedBean {

    // déclaration de POJO (BackingBean)
    private Cyclist cyclist = new Cyclist();

    private List<Cyclist> listeCyclists;

    @EJB
    private CyclistModel cyclistModel;

    public CyclistManagedBean() {
    }

    public String validEdit() {
        if (cyclist.getId() != null) {
            cyclistModel.update(cyclist);
            FacesMessage succes = new FacesMessage(FacesMessage.SEVERITY_INFO, "Merci d'avoir modifié un cyclist : " + cyclist.getLastName() +" "+ cyclist.getFirstName(), null);
            FacesContext.getCurrentInstance().addMessage("succes", succes);
            
        } else {
            cyclistModel.create(cyclist);
            FacesMessage succes = new FacesMessage(FacesMessage.SEVERITY_INFO, "Merci d'avoir ajouté un cyclist : " + cyclist.getLastName() +" "+ cyclist.getFirstName(), null);
            FacesContext.getCurrentInstance().addMessage("succes", succes);
        }

        cyclist = new Cyclist(); //permet de vider les champs sur la page editerCyclist
        return "listerCyclist";
    }

    public void delete(Cyclist c) {
        cyclistModel.delete(c);
    }

    public String validUpdate(Cyclist c) {
        this.cyclist = c;
        return "editerCyclist";

    }

    public Cyclist getCyclist() {
        return cyclist;
    }

    public void setCyclist(Cyclist cyclist) {
        this.cyclist = cyclist;
    }

    public List<Cyclist> getListeCyclists() {
        listeCyclists = cyclistModel.read();
        return listeCyclists;
    }

    public void setListeCyclists(List<Cyclist> listeCyclists) {
        this.listeCyclists = listeCyclists;
    }

}
