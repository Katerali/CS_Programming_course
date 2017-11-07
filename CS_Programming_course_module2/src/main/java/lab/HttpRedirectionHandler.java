package lab;

public class HttpRedirectionHandler implements HttpHandler {
    @Override
    public String generateMessage() {
        return "You are redirected";
    }
}
