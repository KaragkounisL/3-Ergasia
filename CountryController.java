/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.persistence.Query;
import model.Country;

/**
 *
 * @author karag
 */

	
	public class CountryController extends MainController{

public CountryController(){
super();
    } 

/* Αποθήκευση χωρών στη βάση δεδομένων */
public void storeCountriesToDataBase(ArrayList<Country>countries){
em.getTransaction().begin();
for (Country country : countries) {
em.persist(country);
        }
em.getTransaction().commit();
}

public Country getCountryIso(String isoCode){
        Query q = em.createNamedQuery("Country.findByIsoCode");
        q.setParameter("isoCode", isoCode);
return (Country)q.getSingleResult();
}

public Country getCountryName(String name){
        Query q = em.createNamedQuery("Country.findByName");
        q.setParameter("name", name);
return (Country)q.getSingleResult();
}
	
}
