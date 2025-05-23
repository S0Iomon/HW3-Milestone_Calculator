/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.milestonecalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Ezio Auditore
 */
public class MilestoneCalculator {
    
    private Student student = new Student();
    
    private ArrayList<Student> Students = new ArrayList<>();
    
    private JFrame calculatorFrame;
    
    private JPanel calculatorContainer;
    
    private JLabel studentNumberLabel, studentNameLabel, studentCourseLabel,
                   studentSectionLabel, studentMS1Label, studentMS2Label, studentTALabel, 
                   studentFinalGradeLabel;
    
    
            
    private JTextField studentNumberText, studentNameText, studentMS1Text, 
                       studentMS2Text, studentTAText, studentSectionText;
    
    private JComboBox studentCourseDropdown;
    
    private JButton calculateGradesButton = new JButton("Calculate Final Grade");
    
    private Font FranklinBold = new Font("Franklin Gothic Demi", Font.PLAIN, 14);
    private Font FranklinRegular = new Font("Franklin Gothic Book", Font.PLAIN, 14);
    private Border elementBorder = BorderFactory.createLineBorder(Color.decode("#DCBDAC"), 1);
    
    private String chosenCourse;
    
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
        studentCourseDropdown.setPreferredSize(new Dimension(228, 25));
        
        studentSectionLabel = new JLabel("Student Section:");
        studentSectionText = new JTextField(20);
        
        studentMS1Label = new JLabel("Milestone 1 Grade:");
        studentMS1Text = new JTextField(20);
        
        studentMS2Label = new JLabel("Milestone 2 Grade:");
        studentMS2Text = new JTextField(20);
        
        studentTALabel = new JLabel("Terminal Assessment Grade:");
        studentTAText = new JTextField(20);
        
        calculateGradesButton.setPreferredSize(new Dimension(200, 30));
        
        studentFinalGradeLabel = new JLabel("0.00");
        
        //GUI DESIGN
        
        JComponent allLabels[] = {studentNumberLabel, studentNameLabel,
        studentCourseLabel,  studentSectionLabel,
         studentMS1Label,  studentMS2Label,  
        studentTALabel,studentFinalGradeLabel};
        
        JComponent allTexts[] = {studentNumberText, studentNameText, studentCourseDropdown,
        studentSectionText, studentMS1Text, studentMS2Text,studentTAText, calculateGradesButton,};
        
        
        for (JComponent label: allLabels){
           label.setFont(FranklinBold);
           label.setForeground(Color.decode("#502B2D"));
           label.setBackground(Color.decode("#DCBDAC"));
        }
        
        
        for (JComponent text: allTexts){
            text.setFont(FranklinRegular);
            text.setBorder(BorderFactory.createCompoundBorder(elementBorder, new EmptyBorder(2, 3, 2, 3)));
            text.setBackground(Color.decode("#502B2D"));
            text.setForeground(Color.decode("#DCBDAC"));
        }
        
        studentFinalGradeLabel.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
        
