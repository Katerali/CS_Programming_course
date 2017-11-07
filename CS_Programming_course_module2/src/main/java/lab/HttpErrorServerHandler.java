package lab;

public class HttpErrorServerHandler implements HttpHandler {
    @Override
    public String generateMessage() {
        return "Server error happened";
    }
}
