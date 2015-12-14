package reflect;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
@Configurable
public class Beans {
    @Bean(name = "car")
    public Car getCar(){
        Car car = new Car();
        car.setColor("black");
        return car;
    }
}
