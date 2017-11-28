import humanTest.Man;
import humanTest.Person;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("aaa");
        System.out.println("1129分支的a0提交");
        System.out.println("1129分支的a1提交");
    }

    /**
     * String + 号练习
     * @param args
     */
    public static void main3(String[] args) {
        String source="aaaaa";
        String dest=source+"";
        //true
        System.out.println(StringUtils.equals(source,dest));
        //true source==dest
        System.out.println(source.hashCode()==dest.hashCode());
        System.out.println(dest.hashCode());
    }

    /**
     * joda 使用练习
     * @param args
     */
    public static void main2(String[] args) {

        Date date=new Date();
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(date));

        DateTime dateTime=new DateTime(new Date());
        System.out.println(dateTime.toDate());
        System.out.println(dateTime.hourOfDay().setCopy(9).minuteOfHour().setCopy(15).secondOfMinute().withMinimumValue().toDate());
        DateTime dateTime1=dateTime.dayOfMonth().withMaximumValue().secondOfMinute().setCopy(8);
        System.out.println(dateTime1.toDate());
//        DateTime dateTime2=dateTime1.hourOfDay().withMaximumValue();
//        System.out.println(dateTime2.toDate());
//        System.out.println( dateTime.millisOfDay().withMinimumValue().toDate());
//        System.out.println(dateTime.dayOfMonth().setCopy(12).hourOfDay().withMaximumValue());
    }

    /**
     * 练习初始化顺序
     * @param args
     */
    public static void main1(String[] args) {
        System.out.println("main start------");
        Man man=new Man();
        Person person=new Person();
        System.out.println("main end------");
    }
}
