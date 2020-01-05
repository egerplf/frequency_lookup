package demo.exercise.frequency;

public interface Solver<E extends Comparable> {
    public static final String EMPTY_RESULT = "Empty result.";

    String getFrequency(E elements[]);
}
