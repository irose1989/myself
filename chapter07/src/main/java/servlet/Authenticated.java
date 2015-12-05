package servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wb-chenchaobin on 2015/12/3.
 */
@WebServlet(name = "authenticated",urlPatterns = "/authenticated")
public class Authenticated extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            req.getRequestDispatcher("WEB-INF/jsp/authenticated.jsp").forward(req, resp) ;
        }else{
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
        }
    }
}
