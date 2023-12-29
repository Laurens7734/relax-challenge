package nl.laurens7734.games;

import java.util.Random;

public class Game2 extends BaseGame{
    private int turnsLeft;
    private boolean result;
    public Game2(double bet, Random rng) {
        super(1, bet, rng);
        turnsLeft = 24;
        result = false;
    }

    @Override
    public boolean gameWon() {
        return result;
    }

    @Override
    public void playGame() {
        while (turnsLeft>0){
            int diceRoll = rng.nextInt(36);
            if(diceRoll == 35){
                result = true;
                turnsLeft = 0;
                break;
            }
            turnsLeft--;
        }
    }
}
