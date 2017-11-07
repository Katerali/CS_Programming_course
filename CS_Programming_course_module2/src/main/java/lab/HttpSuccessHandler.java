package lab;

public class HttpSuccessHandler implements HttpHandler {
    @Override
    public String generateMessage() {
        return "Your request succeeded";
    }
}
