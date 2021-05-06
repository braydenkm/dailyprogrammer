/* Brayden Martin
r/dailyprogrammer - Challenge #353 [Intermediate] - Pancake Sorting Problem */

import java.util.ArrayList;
import java.util.Scanner;

public class pancakeSorting {

    // keeps track of the number of flips used.
    private static int flipCount = 0;

    // keeps track of all the flip states that occur.
    private static StringBuilder flipHistory = new StringBuilder();


    /**
     * Updates the flipHistory variable that keeps track of steps to reach
     * the end result.
     * @param cakes: ArrayList of cake sizes.
     */
    private static void updateHistory(ArrayList<Integer> cakes) {
        StringBuilder tempCake = new StringBuilder();
        for (Integer cake : cakes) {
            tempCake.append(cake).append(" ");
        }
        flipHistory.append(tempCake).append("\n");
    }


    /**
     * flips the array from index 0 to index 'end'.
     * @param cakes: ArrayList of cake sizes.
     * @param end: last index to be included in the flip.
     */
    private static void flip(ArrayList<Integer> cakes, int end) {
        for (int i = 0; i < (end + 1) / 2; i++) {
            int temp = cakes.get(i);
            cakes.set(i, cakes.get(end - i));
            cakes.set(end - i, temp);
        }
    }


    /**
     * Sorts the pancakes by flipping stacks of pancakes.
     * @param cakes: ArrayList containing the sizes of the pancakes.
     * @return sorted ArrayList of pancakes by size.
     */
    private static ArrayList<Integer> cakeSort(ArrayList<Integer> cakes, int numCakes, int count) {
        if (count == numCakes) return cakes;
        int largestIndex = -1, largestCake = -1;

        // find the index of largest pancake.
        for (int i = 0; i < numCakes - count; i++) {
            if (cakes.get(i) > largestCake) {
                largestCake = cakes.get(i);
                largestIndex = i;
            }
        }

        // if largest pancake on bottom, don't flip.
        if (largestIndex != numCakes - count - 1) {
            // largest pancake gets flipped onto the top.
            flip(cakes, largestIndex);
            flipCount++;
            updateHistory(cakes);

            // largest (top) pancake gets flipped to bottom / larger pancake.
            flip(cakes, numCakes - count - 1);
            flipCount++;
            updateHistory(cakes);
        }

        // recursive call with count increased to ignore last element.
        cakes = cakeSort(cakes, numCakes, ++count);

        return cakes;
    }


    /**
     * Main for gathering user input to use in cakeSort function.
     * @param args: not used.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // pancake amount input.
        System.out.print("Enter number of pancakes: ");
        int numCakes = input.nextInt();
        input.nextLine();

        // pancake size input.
        System.out.print("Enter sizes of pancakes: ");
        ArrayList<Integer> cakeSizes = new ArrayList<>(numCakes);
        for (int i = 0; i < numCakes; i++) {
            cakeSizes.add(input.nextInt());
        }

        // add initial order of sizes to history.
        updateHistory(cakeSizes);

        // sort pancake sizes.
        cakeSort(cakeSizes, numCakes, 0);

        // print sorted pancakes.
        System.out.print(flipCount + " flips:\n" + flipHistory);
    }
}
