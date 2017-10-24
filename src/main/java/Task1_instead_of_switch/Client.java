package instead_of_switch;

import lombok.Data;

@Data
public class Client {
    private String name;
    private int age;

    public Client(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
}
