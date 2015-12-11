package windows;

import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * Created by wb-chenchaobin on 2015/12/9.
 */
public class EnvironmentConverter extends StrutsTypeConverter {
    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        Environment e = new Environment(strings[0]);
        return e;
    }

    @Override
    public String convertToString(Map map, Object o) {
        Environment e = (Environment)o;
        return e==null?null:e.getName();
    }
}
