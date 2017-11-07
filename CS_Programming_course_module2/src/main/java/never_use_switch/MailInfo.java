package never_use_switch;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailInfo {

    private Client client;
    private int mailCode;


    public Client getClient() {
        return client;
    }

    public int getMailCode() {
        return mailCode;
    }


    public MailInfo(int mailCode) {
        this.mailCode = mailCode;
    }
}
