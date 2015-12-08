package employee;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2015/12/9.
 *
 * TODO 一直验证失败
 */
public class EmployeeAction extends ActionSupport {
    private String username;
    private int age1;
//    @Override
//    public void validate() {
//        if(name==null||name.trim().equals("")){
//            System.out.println("name is required");
//            addFieldError("name","name is required");
//        }
//        if(age>50||age<20){
//            addFieldError("age","Age must be in between 20 and 50");
//        }
//    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }
}
