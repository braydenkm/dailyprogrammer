/* Brayden Martin
r/dailyprogrammer - Challenge #381 [Easy] - Yahtzee Upper Section Scoring */

public class YahtzeeUpper {

    /**
     * Calculates the score for each possible number then returns the highest.
     * @param roll: integer array containing values from 1-6.
     * @return highestScore: The largest possible score from the amount rolled.
     */
    public static int yahtzeeCalc(int[] roll) {
        // Exit if number does not exist on die.
        for (int number : roll) {
            if (1 > number || number > 6) {
                throw new RuntimeException("Value of the dice must be between 1 and 6");
            }
        }

        // Determine the highest score for each side of die.
        int highestScore = -1;
        for (int item : roll) {
            int score = 0;
            for (int value : roll) {
                if (value == item) {
                    score += item;
                }
            }
            if (score >= highestScore) {
                highestScore = score;
            }
        }
        return highestScore;
    }


    /**
     * Main used for testing the yahtzee calculator.
     * @param args
     */
    public static void main (String[] args) {
        int[] input = {1, 1, 1, 1, 1, 2};
        int result = yahtzeeCalc(input);
        System.out.println("The largest value is " + result);
    }
}
