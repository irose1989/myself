import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wb-chenchaobin on 2015/12/8.
 */
public class HelloWorldAction extends ActionSupport{
    private String name;

    public String getName() {
        System.out.println("getName:"+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute(){
        System.out.println("inside....");
        if("success".equals(name)){
            return SUCCESS;
        }
        return ERROR;
    }
}
