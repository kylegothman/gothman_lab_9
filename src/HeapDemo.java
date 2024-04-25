import java.util.Random;
import java.util.Comparator;


public class HeapDemo {
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;
        Heap<Integer> heap = new Heap<>(comparator);
        Random rand = new Random();

        System.out.println("Adding numbers:");
        for (int i = 0; i < 17; i++) {
            int number = rand.nextInt(100);
            System.out.print(number + " ");
            heap.add(number);
        }

        System.out.println("\n\nRemoving numbers:");
        while (true) {
            Integer number = heap.remove();
            if (number == null) {
                break;
            }
            System.out.print(number + " ");
        }
    }
}
