package sample.entity;

import java.util.Date;
import java.util.List;

public class Ordering {
    private String bookName;
    private String visitorLastName;
    private Date returnedDate;
    private List<PrintEdition> listOfBooks;
    private Profile visitor;


    public void setBookName(String bookName) {
        this.bookName= bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setVisitorLastName(String visitorLastName) {
        this.visitorLastName = visitorLastName;
    }

    public String getVisitorLastName() {
        return visitorLastName;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }
}
