package Servlet;

public class MyServlet extends PseudoHttpServlet{
    @Override
    protected void doGet(Request req, Response res) {
        res.write("Handling GET: " + req.getBody());
    }
    @Override
    protected void doPost(Request req, Response res) {
        res.write("Handling POST with data: " + req.getBody());
    }
}
