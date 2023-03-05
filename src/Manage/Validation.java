/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.util.List;
import java.util.Scanner;
import ObjectHolder.Book;
import ObjectHolder.Publisher;

/**
 *
 * @author USER
 */
public class Validation {
//    input value: String String int

    private static Scanner sc = new Scanner(System.in);
//Publisher
//    Function to check publisher's id

    public static String getPublisherIdForUpdate(String msg, List<Publisher> pList) {
        String id;
        String pattern = "(P)[0-9][0-9][0-9][0-9][0-9]";
        while (true) {
            System.out.print(msg);
            id = sc.nextLine();
            if (id.matches(pattern)) {
                if (idExist(id, pList)) {
                    break;
                }
            } else if (id.equals("")) {
                break;

            } else {
                System.out.println("Id not found");
            }

        }
        return id;
    }

    public static String getPublisherId(String msg, List<Publisher> pList, int mode) {
        String id;
        String pattern = "(P)[0-9][0-9][0-9][0-9]";
        while (true) {
            System.out.print(msg);
            id = sc.nextLine();
            try {
                if (!id.matches(pattern)) {
                    throw new NumberFormatException();
                } else if (idExist(id, pList) && mode == 1) {
                    throw new Exception();
                } else if (!idExist(id, pList) && mode == 2) {
                    throw new NullPointerException();
                }

                break;
            } catch (NumberFormatException exception) {
                System.out.println("Wrong format or blank input !! - Please input like this format (Pxxxxx) - x are digits!");
            } catch (NullPointerException exception) {
                System.out.println("Id not exist !");
            } catch (Exception exception) {
                System.out.println("Id already exist !");;
            }

        }

        return id;
    }
//Check BPID

    public static String getBookIdCheck(String msg, List<Publisher> pList, int mode) {
        String id;
        String pattern = "(P)[0-9][0-9][0-9][0-9][0-9]";
        while (true) {
            System.out.print(msg);
            id = sc.nextLine();
            try {
                if (!id.matches(pattern)) {
                    throw new NumberFormatException();
                } else if (idExist(id, pList) && mode == 3) {
                    break;
                }
                throw new Exception();

            } catch (NumberFormatException exception) {
                System.out.println("Wrong format");

            } catch (Exception e) {
                System.out.println("Id not exist please enter again");
            }
        }
        return id;
    }

    public static String getBookId(String msg, List<Book> bList, int mode) {
        String bookId;
        String pattern = "(B)[0-9][0-9][0-9][0-9][0-9]";
        while (true) {
            System.out.print(msg);
            bookId = sc.nextLine();
            try {

                if (!bookId.matches(pattern)) {
                    throw new NumberFormatException();
                } else if (idBookExist(bookId, bList) && mode == 1) {
                    throw new Exception();
                } else if (!idBookExist(bookId, bList) && mode == 2) {
                    throw new NullPointerException();
                }

                break;
            } catch (NumberFormatException exception) {
                System.out.println("Wrong format or blank input !! - Please input like this format (Pxxxxx) - x are digits!");
            } catch (NullPointerException exception) {
                System.out.println("Id not exist !");
            } catch (Exception exception) {
                System.out.println("Id already exist !");;
            }

        }

        return bookId;
    }

    private static boolean idExist(String idPublisher, List<Publisher> pList) {
        for (Publisher p : pList) {
            if (p.getId().equals(idPublisher)) {
                return true;
            }
        }
        return false;
    }

    private static boolean idBookExist(String bId, List<Book> bList) {
        for (Book b : bList) {
            if (b.getBookId().equals(bId)) {
                return true;
            }
        }
        return false;
    }

    public static String getName(String msg) {
        String input;
        String pattern = "^([a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*){5,30}$";
        while (true) {
            try {
                System.out.print(msg);
                input = sc.nextLine();
                if (input.matches(pattern)) {
                    break;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input characters in range 5-30 ");
            }

        }

        return input;
    }

//    Get phone number
    public static String getPhoneNumber(String msg) {
        String p;
        while (true) {
            try {
                System.out.print(msg);
                p = sc.nextLine();
                if (10 <= p.length() && p.length() <= 12) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input an integer phone Number in range 10 - 12 numbers ");

            }

        }
        return p;
    }

//    Boook Management Boook 
    public static String getBookNameForUpdate(String msg) {
        String input;
        while (true) {
            try {
                String patternForUpdate = "[\\s\\S]*.{5,30}";
                System.out.println(msg);
                input = sc.nextLine();
                if (input.matches(patternForUpdate)) {
                    break;
                } else if (input.equals("")) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Book name has length 5 - 30 characters");
                System.out.println("Enter book name again");
            }
        }
        return input;
    }

    public static String gerBookNameForSearch(String msg) {
        String input;
        while (true) {
            try {
                String patternForUpdate = "[\\s\\S]*.{5,30}";
                System.out.println(msg);
                input = sc.nextLine();
                if (input.matches(patternForUpdate)) {
                    break;
                } else if (input.equals("")) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Book name has length 5 - 30 characters");
                System.out.println("Enter book name again");
            }
        }
        return input;
    }

    public static String getBookName(String msg) {
        String input;
        while (true) {
            try {
                String pattern = "^([a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*){5,30}$";
                System.out.print(msg);
                input = sc.nextLine();
                if (input.matches(pattern)) {
                    break;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input characters in range 5-30 ");
            }

        }

        return input;
    }

//       Ham lay gia cua cuon sach
    public static double getBookPrice(String msg, double min, double max) {
        double price;
        while (true) {
            try {
                System.out.print(msg);
                price = Double.parseDouble(sc.nextLine());
                if (price >= 0.00000001) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("Please input double >= 0");
            }
        }
        return price;
    }

    public static int getBookQuantity(String msg) {
        int quantity;
        while (true) {
            try {
                System.out.print(msg);
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();

                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please input integer >0");
            }
        }
        return quantity;
    }

    public static String getBookStatus(String msg) {
        String b;
        System.out.print("Enter your choice A(availaible) or N(not available)");
        while (true) {

            try {
                b = sc.nextLine();
                if ("a".equals(b) || "A".equals(b)) {
                    b = "Available";
                    break;
                } else if ("n".equals(b) || "N".equals(b)) {
                    b = "Not available";
                    break;

                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter A or N");
            }

        }
        return b;

    }

    public static String getBookUpdateStatus(String msg) {
        String b;
        System.out.print("Enter your choice A(availaible) or N(not available)");
        while (true) {

            try {
                b = sc.nextLine();
                if ("a".equals(b) || "A".equals(b)) {
                    b = "Available";
                    break;
                } else if ("n".equals(b) || "N".equals(b)) {
                    b = "Not available";
                    break;
                } else if (b.equals("")) {
                    return b;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter A or N");
            }

        }
        return b;

    }

    public static String publisherName(String id, List<Publisher> pList, List<Book> bList) {
        String name;
        for (Publisher p : pList) {
            if (p.getId().equals(id)) {
                name = p.getName();
                return name;
            }
        }
        return null;
    }

}
