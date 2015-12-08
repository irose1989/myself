package hello;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HelloAction2 extends ActionSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String execute(){
        return SUCCESS;
    }
}
