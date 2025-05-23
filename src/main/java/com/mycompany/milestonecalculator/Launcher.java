/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.milestonecalculator;

/**
 *
 * @author Ezio Auditore
 */
public class Launcher {
    public static void main(String[] args) {
        MilestoneCalculator Calculator = new MilestoneCalculator();
        
        Calculator.showLabelsAndTexts();
        Calculator.showContainer();
        Calculator.showFrame();
        Calculator.calculateButtonPressed();
    }
}
