package demo.exercise.frequency;


import java.util.Arrays;
import java.util.Random;

public class TestUtils {

    public static Character[] generateRandomTestInput(int variety, int size) {
        Character[] testData = new Character[size];
        Random rnd = new Random();
        for (int i=0; i<size; i++) {
            char c = (char)(rnd.nextInt(variety) + 'a');
            testData[i]=c;
        }
        Arrays.sort(testData);
       return testData;
    }

}
