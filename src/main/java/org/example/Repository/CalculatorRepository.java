package org.example.Repository;

import org.example.HibernateUtil.HibernateUtil;
import org.example.model.Calculator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class CalculatorRepository {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactoryInstance();

    public void save(Calculator calculator){
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(calculator);

        transaction.commit();

        session.close();
    }

    public Optional<Calculator> findByCapacitateMemorie(Integer capacitate){
        Session session=sessionFactory.openSession();

        Query<Calculator> query = session.createQuery("select d from Calculator d where d.capacitate_memorie = :parameter");
        query.setParameter("parameter",capacitate);

        return query.uniqueResultOptional();
    }
}
