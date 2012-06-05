/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gild.puzzles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class RotateCoder {

    private static final int CHARCODE_LOWER_A = 97;
    private static final int CHARCODE_LOWER_Z = 122;
    private static final int CHARCODE_UPPER_A = 65;
    private static final int CHARCODE_UPPER_Z = 90;

    private final int normalizedRotation;

    public RotateCoder(final String config) {
        final int rotation = Integer.parseInt(config);
        normalizedRotation = normalizeRotation(rotation);
    }

    private int normalizeRotation(final int rotation) {
        int abcd = rotation;
        if (abcd < 0) {
            abcd = (26 - ((0 - abcd) % 26));
        }
        final int normalizedRotation =26 - abcd % 26; // for encrypting
        return normalizedRotation;
    }

    public char encrypt(char ch) {
        if (ch >= CHARCODE_UPPER_A && ch <= CHARCODE_UPPER_Z) {
            if (ch + normalizedRotation <= CHARCODE_UPPER_Z) {
                return (char) (ch + normalizedRotation);
            } else {
                return (char) (ch + normalizedRotation - 26);
            }

        } else if (ch >= CHARCODE_LOWER_A && ch <= CHARCODE_LOWER_Z) {
            if (ch + normalizedRotation <= CHARCODE_LOWER_Z) {
                return (char) (ch + normalizedRotation);
            } else {
                return (char) (ch + normalizedRotation - 26);
            }
        }
        return ch;
    }

}
public class Fightsopa {

    private static class InputErrorException extends Exception {

        public InputErrorException(String string) {
        }
    }

    public Fightsopa() {
    }

    public String processLine(final String input, final RotateCoder coder) {
        final StringBuilder result = new StringBuilder();
        for (final char ch : input.toCharArray()) {
            final char out = coder.encrypt(ch);
            result.append(out);
        }
        return result.toString();
    }

    public String handle(final File inputFile) 
            throws FileNotFoundException, InputErrorException {
        final Scanner scanner = new Scanner(new FileReader(inputFile));
        try {
            final RotateCoder coder = createCoder(scanner);
            return processFile(scanner, coder);
        } finally {
            scanner.close();
        }
    }

    private RotateCoder createCoder(final Scanner scanner) 
            throws InputErrorException {
        if (!scanner.hasNext()) {
            throw new InputErrorException("Unable to read rotation.");
        }
        final String coderConfig = scanner.nextLine();
        return new RotateCoder(coderConfig);
    }

    private String processFile(final Scanner scanner, final RotateCoder coder) {
        final StringBuilder result = new StringBuilder();
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            final String processedLine = processLine(line, coder);
            result.append(processedLine);
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(final String args[]) 
            throws FileNotFoundException, InputErrorException {
       

        final File inputFile = new File("D:\\a.in");
        final Fightsopa fsopa = new Fightsopa();
        final String result = fsopa.handle(inputFile);
        System.out.print(result);
    }
}
