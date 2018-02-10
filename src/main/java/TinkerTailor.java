import java.util.LinkedList;
import java.util.List;

public class TinkerTailor {

    public static void main(String[] args) {
        int inputLength = 5;
        int step = 3;
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
        List<Integer> inputList = new LinkedList<>();

        for (int i = 1; i <= inputLength; i++) {
            inputList.add(i);
        }

        return inputList;
    }
}
