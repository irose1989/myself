package reflect;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class PrivateCar {
    private String color;
    private void show(){
        System.out.println("car:" +color);
    }

    @Override
    public String toString() {
        return "PrivateCar{" +
                "color='" + color + '\'' +
                '}';
    }
}
