package com.example.andre.costumlist;

import java.util.ArrayList;

/**
 * Created by xiiip on 10/21/2016.
 */
public class SStudent {
        private static ArrayList<Student> studentList = new ArrayList<>();
        private static SStudent instance = new SStudent();

        public static ArrayList<Student> getStudentList() {
            return studentList;
        }

        public static void setStudentList(ArrayList<Student> studentList) {
            //unused method to apply accumulation in list
            SStudent.studentList = studentList;
        }

        public static SStudent getInstance() {
            return instance;
        }

        public static void setInstance(SStudent instance) {
            SStudent.instance = instance;
        }

        public void addStudent(Student student){
            studentList.add(student);
        }

        public Student get(int index){
            Student student = studentList.get(index);
            return student;
        }

        public void set(int index, Student student){
            studentList.set(index, student);
        }

        public Student remove(int index){
            Student student = studentList.remove(index);
            reset(index);
            return student;
        }

        public void AddStudents(ArrayList<Student> students){
            studentList.addAll(students);
        }

        public ArrayList<Student> getList(){
            return studentList;
        }

        public int count(){
            return studentList.size();
        }

        public void clearList(){
            studentList.clear();
        }

        private void reset(int i){
            for (int j = i; j < studentList.size(); j++) {
            studentList.get(j).setId(j);
            }
        }

    }