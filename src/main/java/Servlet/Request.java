package Servlet;

public class Request {
    private final String method;
    private final String body;

    public Request(String method, String body) {
        this.method = method;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public String getBody() {
        return body;
    }
}
