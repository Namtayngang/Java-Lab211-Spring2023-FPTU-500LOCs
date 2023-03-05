/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import ObjectHolder.Book;
import ObjectHolder.Publisher;

/**
 *
 * @author USER
 */
public class Management {

    private Scanner sc = new Scanner(System.in);

    private List<Publisher> pList;
    private List<Book> bList;
    private double min = 0.00001;

    public Management() {
        pList = new ArrayList<>();
        bList = new ArrayList<>();
    }
//Add function zone

    public void addBook() {

        String bId, bName;
        double bPrice;
        int bQuantity;
        String bStatus;
        String bPublisherId;
        bId = Validation.getBookId("Enter book Id:", bList, 1);
        bName = Validation.getBookName("Enter name:");
        bPrice = Validation.getBookPrice("Enter Price:", min, Double.MAX_VALUE);
        bQuantity = Validation.getBookQuantity("Enter book quantity:");
        bStatus = Validation.getBookStatus("Enter Book status:");
        bPublisherId = Validation.getBookIdCheck("Enter book publisher id:", pList, 3);

        bList.add(new Book(bId, bName, bPrice, bQuantity, bStatus, bPublisherId));

        this.saveBookToFile();
        bList.removeAll(bList);
    }

    public void addPublisher() {
        String id, name, phoneNumber;
        id = Validation.getPublisherId("Enter publisher Id (Format Pxxxxx Where x are digits): ", pList, 1);
        name = Validation.getName("Enter publisher name:");
        phoneNumber = Validation.getPhoneNumber("Enter publisher phone number (! Limit 10 -12 characters):");

        pList.add(new Publisher(id, name, phoneNumber));
        this.saveToFile();
        pList.removeAll(pList);

    }
//    End add function zone

//Search function zone
    public void searchBookV2() {
        System.out.print("Enter book name to search:");
        String searchByName = sc.nextLine();
        String searchByPId = Validation.getPublisherId("Enter publisher id to search: ", pList, 2);

        for (Book b : bList) {
            if (bList.isEmpty()) {
                System.out.println("Cant search because the list is empty");
            }

            if (b.getBookName().contains(searchByName) || b.getBookPublisher().contains(searchByPId)) {
                System.out.printf("%-10s | %-30s | %7.0f | %8d | %-10.1f | %-25s | %-15s\n",
                        b.getBookId(), b.getBookName(), b.getBookPrice(), b.getBookQuantity(), (b.getBookQuantity() * b.getBookPrice()), Validation.publisherName(b.getBookPublisher(), pList, bList), b.getBookStatus());
            }

        }
    }

    public void searchBook() {
        int choice;
        while (true) {
            System.out.println("1.Search by ID");
            System.out.println("2.Search by name");
            System.out.print("Enter choice:");
            try {
                choice = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Input Integer number !!");
            }

        }
        switch (choice) {
            case 1:
                searchById();
                break;
            case 2:
                searchByName();
                break;
        }
    }

    public void searchByName() {
        String s = Validation.getBookName("Enter book name to search:");
        for (Book book : bList) {
            if (book.getBookName().equalsIgnoreCase(s)) {
                System.out.print(book);
            }
            if (!checkB(s)) {
                System.out.println("Name not found");
                break;
            }
        }
    }

    public void searchById() {
        String pattern = "(P)[0-9][0-9][0-9][0-9][0-9]";
        String s;
        System.out.print("Enter book publisher id to search:");
        s = sc.nextLine();
        if (!s.matches(pattern)) {
            System.out.println("Wrong format");
        } else if (s.matches(pattern)) {
            for (Book b : bList) {
                if (b.getBookPublisher().equals(s)) {
                    System.out.print(b);
                } else if (!checkB(s)) {
                    System.out.println("Id not found");
                    break;
                }
            }
        }

    }
//    End search function zone

    public boolean checkB(String s) {
        for (Book b : bList) {
            if ((b.getBookPublisher().equals(s)) || b.getBookName().equals(s) || b.getBookId().equals(s)) {
                return true;
            }
        }
        return false;
    }
//Update

