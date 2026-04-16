package org.example;

import org.example.model.Book;
import org.example.model.Member;
import org.example.service.AdminService;
import org.example.service.MemberService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        AdminService adminService = new AdminService();
        MemberService memberService = new MemberService();

        boolean isNotExit = true;

        while (isNotExit) {
            System.out.println();
            System.out.println("1. Admin Login");
            System.out.println("2. Member Login");
            System.out.println("3. Member Registration");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean login = adminService.logInAdmin(id,sc);

                    if (login) adminOperations(adminService,sc);
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean login = memberService.logInMember(id,sc);

                    if (login) memberOperations(memberService,sc);
                    break;
                }

                case 3: {
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    System.out.print("Enter PhoneNumber: ");
                    String phonerNumber = sc.nextLine();

                    Member member = new Member(name,password,phonerNumber);
                    memberService.registerMember(member);
                    break;
                }

                case 4: {
                    System.out.println("Thank you");
                    isNotExit = false;
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }



    }

    public static void adminOperations(AdminService service, Scanner sc){
        boolean isNotExit = true;

        while (isNotExit) {
            System.out.println();
            System.out.println("1. Add New Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book Details");
            System.out.println("4. Search Book by ID");
            System.out.println("5. Show All Books");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1: {
                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String authorName = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Book book = new Book(bookName, authorName, price);
                    service.addBook(book);
                    break;
                }

                case 2: {
                    System.out.print("Enter BookId: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.removeBook(id);
                    break;
                }

                case 3: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Name (just Enter to Skip): ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Author Name (just Enter to Skip): ");
                    String authorName = sc.nextLine();
                    System.out.print("Enter Price (just Enter to Skip): ");
                    String price = sc.nextLine();

                    service.updateBook(id,bookName,authorName,price);
                    break;
                }

                case 4: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.searchByID(id);
                    break;
                }

                case 5:{
                    service.viewAllBooks();
                    break;
                }

                case 6: {
                    System.out.println("Thank you");
                    isNotExit = false;
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }


    public static void memberOperations(MemberService service, Scanner sc){
        boolean isNotExit = true;

        while (isNotExit) {
            System.out.println();
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Search Book");
            System.out.println("4. Show All Available Books");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1: {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.issueBook(id);
                    break;
                }

                case 2: {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.returnBook(id);
                    break;
                }

                case 3: {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    service.searchByID(id);
                    break;
                }

                case 4:{
                    service.viewAllAvailableBooks();
                    break;
                }

                case 5: {
                    System.out.println("Thank you");
                    isNotExit = false;
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}