import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;

/**
 * Created by wb-chenchaobin on 2015/12/8.
 */
public class LoginAction extends ActionSupport {
    private String user;
    private String password;
    private String name;
    public String execute(){
        String result = ERROR;
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql:///struts_tutorial?useUnicode=true&amp;characterEncoding=utf-8";
            try {
                conn = DriverManager.getConnection(url,"root","root");
                String sql = "select * from login where user=? and password=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,user);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    name = rs.getString(1);
                    result=SUCCESS;
                }
            } catch (SQLException e) {
                result=ERROR;
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            result=ERROR;
            e.printStackTrace();
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
