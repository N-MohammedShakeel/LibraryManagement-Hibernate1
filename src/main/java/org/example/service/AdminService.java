package org.example.service;

import org.example.model.Admin;
import org.example.model.Book;
import org.example.repo.AdminRepo;
import org.example.repo.BookRepo;

import java.util.List;
import java.util.Scanner;

public class AdminService {

    BookRepo repo = new BookRepo();
    AdminRepo admin = new AdminRepo();

    public void addBook(Book book) {
        repo.addBook(book);
        System.out.println("Book Added Successfully");
    }

    public void removeBook(int id) {
        Book b = repo.findBookById(id);

        if(b == null){
            System.out.println("Book Not Found");
        }
        repo.removeBook(b);
        System.out.println("Book Removed Successfully");
    }

    public void updateBook(int id, String bookName, String authorName, String price) {

        Book b = repo.findBookById(id);

        if(bookName!= null && !bookName.isEmpty()) b.setBookName(bookName);
        if(authorName!= null && !authorName.isEmpty()) b.setAuthorName(authorName);
        if(price!= null && !price.isEmpty()) b.setPrice(Double.parseDouble(price));

        repo.updateBook(b);
        System.out.println("Book updated Successfully");
    }

    public void searchByID(int id) {
        Book b = repo.findBookById(id);

        if(b == null){
            System.out.println("Book Not Found");
        }
        System.out.println(b);
    }

    public void viewAllBooks() {

        List<Book> books = repo.viewAllBooks();

        if (books.isEmpty()){
            System.out.println("No Books Found");
            return;
        }

        for (Book b : books){
            System.out.println(b);
        }
    }

    public boolean logInAdmin(int id, Scanner sc) {

        System.out.print("Enter UserName: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Admin a = admin.findByID(id);

        if(a != null && a.getAdminName().equals(username) && a.getPassword().equals(password)){
            System.out.println("Login Successfull");
            return true;
        }else{
            System.out.println("Login Failed");
        }
        return false;
    }
}
