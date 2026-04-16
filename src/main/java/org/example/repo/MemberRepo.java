package org.example.repo;

import org.example.model.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MemberRepo {

    private SessionFactory sf;

    public MemberRepo() {
        this.sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Member.class)
                .buildSessionFactory();
    }

    public Member findByID(int id) {
        Session s = sf.openSession();

        Member member = s.find(Member.class, id);

        s.close();
        return member;
    }

    public void createMember(Member member) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        s.persist(member);

        t.commit();
        s.close();
    }
}
