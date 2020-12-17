package sample.UI;

import sample.entity.PrintEdition;
import sample.entity.StorageRecord;
import sample.entity.VisitorRole;
import sample.services.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class UI {
    AuthorizationServiceImpl authorizationService;
    BookBorrowingServiceImpl bookBorrowingService;
    BookServiceImpl bookService;
    ServiceFormImpl serviceForm;

    public void library(){
        JFrame frame = new JFrame();
        frame.setSize(500,400);
        JPanel jpanel1 = new JPanel();
        jpanel1.setLayout(new BoxLayout(jpanel1,BoxLayout.X_AXIS));
        JButton buttonEditBook = new JButton();
        buttonEditBook.setText("Вход в библиотеку");
        buttonEditBook.setSize(400,50);
        buttonEditBook.addActionListener(actionEvent ->
        {
            entry();
        });
        JButton  buttonAddBook = new JButton();
        buttonAddBook.setText("Регистрация");
        buttonAddBook.setSize(400,50);
        buttonAddBook.addActionListener(actionEvent -> {
            addProfile();
        });

        JButton  buttonDeleteBook = new JButton();
        buttonDeleteBook.setText("Удалить учетную запись");
        buttonDeleteBook.setSize(400,50);
        /*buttonDeleteBook.addActionListener(actionEvent -> {
         //ToDo
            deleteProfile();
        });*/

        jpanel1.add(buttonEditBook);
        jpanel1.add(buttonAddBook);
        jpanel1.add(buttonDeleteBook);
        frame.add(jpanel1);
        frame.setVisible(true);

    }

    public void addProfile()
    {
        JFrame jframe = new JFrame();
        jframe.setSize(600,400);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        JLabel labelLastName = new JLabel("Фамилия");
        labelLastName.setSize(100,50);
        JTextField textFieldName = new JTextField();
        textFieldName.setMaximumSize(new Dimension(100,50));

        JLabel labelName = new JLabel("Имя");
        labelLastName.setSize(100,50);
        JTextField textFieldLastName = new JTextField();
        textFieldLastName.setMaximumSize(new Dimension(100,50));

        JLabel labelLogin= new JLabel("Login");
        labelLogin.setSize(100,50);
        JTextField textFieldLogin = new JTextField();
        textFieldLogin.setMaximumSize(new Dimension(100,50));

        JLabel labelPassword= new JLabel("Password");
        labelPassword.setSize(100,50);
        JTextField textFieldPassword = new JTextField();
        textFieldPassword.setMaximumSize(new Dimension(100,50));


        JLabel labelMail= new JLabel("Почта");
        labelMail.setSize(100,50);
        JTextField textFieldMail = new JTextField();
        textFieldMail.setMaximumSize(new Dimension(100,50));
        ArrayList<JRadioButton> radioButtons= new ArrayList<>();

        JRadioButton radioButton1 = new JRadioButton();
        radioButton1.setText("OWNER");

        JRadioButton radioButton2 = new JRadioButton();
        radioButton2.setText("VISITOR");

        JButton button = new JButton("Зарегистрироваться");
        button.setMaximumSize(new Dimension(100,50));

        button.addActionListener(actionEvent ->
        {
            jframe.dispose();
            JRadioButton temp = new JRadioButton();
            for(JRadioButton radioButton:radioButtons)
            {
                if(radioButton.isSelected())
                {
                    temp = radioButton;
                }
            }
            if(textFieldName.getText().equals("") || textFieldLastName.getText().equals("") || textFieldMail.getText().equals(""))
            {
                System.out.println("Ошибка");
            }
            else{

                authorizationService.addProfile(textFieldLastName.getText(),textFieldName.getText(),textFieldLogin.getText(),textFieldPassword.getText(),textFieldMail.getText(), temp.getText());
                entry();
            }

        });
        JButton buttonBack = new JButton("Назад");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            jframe.dispose();
            library();
        });

        jPanel.add(labelName);
        jPanel.add(textFieldName);
        jPanel.add(labelLastName);
        jPanel.add(textFieldLastName);
        jPanel.add(labelMail);
        jPanel.add(textFieldMail);
        jPanel.add(labelLogin);
        jPanel.add(textFieldLogin);
        jPanel.add(labelPassword);
        jPanel.add(textFieldPassword);
        jPanel.add(radioButton1);
        jPanel.add(radioButton2);
        jPanel.add(button);
        jPanel.add(buttonBack);
        jframe.add(jPanel);
        jframe.setVisible(true);
    }

    public void entry()
    {
        JFrame jframe = new JFrame();
        jframe.setSize(500, 300);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.LINE_AXIS));
        JLabel jlabel = new JLabel();
        jlabel.setText("Login");
        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(300, 50));
        JLabel jlabelPassword = new JLabel();
        jlabelPassword.setText("Пароль");
        JTextField jTextField1 = new JTextField();
        jTextField1.setMaximumSize(new Dimension(300, 50));
        JButton jButton = new JButton();
        jButton.setMaximumSize(new Dimension(100, 50));
        jButton.setText("Войти");
        jButton.addActionListener(actionEvent ->
        {

            login(jTextField.getText(), jTextField1.getText());
            jframe.dispose();
        });
        jpanel.add(jlabel);
        jpanel.add(jTextField);
        jpanel.add(jlabelPassword);
        jpanel.add(jTextField1);
        jpanel.add(jButton);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }

    public void login(String login, String password)
    {
        authorizationService.authorization(login, password);
        adminWindow();
    }

    public void adminWindow()
    {
        if(VisitorRole.OWNER == authorizationService.getVisitor().getRole())
        {
            JFrame frame = new JFrame();
            frame.setSize(800,500);
            JPanel jpanel1 = new JPanel();
            jpanel1.setLayout(new BoxLayout(jpanel1,BoxLayout.X_AXIS));
            JButton buttonEditBook = new JButton();
            buttonEditBook.setText("Обновить информацию о книге");
            buttonEditBook.setSize(400,50);
            buttonEditBook.addActionListener(actionEvent ->
            {
                editWindow();
            });
            JButton  buttonAddBook = new JButton();
            buttonAddBook.setText("Добавить новую книгу в библиотеку");
            buttonAddBook.setSize(400,50);
            buttonAddBook.addActionListener(actionEvent -> {
                addWindow();
            });

            JButton  buttonDeleteBook = new JButton();
            buttonDeleteBook.setText("Удалить книгу из библиотеки");
            buttonDeleteBook.setSize(400,50);
            buttonDeleteBook.addActionListener(actionEvent -> {
                deleteWindow();
            });

            jpanel1.add(buttonEditBook);
            jpanel1.add(buttonAddBook);
            jpanel1.add(buttonDeleteBook);
            frame.add(jpanel1);
            frame.setVisible(true);

        }
        else if(VisitorRole.VISITOR == authorizationService.getVisitor().getRole())
        {
            JFrame frame = new JFrame();
            frame.setSize(1000,500);
            JPanel jpanel1 = new JPanel();
            jpanel1.setLayout(new BoxLayout(jpanel1,BoxLayout.X_AXIS));
            JButton buttonFrameManagmentProduct= new JButton();
            buttonFrameManagmentProduct.setText("Взять книгу");
            buttonFrameManagmentProduct.setSize(1000,50);
            buttonFrameManagmentProduct.addActionListener(actionEvent ->
            {

                tookBook();

            });
            JButton buttonShowOverdueProduct = new JButton();
            buttonShowOverdueProduct.setText("Сдать книгу");
            buttonShowOverdueProduct.setSize(1000,50);
            buttonShowOverdueProduct.addActionListener(actionEvent -> {

                returnBook();
            });
            JButton buttonManagementProduct = new JButton();
            buttonManagementProduct.setText("Оплатить задолженность");
            buttonManagementProduct.setSize(1000,50);
            buttonManagementProduct.addActionListener(actionEvent -> {
                money();
            });


            jpanel1.add(buttonManagementProduct);
            jpanel1.add(buttonShowOverdueProduct);
            jpanel1.add(buttonFrameManagmentProduct);
            frame.add(jpanel1);
            frame.setVisible(true);

        }
    }

    public void editWindow(){

        JFrame jframe = new JFrame();
        jframe.setSize(500,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JComboBox<String> bookJComboBox= new JComboBox<>();
        bookJComboBox.setMaximumSize(new Dimension(100,50));
        for (PrintEdition ourPrintEdition: bookService.getListOfBooks())
        {
            bookJComboBox.addItem(ourPrintEdition.getBookName());
        }
        JButton button = new JButton("Редактировать");
        button.setSize(100,50);
        button.addActionListener(actionEvent ->
        {

            for (PrintEdition ourPrintEdition: bookService.getListOfBooks())
            {
                if(bookJComboBox.getSelectedItem().toString().equals(ourPrintEdition.getBookName()))
                {
                    jframe.dispose();
                    editPrintEdition(ourPrintEdition);
                }

            }
        });
        JButton buttonBack = new JButton("Back");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            jframe.dispose();
            adminWindow();
        });
        jPanel.add(bookJComboBox);
        jPanel.add(button);
        jPanel.add(buttonBack);
        jframe.add(jPanel);
        jframe.setVisible(true);

    }

    public  void editPrintEdition(PrintEdition book)
    {
        JFrame jframe = new JFrame();
        jframe.setSize(500,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        JLabel labelName = new JLabel("Название книги:");
        labelName.setSize(100,50);
        JTextField textFieldName = new JTextField();
        textFieldName.setText(book.getBookName());
        textFieldName.setMaximumSize(new Dimension(100,50));

        JLabel labelLastName = new JLabel("Автор книги:");
        labelLastName.setSize(100,50);
        JTextField textFieldLastName = new JTextField();
        textFieldLastName.setText(book.getAuthor());
        textFieldLastName.setMaximumSize(new Dimension(100,50));

        JLabel labelPatronymic = new JLabel("Год назад");
        labelPatronymic.setSize(100,50);
        JTextField textFieldPatronymic = new JTextField();
        textFieldPatronymic.setText(String.valueOf(book.getPublishingYear()));
        textFieldPatronymic.setMaximumSize(new Dimension(100,50));


        JButton button = new JButton("Отредактировать");
        button.setMaximumSize(new Dimension(100,50));

        button.addActionListener(actionEvent ->
        {
            jframe.dispose();
            if(textFieldName.getText().equals("") || textFieldLastName.getText().equals("") || textFieldPatronymic.getText().equals(""))
            {
                System.out.println("Проверьте данные");
            }
            else{

                bookService.editPrintEdition(book,textFieldName.getText(),textFieldLastName.getText(), Integer.valueOf(textFieldPatronymic.getText()));
                editWindow();
            }

        });

        jPanel.add(labelName);
        jPanel.add(textFieldName);
        jPanel.add(labelLastName);
        jPanel.add(textFieldLastName);
        jPanel.add(labelPatronymic);
        jPanel.add(textFieldPatronymic);
        jPanel.add(button);
        jframe.add(jPanel);
        jframe.setVisible(true);
    }

    public void addWindow(){
        JFrame jframe = new JFrame();
        jframe.setSize(500,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));

        JLabel labelName = new JLabel("Название книги:");
        labelName.setSize(100,50);
        JTextField textFieldName = new JTextField();
        textFieldName.setMaximumSize(new Dimension(100,50));

        JLabel labelAuthor = new JLabel("Автор книги:");
        labelAuthor.setSize(100,50);
        JTextField textFieldAuthor = new JTextField();
        textFieldAuthor.setMaximumSize(new Dimension(100,50));

        JLabel labelYear = new JLabel("Год публикации:");
        labelYear.setSize(100,50);
        JTextField textFieldYear = new JTextField();
        textFieldYear.setMaximumSize(new Dimension(100,50));


        JButton button = new JButton("Добавить книгу в библиотеку");
        button.setMaximumSize(new Dimension(400,50));

        button.addActionListener(actionEvent ->
        {
            jframe.dispose();

            if(textFieldName.getText().equals("") || textFieldAuthor.getText().equals("") || textFieldYear.getText().equals(""))
            {
                System.out.println("Ошибка");
            }
            else{

                bookService.addToLibrary(textFieldName.getText(),textFieldAuthor.getText(), Integer.valueOf(textFieldYear.getText()));
                adminWindow();
            }

        });
        JButton buttonBack = new JButton("Back");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            jframe.dispose();
            adminWindow();
        });

        jPanel.add(labelName);
        jPanel.add(textFieldName);
        jPanel.add(labelAuthor);
        jPanel.add(textFieldAuthor);
        jPanel.add(labelYear);
        jPanel.add(textFieldYear);

        jPanel.add(button);
        jPanel.add(buttonBack);
        jframe.add(jPanel);
        jframe.setVisible(true);
    }

    public void deleteWindow(){

        JFrame jframe = new JFrame();
        jframe.setSize(700,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JComboBox<String> bookJComboBox= new JComboBox<>();
        bookJComboBox.setMaximumSize(new Dimension(400,50));
        for (PrintEdition books: bookService.getListOfBooks())
        {
            bookJComboBox.addItem(books.getBookName());
        }
        JButton button = new JButton("Удалить");
        button.setSize(100,50);
        button.addActionListener(actionEvent ->
        {
            for (PrintEdition books: bookService.getListOfBooks())
            {
                if(bookJComboBox.getSelectedItem().toString().equals(books.getBookName()))
                {
                    jframe.dispose();
                    bookService.deletePrintEdition(books);
                }

            }
        });
        JButton buttonBack = new JButton("Назад");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            jframe.dispose();
            adminWindow();
        });
        jPanel.add(bookJComboBox);
        jPanel.add(button);
        jPanel.add(buttonBack);
        jframe.add(jPanel);
        jframe.setVisible(true);
    }


    public void tookBook(){
        JFrame frame = new JFrame();
        frame.setSize(700,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JComboBox<String> bookJComboBox= new JComboBox<>();
        bookJComboBox.setMaximumSize(new Dimension(400,50));
        for (PrintEdition books: bookService.getListOfBooks())
        {
            bookJComboBox.addItem(books.getBookName());
        }
        JButton button = new JButton("Взять в пользование");
        button.setSize(100,50);
        button.addActionListener(actionEvent ->
        {
            for (PrintEdition books: bookService.getListOfBooks())
            {
                if(bookJComboBox.getSelectedItem().toString().equals(books.getBookName()))
                {
                    frame.dispose();
                    bookBorrowingService.takeBook(books);

                }

            }
        });
        JButton buttonBack = new JButton("Назад");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            frame.dispose();
            adminWindow();
        });
        jPanel.add(bookJComboBox);
        jPanel.add(button);
        jPanel.add(buttonBack);
        frame.add(jPanel);
        frame.setVisible(true);
    }

    public void returnBook(){
        JFrame frame = new JFrame();
        frame.setSize(700,500);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        JComboBox<String> bookJComboBox= new JComboBox<>();
        bookJComboBox.setMaximumSize(new Dimension(400,50));
        for (PrintEdition books: bookService.getListOfBooks())
        {
            bookJComboBox.addItem(books.getBookName());
        }
        JButton button = new JButton("Вернуть книгу в библиотеку");
        button.setSize(100,50);
        button.addActionListener(actionEvent ->
        {
            for (PrintEdition books: bookService.getListOfBooks())
            {
                if(bookJComboBox.getSelectedItem().toString().equals(books.getBookName()))
                {
                    frame.dispose();
                    bookBorrowingService.returnBook(books);

                }

            }
        });
        JButton buttonBack = new JButton("Назад");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            frame.dispose();
            adminWindow();
        });
        jPanel.add(bookJComboBox);
        jPanel.add(button);
        jPanel.add(buttonBack);
        frame.add(jPanel);
        frame.setVisible(true);
    }


    public void money(){
        JFrame jframe = new JFrame();
        jframe.setSize(500, 300);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.LINE_AXIS));
        JLabel jlabel = new JLabel();
        jlabel.setText("Задолженность");
        JTextField jTextField = new JTextField();
        jTextField.setMaximumSize(new Dimension(300, 50));

        JButton button = new JButton("Оплатить задолженность");
        button.setSize(100,50);
        button.addActionListener(actionEvent ->
        {
            money();
        });
        JButton buttonBack = new JButton("Назад");
        buttonBack.setSize(100,50);
        buttonBack.addActionListener(actionEvent ->
        {
            jframe.dispose();
            adminWindow();
        });

        jpanel.add(jlabel);
        jpanel.add(jTextField);
        jpanel.add(button);
        jpanel.add(buttonBack);
        jframe.add(jpanel);
        jframe.setVisible(true);
    }

















    public BookBorrowingService getBookBorrowingService() {
        return bookBorrowingService;
    }

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public ServiceForm getServiceForm() {
        return serviceForm;
    }

    public void setAuthorizationService(AuthorizationServiceImpl authorizationService) {
        this.authorizationService = authorizationService;
    }

    public void setBookBorrowingService(BookBorrowingServiceImpl bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }

    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    public void setServiceForm(ServiceFormImpl serviceForm) {
        this.serviceForm = serviceForm;
    }
}
