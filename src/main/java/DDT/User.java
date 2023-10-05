package DDT;

public class User {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String dateOfBirth;
    private String password;

    public User(String firstName, String lastName, String mobileNumber, String email, String dateOfBirth, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getFirstName() {return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }
}
