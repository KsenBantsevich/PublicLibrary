package sample.services;

import sample.entity.PrintEdition;
import sample.entity.Profile;
import sample.entity.StorageRecord;
import java.util.List;

public class BookBorrowingServiceImpl implements BookBorrowingService {
    PrintEdition book;
    List<Profile> listOfProfiles;

    public void takeBook(PrintEdition books) {

    }

    public void returnBook(PrintEdition books) {
//проверка на взятие
        //возвращение
    }

    public void money(PrintEdition books) {
//посчитать сумму задолженности
        //оплатить/удалить задолженность с формуляра
    }

    public void mail(List<Profile> listOfProfiles) {
//сообщение об задолженности на почту
    }
}
