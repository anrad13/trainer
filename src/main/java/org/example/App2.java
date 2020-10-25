package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class App2
{
    private static final int TRAINING_LIMIT = 30;
    static final int NUMBER_RANGE = 99;
    static final int SOUND_WAITING_SEC = 2;

    final static Random random = new Random();

    public static void main( String[] args ) {
        new App2().apply();
    }

    void apply() {
        final GoogleTranslatorForm f = new GoogleTranslatorForm();
        Stream.generate(() -> random.nextInt(NUMBER_RANGE))
                .limit(TRAINING_LIMIT)
                .map(number -> number + "")
                .forEachOrdered(
                        number -> {
                            System.out.print(number + " ");
                            f.say(number);
                            f.sleep(SOUND_WAITING_SEC);
                        }
                );
    }

}
