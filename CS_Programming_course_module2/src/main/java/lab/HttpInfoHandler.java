package lab;

public class HttpInfoHandler implements HttpHandler {
    @Override
    public String generateMessage() {
        return "You're receiving right information";
    }
}
