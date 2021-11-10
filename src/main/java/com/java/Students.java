package com.java;
class Students {

        int rollNum;
        String name;
        int age;
        int marks;

        public Students() {
            super();

        }

        public Students(int rollNum, String name, int age, int marks) {
            this.rollNum = rollNum;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        public int getRollNum(int rollNum) {
            return rollNum;
        }

        public void setRollNum(int rollNum) {
            this.rollNum = rollNum;
        }

        public String getName(String name) {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge(int age) {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getMarks(int marks) {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "\nStudents {RollNum=" + rollNum + "," +
                    " name=" + name + ", " +
                    "Mark=" + marks + ", " +
                    "age=" + age + "}";


        }
    }
