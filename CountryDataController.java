/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.persistence.Query;
import model.CountryData;

/**
 *
 * @author karag
 */
public class CountryDataController extends MainController{

public CountryDataController(){
super();
    } 

/* Αποθήκευση data στη βάση δεδομένων */
public void storeCountryDataToDataBase(ArrayList<CountryData>countrydata){
em.getTransaction().begin();
for (CountryData cdata : countrydata) {
em.persist(cdata);
        }
em.getTransaction().commit();
}

public CountryData getCountryData(int id){
        Query q = em.createNamedQuery("CountryData.findById");
        q.setParameter("id", id);
return (CountryData)q.getSingleResult();
}

public ArrayList<CountryData>getDataForList(CountryData countrydata){
        Query q = em.createNamedQuery("CountryDataset.findByDatasetId");
        q.setParameter("dataset", countrydata);
// Μετατροπή List σε ArrayList  
        ArrayList<CountryData> cdata = new ArrayList<>(q.getResultList());
return cdata;
    } 



}