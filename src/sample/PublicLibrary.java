package sample;
import sample.UI.UI;
import sample.entity.PrintEdition;
import sample.entity.Profile;
import sample.entity.VisitorRole;
import sample.services.*;

import java.util.ArrayList;

public class PublicLibrary {

    private UI ui;

    public void start() {
        AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl();
        BookBorrowingServiceImpl bookBorrowingService = new BookBorrowingServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        ServiceFormImpl serviceForm = new ServiceFormImpl();

        Profile visitor = new Profile("Ксения","Банцевич", "111","111","ggg@gmail");
        Profile visitor1 = new Profile("Анна","Грицук","222","222","ааа@gmail.com");
        visitor.setRole(VisitorRole.OWNER);
        visitor1.setRole(VisitorRole.VISITOR);
        ArrayList<Profile> visitorArrayList = new ArrayList<>();
        visitorArrayList.add(visitor);
        visitorArrayList.add(visitor1);
        authorizationService.setListOfProfiles(visitorArrayList);

        PrintEdition master = new PrintEdition("Мастер и Маргарита","М.А.Булгаков", 1966);
        PrintEdition picture = new PrintEdition("Портрет Дориана Грея","Оскар Уайлд",1890);
        PrintEdition arc = new PrintEdition("Триумфальная арка","Эрих Мария Ремарк",1946);
        ArrayList<PrintEdition> bookArrayList = new ArrayList<>();
        bookArrayList.add(master);
        bookArrayList.add(picture);
        bookArrayList.add(arc);
        bookService.setListOfBooks(bookArrayList);
        bookBorrowingService.mail(visitorArrayList);
        ui = new UI();
        ui.setAuthorizationService(authorizationService);
        ui.setBookBorrowingService(bookBorrowingService);
        ui.setBookService(bookService);
        ui.setServiceForm(serviceForm);
        ui.library();
    }
    public UI getUi() {
        return ui;
    }

}
