package demo.exercise.frequency;

public class SolverImplSubOrdN<E extends Comparable> implements Solver<E> {

    @Override
    public String getFrequency(E elements[]) {
        if (elements == null || elements.length < 1) {
            return EMPTY_RESULT;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < elements.length) {
            int lastIndex = last(elements, elements[index], index+1, elements.length-1);
            int frequency = lastIndex == -1 ? 1 : lastIndex - index +1;
            sb.append(String.format("%s:%s,", elements[index], frequency));
            if (lastIndex == -1) {
                index = index + 1;
            } else {
                index = lastIndex + 1;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /* binary search for the las occurrence of E e */
    private int last(E elements[], E elem, int low, int high) {
        if(high >= low)
        {
            int n = elements.length-1;
            /*low + (high - low)/2;*/
            int mid = (low + high)/2;
            if( ( mid == n || elem.compareTo(elements[mid+1]) < 0 ) && elements[mid].equals(elem) )
                return mid;
            else if(elem.compareTo(elements[mid])<0)
                return last(elements, elem, low, (mid -1));
            else
                return last(elements, elem, (mid + 1), high);
        }
        return -1;

    }
}
