import java.util.List;

/**
 * Main class for testing the Album and Music Composition hierarchy.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Album album = new Album();

            album.addComposition(new RockComposition("Bohemian Rhapsody", "Queen", 5.55));
            album.addComposition(new JazzComposition("Take Five", "Dave Brubeck", 5.24));
            album.addComposition(new PopComposition("Thriller", "Michael Jackson", 5.57));
            album.addComposition(new RockComposition("Stairway to Heaven", "Led Zeppelin", 8.02));
            album.addComposition(new JazzComposition("So What", "Miles Davis", 9.22));

            System.out.println("Album before sorting:");
            album.printAlbum();

            System.out.println("\nTotal duration of the album: " + album.calculateTotalDuration() + " minutes");

            System.out.println("\nSorting compositions by genre...");
            album.sortCompositionsByGenre();
            album.printAlbum();

            System.out.println("\nFinding compositions with duration between 5 and 6 minutes:");
            List<MusicComposition> filteredCompositions = album.findCompositionsByDurationRange(5, 6);
            filteredCompositions.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}