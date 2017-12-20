import com.google.common.collect.Maps;
import com.google.gson.Gson;
import humanTest.Man;
import humanTest.Person;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        FileUtils.readLines(,)
    }

    /**
     * 打印文件夹下文件
     * @param args
     */
    public static void main8(String[] args) {
        File file=new File("/home/zbj/gitHubSouce/test-git/test-git1.0/src/main/java");
        Map map=Maps.newHashMap();
        searchFile(map,file);
        System.out.println(new Gson().toJson(map));
    }

    private static void searchFile(Map map,File file){

        if(!file.isDirectory()){
            map.put(file.getName(),file.getAbsolutePath());
            System.out.println(file.getName()+"----"+file.getAbsolutePath());
        }else {
            String [] subFile=file.list();
            for(String s:subFile){
                File file1=new File(file.getPath()+"/"+s);
                searchFile(map,file1);
            }
        }
    }

    /**
     * 文件流学习
     * @param args
     */
    public static void main7(String[] args) throws IOException{

        // 节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");
        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                fileOutputStream);

        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeChars("2133\n");
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();

        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
       FileReader fileReader=new FileReader("A.txt");
       System.out.println(fileReader.read());
       fileReader.close();
    }


    /**
     * 测试ThreadLocal
     */
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
        private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
            public Integer initialValue() {
                return 0;
            }
        };

        // ②获取下一个序列值
        public int getNextNum() {
            seqNum.set(seqNum.get() + 1);
            return seqNum.get();
        }

        public static void main6(String[] args) {
            Main sn = new Main();
            // ③ 3个线程共享sn，各自产生序列号
            TestClient t1 = new TestClient(sn);
            TestClient t2 = new TestClient(sn);
            TestClient t3 = new TestClient(sn);
            t1.start();
            t2.start();
            t3.start();
        }

        private static class TestClient extends Thread {
            private Main sn;

            public TestClient(Main sn) {
                this.sn = sn;
            }

            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{
                        sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }

                    // ④每个线程打出3个序列值
                    System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                            + sn.getNextNum() + "]");
                }
            }
        }



    /**
     * java.sql.Date 只包含日期
     * @param args
     */
    public static void main5(String[] args) {
        //3917-12-30
        System.out.println(new java.sql.Date(2017,11,30));
    }

    /**
     *
     * @param args
     */
    public static void main4(String[] args) {
        System.out.println("1128第一提交");
        System.out.println("aaa");
        System.out.println("1129分支的a0提交");
        System.out.println("1129分支的a1提交");
        System.out.println("1129分支的a2提交");
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
