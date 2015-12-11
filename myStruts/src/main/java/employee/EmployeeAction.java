package employee;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


/**
 * Created by Administrator on 2015/12/9.
 *
 * TODO XML配置验证一直失败
 * TODO 使用注释验证木有成功
 */
@Results({
        @Result(name = "success",location = "/employee/empSuccess.jsp"),
        @Result(name = "input",location = "/employee/employee.jsp")
})
@Namespace("/employee")
public class EmployeeAction extends ActionSupport {
    private String username;
    private int age;
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
    @Action(value = "emp")
    public String execute() throws Exception {
        return SUCCESS;

    }
    @RequiredFieldValidator(message = "用户名不能为空")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @IntRangeFieldValidator(min = "20",max = "50",message = "年龄必须在20-50之间")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
