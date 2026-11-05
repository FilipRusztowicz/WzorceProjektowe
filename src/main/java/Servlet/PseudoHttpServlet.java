package Servlet;

import java.util.HashMap;
import java.util.Map;

public abstract class PseudoHttpServlet {
    private final Map<String, RequestHandlerInterface> handlers = new HashMap<>();

    public PseudoHttpServlet() {
        handlers.put("GET", this::doGet);
        handlers.put("POST", this::doPost);
        handlers.put("PUT", this::doPut);
        handlers.put("DELETE", this::doDelete);
    }

    protected void doGet(Request req, Response res) {
        res.write("Default GET not implemented");
    }

    protected void doPost(Request req, Response res) {
        res.write("Default POST not implemented");
    }

    protected void doPut(Request req, Response res) {
        res.write("Default PUT not implemented");
    }

    protected void doDelete(Request req, Response res) {
        res.write("Default DELETE not implemented");
    }


    public void service(Request req, Response res) {
        RequestHandlerInterface handler = handlers.get(req.getMethod());
        if (handler != null) {
            handler.handle(req, res);
        } else {
            res.write("405 Method Not Allowed");
        }
    }
}

