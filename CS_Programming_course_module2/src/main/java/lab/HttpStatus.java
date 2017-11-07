package lab;

import lombok.Getter;

@Getter
public enum HttpStatus {
    INFORMATIONAL(100, 199, new HttpInfoHandler()),
    SUCCESS(200, 299, new HttpSuccessHandler()),
    REDIRECTION(300, 399, new HttpRedirectionHandler()),
    ERROR_CLIENT(400, 499, new HttpErrorClientHandler()),
    ERROR_SERVER(500, 599, new HttpErrorServerHandler());


    private int min, max;
    private HttpHandler handler;


    HttpStatus(int min, int max, HttpHandler handler) {
        this.min = min;
        this.max = max;
        this.handler = handler;
    }


    public static HttpHandler findByHttpCode(int code) {
        for (HttpStatus value : values()) {
            if (code >= value.min && code <= value.max){
                return value.handler;
        }
            }
        throw new RuntimeException(code + " not supported");
    }

    public HttpHandler getHandler(){
        return handler;
    }
}

