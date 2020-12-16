package sample.UI;

import sample.entity.Profile;
import sample.entity.VisitorRole;
import sample.services.*;

import javax.swing.*;
import java.awt.*;

public class UI {
    AuthorizationServiceImpl authorizationService;
    BookBorrowingServiceImpl bookBorrowingService;
    BookServiceImpl bookService;
    ServiceFormImpl serviceForm;

        public void entry()
        {
            JFrame jframe = new JFrame();
            jframe.setSize(1000, 500);
            JPanel jpanel = new JPanel();
            jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.LINE_AXIS));
            JLabel jlabel = new JLabel();
            jlabel.setText("Login");
            JTextField jTextField = new JTextField();
            jTextField.setMaximumSize(new Dimension(400, 50));
            JLabel jlabelPassword = new JLabel();
            jlabelPassword.setText("Password");
            JTextField jTextField1 = new JTextField();
            jTextField1.setMaximumSize(new Dimension(400, 50));
            JButton jButton = new JButton();
            jButton.setMaximumSize(new Dimension(400, 50));
            jButton.setText("Log in");
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
        if(VisitorRole.ROLE_OWNER == authorizationService.getVisitor().getRole())
        {
            JFrame frame = new JFrame();
            frame.setSize(1000,500);
            JPanel jpanel1 = new JPanel();
            jpanel1.setLayout(new BoxLayout(jpanel1,BoxLayout.X_AXIS));
            JButton buttonEditBook = new JButton();
            buttonEditBook.setText("Обновить информацию о книге");
            buttonEditBook.setSize(400,50);
            buttonEditBook.addActionListener(actionEvent ->
            {

                //frameManagementEmployee.showFrameManagementEmployee();
            });
            JButton  buttonAddBook = new JButton();
            buttonAddBook.setText("Добавить новую книгу");
            buttonAddBook.setSize(400,50);
            buttonAddBook.addActionListener(actionEvent -> {

               // frameStaff.buttonIsPressed(buttonShowInformation.getText());
            });



            jpanel1.add(buttonEditBook);
            jpanel1.add(buttonAddBook);
            frame.add(jpanel1);
            frame.setVisible(true);

        }
        else if(VisitorRole.ROLE_VISITOR == authorizationService.getVisitor().getRole())
        {
            JFrame frame = new JFrame();
            frame.setSize(1000,500);
            JPanel jpanel1 = new JPanel();
            jpanel1.setLayout(new BoxLayout(jpanel1,BoxLayout.X_AXIS));
            JButton buttonFrameManagmentProduct= new JButton();
            buttonFrameManagmentProduct.setText("Show number of products");
            buttonFrameManagmentProduct.setSize(1000,50);
            buttonFrameManagmentProduct.addActionListener(actionEvent ->
            {

               // frameShowNumber.showNumber();

            });
            JButton buttonShowOverdueProduct = new JButton();
            buttonShowOverdueProduct.setText("Show overdue products");
            buttonShowOverdueProduct.setSize(1000,50);
            buttonShowOverdueProduct.addActionListener(actionEvent -> {

                //frameProduct.buttonIsPressed(buttonShowOverdueProduct.getText());
            });
            JButton buttonManagementProduct = new JButton();
            buttonManagementProduct.setText("Show management products");
            buttonManagementProduct.setSize(1000,50);
            buttonManagementProduct.addActionListener(actionEvent -> {
                //frameManagementProduct.buttonIsPressed(buttonManagementProduct.getText());
            });


            jpanel1.add(buttonManagementProduct);
            jpanel1.add(buttonShowOverdueProduct);
            jpanel1.add(buttonFrameManagmentProduct);
            frame.add(jpanel1);
            frame.setVisible(true);

        }
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
