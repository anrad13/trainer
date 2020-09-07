package org.example;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2
{
    private static final int TRAINING_LIMIT = 30;
    // The amount of space between digits. Set up the pause in pronounce of separate digits
    static final String DIGIT_SEPARATOR = " ";
    static final int NUMBER_RANGE = 10;
    static final int SOUND_WAITING_SEC = 2;

    final static Random random = new Random();

    public static void main( String[] args )
    {
        new App2().apply();
    }

    App2 () {}

    void apply() {
        final GoogleTranslatorForm f = new GoogleTranslatorForm();
        final Random random = new Random();
        for (int i = 0; i < TRAINING_LIMIT; i++) {
            int n1 = random.nextInt(NUMBER_RANGE);
            String number1 = (n1 != 0) ? n1 + "" : "";
            String number2 = random.nextInt(NUMBER_RANGE) + "";
            String number = number1+number2+"";
            System.out.print(number + DIGIT_SEPARATOR);
            f.say(number);
            f.sleep(SOUND_WAITING_SEC);
        }

        /*
        Stream.generate(() -> App.getNumber(10))
                .limit(TRAINING_LIMIT)
                .forEachOrdered(
                        number -> {f.say(number); f.sleep(5);}
                );

        String number = getNumber(10);
        System.out.println(number + "\n");
        f.say(number);
        f.sleep(5);

         */
    }

    static private String getNumber(int length) {
        final Random r = new Random();
        return Stream.generate(() -> r.nextInt(10) + DIGIT_SEPARATOR)
                .limit(length)
                .collect(Collectors.joining());
    }

    static private String getDigit() {
        return random.nextInt(10) + DIGIT_SEPARATOR;
    }




}