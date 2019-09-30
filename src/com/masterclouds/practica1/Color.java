package com.masterclouds.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Color {
    Red("r"), Blue("b"), Yellow("y"), Green("g"), Orange("o"), Purple("p");
    
    private static final String MESSAGE_ERROR = "Wrong colors, they must be: rbygop";
    
    private final String name;

    private Color(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static Color generateRandomColor() {
        Random ramdom = new Random();
        return Color.values()[ramdom.nextInt(Color.values().length)];
    }
    
    private static void assertColor(String color) throws IllegalArgumentException {
        if (color == null || color.trim().length() == 0)
            throw new IllegalArgumentException(MESSAGE_ERROR);
    }
    
    private static void assertColor(Color color) throws IllegalArgumentException {
        if (color == null)
            throw new IllegalArgumentException(MESSAGE_ERROR);
    }
    
    private static Color findColor(String color) {
        Color colorToReturn = null;        
        for (Color colorItem : Color.values()) {
            if (colorItem.getName().equals(color)) {
                colorToReturn = colorItem;
                break;
            }
        }        
        return colorToReturn;
    }
    
    public static Color get(char color) throws IllegalArgumentException {
        String sColor = String.valueOf(color);
        assertColor(sColor);
        return findColor(sColor);
    }
    
    public static List<Color> get(String colors) throws IllegalArgumentException { 
        List<Color> listColor = new ArrayList<>();
        
        for (int i = 0; i < colors.length(); i++){
            char cColor = colors.charAt(i);
            Color color = Color.get(cColor);
            assertColor(color);
            listColor.add(color);
        }
        
        return listColor;
    }
}