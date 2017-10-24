package instead_of_switch;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random r = new Random();
        int mailCode = r.nextInt(6);

        Client client = new Client("Ivan", 24);


        Mail mail = new Mail(mailCode, client);
        mail.content();

    }

}
