/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.test;

import com.stema.beans.Cyclist;
import com.stema.models.CyclistModel;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.bson.types.ObjectId;

/**
 *
 * @author Hugo Marque
 */
@Named(value = "testManagedBean")
@Dependent


public class TestManagedBean {
    
    @EJB
    private CyclistModel cyclistModel;

    /**
     * Creates a new instance of TestManagedBean
     */
    public TestManagedBean() {
    }
    
    public void testCreateCyclist(){
        Cyclist cyclist=new Cyclist();
        cyclist.setFirstName("Hugo" + new Date());
        cyclist.setLastName("Marque");
        
        cyclistModel.create(cyclist);       
    }
    
    public void testUptadeCyclist(){
       Cyclist cyclist = cyclistModel.find(new ObjectId(""));
       
       cyclist.setFirstName("Pierre");
       cyclist.setLastName("Dupond");
       cyclistModel.update(cyclist);
       
    }
}
