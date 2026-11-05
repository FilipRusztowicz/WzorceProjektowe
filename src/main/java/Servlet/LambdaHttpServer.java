package Servlet;

import java.util.HashMap;
import java.util.Map;

public class LambdaHttpServer {
    private final Map<String, RequestHandlerInterface> handlers = new HashMap<>();

    public void register(String method, RequestHandlerInterface handler) {
        handlers.put(method.toUpperCase(), handler);
    }

    public void service(Request req, Response res) {
        RequestHandlerInterface handler = handlers.get(req.getMethod().toUpperCase());
        if (handler != null) {
            handler.handle(req, res);
        } else {
            res.write("405 Method Not Allowed");
        }
    }
}
