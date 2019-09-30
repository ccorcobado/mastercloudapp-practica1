package com.masterclouds.practica1;

import java.util.List;
import java.util.Scanner;

public class ProposedCombination extends Combination {
    private static final String MESSAGE_LENGTH_ERROR = "Wrong proposed combination length";
    
    private Result result;
    
    private void assertLengthColor(List<Color> proposedColors) throws IllegalArgumentException {
        if (proposedColors == null || proposedColors.size() != MAX_COLORS)
            throw new IllegalArgumentException(MESSAGE_LENGTH_ERROR);
    }
    
    private void assertRepeatedColor(String proposedColors) throws IllegalArgumentException {
        int index = -1; 
        for (int i = 0; i < proposedColors.length(); i++) { 
            for (int j = i + 1; j < proposedColors.length(); j++) { 
                if (proposedColors.charAt(i) == proposedColors.charAt(j)) { 
                    index = i; 
                    break; 
                } 
            } 
            if (index != -1) 
                break; 
        } 
      
        if (index != -1)
            throw new IllegalArgumentException("Repeated colors");
    }
    
    protected void populateProposedColors(String proposedColors) throws IllegalArgumentException {
        List<Color> colorsConverted = Color.get(proposedColors);
        this.assertLengthColor(colorsConverted);
        this.assertRepeatedColor(proposedColors);
        
        this.clearColors();
        for (Color color : colorsConverted)
            this.populateColor(color);
    }
    
    public void read(Scanner scanner) {
        do {
            try {
                System.out.print("Propose a combination: ");
                String colorsProposed = scanner.nextLine();
                this.populateProposedColors(colorsProposed);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!super.isAllColorsPopulated());
    }

    public boolean contains(Color color, int position) {
        return super.containColor(color, position);
    }

    public boolean contains(Color color) {
        return super.containColor(color);
    }
    
    public void setResult(Result result) {
        this.result = result;
    }

    boolean isWinner() {
        return this.result.isWinner();
    }
    
    public void write() {
        writeCurrentColors();
        System.out.print(" ");
        this.result.write();
    }
}