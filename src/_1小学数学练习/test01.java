package _1小学数学练习;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class test01 {
    static Scanner sc = new Scanner(System.in);
    static Random ra = new Random();
    static int score;   //分数
    static long time;   //时间
    static String [] transcript = new String [100]; //成绩单
    static int index = 0; //第index 次成绩
    static int book;

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        System.out.println("请输入用户名ID: ");
        String str = sc.next();
        //判断用户名ID是否正确，错误重新输入直到用户名输入正确为止
        while(!judge(str)){
            System.out.println("请重新输入用户名ID: ");
            str = sc.next();
        }
        System.out.println("用户名输入正确!");
        try{
            File file = new File("C:\\Users\\1\\Desktop\\程序设计课程设计R19\\src\\_1小学数学练习\\record.txt");
            if(!file.isFile())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter(file,true);          //通过 true 可设置追加
            fileWriter.write("你以前的记录是:\n");
            // fileWriter.flush();   //清空缓冲区，压入文件
            fileWriter.close();
            boolean flag = true;
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 1;i < 5; i++){
                list.add(i);
            }
            while(flag) {
                System.out.println("**********欢迎来到小学生数学练习系统**********\n");
                System.out.println("**********(1)开始测试**********\n");
                System.out.println("**********(2)检查分数**********\n");
                System.out.println("**********(3)退出系统**********\n");
                System.out.println("请选择:");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        score = 0;
                        Collections.shuffle(list);
                        book = list.get(3);
                        long start = System.currentTimeMillis(); //开始时间
                        for (int j = 0; j < 10; j++) {
                            if (j < 4) {
                                calculate(list.get(j));
                            }
                            else {
                                calculate();
                            }
                        }
                        long end = System.currentTimeMillis(); //结束时间
                        time = (end - start) / 1000;
                        fileWriter = new FileWriter(file, true);
                        fileWriter.write(str + " " + score + " " + time + " 秒\n");
                        //fileWriter.flush();
                        fileWriter.close();

                        System.out.println("\n问题     | 正确答案  | 你的答案 ");
                        for (int i = 0; i < 10; i++) {
                            System.out.println(transcript[i]);
                        }
                        System.out.println();
                        index = 0;
                        break;
                    }
                    case 2:{
                        FileReader fileReader = new FileReader(file);
                        BufferedReader in = new BufferedReader(fileReader);
                        String s;
                        while ((s = in.readLine()) != null)
                            System.out.println(s);
                        System.out.println();
                        fileReader.close();
                        break;
                    }
                    case 3:
                        System.out.println("退出成功!");
                        flag = false;
                        file.delete();
                        break;
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        sc.close();
    }
    public static boolean judge(String str) {
        if(str.length()!= 6){
            System.out.println("用户名ID输入错误,用户名ID是由六位大写字母和数字组成。");
            return false;
        }
        for(int i = 0;i < 2;i++){
            if(!Character.isUpperCase(str.charAt(i))){
                System.out.println("用户名ID输入错误,用户名ID前两位应该是大写字母哦!!!");
                return false;
            }
        }
        for(int i = 2;i < 6;i++){
            if(!Character.isDigit(str.charAt(i))){
                System.out.println("用户名ID输入错误,用户名ID后四位应该是数字哦!!!");
                return false;
            }
        }
        return true;
    }

//    public static  boolean judge(String str){
//        String regex = "[A-Z][A-Z]\\d\\d\\d\\d";
//        Pattern r = Pattern.compile(regex);
//        Matcher m = r.matcher(str);
//        return m.matches();
//    }
    //随机运算
    public static void calculate(){
        //int n = ra.nextInt(4)+1;//四种运算法,随机产生
        int n = (int)(Math.random()*8)%4+1;
        while(book == n)                   //相邻运算不能相同
            n = ra.nextInt(4)+1;
        book = n;
        switch (n){
            case 1:add();break;
            case 2:subtract();break;
            case 3:multiplication();break;
            case 4:division();break;
            default:
                System.out.println("error!!!");
        }
    }

    public static void calculate(int n){
        switch (n){
            case 1:add();break;
            case 2:subtract();break;
            case 3:multiplication();break;
            case 4:division();break;
            default:
                System.out.println("error!!!");
        }
    }

    //加法运算
    public static void add(){
        int num1 = ra.nextInt(99)+1;
        int num2 = ra.nextInt(100-num1-1)+1;  //保证两数相加运算结果小于100
        System.out.println(num1 + "+" + num2 + "=");
        int result = sc.nextInt();

        transcript[index++]= String.format("%-2d + %-2d = | %-2d | %-2d",num1,num2,num1+num2,result);  //字符串格式化
        if(result == num1+num2)
            score += 10;

    }

    //减法运算
    public static void subtract(){
        int num1 = ra.nextInt(99)+1;
        int num2 = ra.nextInt(99)+1;
        while(num1 == num2) //保证两数不相等
            num2 = ra.nextInt(99)+1;
        if(num1 < num2){        //避免出现负数
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        System.out.println(num1 + "-" + num2 + "=");
        int result = sc.nextInt();

        transcript[index++]= String.format("%-2d - %-2d = | %-2d | %-2d",num1,num2,num1-num2,result);  //字符串格式化
        if(result == num1-num2)
            score += 10;

    }

    //乘法运算
    public static void multiplication(){
        int num1=100,num2=100;
        while (num1*num2>=100){
            num1 = ra.nextInt(99)+1;
            num2 = ra.nextInt(99)+1;
        }

        System.out.println(num1 + "*" + num2 + "=");
        int result = sc.nextInt();
        transcript[index++]= String.format("%-2d * %-2d = | %-2d | %-2d",num1,num2,num1*num2,result);  //字符串格式化
        if(result == num1*num2)
            score += 10;
    }

    //除法运算
    public static void division() {
        int num1 = ra.nextInt(99)+1;
        int num2;
        if(num1>50)
            num2 = num1;
        else
            num2 = (ra.nextInt(100/num1-1)+1)*num1;  //num2必须是num1的整数倍
        System.out.println(num2 + "/" + num1 + "=");
        int result = sc.nextInt();
        transcript[index++]= String.format("%-2d / %-2d = | %-2d | %-2d",num2,num1,num2/num1,result);  //字符串格式化
        if(result == num2/num1)
            score += 10;
    }
}
