package system;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wb-chenchaobin on 2015/12/8.
 */
public class SystemDetailAction extends ActionSupport {
    private Environment environment = new Environment("develop");
    private String operatingSystem ="Win7 basic";

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
