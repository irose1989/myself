package servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        String error = null;
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            error="用户不存在";
        }catch (IncorrectCredentialsException e){
            error="密码错误";
        }catch (Exception e){
            error="其他错误";
            req.setAttribute("error","其他错误");
        }
        if(error!=null){
            req.setAttribute("error",error);
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("WEB-INF/jsp/loginSuccess.jsp").forward(req,resp);
        }

    }
}
