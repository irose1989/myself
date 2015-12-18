package copybean;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class GirlFriend {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
