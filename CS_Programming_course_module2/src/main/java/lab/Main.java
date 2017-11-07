package lab;

import factory.InjectRandomInt;

public class Main {
    public static void main(String[] args) {
        HttpHandler message = HttpStatus.findByHttpCode(456);
        System.out.println(message.generateMessage());
    }
}
