/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.milestonecalculator;

/**
 *
 * @author Ezio Auditore
 */
public class Student {
    //properties
    private String name;
    private String course;
    private String section;
    private int studentNumber;
    private int ms1Grade;
    private int ms2Grade;
    private int taGrade;
    
    public String getName() {
        return this.name;
    }
    
    public String getCourse() {
        return this.course;
    }
    
    public String getSection(){
        return this.section;
    }
    
    public int getStudentNumber(){
        return this.studentNumber;
    }
    
    public int getMS1Grade(){
        return this.ms1Grade;
    }
    
    public int getMS2Grade(){
        return this.ms2Grade;
    }
    
    public int getTAGrade(){
        return this.taGrade;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public void setSection(String section){
        this.section = section;
    }
    
    public void setStudentNumber (int studentNumber){
        this.studentNumber = studentNumber;
    }
    
    public void setMS1Grade (int ms1Grade){
        this.ms1Grade = ms1Grade;
    }
    
    public void setMS2Grade (int ms2Grade){
        this.ms2Grade = ms2Grade;
    }
    
    public void setTAGrade (int taGrade){
        this.taGrade = taGrade;
    }
    
    
    public int calculateFinalGrade (){
        return this.ms1Grade + this.ms2Grade + this.taGrade;
    }
    
    //checks if all is valid before doing other actions
    public boolean isValid() {
        return name != null &&
               course != null &&
               section != null &&
               studentNumber != 0 && 
               (ms1Grade >= 0 && ms1Grade <= 25) && 
               (ms2Grade >= 0 && ms2Grade <= 40) &&
               (taGrade >= 0 && taGrade <= 35);
    }
    
    //debugging
    @Override
    public String toString (){
        return ""+this.name+" has been added to the list!";
    }
}

