import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing an Album that consists of a collection of Music Compositions.
 */
public class Album {
    private List<MusicComposition> compositions;

    public Album() {
        this.compositions = new ArrayList<>();
    }

    public void addComposition(MusicComposition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        compositions.add(composition);
    }

    public double calculateTotalDuration() {
        return compositions.stream()
                .mapToDouble(MusicComposition::getDuration)
                .sum();
    }

    public void sortCompositionsByGenre() {
        compositions.sort(Comparator.comparing(MusicComposition::getGenre));
    }

    public List<MusicComposition> findCompositionsByDurationRange(double min, double max) {
        if (min < 0 || max <= 0 || min > max) {
            throw new IllegalArgumentException("Invalid duration range.");
        }
        return compositions.stream()
                .filter(comp -> comp.getDuration() >= min && comp.getDuration() <= max)
                .collect(Collectors.toList());
    }

    public void printAlbum() {
        if (compositions.isEmpty()) {
            System.out.println("The album is empty.");
        } else {
            compositions.forEach(System.out::println);
        }
    }
}
