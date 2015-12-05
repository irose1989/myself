package servlet;

import org.apache.shiro.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wb-chenchaobin on 2015/12/3.
 */
@WebServlet(name="role",urlPatterns = "/role")
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SecurityUtils.getSubject().checkRole("admin");

        req.getRequestDispatcher("WEB-INF/jsp/role.jsp").forward(req,resp);
    }
}
