package no.hvl.dat107.innlevering3;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {
	
	
	public static ansatt finnAnsattMedId(int id) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "24Pilser"));

        EntityManager em = emf.createEntityManager();

        ansatt p = null;
        
        try {
            p = em.find(ansatt.class, id);
            

        } finally {
            em.close();
        }

        return p;
		
	}
	
	public static ansatt nyLønnOgStilling(int ansattId,String stilling){
		return nyLønnOgStilling( ansattId, -1 , stilling);
	}
	
	public static ansatt nyLønnOgStilling(int ansattId,int lønn ){
		return nyLønnOgStilling( ansattId, lønn , null);
	}
	
	public static ansatt nyLønnOgStilling(int ansattId,int lønn ,String stilling) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "24Pilser"));
		
		
        EntityManager em = emf.createEntityManager();
        
        ansatt p = finnAnsattMedId(ansattId);
        
        if(p!=null) {
        	if(lønn!=-1) {
        		p.setMonedslonn(lønn);
        	}
            if(stilling !=null) {
            	 p.setStilling(stilling);
            }
        }
        
        try {
        	em.getTransaction().begin();
 
            em.merge(p);
            
            em.getTransaction().commit();
           
            return p;
            

        } catch(NoResultException e) {
        	return null;
        }
        finally {
            em.close();
        }
	}
	
	public static List<ansatt> alleAnsatte() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "24Pilser"));
		

        EntityManager em = emf.createEntityManager();
        
        
        String queryString = "select a from ansatt a";

        
        try {
 
            em.getTransaction().begin();
            
            
            TypedQuery<ansatt> query = em.createQuery(queryString,ansatt.class);
            em.getTransaction().commit();
            
            return query.getResultList();
            

        } catch(NoResultException e) {
        	return null;
        }
        finally {
            em.close();
        }
	}
	
	
	public static ansatt finnAnsattMedBrukernavn(String brukernavn) {
		//logger inn på database.
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "24Pilser"));
		
		// hjelpe objekt for og snakke med databasen.
        EntityManager em = emf.createEntityManager();
        
        
        // bare kaller teksten for queryString slik at jeg slipper og skrive alte inn under
        String queryString = "select a from ansatt a Where a.brukernavn= :brukernavn";
       
        
        try {
  
            em.getTransaction().begin();
            
 
            TypedQuery<ansatt> query = em.createQuery(queryString,ansatt.class);

            query.setParameter("brukernavn", brukernavn);
            

            em.getTransaction().commit();
            

            return d + query.getSingleResult();
            

        } catch(NoResultException e) {
        	return null;
        }
        finally {
            em.close();
        }
	}
	
	public static ansatt LeggTilAnsatt (Integer ansattid, String brukernavn , String fornavn,
			String etternavn, LocalDate ansattdato, String stilling, Integer monedslonn, Integer avdelingId) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit",
				Map.of("javax.persistence.jdbc.password", "1234"));
		

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		ansatt a = new ansatt (ansattid, brukernavn, fornavn, etternavn, ansattdato, stilling, monedslonn,avdelingId);
		
		try {
			tx.begin();
			em.persist(a); 
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	return a;
	
	}
	
	

}