import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {
    ItemDAO itemDAO = new ItemDAO();
    ItemController itemController = new ItemController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().println(itemDAO.findById(itemDAO.convertStringIdToLong(req, resp)));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String strReq = req.getParameter("id");
//        Long id = null;
//        try {
//            id = new Long(req.getParameter("id"));
//        } catch (NumberFormatException e) {
//            resp.getWriter().println("Wrong format");
//        }

        try {
            itemController.delete(itemDAO.convertStringIdToLong(req, resp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item();
        item.setName(req.getParameter("name"));
        item.setDescription(req.getParameter("description"));
        item.setDateCreated(new Date());
        item.setLastUpdateDate(new Date());

        resp.getWriter().println(itemController.save(item));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item();
        Long id = null;
        try {
            id = new Long(req.getParameter("id"));
        } catch (NumberFormatException e) {
            resp.getWriter().println("Wrong format");
        }

        item.setId(id);
        item.setName(req.getParameter("name"));
        item.setDescription(req.getParameter("description"));
        item.setLastUpdateDate(new Date());

        try {
            resp.getWriter().println(itemController.update(item));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //servlet registration - init()
    //servlet works wits service method - service()
    //to close servlet with its resources - destroy()

    //HTTP requests
    // GET - get some info
    // POST - save some info
    // PUT - update
    // DELETE - delete info
}