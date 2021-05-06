/* Brayden Martin
r/dailyprogrammer - Challenge #374 [Easy] - Additive Persistence
Completed without the use of strings */

public class additivePersistence {

    /**
     * Determines the additive persistence of a given integer.
     * @param number: integer input.
     * @return additive persistence of input.
     */
    private static int persistenceCalc(int number) {
        int sum = number, count = 0;

        // loop while sum of digits is more than a single digit.
        while (sum >= 10) {
            number = sum;
            sum = 0;

            // add the digits of number.
            while (number >= 10) {
                sum += number % 10;
                number /= 10;
            }
            sum += number;

            count++;
        }
        return count;
    }


    /**
     * Main used for testing the persistenceCalc function.
     * @param args: no arguments used.
     */
    public static void main(String[] args) {
        System.out.println(persistenceCalc(1234));
    }
}
