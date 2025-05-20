import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        System.out.println("=== Example 1: LRU Cache with removeEldestEntry ===");
        demonstrateLRUCache();
        
        System.out.println("\n=== Example 2: Unlimited Growth Map ===");
        demonstrateUnlimitedGrowth();
        
        System.out.println("\n=== Example 3: Default Constructor Values ===");
        demonstrateDefaultValues();
    }

    private static void demonstrateLRUCache() {
        // note that LinkedHashMap extends HashMap, and resize is to optimize performance 
        // rather than eviction and resize applies to both HashMap and LinkedHashMap.
        Map<String, Integer> lruCache = new LinkedHashMap<>(
            3,      // initial capacity: starting size of the hash table
            0.75f,  // load factor: when size > (capacity * load factor), the map will resize
            true    // access order: true means elements are ordered by last access time (get/put)
        ) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 3; // impl for eviction, without this, map will keep growing whenever put is called
            }
        };

        // Add initial elements
        System.out.println("Adding initial elements:");
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        System.out.println("Cache state: " + lruCache);
        System.out.println("Note: First entry (A) is oldest, Last entry (C) is newest");

        // Access 'A' - it becomes most recently used
        System.out.println("\nAccessing 'A':");
        lruCache.get("A");
        System.out.println("Cache state: " + lruCache);
        System.out.println("Note: 'A' moved to end (newest), 'B' is now oldest");

        // Add new element - should remove least recently used (B)
        System.out.println("\nAdding 'D':");
        lruCache.put("D", 4);
        System.out.println("Cache state: " + lruCache);
        System.out.println("Note: 'B' was removed (it was oldest), 'D' is now newest");
    }

    private static void demonstrateUnlimitedGrowth() {
        Map<String, Integer> unlimitedMap = new LinkedHashMap<>(
            3,      // same initial capacity
            0.75f,  // same load factor
            true    // same access order
        );

        // Add elements
        System.out.println("Adding elements:");
        unlimitedMap.put("A", 1);
        unlimitedMap.put("B", 2);
        unlimitedMap.put("C", 3);
        System.out.println("Map state: " + unlimitedMap);

        // Add more elements - map will keep growing
        System.out.println("\nAdding more elements:");
        unlimitedMap.put("D", 4);
        unlimitedMap.put("E", 5);
        unlimitedMap.put("F", 6);
        System.out.println("Map state: " + unlimitedMap);
    }

    private static void demonstrateDefaultValues() {
        Map<String, Integer> defaultMap = new LinkedHashMap<>();  // Uses all default values
        System.out.println("Default values are:");
        System.out.println("- Initial capacity: 16");
        System.out.println("- Load factor: 0.75");
        System.out.println("- Access order: false (insertion order)");
    }
}
