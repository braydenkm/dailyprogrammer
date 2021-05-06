/* Brayden Martin
r/dailyprogrammer - Challenge #369 [Easy] - Hex Colours */

public class hexColour {

    /**
     * Converts RGB colour values into hex colour value.
     * @param red: int between 0-255 representing red tone.
     * @param green: int between 0-255 representing green tone.
     * @param blue: int between 0-255 representing blue tone.
     * @return string of hex colour value.
     */
    private static String RGBtoHex(int red, int green, int blue) {
        String redHex = "", greenHex = "", blueHex = "";

        // If values are less than 16, require to be padded with zero.
        if (red < 16) redHex = "0";
        if (green < 16) greenHex = "0";
        if (blue < 16) blueHex = "0";

        // Hex values calculated.
        redHex += Integer.toHexString(red);
        greenHex += Integer.toHexString(green);
        blueHex += Integer.toHexString(blue);

        return "#" + (redHex + greenHex + blueHex).toUpperCase();
    }


    /**
     * Main used for testing RGBtoHex function.
     * @param args: not used.
     */
    public static void main(String[] args) {
        System.out.println(RGBtoHex(15, 16, 255));
    }
}
