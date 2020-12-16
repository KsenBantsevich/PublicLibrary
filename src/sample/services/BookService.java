package sample.services;

import sample.entity.PrintEdition;

public interface BookService {
    void addToLibrary(String author, String bookName,  Integer publishingYear);
    void checkIfExists(String bookName);
    void editPrintEdition(PrintEdition ourPrintEdition, String bookName, String author, Integer publishingYear);
    void deletePrintEdition(PrintEdition printEdition);
}
