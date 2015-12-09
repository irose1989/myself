import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by wb-chenchaobin on 2015/12/8.
 */
public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("pre....");
        String result =  actionInvocation.invoke();
        System.out.println("post....");
        System.out.println("result:"+result);
        return result;
    }
}
