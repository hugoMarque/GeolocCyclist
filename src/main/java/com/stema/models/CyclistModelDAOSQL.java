/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.models;

import com.stema.beans.Cyclist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hugo Marque
 */
@Stateless
public class CyclistModelDAOSQL {

    @PersistenceContext
    private EntityManager em;

    public CyclistModelDAOSQL() {
    }
    
    public void create(Cyclist cyclist){
        em.persist(cyclist);
    }
    
    
}