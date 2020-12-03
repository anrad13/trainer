package org.example;

import java.util.Random;
import java.util.stream.Stream;

public class Numbers
{
    private int trainingLimit = 100;
    private int soundWaitingSec = 2;

    final Random random = new Random(System.currentTimeMillis());
    final GoogleTranslatorForm f = new GoogleTranslatorForm();

    public Numbers() {
    }

    public Numbers setLimit(int trainingLimit) {
        this.trainingLimit = trainingLimit;
        return this;
    }

    public Numbers setSoundWait(int soundWaitingSec) {
        this.soundWaitingSec = soundWaitingSec;
        return this;
    }

    public void apply(int range) {
        final Printer printer = new Printer();
        Stream.generate(() -> random.nextInt(range))
                .limit(trainingLimit)
                .map(number -> Integer.toString(number))
                .forEachOrdered(
                        number -> {
                            printer.printNumber(number);
                            f.say(number);
                            f.sleep(soundWaitingSec);
                        }
                );
    }

    class Printer {
        private static final int LINE_MAX_NUMBERS = 3;
        private int lineCount = 0;

        void printNumber (String number) {
            if (lineCount >= LINE_MAX_NUMBERS) {
                lineCount = 0;
                System.out.println();
            }
            lineCount++;
            System.out.print(number + "\t");
        }
    }

}
