package org.example.repo;

import org.example.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AdminRepo {

    private SessionFactory sf;

    public AdminRepo() {
        this.sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Admin.class)
                .buildSessionFactory();
    }


    public Admin findByID(int id) {
        Session s = sf.openSession();

        Admin admin = s.find(Admin.class, id);

        s.close();
        return admin;
    }
}
