/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entite;

/**
 *
 * @author iskander
 */
public class Evenements {
    private int id_event;
    private String object_event;
    private String description_event;
    private String adresse_event;
    private String dateDeb_event;
    private String dateFin_event;
    private Boutique boutique_fk;

    public Evenements() {
    }

    public Evenements(int id_event, String object_event, String description_event, String adresse_event, String dateDeb_event, String dateFin_event, Boutique boutique_fk) {
        this.id_event = id_event;
        this.object_event = object_event;
        this.description_event = description_event;
        this.adresse_event = adresse_event;
        this.dateDeb_event = dateDeb_event;
        this.dateFin_event = dateFin_event;
        this.boutique_fk = boutique_fk;
    }

    public Evenements(int id_event, String object_event, String description_event, String adresse_event, String dateDeb_event, String dateFin_event) {
        this.id_event = id_event;
        this.object_event = object_event;
        this.description_event = description_event;
        this.adresse_event = adresse_event;
        this.dateDeb_event = dateDeb_event;
        this.dateFin_event = dateFin_event;
    }

    public Evenements(String object_event, String description_event, String adresse_event, String dateDeb_event, String dateFin_event, Boutique boutique_fk) {
        this.object_event = object_event;
        this.description_event = description_event;
        this.adresse_event = adresse_event;
        this.dateDeb_event = dateDeb_event;
        this.dateFin_event = dateFin_event;
        this.boutique_fk = boutique_fk;
    }

    public Evenements(String object_event, String description_event, String adresse_event, String dateDeb_event, String dateFin_event) {
        this.object_event = object_event;
        this.description_event = description_event;
        this.adresse_event = adresse_event;
        this.dateDeb_event = dateDeb_event;
        this.dateFin_event = dateFin_event;
    }

    

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getObject_event() {
        return object_event;
    }

    public void setObject_event(String object_event) {
        this.object_event = object_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public Boutique getBoutique_fk() {
        return boutique_fk;
    }

    public void setBoutique_fk(Boutique boutique_fk) {
        this.boutique_fk = boutique_fk;
    }

    public String getAdresse_event() {
        return adresse_event;
    }

    public void setAdresse_event(String adresse_event) {
        this.adresse_event = adresse_event;
    }

    public String getDateDeb_event() {
        return dateDeb_event;
    }

    public void setDateDeb_event(String dateDeb_event) {
        this.dateDeb_event = dateDeb_event;
    }

    public String getDateFin_event() {
        return dateFin_event;
    }

    public void setDateFin_event(String dateFin_event) {
        this.dateFin_event = dateFin_event;
    }

    @Override
    public String toString() {
        return "Evenements{" + "id_event=" + id_event + ", object_event=" + object_event + ", description_event=" + description_event + ", adresse_event=" + adresse_event + ", dateDeb_event=" + dateDeb_event + ", dateFin_event=" + dateFin_event + ", boutique_fk=" + boutique_fk + '}';
    }

    
    
    
}
