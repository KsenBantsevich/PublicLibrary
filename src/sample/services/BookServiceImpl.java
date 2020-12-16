
package sample.services;

import sample.entity.PrintEdition;

import java.util.List;

public class BookServiceImpl implements BookService {
    List<PrintEdition> listOfBooks;
    PrintEdition book;


    public void set(List<PrintEdition> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<PrintEdition> getListOfBooks() {
        return listOfBooks;
    }

    public void setBook(PrintEdition book) {
        this.book = book;
    }

    public PrintEdition getBook() {
        return book;
    }

    @Override
    public void addToLibrary(String bookName, String author, Integer publishingYear) {
        PrintEdition printEdition = new PrintEdition(bookName, author, publishingYear);
        listOfBooks.add(printEdition);
    }

    @Override
    public void checkIfExists(String bookName) {

    }
}