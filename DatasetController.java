/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.CountryDataset;

/**
 *
 * @author karag
 */
public class DatasetController extends MainController{

public DatasetController(){
super();
    } 

//αποθήκευση dataset στη db
public void storeDatasetToDataBase(ArrayList<CountryDataset>dataset){
em.getTransaction().begin();
for (CountryDataset dset : dataset) {
em.persist(dset);
        }
em.getTransaction().commit();
}

public CountryDataset getDatasetListByName(String name){
        Query q = em.createNamedQuery("CountryDataset.findByName");
        q.setParameter("name", name);
        List<CountryDataset> found = q.getResultList();
if (found.isEmpty()) {
return null; //or throw checked exception data not found
        } else {
return found.get(0);
        }
}

}
