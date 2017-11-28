package humanTest;

public class Person {

    private String name;

    private Long age;

    public Person(){

        System.out.println("父类构造函数");
    }

    static {
        System.out.println("父类静态函数执行");
    }

    {
        System.out.println("父类构造代码块执行" );
    }

    public Person(String name ,Long age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
