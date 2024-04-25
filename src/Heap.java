import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> data;
    private final Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.data = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T element) {
        data.add(element);
        int current = data.size() - 1;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (comparator.compare(data.get(current), data.get(parent)) >= 0) {
                break;
            }
            swap(current, parent);
            current = parent;
        }
    }

    public T remove() {
        if (data.size() == 0) {
            return null;
        }
        T result = data.get(0);
        if (data.size() == 1) {
            data.remove(0);  // Just remove the last element, no need to re-heapify.
            return result;
        }
        data.set(0, data.remove(data.size() - 1));  // Move last element to the root and then re-heapify.
        int current = 0;
        while (true) {
            int leftChild = 2 * current + 1;
            int rightChild = 2 * current + 2;
            if (leftChild >= data.size()) {
                break;
            }
            int minChild = leftChild;
            if (rightChild < data.size() && comparator.compare(data.get(rightChild), data.get(leftChild)) < 0) {
                minChild = rightChild;
            }
            if (comparator.compare(data.get(current), data.get(minChild)) <= 0) {
                break;
            }
            swap(current, minChild);
            current = minChild;
        }
        return result;
    }

    private void swap(int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}