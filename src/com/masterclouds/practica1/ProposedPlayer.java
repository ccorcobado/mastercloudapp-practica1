package com.masterclouds.practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProposedPlayer {
    private static final int MAX_ATTEMPTS = 10;

    private final List<ProposedCombination> attempts;
    
    public ProposedPlayer() {
        this.attempts = new ArrayList<>();
    }
    
    public ProposedCombination getLastProposedCombination() {
        return this.attempts.get(this.attempts.size() - 1);
    }

    public void propose(Scanner scanner) {
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read(scanner);
        this.attempts.add(proposedCombination);
    }

    public void writeAttempts() {
        System.out.println(this.attempts.size() + " attempt(s):");
    }

    public void writeProposedCombinations() {
        for (ProposedCombination attempt : this.attempts)
            attempt.write();
    }
    
    public void writeResult() {
        if(this.isWinner())
            System.out.println("You win!!");
        else if(this.isLooser())
            System.out.println("You lost!!");
    }

    public boolean isWinner() {
        return this.getLastProposedCombination().isWinner();
    }

    public boolean isLooser() {
        return this.attempts.size() >= MAX_ATTEMPTS;
    }

    public boolean continuePlaying(Scanner scanner) {
        this.attempts.clear();
        System.out.print("Do you want to continue? (s/n): ");
        String option = scanner.nextLine();
        return "s".equalsIgnoreCase(option);
    }
}