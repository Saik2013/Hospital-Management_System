package com.acciojob.basicapilearning;

public class Patient {
    //instance variables
    private int patientId;
    private String name;
    private int age;
    private String disease;

    //getter


    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId){
        this.patientId = patientId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
//constructor
    public Patient(int patientId,String name,int age,String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", disease='" + disease + '\'' +
                '}';
    }
}