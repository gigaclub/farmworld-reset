package gigaclub.farmworldreset.helper;

public class Helper {
    public static boolean isInteger(String eingabe) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(eingabe);
            isValidInteger = true;
        } catch (NumberFormatException e) {

        }
        return isValidInteger;
    }

    public static boolean isDouble(String eingabe) {
        boolean isValidInteger = false;
        try {
            Double.parseDouble(eingabe);
            isValidInteger = true;
        } catch (NumberFormatException e) {

        }
        return isValidInteger;
    }
}
