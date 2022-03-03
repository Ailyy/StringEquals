package com.yechao.string;

import java.util.Random;
import java.util.Scanner;

public class StringEqualsDemo3 {
    public static void main(String[] args) {
        String okCode = "";

        // 设置正确的账号和密码
        String okName = "cdwdb";
        String okPassword = "990417";

        while (true) {

            // 用户输入账号和密码
            Scanner in = new Scanner(System.in);
            System.out.println("请输入您的账号：");
            String name = in.next();
            System.out.println("请输入您的密码：");
            String password = in.next();

            // 随机生成一个5位数的验证码，（由数字、大写字母、小写字母组成）
            for (int i=0; i < 5; i++) {
                Random r = new Random();
                // 随机生成数字（0，1，2）：
                int type = r.nextInt(3);// 0代表数字，1代表大写字母，2代表小写字母
                switch (type){
                    case 0:
                        okCode += r.nextInt(9);
                        break;
                    case 1:
                        okCode += (char)(r.nextInt(25) + 97);
                        break;
                    case 2:
                        okCode += (char)(r.nextInt(25) + 65);
                        break;
                }
            }

            // 让用户输入验证码
            System.out.println("请输入正确的验证码\t" + okCode);
            String codes = in.next();
            // 判断验证码是否正确
            if (okCode.equalsIgnoreCase(codes)){
                // 判断用户名和密码是否正确
                if (okName.equals(name) && okPassword.equals(password)){
                    System.out.println("登录成功！");
                    break;
                }else {
                    System.out.println("账号或密码错误！");
                    okCode = "";// 随机生成的验证码清楚，重新生成一组验证码
                }

            }else{
                System.out.println("验证码错误！");
                okCode = "";// 随机生成的验证码清楚，重新生成一组验证码
            }
        }
    }
}
