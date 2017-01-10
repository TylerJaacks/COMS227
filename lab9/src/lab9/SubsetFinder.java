package lab9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetFinder {
    public static void main(String[] args) {
        // Try finding the 4-element subsets of a 7-element set
        int[] testValues = {0, 1, 2, 3, 4, 5, 6};
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int val : testValues) {
            test.add(val);
        }

        ArrayList<int[]> subsets = findSubsets(test, 4);

        // print everything out
        for (int[] s : subsets) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println("Found " + subsets.size() + " subsets");
    }

    /**
     * Finds all subsets of the given set with 'size' elements.  In the result list,
     * each subset is represented as an array of distinct integers.
     */
    public static ArrayList<int[]> findSubsets(ArrayList<Integer> givenSet, int size) {
        // Empty array list in which to put the results
        ArrayList<int[]> results = new ArrayList<int[]>();

        // Initially no values are chosen
        ArrayList<Integer> chosen = new ArrayList<Integer>();

        // Start the recursive search using helper method
        findSubsets(chosen, givenSet, size, results);

        return results;
    }

    /**
     * Recursive helper method finds all subsets that can be obtained by selecting
     * 'howMany' elements from 'available' and adding them to 'chosen'.
     * Results are added to the given array list 'results'.  This method does
     * not modify 'chosen' or 'available'.
     */
    private static void findSubsets(ArrayList<Integer> chosen, ArrayList<Integer> available, int howMany, ArrayList<int[]> results) {
        ArrayList<Integer> _chosen = new ArrayList<>(chosen);
        ArrayList<Integer> _available = new ArrayList<>(available);

        if (howMany == 0) {
            int[] subset = new int[_chosen.size()];

            // Base case (success): we've selected enough elements, add chosen elements to list
            for (int i = 0; i < _chosen.size(); i++) {
                subset[i] = _chosen.get(i);
            }

            results.add(subset);
        } else if (available.size() == 0) {
            // Base case (failure): there are no more elements available to select, so
            // this is a dead end
            return;
        } else {
            // Recursive case: take the first available element.  Possible
            // subsets either include it, or they don't.
            int first = available.get(0);

            _available.remove(0);

            _chosen.add(first);

            // First, find all subsets that DO include ch, by selecting
            // howMany - 1 more elements from remaining...
            findSubsets(_chosen, _available, howMany - 1, results);

            // Then find subsets that DON'T include ch, by selecting howMany more
            // elements from remaining
            findSubsets(chosen, _available, howMany, results);
        }
    }
}