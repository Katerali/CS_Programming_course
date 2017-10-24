package instead_of_switch;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Mail {
    private Client client;
    public int mailCode;

    public Mail(int mailCode, Client client){
        this.mailCode = mailCode;
        this.client = client;
    }

    public void content(){
        String startString = "Dear " + this.client.getName() + "!\n";
        if (this.mailCode == 0){
                System.out.println(startString + "Welcome to our company!");
        }
        if (this.mailCode == 1){
            System.out.println(startString + "A month left for paying");
        }
        if (this.mailCode == 2) {
            System.out.println(startString + "A week left for paying");
        }
        if (this.mailCode == 3){
            System.out.println(startString + "A day left for paying");
        }
        if (this.mailCode == 4){
            System.out.println(startString + "It's late to pay");
        }
        if (this.mailCode == 5){
            System.out.println(startString + "Goodbye. You are not our client anymore");
        }
    };
}
