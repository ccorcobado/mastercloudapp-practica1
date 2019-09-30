package com.masterclouds.practica1;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination {    
    protected static final int MAX_COLORS = 4;
    
    private final List<Color> colors = new ArrayList<>(MAX_COLORS);    
    
    protected List<Color> getColors() {
        return this.colors;
    }
    
    protected void addColor(Color color) {
        this.colors.add(color);
    }
    
    protected boolean containColor(Color color) {
        return this.colors.contains(color);
    }
    
    protected boolean containColor(Color color, int position) {
        return this.colors.get(position) != null && this.colors.get(position) == color;
    }
    
    protected boolean isAllColorsPopulated() {
        return this.colors.size() == MAX_COLORS;
    }
    
    protected void clearColors() {
        this.colors.clear();
    }
    
    protected void populateColor(Color color) {
        if (!this.containColor(color)) {
            this.addColor(color);
        }
    }
    
    protected void writeCurrentColors() {
        for (Color color : this.getColors())
            System.out.print(color.getName());
    }
}