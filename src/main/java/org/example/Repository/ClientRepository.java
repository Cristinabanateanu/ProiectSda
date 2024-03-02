package org.example.Repository;

import org.example.model.Client; // Changed from Calculator
import org.example.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ClientRepository { // Class name changed to reflect Client
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();

    public void save(Client client) { // Parameter type changed to Client
        // Step 1: start a session from session factory
        Session session = sessionFactory.openSession();

        // Step 2: start a transaction
        Transaction transaction = session.beginTransaction();

        // Step 3: save the object in the session
        session.save(client); // Changed to save a Client

        // Step 4: commit the transaction
        transaction.commit();

        // Step 5: close the session
        session.close();
    }

    public Optional<Client> findByClientName(String clientName) { // Method and parameter name changed to Client

        Session session = sessionFactory.openSession();

        Query<Client> query = session.createQuery
                ("SELECT c FROM Client c WHERE c.nume = :parameter", Client.class); // Changed to query Client entities
        query.setParameter("parameter", clientName);
        return query.uniqueResultOptional();
    }
}
