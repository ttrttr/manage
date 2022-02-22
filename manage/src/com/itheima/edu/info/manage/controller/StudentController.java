package com.itheima.edu.info.manage.controller;

import com.itheima.edu.info.manage.domain.Student;
import com.itheima.edu.info.manage.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc=new Scanner(System.in);
    //start student manage system and show manage menu
    public void start() {
        //Scanner sc=new Scanner(System.in);
        studentLoop:
        while(true){
            System.out.println("--------------welcome student management system-----------------");
            System.out.println("please enter your choice: 1.add student 2.delete teacher 3.modify student 4.search student 5.exit");
            String choice = sc.next();
            switch(choice){
                case "1":
                    //System.out.println("add");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("delete");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("modify");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("search");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("thank you for using student manage system");
                    break studentLoop;
                default:
                    System.out.println("wrong print in, please enter again");
                    break;
            }
        }
    }

    public void updateStudent() {
        String updateId;
        while(true){
            System.out.println("Please enter the studentID,you want to modify");
            updateId = sc.next();
            boolean exists = studentService.isExists(updateId);
            if(!exists){
                System.out.println("id is not exist");
            }else{
                break;
            }
        }
        System.out.println("please enter name");
        String name=sc.next();
        System.out.println("please enter age");
        String age=sc.next();
        System.out.println("please enter birthday");
        String birthday=sc.next();

        Student newStu=new Student();
        newStu.setId(updateId);
        newStu.setName(name);
        newStu.setAge(age);
        newStu.setBirthday(birthday);

        studentService.updateStudent(updateId,newStu);
        System.out.println("modify success");
    }

    public void deleteStudentById() {
        String delId;
        while(true){
            System.out.println("Please enter the studentID,you want to delete");
            delId = sc.next();
            boolean exists = studentService.isExists(delId);
            if(!exists){
                System.out.println("id is not exist");
            }else{
                break;
            }
        }
        studentService.deleteStudentById(delId);
        System.out.println("delete success");
    }

    public void findAllStudent() {
        Student[] stus = studentService.findAllStudent();
        if(stus==null){
            System.out.println("no information");
            return;
        }
        System.out.println("number\t\tname\tage\tbirthday");
        for (int i = 0; i <stus.length ; i++) {
            Student stu=stus[i];
            if(stu!=null){
                System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t\t"+stu.getBirthday());
            }
        }
    }

    public void addStudent() {
        //StudentService studentService = new StudentService();
        //键盘接收学生信息
        //Scanner sc=new Scanner(System.in);
        String id;
        while(true){
            System.out.println("请输入学生id");
            id =sc.next();
            boolean flag = studentService.isExists(id);
            if(flag){
                System.out.println("学号已被占用，请重新输入");
            }else{
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name =sc.next();
        System.out.println("请输入学生年龄");
        String age=sc.next();
        System.out.println("请输入学生生日");
        String birthday =sc.next();
        //将学生信息封装为学生对象
        Student stu =new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        //将学生对象，传递给StudentService（业务员）中的addStudent方法
        //StudentService studentService = new StudentService();
        boolean result = studentService.addStudent(stu);
        //根据返回的Boolean类型结果，在控制台打印成功、失败
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
