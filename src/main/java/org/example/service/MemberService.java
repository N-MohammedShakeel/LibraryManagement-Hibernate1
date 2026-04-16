package org.example.service;

import org.example.model.Book;
import org.example.model.Member;
import org.example.repo.BookRepo;
import org.example.repo.MemberRepo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemberService {

    BookRepo repo = new BookRepo();
    MemberRepo memberRepo = new MemberRepo();

    public void issueBook(int id) {

        Book b = repo.findBookById(id);
        b.setStatus("Issued");

        repo.updateBook(b);
        System.out.println("Book Issued Successfully");
    }

    public void returnBook(int id) {

        Book b = repo.findBookById(id);
        b.setStatus("Available");

        repo.updateBook(b);
        System.out.println("Book Returned Successfully");
    }

    public void searchByID(int id) {
        Book b = repo.findBookById(id);

        if(b == null){
            System.out.println("Book Not Found");
        }
        System.out.println(b);
    }

    public void viewAllAvailableBooks() {

        List<Book> books = repo.viewAllBooks().stream().filter(b -> b.getStatus().equals("Available")).collect(Collectors.toList());

        if (books.isEmpty()){
            System.out.println("No Books Found");
            return;
        }

        for (Book b : books){
            if(b.getStatus().equals("Available")){
                System.out.println(b);
            }
        }
    }

    public boolean logInMember(int id, Scanner sc) {

        System.out.print("Enter UserName: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Member m = memberRepo.findByID(id);

        if(m != null && m.getMemberName().equals(username) && m.getPassword().equals(password)){
            System.out.println("Login Successfull");
            return true;
        }else{
            System.out.println("Login Failed");
        }
        return false;
    }

    public void registerMember(Member member) {

        if (member.getMemberName().isEmpty() ||
                member.getPassword().isEmpty() ||
                member.getPhoneNumber().isEmpty()) {

            System.out.println("Fields Should Not Be Empty");
            System.out.println("Member Registration Failed");
            return;
        }

        memberRepo.createMember(member);
        System.out.println("Member Registered Successfully");
    }
}
