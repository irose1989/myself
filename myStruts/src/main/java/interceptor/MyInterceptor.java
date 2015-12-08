package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Administrator on 2015/12/8.
 */
public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("pre intercept.....");
        String result = actionInvocation.invoke();
        System.out.println("post intercept....");
        return result;
    }
}
