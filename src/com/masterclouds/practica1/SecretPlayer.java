package com.masterclouds.practica1;

public class SecretPlayer {
    private final ProposedPlayer proposedPlayer;
    private SecretCombination secretCombination;
    
    public SecretPlayer(ProposedPlayer proposedPlayer) {
        if (proposedPlayer == null)
            throw new IllegalArgumentException("Invalid proposedPlayer");
       
        this.proposedPlayer = proposedPlayer;
    }

    public void prepare() {
        this.secretCombination = new SecretCombination();
    }

    public void write() {
        this.secretCombination.write();
    }

    public void answer() {
        ProposedCombination proposedCombination = this.proposedPlayer.getLastProposedCombination();
        this.secretCombination.calculateResult(proposedCombination);
    }
}