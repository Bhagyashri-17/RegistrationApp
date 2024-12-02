import dao.RegistrationDAO;

public class Main {
    public static void main(String[] args) {
        RegistrationDAO dao = new RegistrationDAO();
        dao.createRegistration("Komal Jadhav", "komal@example.com", "2000-01-01", "1234567890", "Mumbai");
        dao.readRegistration(1);
        dao.updateEmail(1, "komal.updated@example.com");
        dao.deleteRegistration(1);
    }
}
