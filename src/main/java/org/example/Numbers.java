package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class Numbers
{
    private static final int TRAINING_LIMIT = 30;
    static final int SOUND_WAITING_SEC = 2;

    final static Random random = new Random(System.currentTimeMillis());
    final static GoogleTranslatorForm f = new GoogleTranslatorForm();

    void apply(int range) {
        Stream.generate(() -> random.nextInt(range))
                .limit(TRAINING_LIMIT)
                .map(number -> Integer.toString(number))
                .forEachOrdered(
                        number -> {
                            System.out.print(number + " ");
                            f.say(number);
                            f.sleep(SOUND_WAITING_SEC);
                        }
                );
    }

}
