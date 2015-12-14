package reflect;

/**
 * Created by wb-chenchaobin on 2015/12/14.
 */
public class Boss {
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
