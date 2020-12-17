package sample.entity;

public class Profile {
    private String name;
    private String firstName;
    private VisitorRole role;
    private String login;
    private String password;
    private String mail;
    private StorageRecord storageRecord;
    public Profile(String lastName, String firstName,String  login,String password,String mail)
    {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.name = lastName;
        this.mail = mail;

    }

    public VisitorRole getVisitorRole() {
        return  role;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.name = lastName;
    }

    public String getLastName() {
        return name;
    }

    public void setRole(VisitorRole role) {
        this.role = role;
    }

    public VisitorRole getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login= login;
    }

    public String getLogin() {
        return login;
    }

    public void setMail(String mail) {
        this.mail= mail;
    }

    public String getMail() {
        return mail;
    }

    public StorageRecord getStorageRecord() {
        return storageRecord;
    }

    public void setStorageRecord(StorageRecord storageRecord) {
        this.storageRecord = storageRecord;
    }
}
