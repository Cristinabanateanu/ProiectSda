package org.example.Repository;

import org.example.model.Reparatie; // Changed from Calculator
import org.example.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ReparatieRepository { // Class name changed to match Reparatie
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();

    public void save(Reparatie reparatie) { // Parameter type changed to Reparatie
        // Step 1: start a session from session factory
        Session session = sessionFactory.openSession();

        // Step 2: start a transaction
        Transaction transaction = session.beginTransaction();

        // Step 3: save the object in the session
        session.save(reparatie); // Changed to save a Reparatie object

        // Step 4: commit the transaction
        transaction.commit();

        // Step 5: close the session
        session.close();
    }

    public Optional<Reparatie> findByReparatieName(String reparatieName) { // Method and parameter name changed to match Reparatie

        Session session = sessionFactory.openSession();

        Query<Reparatie> query = session.createQuery
                ("SELECT r FROM Reparatie r WHERE r.name = :parameter", Reparatie.class); // Changed to query Reparatie objects
        query.setParameter("parameter", reparatieName);
        return query.uniqueResultOptional();
    }
}
