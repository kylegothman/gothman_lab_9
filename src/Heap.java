import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> data;
    private final Comparator<? super T> comparator;

    public Heap(Comparator<? super T> comparator) {
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
        if (data.isEmpty()) {
            return null;
        }
        T result = data.get(0);
        if (data.size() > 1) {
            data.set(0, data.remove(data.size() - 1));
            heapify(0);
        } else {
            data.remove(0);
        }
        return result;
    }

    private void heapify(int current) {
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;
        int smallest = current;

        if (leftChild < data.size() && comparator.compare(data.get(leftChild), data.get(smallest)) < 0) {
            smallest = leftChild;
        }
        if (rightChild < data.size() && comparator.compare(data.get(rightChild), data.get(smallest)) < 0) {
            smallest = rightChild;
        }
        if (smallest != current) {
            swap(current, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}