/* Brayden Martin
r/dailyprogrammer - Challenge #362 [Intermediate] - "Route" Transposition Cipher */

public class transpositionCipher {

    /**
     * Strips non-word characters from message and adds Xs to meet the required length.
     * @param message: String to be encrypted.
     * @param columns: number of columns.
     * @param rows: number of rows.
     * @return formatted message in form of a grid.
     */
    private static char[][] format(String message, int columns, int rows) {
        // remove any non-word characters.
        message = message.replaceAll("\\W", "").toUpperCase();

        // add Xs until every space in grid is full.
        int area = columns * rows;
        if (area < message.length()) throw new RuntimeException();
        else if (area > message.length()) {
            int xToAdd = area - message.length();
            message = message + "X".repeat(xToAdd);
        }

        // fills a 2D char array with message from left to right, top to bottom.
        char[][] grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = message.charAt(i * columns + j);
            }
        }

        return grid;
    }


    /**
     * Performs route transposition cipher to the input message.
     * @param message: String to be encrypted.
     * @param columns: number of columns.
     * @param rows: number of rows.
     * @param direction: direction of rotation.
     * @return encrypted String.
     */
    private static String cipher(String message, int columns, int rows, String direction) {
        // strip non-word characters and form into a grid.
        char[][] messageGrid = format(message, columns, rows);

        StringBuilder ciphered = new StringBuilder();
        int colMin = 0, rowMin = 0, colMax = columns, rowMax = rows;

        // spiral clockwise from top right of grid to centre. place values into
        // ciphered message.
        if (direction.equals("clockwise")) {
            while (ciphered.length() < columns * rows) {

                // right wall, going down.
                for (int i = rowMin; i < rowMax; i++) {
                    ciphered.append(messageGrid[i][colMax - 1]);
                }
                colMax--;
                if (colMax == colMin) break;

                // bottom wall, going left.
                for (int i = colMax - 1; i >= colMin; i--) {
                    ciphered.append(messageGrid[rowMax - 1][i]);
                }
                rowMax--;
                if (rowMax == rowMin) break;

                // left wall, going up.
                for (int i = rowMax - 1; i >= rowMin; i--) {
                    ciphered.append(messageGrid[i][colMin]);
                }
                colMin++;
                if (colMax == colMin) break;

                // top wall, going right.
                for (int i = colMin; i < colMax; i++) {
                    ciphered.append(messageGrid[rowMin][i]);
                }
                rowMin++;
                if (rowMax == rowMin) break;
            }
        }

        // spiral counter-clockwise from top right of grid to centre. place values into
        // ciphered message.
        else if (direction.equals("counter-clockwise")) {
            while (ciphered.length() < columns * rows) {

                // top wall, going right.
                for (int i = colMax - 1; i >= colMin; i--) {
                    ciphered.append(messageGrid[rowMin][i]);
                }
                rowMin++;
                if (rowMax == rowMin) break;

                // left wall, going down.
                for (int i = rowMin; i < rowMax; i++) {
                    ciphered.append(messageGrid[i][colMin]);
                }
                colMin++;
                if (colMax == colMin) break;

                // bottom wall, going right.
                for (int i = colMin; i < colMax; i++) {
                    ciphered.append(messageGrid[rowMax - 1][i]);
                }
                rowMax--;
                if (rowMax == rowMin) break;

                // right wall, going up.
                for (int i = rowMax - 1; i >= rowMin; i--) {
                    ciphered.append(messageGrid[i][colMax - 1]);
                }
                colMax--;
                if (colMax == colMin) break;
            }
        } else throw new RuntimeException(direction + " is not a valid direction");

        return ciphered.toString();
    }


    /**
     * Main used for testing the cipher function.
     * @param args: not used.
     */
    public static void main(String[] args) {
        System.out.println("Ciphered / Expected");
        System.out.println(cipher("WE ARE DISCOVERED. FLEE AT ONCE" ,9, 3, "clockwise"));
        System.out.println("CEXXECNOTAEOWEAREDISLFDEREV\n");

        System.out.println("Ciphered / Expected");
        System.out.println(cipher("why is this professor so boring omg", 6, 5, "counter-clockwise"));
        System.out.println("TSIYHWHFSNGOMGXIRORPSIEOBOROSS\n");

        System.out.println("Ciphered / Expected");
        System.out.println(cipher("Solving challenges on r/dailyprogrammer is so much fun!!", 8, 6, "counter-clockwise"));
        System.out.println("CGNIVLOSHSYMUCHFUNXXMMLEGNELLAOPERISSOAIADRNROGR\n");
    }
}
