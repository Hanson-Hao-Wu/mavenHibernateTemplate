package org.hao.util;

import java.util.List;

import org.hao.entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

public class TestHibernate {

	@Test
	public void testGetSession() {
		Session session = HibernateUtil.getSession();  
        Assert.assertNotNull(session);  
        HibernateUtil.closeSession();
	}
	
	@Test  
    public void testExport() {  
        new SchemaExport(new Configuration().configure()).create(true , true);  
    }
	
	@Test  
    public void testSave() {  
		Person person = new Person(new Integer(1), "wuhao");         
        Session session = HibernateUtil.getSession();  
        Transaction tx = session.beginTransaction();  
          
        session.save(person);  
          
        tx.commit();  
        HibernateUtil.closeSession();  
    }
	@Test  
    public void testQuery() {  
        Session session = HibernateUtil.getSession();  
        session.beginTransaction();  
          
        @SuppressWarnings("unchecked")  
        List<Person> personList = session.createQuery("select p from Person p").list();  
	      
	    for(Person eachPerson : personList) {  
	        System.out.println(eachPerson);
	    }  
	      
	    session.getTransaction().commit();  
	    HibernateUtil.closeSession();  
	}

}
