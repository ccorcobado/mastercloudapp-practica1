package com.masterclouds.practica1;

public class SecretCombination extends Combination {
    public SecretCombination() {
        this.populateRandomColors();
    }
    
    private void populateRandomColors() {
        do {
            Color color = Color.generateRandomColor();
            this.populateColor(color);
        } while (!this.isAllColorsPopulated());
    }
    
    public void write() {
        String colors = "";
        for (Color color : super.getColors()) {
            colors += "*";
        }
        System.out.println(colors);
    }

    public void calculateResult(ProposedCombination proposedCombination) {
        int damaged = 0;
        int deads = 0;

        for (int i = 0; i < super.getColors().size(); i++) {
            Color color = super.getColors().get(i);
            if (proposedCombination.contains(color, i))
                deads++;
            else if (proposedCombination.containColor(color))
                damaged++;
        }
        
        proposedCombination.setResult(new Result(deads, damaged));
    }
}
