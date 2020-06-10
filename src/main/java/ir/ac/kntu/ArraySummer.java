package ir.ac.kntu;

/**
 * @author your name
 */
public class ArraySummer implements Runnable {
    private Integer[] array;
    private Integer sum;
    private Integer start, end;

    public ArraySummer(Integer[] array, Integer start, Integer end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }


    public Integer getSum() {
        return sum;
    }

    public void run() {
        // TODO: calculate sum of the given array from start to end
    }

    /***
     * A helper method that returns the number of logical processors.
     *
     * @return number of logical processors available
     */
    public static Integer getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }
}
