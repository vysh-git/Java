import java.util.*;

public class TopKFrequentNumbers {
    // Static variable to store the input array
    private static int[] numbers;

    // Static method to find the top K numbers with the maximum occurrences
    public static List<Integer> findTopKFrequent(int K) {
        // Frequency map to store occurrences of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Priority queue to store numbers based on frequency and value
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue().equals(a.getValue()) ? b.getKey() - a.getKey() : b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());

        // Collect the top K frequent numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        numbers = new int[]{3, 1, 4, 4, 5, 2, 6, 1};
        int K1 = 2;
        System.out.println("Top " + K1 + " frequent numbers: " + findTopKFrequent(K1));

        // Test case 2
        numbers = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int K2 = 4;
        System.out.println("Top " + K2 + " frequent numbers: " + findTopKFrequent(K2));
    }
}

public class ShareTrader {
    // Static variable to store the maximum profit
    private static int maxProfit;

    // Static method to calculate the maximum profit
    public static int findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        // Arrays to store maximum profit up to each day
        int[] profitLeft = new int[n];
        int[] profitRight = new int[n];

        // Track the minimum price and calculate maximum profit for the first transaction
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice);
        }

        // Track the maximum price and calculate maximum profit for the second transaction
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]);
        }

        // Combine the profits from both transactions
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        System.out.println("Max Profit: " + findMaxProfit(prices1));  // Output: 87

        // Test case 2
        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        System.out.println("Max Profit: " + findMaxProfit(prices2));  // Output: 100
    }
}
