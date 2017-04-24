public interface PriorityQueue<T> {

    void add(T x);
    boolean isEmpty();
    T peekMin();
    T removeMin();

}
