package com.masterclouds.practica1;

public class Result {
    private static final int DEADS_WINS = 4;

    private int deads = 0;
    private int damaged = 0;

    public Result(int deads, int damaged) {
        this.deads = deads;
        this.damaged = damaged;
    }

    public void write() {
        System.out.println(String.format("%d blacks and %d whites", this.deads, this.damaged));
    }

    public boolean isWinner() {
        return damaged == 0 && deads == DEADS_WINS;
    }
}
