/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stema.beans;

import com.stema.converter.IdSQLDBConverter;
import java.io.Serializable;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.bson.types.ObjectId;

/**
 *
 * @author Hugo Marque
 */
@Entity
public class Cyclist implements Serializable{
    
    @Id
    @Convert(converter=IdSQLDBConverter.class)
    private ObjectId _id;  
    
    private String lastName;
    private String firstName;
    private boolean onLine;
    private String email;
    private String password;
    private String picture;
    
    //IOT
    
    private String longitude;
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getOnLine() {
        return onLine;
    }

    public void setOnLine(Boolean onLine) {
        this.onLine = onLine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Cyclist(){
        
    }

    @Override
    public String toString() {
        return "Cyclist{" + "_id=" + _id + ", lastName=" + lastName + ", firstName=" + firstName + ", onLine=" + onLine + ", email=" + email + ", password=" + password + ", picture=" + picture + ", longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    
}
