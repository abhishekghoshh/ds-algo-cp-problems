package HeapProblems;



public class Pair {
    private int first;
    private int second;
    /**
     * @param first
     * @param second
     */
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }

    /**
     * @return T return the first
     */
    public int getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(int first) {
        this.first = first;
    }

    /**
     * @return R return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

}
