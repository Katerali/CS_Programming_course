package never_use_switch;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    public String getName() {
        return name;
    }

    private String name;

    public int getAge() {
        return age;
    }

    private int age;
}
