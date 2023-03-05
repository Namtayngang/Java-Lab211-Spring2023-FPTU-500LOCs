/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectHolder;

/**
 *
 * @author USER
 */
public class Book {

    private String bookId;
    private String bookName;
    private Double bookPrice;
    private int bookQuantity;
    private String bookStatus;
    private String bookPublisher;

    public Book(String bookId, String bookName, Double bookPrice, int bookQuantity, String bookStatus, String bookPublisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
        this.bookStatus = bookStatus;
        this.bookPublisher = bookPublisher;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString() {
        return String.format("%-8s|%-20s|%-7.0f|%-10d|%-10s|%-10s|\n",
                bookId, bookName, bookPrice, bookQuantity, bookStatus, bookPublisher);
    }

}
