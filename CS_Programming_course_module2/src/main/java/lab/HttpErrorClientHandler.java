package lab;

public class HttpErrorClientHandler implements HttpHandler {
    @Override
    public String generateMessage() {
        return "Client error happened";
    }
}
