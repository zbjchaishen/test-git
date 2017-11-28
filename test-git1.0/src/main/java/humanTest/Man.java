package humanTest;

public class Man extends Person{

    public Man (){
        System.out.println("man子类 构造函数");
    }

    {
        System.out.println("man子类 构造代码块");
    }

    static {
        System.out.println("man子类 静态代码块");
    }
}
