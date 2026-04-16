package org.example.repo;

import org.example.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookRepo {

    private SessionFactory sf;

    public BookRepo() {
        this.sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
    }


    public void addBook(Book book) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        s.persist(book);

        t.commit();
        s.close();
    }

    public Book findBookById(int id) {
        Session s = sf.openSession();

        Book book = s.find(Book.class, id);

        s.close();
        return book;
    }

    public void removeBook(Book b) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        s.remove(b);

        t.commit();
        s.close();
    }

    public void updateBook(Book b) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        s.merge(b);

        t.commit();
        s.close();
    }

    public List<Book> viewAllBooks() {
        Session s = sf.openSession();

        List<Book> books = s.createQuery("from Book", Book.class).list();

        s.close();
        return books;
    }
}
