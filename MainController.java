package controller;
/*γενική κλάση διαχείρησης των entities*/


import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Country;
import remote.DBManager;

//import remote.JsonManager;


public abstract class MainController {

protected EntityManager em;

// Δημιουργία EntityManager
public MainController(){
        DBManager dbManager = DBManager.getInstance();
em = dbManager.getEm();
    }

// μέθοδος διαγραφής πίνακα μέσω ενός έτοιμου namedQuery
public void deleteFromDataBase(String query){
try
        { 
em.getTransaction().begin();
            Query q = em.createNamedQuery(query);
            q.executeUpdate();
em.getTransaction().commit();
        } 
catch (Exception e) 
        { 
em.getTransaction().rollback();
} 
    }

}

