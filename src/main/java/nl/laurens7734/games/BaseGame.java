package nl.laurens7734.games;

import java.util.Random;

public abstract class BaseGame {
    private final int payout;
    private final double bet;
    protected final Random rng;

    public BaseGame(int payout, double bet, Random rng) {
        this.payout = payout;
        this.bet = bet;
        this.rng = rng;
    }
    public abstract boolean gameWon();
    public abstract void playGame();
    public double winnings(){
        if(gameWon())
            return bet*payout;
        return 0.0;
    }
}
