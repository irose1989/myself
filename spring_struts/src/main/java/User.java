import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wb-chenchaobin on 2015/12/9.
 */
public class User extends ActionSupport{
    private String firstName;
    private String lastName;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
