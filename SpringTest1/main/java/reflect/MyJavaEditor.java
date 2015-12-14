package reflect;

import java.beans.PropertyEditorSupport;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class MyJavaEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text==null||text.indexOf(",")==-1){
            throw new IllegalArgumentException();
        }
        String[] args = text.split(",");
        System.out.println(text);
        Car car  = new Car();
        car.setBrand(args[0]);
        car.setColor(args[1]);
        car.setSpeed(Integer.valueOf(args[2]));
        setValue(car);
    }
}
