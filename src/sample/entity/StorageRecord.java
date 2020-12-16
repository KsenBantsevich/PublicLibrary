package sample.entity;

import java.util.List;

public class StorageRecord {
    private String bookName;
    private double indebtedness;
    private List<PrintEdition> listOfUnBooks;
    private List<PrintEdition> listOfBooks;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }


    public void setIndebtedness(int indebtedness) {
        this.indebtedness = indebtedness;
    }

    public double getIndebtedness() {
        return indebtedness;
    }
}
