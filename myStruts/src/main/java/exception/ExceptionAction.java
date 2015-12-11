package exception;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wb-chenchaobin on 2015/12/9.
 */
public class ExceptionAction extends ActionSupport {
    private String name;
    @Override
    public String execute() throws Exception {
        name=null;
        name = name.substring(0);
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