    public void updateBook() {
        String bUpdate;
        String bNameUpdate, bPublisherIDUpdate, bStatusUpdate;
        String bPriceUpdate;
        String bQuantityUpdate;
        int count = 0;
        do {
            if (bList.isEmpty()) {
                System.out.println("Cant update empty list");
            }
            System.out.print("Enter Book id you want to update : ");
            bUpdate = sc.nextLine();

            for (Book b : bList) {
                if (bUpdate.equals(b.getBookId())) {
                    bNameUpdate = Validation.getBookNameForUpdate("Enter name to update:");
                    if (bNameUpdate.equals("")) {
                        b.setBookName(b.getBookName());
                    } else {
                        b.setBookName(bNameUpdate);
                    }
//                    update price
                    while (true) {
                        System.out.print("Update book price:");
                        bPriceUpdate = sc.nextLine();
                        try {
                            if (bPriceUpdate.equals("")) {
                                b.setBookPrice(b.getBookPrice());
                                break;
                            }
                            if (bPriceUpdate.matches(("^([0-9]){1,15}$")) || bPriceUpdate.matches(("^([0.00-9.99]){1,15}$"))) {
                                b.setBookPrice(Double.parseDouble(bPriceUpdate));
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Error!");
                        }
                    }
//                    end While

//        Update quantity
                    while (true) {
                        System.out.print("Update book quantity:");
                        bQuantityUpdate = sc.nextLine();
                        try {
                            if (bQuantityUpdate.equals("")) {
                                b.setBookQuantity(b.getBookQuantity());
                                break;
                            }
                            if (bQuantityUpdate.matches("^([0-9]){1,15}$")) {
                                b.setBookQuantity(Integer.parseInt(bQuantityUpdate));
                                break;
                            }

                        } catch (Exception e) {
                            System.out.println("Error ! Invalid quantity");
                        }
                    }
                    //                    end While

                    bPublisherIDUpdate = Validation.getPublisherIdForUpdate("Update Publisher Id: ", pList);
                    if (bPublisherIDUpdate.equals("")) {
                        b.setBookPublisher(b.getBookPublisher());
                    } else {
                        b.setBookPublisher(bPublisherIDUpdate);
                    }

                    bStatusUpdate = Validation.getBookUpdateStatus("Update book status: ");
                    if (bStatusUpdate.equals("")) {
                        b.setBookStatus(b.getBookStatus());
                    } else {
                        b.setBookStatus(bStatusUpdate);
                    }
                    count++;
                    saveBookToFile();
                }
            }

            if (count == 0) {
                System.err.println("Book's Name does not exist");
            } else {
                break;
            }

        } while (true);
    }
//    Delete function zone

    public void deleteBook() {
        String bookId = Validation.getBookId("Enter book Id you want to delete:", bList, 2);
        for (Book book : bList) {
            if (book.getBookId().equalsIgnoreCase(bookId)) {
                bList.remove(book);
                break;
            }
        }
        saveBookToFile();
        System.out.println("Delete book successful");

    }

    public void deletePublisher() throws Exception {
        String publisherId;
        publisherId = Validation.getPublisherId("Enter publisher ID you want to delete:", pList, 2);
        for (Publisher p : pList) {
            if (p.getId().equalsIgnoreCase(publisherId)) {
                pList.remove(p);
                break;
            }
        }

        this.saveToFile();
        pList.removeAll(pList);
    }
    //End delete function zone

//Save function Zone
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("publisher.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Publisher p : pList) {
                bw.write(p.toString());
            }
            System.out.println("Added and save successful");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Save failed - Please disable read-only in text file properties");
        }

    }

    public void saveBookToFile() {
        try {
            FileWriter fw = new FileWriter("book.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Book b : bList) {
                bw.write(b.toString());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Save failed - Please disable read-only in text file properties");

        }

    }
    // End save function Zone

    public void sortPublisher() {
        Collections.sort(pList, new Comparator<Publisher>() {
            @Override
            public int compare(Publisher o1, Publisher o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    }

// Load function zone
    public void loadBookFromFile() throws IOException {
        File f = new File("book.txt");
        if (!f.exists()) {
            System.out.println("NEW FILE IS CREATED");
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] info = line.split("[|]");
            String bId = info[0].trim();
            String bName = info[1].trim();
            double bPrice = Double.parseDouble(info[2].trim());
            int bQuantity = Integer.parseInt(info[3].trim());
            String bStatus = info[4].trim();
            String bPublisher = info[5].trim();
            bList.add(new Book(bId, bName, bPrice, bQuantity, bStatus, bPublisher));

        }
        fr.close();
        br.close();

    }

    public void loadFromFile() throws FileNotFoundException, IOException {
        File f = new File("publisher.txt");
        if (!f.exists()) {
            System.out.println("NEW FILE IS CREATED");
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            String[] info = line.split("[|]");
            String id = info[0].trim();
            String name = info[1].trim();
            String phone = info[2].trim();
            pList.add(new Publisher(id, name, phone));
        }
        fr.close();
        br.close();
    }
//  End load function zone   

// Print function zone
    public void printPublisher() {
        this.sortPublisher();
        System.out.println("Publisher's Id        Name                   PhoneNumber");
        for (Publisher p : pList) {
            System.out.printf("%-20s | %-20s | %-10s\n",
                    p.getId(), p.getName(), p.getPhoneNumber());
        }
    }

    public void printBook() {
//        Sorting by quantity Or price
        System.out.println("");
        for (int i = 0; i < bList.size() - 1; i++) {
            for (int j = 0; j < bList.size(); j++) {
                if (bList.get(i).getBookQuantity() < bList.get(j).getBookQuantity()) {
                    Collections.swap(bList, i, j);
                } else if (bList.get(i).getBookQuantity() == bList.get(j).getBookQuantity()) {
                    if (bList.get(i).getBookPrice() > bList.get(j).getBookPrice()) {
                        Collections.swap(bList, i, j);
                    }
                }
            }
        }
//        Print by format  
        System.out.println("Book's Id   Book's Name                      Prices    Quantity   Subtotal     Book's publisher name       Status");
        for (Book b : bList) {
            System.out.printf("%-10s | %-30s | %7.0f | %8d | %-10.1f | %-25s | %-15s\n",
                    b.getBookId(), b.getBookName(), b.getBookPrice(), b.getBookQuantity(), (b.getBookQuantity() * b.getBookPrice()), Validation.publisherName(b.getBookPublisher(), pList, bList), b.getBookStatus());
        }
    }
//  End print function zone   

//    End class
}
