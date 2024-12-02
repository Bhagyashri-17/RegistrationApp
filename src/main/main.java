import dao.RegistrationDAO;

public class Main {
    public static void main(String[] args) {
        RegistrationDAO dao = new RegistrationDAO();
        dao.createRegistration("Bhagyashri Jadhav", "bhagyshrijadhav71@gmail.com", "2000-07-05", "9975329387", "Bengaluru");
        dao.readRegistration(1);
        dao.updateEmail(1, "bhagyashrijadhav71.updated@gmail.com");
        dao.deleteRegistration(1);
    }
}
