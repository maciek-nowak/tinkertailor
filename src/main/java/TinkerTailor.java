import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TinkerTailor {

    public static void main(String[] args) {
        int inputLength = 10;
        int step = 5;
        System.out.println(new TinkerTailor().findTinkerTailorSequence(inputLength, step));
    }

    public List<Integer> findTinkerTailorSequence(int inputLength, int step) {
        if (step < 1) {
            throw new IllegalArgumentException("step must be positive");
        }

        List<Integer> inputList = this.prepareInputList(inputLength);
        List<Integer> tinkerTailorSequence = new LinkedList<>();

        int currentIndex = 0;
        while (!inputList.isEmpty()) {
            currentIndex = (--currentIndex + step) % inputList.size();
            Integer currentElement = inputList.remove(currentIndex);
            tinkerTailorSequence.add(currentElement);
        }

        return tinkerTailorSequence;
    }

    private List<Integer> prepareInputList(int inputLength) {

        return IntStream.rangeClosed(1, inputLength)
                        .boxed()
                        .collect(Collectors.toList());
    }
}
