/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.milestonecalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

/**
 *
 * @author Ezio Auditore
 */
public class MilestoneCalculator {
    private Student student = new Student();
    //Frame
    private JFrame calculatorFrame;
    
    private JPanel calculatorContainer;
    
    private JLabel studentNumberLabel, studentNameLabel, studentCourseLabel,
                   studentSectionLabel, studentMS1Label, studentMS2Label, studentTALabel, 
                   studentFinalGradeLabel;
    
    
            
    private JTextField studentNumberText, studentNameText, studentMS1Text, 
                       studentMS2Text, studentTAText, studentSectionText,
                       studentFinalGradeText;
    
    private JComboBox studentCourseDropdown;
    
    private JButton calculateGradesButton = new JButton("Calculate Final Grade");
    
    public void showFrame(){
        calculatorFrame = new JFrame();
        calculatorFrame.setTitle("Milestone Calculator");
        calculatorFrame.setMinimumSize(new Dimension(500, 450));
        calculatorFrame.setSize(700, 420);
        calculatorFrame.setLocationRelativeTo(null);
        calculatorFrame.add(calculatorContainer);
        calculatorFrame.setVisible(true);
        calculatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void showLabelsAndTexts(){
        String courses[] = {"Art Appreciation", "Ethics", "Computer Programming 2", "Discrete Structures", "NSTP", "PE3"};
        
        studentNumberLabel = new JLabel("Student Number:");
        studentNumberText = new JTextField(20);
        
        studentNameLabel = new JLabel("Student Name:");
        studentNameText = new JTextField(20);
        
        studentCourseLabel = new JLabel("Student Course:");
        studentCourseDropdown = new JComboBox(courses);
        studentCourseDropdown.setPreferredSize(new Dimension(225, 30));
        
        studentSectionLabel = new JLabel("Student Section:");
        studentSectionText = new JTextField(20);
        
        studentMS1Label = new JLabel("Milestone 1 Grade:");
        studentMS1Text = new JTextField(20);
        
        studentMS2Label = new JLabel("Milestone 2 Grade:");
        studentMS2Text = new JTextField(20);
        
        studentTALabel = new JLabel("Terminal Assessment Grade:");
        studentTAText = new JTextField(20);
        
        studentFinalGradeLabel = new JLabel("Final Grade");
        studentFinalGradeText = new JTextField(20);
    }
    
    public void showContainer(){
        calculatorContainer = new JPanel();
        
        calculatorContainer.add(studentNumberLabel);
        calculatorContainer.add(studentNumberText);
        calculatorContainer.add(studentNameLabel);
        calculatorContainer.add(studentNameText);
        calculatorContainer.add(studentCourseLabel);
        calculatorContainer.add(studentCourseDropdown);
        calculatorContainer.add(studentSectionLabel);
        calculatorContainer.add(studentSectionText);
        calculatorContainer.add(studentMS1Label);
        calculatorContainer.add(studentMS1Text);
        calculatorContainer.add(studentMS2Label);
        calculatorContainer.add(studentMS2Text);
        calculatorContainer.add(studentTALabel);
        calculatorContainer.add(studentTAText);
        calculatorContainer.add(studentFinalGradeLabel);
        calculatorContainer.add(studentFinalGradeText);
        calculatorContainer.add(calculateGradesButton);
        
        SpringLayout calculatorLayout = new SpringLayout();
        //STUDENT NUMBER
        calculatorLayout.putConstraint(SpringLayout.WEST, studentNumberLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentNumberLabel, 20, SpringLayout.NORTH, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentNumberText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentNumberText, 20, SpringLayout.NORTH, calculatorContainer);
        
        //STUDENT NAME
        calculatorLayout.putConstraint(SpringLayout.WEST, studentNameLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentNameLabel, 30, SpringLayout.SOUTH, studentNumberLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentNameText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentNameText, 25, SpringLayout.SOUTH, studentNumberText);
        
        //STUDENT COURSE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentCourseLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentCourseLabel, 30, SpringLayout.SOUTH, studentNameLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentCourseDropdown, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentCourseDropdown, 25, SpringLayout.SOUTH, studentNameText);
        
        //STUDENT SECTION 
        calculatorLayout.putConstraint(SpringLayout.WEST, studentSectionLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentSectionLabel, 25, SpringLayout.SOUTH, studentCourseLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentSectionText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentSectionText, 23, SpringLayout.SOUTH, studentCourseDropdown);
        
        //MS1 GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentMS1Label, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS1Label, 25, SpringLayout.SOUTH, studentSectionLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentMS1Text, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS1Text, 20, SpringLayout.SOUTH, studentSectionText);
        
        //MS2 GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentMS2Label, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS2Label, 25, SpringLayout.SOUTH, studentMS1Label);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentMS2Text, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS2Text, 22, SpringLayout.SOUTH, studentMS1Text);
        
        //TA GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentTALabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentTALabel, 25, SpringLayout.SOUTH, studentMS2Label);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentTAText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentTAText, 22, SpringLayout.SOUTH, studentMS2Text);
        
        //CALCULATE BUTTON
        calculatorLayout.putConstraint(SpringLayout.NORTH, calculateGradesButton, 25, SpringLayout.SOUTH, studentTALabel);
        calculatorLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calculateGradesButton, 0, SpringLayout.HORIZONTAL_CENTER, calculatorContainer);
        
        //FINAL GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentFinalGradeLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentFinalGradeLabel, 25, SpringLayout.SOUTH, calculateGradesButton);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentFinalGradeText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentFinalGradeText, 24, SpringLayout.SOUTH, calculateGradesButton);
        calculatorContainer.setSize(400, 400);
        calculatorContainer.setLayout(calculatorLayout); 
    }
    
    public void calculateButtonPressed(){
        studentCourseDropdown.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                student.setCourse(studentCourseDropdown.getSelectedItem().toString());
            }
        });   
        
        calculateGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentNumber = studentNumberText.getText();
                String studentName = studentNameText.getText();
                String studentSection = studentSectionText.getText();
                String studentMS1Grade = studentMS1Text.getText();
                String studentMS2Grade = studentMS2Text.getText();
                String studentTAGrade = studentTAText.getText();
                
                try {
                    student.setStudentNumber(Integer.parseInt(studentNumber));
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "ENTER A VALID NUMBER!", "", JOptionPane.WARNING_MESSAGE);
                }

                Pattern pattern = Pattern.compile("[a-zA-Z]+");
                Matcher match = pattern.matcher(studentName);
                if (match.find()){
                    student.setName(studentNameText.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID STUDENT NAME!", "", JOptionPane.WARNING_MESSAGE);
                }


                if (studentSection.length() == 5){
                    student.setSection(studentSectionText.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID SECTION !", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentMS1Grade) > 25){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM WHICH IS: "+25, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentMS1Grade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    } else {
                        student.setMS1Grade(Integer.parseInt(studentMS1Grade));
                    }
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUTTED MS1 GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentMS2Grade) > 40){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM WHICH IS: "+40, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentMS2Grade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    } else {
                        student.setMS2Grade(Integer.parseInt(studentMS2Grade));
                    } 
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUTTED MS2 GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentTAGrade) > 40){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM WHICH IS: "+35, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentTAGrade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    } else {
                        student.setTAGrade(Integer.parseInt(studentTAGrade));
                    }  
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUTTED TA GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                studentFinalGradeText.setText(String.valueOf(student.calculateFinalGrade()));
            }
        });
    }
}
