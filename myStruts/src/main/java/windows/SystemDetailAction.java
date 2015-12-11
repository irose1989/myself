package windows;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wb-chenchaobin on 2015/12/9.
 * TODO property≈‰÷√Œƒº˛ ß–ß
 */
public class SystemDetailAction extends ActionSupport{
    private Environment environment=new Environment("Development");
    private String operatorSystem = "win7";

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getOperatorSystem() {
        return operatorSystem;
    }

    public void setOperatorSystem(String operatorSystem) {
        this.operatorSystem = operatorSystem;
    }
}
