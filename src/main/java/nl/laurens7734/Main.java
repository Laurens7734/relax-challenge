package nl.laurens7734;

import nl.laurens7734.games.*;

import java.util.Random;

public class Main {
    private static final int numberOfTries = 1_000_000;
    private static final double betAmount = 1.0;

    public static void main(String[] args) {
        runGame("game1");
        runGame("game2");
    }

    public static void runGame(String gameName){
        int wins = 0;
        double totalWinnings = 0.0;
        Random rng = new Random();
        for(int i = 0; i < numberOfTries; i++){
            BaseGame game = createNewGame(gameName, betAmount, rng);
            game.playGame();
            if(game.gameWon())
                wins++;
            totalWinnings += game.winnings();
        }

        double mean = calculateMean(totalWinnings,numberOfTries);
        double variance = calculateVariance(totalWinnings /wins, 0, mean, wins, numberOfTries);
        double standardDeviation = calculateStandardDeviation(variance);
        System.out.println("Results for " + gameName);
        System.out.println("Number of games played: " + numberOfTries);
        System.out.println("Number of games won: " + wins);
        System.out.println("Mean: " + mean);
        System.out.println("Variance " + variance);
        System.out.println("Standard deviation: " + standardDeviation);
    }

    public static double calculateMean(double totalWinnings, int attempts){
        return totalWinnings/attempts;
    }

    public static double calculateVariance(double winnings, double loss,double mean, int wins, int tries){
        double sum = Math.pow(winnings-mean,2)*wins+Math.pow(loss-mean,2)*(tries-wins);
        return sum/tries;
    }
    public static double calculateStandardDeviation(double variance){
        return Math.sqrt(variance);
    }

    public static BaseGame createNewGame(String gameName, double betAmount, Random rng){
        return switch (gameName) {
            case "game1" -> new Game1(betAmount, rng);
            case "game2" -> new Game2(betAmount, rng);
            default -> null;
        };
    }
}