package demo.exercise.frequency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static demo.exercise.frequency.Solver.EMPTY_RESULT;

public class SolverTest {

    private Character[] basicTestInput = new Character[] {'a','b','b','b','b','b','d','h','h','h','p'};
    private String basicTestResult = "a:1,b:5,d:1,h:3,p:1";
    private Character[] inputOf100ElementsA,inputOf100ElementsB, inputOf100ElementsC;
    private Character[] inputOf5000ElementsA, inputOf5000ElementsB, inputOf5000ElementsC;
    private Solver<Character> testSolverOn;
    private Solver<Character> testSolverSubOn;

    @Before
    public void setup() {
        testSolverOn = new SolverImplOrdN<>();
        testSolverSubOn = new SolverImplSubOrdN<>();
        inputOf100ElementsA = TestUtils.generateRandomTestInput(10, 100);
        inputOf100ElementsB = TestUtils.generateRandomTestInput(50, 100);
        inputOf100ElementsC = TestUtils.generateRandomTestInput(75, 100);
        inputOf5000ElementsA = TestUtils.generateRandomTestInput(10, 5000);
        inputOf5000ElementsB = TestUtils.generateRandomTestInput(50, 5000);
        inputOf5000ElementsC = TestUtils.generateRandomTestInput(75, 5000);
    }

    @Test
    public void testEmptyInput() {
        String result = testSolverOn.getFrequency(null);
        Assert.assertEquals(EMPTY_RESULT, result);
        result = testSolverOn.getFrequency(new Character[0]);
        Assert.assertEquals(EMPTY_RESULT, result);
        result = testSolverSubOn.getFrequency(null);
        Assert.assertEquals(EMPTY_RESULT, result);
        result = testSolverSubOn.getFrequency(new Character[0]);
        Assert.assertEquals(EMPTY_RESULT, result);
    }

    @Test
    public void testOrdNforBasicList() {
        long time = System.nanoTime();
        String result = testSolverOn.getFrequency(basicTestInput);
        System.out.println(String.format("Basic test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        Assert.assertNotNull(result);
        Assert.assertEquals(basicTestResult, result);
    }

    @Test
    public void testSubOrdNforBasicList() {
        long time = System.nanoTime();
        String result = testSolverSubOn.getFrequency(basicTestInput);
        System.out.println(String.format("Basic test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        Assert.assertNotNull(result);
        Assert.assertEquals(basicTestResult, result);
    }

    @Test
    public void testPerformance100Elements() {
        long time = System.nanoTime();
        String result = testSolverOn.getFrequency(inputOf100ElementsA);
        System.out.println(String.format("100 element A test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 A result was: " + result);
        time = System.nanoTime();
        result = testSolverOn.getFrequency(inputOf100ElementsB);
        System.out.println(String.format("100 element B test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 B result was: " + result);
        time = System.nanoTime();
        result = testSolverOn.getFrequency(inputOf100ElementsC);
        System.out.println(String.format("100 element C test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 C result was: " + result);

        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf100ElementsA);
        System.out.println(String.format("100 element A test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 A result was: " + result);
        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf100ElementsB);
        System.out.println(String.format("100 element B test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 B result was: " + result);
        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf100ElementsC);
        System.out.println(String.format("100 element C test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("100 C result was: " + result);
    }

    @Test
    public void testPerformance5000Elements() {
        long time = System.nanoTime();
        String result = testSolverOn.getFrequency(inputOf5000ElementsA);
        System.out.println(String.format("5000 element A test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 A result was: " + result);
        time = System.nanoTime();
        result = testSolverOn.getFrequency(inputOf5000ElementsB);
        System.out.println(String.format("5000 element B test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 B result was: " + result);
        time = System.nanoTime();
        result = testSolverOn.getFrequency(inputOf5000ElementsC);
        System.out.println(String.format("5000 element C test run time with O(n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 C result was: " + result);

        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf5000ElementsA);
        System.out.println(String.format("5000 element A test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 A result was: " + result);
        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf5000ElementsB);
        System.out.println(String.format("5000 element B test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 B result was: " + result);
        time = System.nanoTime();
        result = testSolverSubOn.getFrequency(inputOf5000ElementsC);
        System.out.println(String.format("5000 element C test run time with O(log n) algo:  %dus%n",
                TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - time)));
        System.out.println("5000 C result was: " + result);
    }
}