        //OPTIONPANE DESIGN
        UIManager.put("OptionPane.background", Color.decode("#DCBDAC"));
        UIManager.put("Panel.background", Color.decode("#DCBDAC"));
        UIManager.put("Button.background", Color.decode("#502B2D"));
        UIManager.put("Button.foreground", Color.decode("#DCBDAC"));
    }
    
    public void showContainer(){
        calculatorContainer = new JPanel();
        
        calculatorContainer.setBackground(Color.decode("#DCBDAC"));
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
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentNameText, 23, SpringLayout.SOUTH, studentNumberText);
        
        //STUDENT COURSE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentCourseLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentCourseLabel, 30, SpringLayout.SOUTH, studentNameLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentCourseDropdown, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentCourseDropdown, 23, SpringLayout.SOUTH, studentNameText);
        
        //STUDENT SECTION 
        calculatorLayout.putConstraint(SpringLayout.WEST, studentSectionLabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentSectionLabel, 25, SpringLayout.SOUTH, studentCourseLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentSectionText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentSectionText, 15, SpringLayout.SOUTH, studentCourseDropdown);
        
        //MS1 GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentMS1Label, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS1Label, 25, SpringLayout.SOUTH, studentSectionLabel);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentMS1Text, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS1Text, 18, SpringLayout.SOUTH, studentSectionText);
        
        //MS2 GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentMS2Label, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS2Label, 25, SpringLayout.SOUTH, studentMS1Label);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentMS2Text, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentMS2Text, 20, SpringLayout.SOUTH, studentMS1Text);
        
        //TA GRADE
        calculatorLayout.putConstraint(SpringLayout.WEST, studentTALabel, 30, SpringLayout.WEST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentTALabel, 25, SpringLayout.SOUTH, studentMS2Label);
        calculatorLayout.putConstraint(SpringLayout.EAST, studentTAText, -30, SpringLayout.EAST, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentTAText, 20, SpringLayout.SOUTH, studentMS2Text);
        
        //CALCULATE BUTTON
        calculatorLayout.putConstraint(SpringLayout.NORTH, calculateGradesButton, 25, SpringLayout.SOUTH, studentTALabel);
        calculatorLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calculateGradesButton, 0, SpringLayout.HORIZONTAL_CENTER, calculatorContainer);
        
        //FINAL GRADE
        calculatorLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentFinalGradeLabel, 0, SpringLayout.HORIZONTAL_CENTER, calculatorContainer);
        calculatorLayout.putConstraint(SpringLayout.NORTH, studentFinalGradeLabel, 20, SpringLayout.SOUTH, calculateGradesButton);
        calculatorContainer.setSize(400, 400);
        calculatorContainer.setLayout(calculatorLayout); 
    }
    
  
    
    public void calculateButtonPressed(){
        chosenCourse = studentCourseDropdown.getSelectedItem().toString();
        studentCourseDropdown.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                chosenCourse = studentCourseDropdown.getSelectedItem().toString();
            }
        });   
        
        calculateGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student = new Student();
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

                Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");
                Matcher match = pattern.matcher(studentName);
                if (match.matches()){
                    student.setName(studentNameText.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID STUDENT NAME!", "", JOptionPane.WARNING_MESSAGE);
                }

                student.setCourse(chosenCourse);

                if (studentSection.length() == 5){
                    student.setSection(studentSectionText.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "ENTER A VALID SECTION!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentMS1Grade) > 25){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM [MS1] WHICH IS: "+25, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentMS1Grade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM [MS1] WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    } 
                    student.setMS1Grade(Integer.parseInt(studentMS1Grade));
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT: MS1 GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentMS2Grade) > 40){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM [MS2] WHICH IS: "+40, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentMS2Grade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM [MS2] WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    }
                    student.setMS2Grade(Integer.parseInt(studentMS2Grade));
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT: MS2 GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                try {
                    if (Integer.parseInt(studentTAGrade) > 35){
                        JOptionPane.showMessageDialog(null, "INPUT IS HIGHER THAN MAXIMUM [TA] WHICH IS: "+35, "", JOptionPane.WARNING_MESSAGE);
                    } else if (Integer.parseInt(studentTAGrade) < 0){
                        JOptionPane.showMessageDialog(null, "INPUT IS LOWER THAN MINIMUM [TA] WHICH IS: "+0, "", JOptionPane.WARNING_MESSAGE);
                    } 
                    student.setTAGrade(Integer.parseInt(studentTAGrade));
                } catch (NumberFormatException num){
                    JOptionPane.showMessageDialog(null, "INVALID INPUT: TA GRADE!", "", JOptionPane.WARNING_MESSAGE);
                }
                
                if (student.isValid()){
                    Students.add(student);
                    studentFinalGradeLabel.setText(String.valueOf(student.calculateFinalGrade()) +".00");
                }
                System.out.println(Students.toString());
            }
        });
    }
}
