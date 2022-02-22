package com.itheima.edu.info.manage.service;

import com.itheima.edu.info.manage.dao.StudentDao;
import com.itheima.edu.info.manage.domain.Student;

public class StudentService {
    private StudentDao studentDao=new StudentDao();
    public boolean addStudent(Student stu) {
         //创建studentdao
        //StudentDao studentDao = new StudentDao();
        //将学生对象，传递给studentDao库管中的addStudent方法
        //将返回的Boolean类型结果，返还给studentController
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
        Student[] stus=studentDao.findAllStudent();

        boolean exists = false;
        //遍历数组,获取每一个学生对象，准备进行判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student !=null && student.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        Student[] allStudent = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i <allStudent.length ; i++) {
            Student stu =allStudent[i];
            if(stu!=null){
                flag=true;
                break;
            }
        }

        if(flag){
            return allStudent;
        }else{
            return null;
        }
    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Student newStu) {
        studentDao.updateStudent(updateId,newStu);
    }
}
