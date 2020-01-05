package demo.exercise.frequency;


import java.util.Iterator;
import java.util.LinkedList;

public class SolverImplOrdN<E extends Comparable> implements Solver<E> {

    @Override
    public String getFrequency(E elements[]) {
        if (elements == null || elements.length < 1) {
            return EMPTY_RESULT;
        }
        LinkedList<E> keys = new LinkedList<>();
        LinkedList<Integer> frequency = new LinkedList<>();
        for (E e : elements) {
            if (keys.size() == 0 || !keys.getLast().equals(e)) {
                keys.add(e);
                frequency.add(1);
            } else {
                int newFrequency = frequency.getLast() + 1;
                frequency.removeLast();
                frequency.add(newFrequency);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<E> keyIterator = keys.iterator();
        Iterator<Integer> frequencyIterator = frequency.iterator();
        while (keyIterator.hasNext()) {
            sb.append(String.format("%s:%d,", keyIterator.next(), frequencyIterator.next()));
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
