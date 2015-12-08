package hello;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HelloAction extends ActionSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String execute(){
        /*值栈*/
        ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String,Object>context = new HashMap<String, Object>();
        context.put("key1","this is key1");
        context.put("key2","this is key2");
        stack.push(context);
        System.out.println(stack.size()+"-------------");
        return SUCCESS;
    }
}
