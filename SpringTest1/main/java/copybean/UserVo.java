package copybean;

import java.util.Date;

/**
 * Created by wb-chenchaobin on 2015/12/18.
 */
public class UserVo {
    private Integer id;
    private Long age;
    private String name;
    private Date birthday;
    private  GirlFriend gf;

    public GirlFriend getGf() {
        return gf;
    }

    public void setGf(GirlFriend gf) {
        this.gf = gf;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gf=" + gf +
                '}';
    }
}
