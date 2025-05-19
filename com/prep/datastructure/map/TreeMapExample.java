import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();

        scores.put(90, "Alice");
        scores.put(75, "Bob");
        scores.put(85, "Charlie");

        System.out.println(scores); // {75=Bob, 85=Charlie, 90=Alice}

        // Get the smallest key >= 80
        System.out.println(scores.ceilingKey(80)); // 85

        // Get all scores above 80
        System.out.println(scores.tailMap(80)); // {85=Charlie, 90=Alice}
    }
}
