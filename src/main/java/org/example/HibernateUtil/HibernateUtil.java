package org.example.HibernateUtil;

import org.example.Service.CalculatorService;
import org.example.Service.ClientService;
import org.example.Service.ReparatieService;
import org.example.model.Calculator;
import org.example.model.Client;
import org.example.model.Reparatie;
//import org.example.model.Project;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private final static String DB_USER = "cristina";
    private final static String DB_PASSWORD = "cristina";
    private final static String DB_HOST = "jdbc:mysql://localhost:3306/jdbc_remote_ro_65";
    public static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactoryInstance() {
        if (sessionFactory == null) {
            instantiateSessionFactory();
        }
        return sessionFactory;
    }

    private static void instantiateSessionFactory() {
        //scriu cod de setup
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

        properties.put(Environment.URL, DB_HOST);
        properties.put(Environment.USER, DB_USER);
        properties.put(Environment.PASS, DB_PASSWORD);


        properties.put(Environment.SHOW_SQL,true);
        properties.put(Environment.HBM2DDL_AUTO,"update"); //create =sterge baza de date / create-drop=la fiecare deschidere a aplicatiei creeaza noi tabele si le sterge pe celelelalte

        configuration.addAnnotatedClass(Calculator.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Reparatie.class);
        configuration.addAnnotatedClass(CalculatorService.class);
        configuration.addAnnotatedClass(ClientService.class);
        configuration.addAnnotatedClass(ReparatieService.class);
//        configuration.addAnnotatedClass(Project.class);

        configuration.setProperties(properties);

        //ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sesionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
