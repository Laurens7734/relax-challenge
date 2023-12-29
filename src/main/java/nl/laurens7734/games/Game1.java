package nl.laurens7734.games;

import java.util.Random;

public class Game1 extends BaseGame{
    private int turnsLeft;
    private boolean result;
    public Game1(double bet, Random rng) {
        super(1, bet, rng);
        turnsLeft = 4;
        result = false;
    }

    @Override
    public boolean gameWon() {
        return result;
    }

    @Override
    public void playGame() {
        while (turnsLeft>0){
            int diceRoll = rng.nextInt(6);
            if(diceRoll == 5){
                result = true;
                turnsLeft = 0;
                break;
            }
            turnsLeft--;
        }
    }
}
