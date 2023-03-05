/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;
import Manage.Management;

/**
 *
 * @author USER
 */
public class Menu {

    private Scanner sc = new Scanner(System.in);
    int choice;

    public void MenuDisplay() throws Exception {
        System.out.println("|==||==||==||==||==||==||==||==||==||==||==||==||==||==|");
        System.out.println("|==|             Bookstore Management               |==|");
        System.out.println("|==|================================================|==|");
        System.out.println("|==|             Publisher Management               |==|");
        System.out.println("|==|01.Create a Publisher                           |==|");
        System.out.println("|==|02.Delete the Publisher                         |==|");
        System.out.println("|==|03.Print the Publisher list from the file.      |==|");
        System.out.println("|==|================================================|==|");
        System.out.println("|==|             Book Management                    |==|");
        System.out.println("|==|04.Create a Book                                |==|");
        System.out.println("|==|05.Search the Book                              |==|");
        System.out.println("|==|06.Update Book                                  |==|");
        System.out.println("|==|07.Delete Book information                      |==|");
        System.out.println("|==|08.Print all books from file                    |==|");
        System.out.println("|==|09.Quit                                         |==|");
        System.out.println("|==||==||==||==||==||==||==||==||==||==||==||==||==||==|");
        System.out.print("Your choice: ");
    }

    public void enterChoice() throws Exception {
        Management m = new Management();
        m.loadFromFile();
        m.loadBookFromFile();
        do {
            while (39 < 79) {
                MenuDisplay();
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Wrong choice\nPlease input your choice again\n");
                }
            }
            switch (choice) {
                case 1:
                    boolean contCase1 = true;
                    do {
                        m.printPublisher();
                        m.addPublisher();
                        m.loadFromFile();
                        System.out.println("");
                        m.printPublisher();
                        System.out.println("Press any key to go back to Menu or (N) to continue");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase1 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase1 = true;
                                cont3 = false;
                            }
                        } while (cont3);
                    } while (contCase1);

                    break;

                case 2:
                    boolean contCase2 = true;
                    do {
                        m.printPublisher();
                        m.deletePublisher();
                        m.loadFromFile();
                        m.printPublisher();
                        System.out.print("Press any key to go back to Menu or (N) to continue ");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase2 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase2 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);

                    } while (contCase2);

                    break;

                case 3:
                    m.printPublisher();

                    break;

                case 4:
                    boolean contCase5 = true;
                    do {
                        m.printBook();
                        m.printPublisher();
                        m.addBook();
                        m.loadBookFromFile();
                        m.printBook();
                        System.out.print("Press any key to go back to Menu or (N) to continue ");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;
                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase5 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase5 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase5);
                    break;
                case 5:
                    boolean contCase6 = true;
                    do {
                        m.printPublisher();
                        m.printBook();
                        m.searchBookV2();
                        System.out.println("Press any key to go back to Menu or (N) to continue");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase6 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase6 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase6);

                    break;
                case 6:
                    boolean contCase7 = true;
                    do {
                        m.printBook();
                        m.printPublisher();
                        m.updateBook();
                        m.printBook();
                        System.out.println("Press any key to go back to Menu or (N) to continue");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase7 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase7 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase7);

                    break;
                case 7:
                    boolean contCase8 = true;
                    do {
                        m.printBook();
                        m.printPublisher();
                        m.deleteBook();
                        m.printBook();
                        System.out.println("Press any key to go back to Menu or (N) to continue");
                        String s;
                        String pattern = "^[nN]";
                        boolean cont3 = true;

                        do {
                            s = sc.nextLine();

                            if (!s.matches(pattern)) {
                                cont3 = false;
                                contCase8 = false;
                                break;
                            } else if (s.matches(pattern)) {
                                contCase8 = true;
                                cont3 = false;
                            } else {
                                System.out.print("Please enter Y/N: ");
                                cont3 = true;
                            }
                        } while (cont3);
                    } while (contCase8);

                    break;
                case 8:
                    m.printBook();
                    break;
                case 9:
                    System.out.println("Thank you <3");
                    System.exit(0);
                default:
                    System.out.println("Please enter 1 - 9");
            }
        } while (true);

//        End function
    }

//    End class
}
