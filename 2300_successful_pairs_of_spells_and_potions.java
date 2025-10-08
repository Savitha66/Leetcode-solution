import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            long minRequired = (success + spell - 1) / spell;

            int index = binarySearch(potions, minRequired);

            pairs[i] = m - index;
        }

        return pairs;
    }

    private int binarySearch(int[] arr, long target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
