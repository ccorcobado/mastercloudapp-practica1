package com.masterclouds.practica1;

import java.util.Scanner;

public class MasterMind {
    private final ProposedPlayer proposedPlayer;
    private final SecretPlayer secretPlayer;

    public MasterMind() {
        this.proposedPlayer = new ProposedPlayer();
        this.secretPlayer = new SecretPlayer(proposedPlayer);
    }

    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("----- MASTERMIND -----");
                this.secretPlayer.prepare();
                this.secretPlayer.write();
                
                do {
                    this.proposedPlayer.propose(scanner);
                    this.proposedPlayer.writeAttempts();
                    this.secretPlayer.write();
                    this.secretPlayer.answer();
                    this.proposedPlayer.writeProposedCombinations();
                } while (!this.proposedPlayer.isWinner() && !this.proposedPlayer.isLooser());
                
                this.proposedPlayer.writeResult();
            } while (this.proposedPlayer.continuePlaying(scanner));
        }
    }
}