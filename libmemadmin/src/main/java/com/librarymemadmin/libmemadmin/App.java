package com.librarymemadmin.libmemadmin;

import libDaoImpl.*;
import entity.*;
import libDao.memberDao;

import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDaoImpl bookDAO = new BookDaoImpl();
        MemberDaoImpl memberDAO = new MemberDaoImpl();

        while (true) {
            System.out.println("\n1.Admin 2.Member 3.Register 4.Exit");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.println("1.Add 2.Remove 3.Update 4.Search 5.Show All");
                    int a = sc.nextInt();

                    if (a == 1) {
                        Book b = new Book();
                        System.out.print("ID: "); b.setBookId(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Name: "); b.setBookName(sc.nextLine());
                        System.out.print("Author: "); b.setAuthorName(sc.nextLine());
                        System.out.print("Price: "); b.setPrice(sc.nextDouble());
                        b.setStatus("Available");

                        bookDAO.addBook(b);
                    }

                    else if (a == 5) {
                        List<Book> list = bookDAO.getAllBooks();
                        list.forEach(x -> System.out.println(x.getBookName()));
                    }
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int id = sc.nextInt();

                    if (memberDAO.isMember(id)) {
                        System.out.println("1.Issue 2.Return");
                        int m = sc.nextInt();

                        System.out.print("Book ID: ");
                        int bid = sc.nextInt();

                        if (m == 1) bookDAO.issueBook(bid);
                        else bookDAO.returnBook(bid);
                    } else {
                        System.out.println("Not Registered!");
                    }
                    break;

                case 3:
                    Member mem = new Member();
                    System.out.print("ID: "); mem.setMemberId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Name: "); mem.setMemberName(sc.nextLine());
                    System.out.print("Phone: "); mem.setPhoneNumber(sc.nextLine());

                    memberDAO.addMember(mem);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}