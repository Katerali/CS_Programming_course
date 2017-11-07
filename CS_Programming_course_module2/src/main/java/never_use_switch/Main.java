package never_use_switch;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MailSender2 mailSender = new MailSender2();

        Client client = new Client("Andriy", 35);
        MailInfo mail = new MailInfo(client, 50);
        mailSender.sendMail(mail);
    }
}
