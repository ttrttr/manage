package com.itheima.edu.info.manage.entry;

import com.itheima.edu.info.manage.controller.StudentController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while(true){
            //main menu establish
            System.out.println("--------------information management system-----------------");
            System.out.println("please enter your choice: 1.student management 2.teacher management 3.exit");
            String choice = sc.next();
            switch(choice){
                case "1":
                    //System.out.println("student manage");
                    //start student manage
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("teacher manage");
                    break;
                case "3":
                    System.out.println("thank you for using");
                    //exit running jvm virtual machine
                    System.exit(0);
                    break;
                default:
                    System.out.println("wrong print in, please enter again");
                    break;
            }
        }
    }
}
