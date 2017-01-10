package mini2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Implementation of a version of the "twenty-four" game.
 */
public class NumberGame {
    public static void main(String[] args) {
        //  Set of numbers: { 2, 3, 4, 5 }
        //  Target: 24
        //
        //    Possible Operations
        // ------------------------
        // | ((5 – 2) * (3 + 4)), |
        // | ((3 – 2) + (4 * 5)), |
        // | (3 * (2 + 5))        |
        // ------------------------

        ArrayList<IntExpression> numbers = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();

        int target = 24;

        numbers.add(new IntExpression(2));
        numbers.add(new IntExpression(3));
        numbers.add(new IntExpression(4));
        numbers.add(new IntExpression(5));

        findSolution(numbers, target, results);
    }

    /**
     * Lists all ways to obtain the given target number using arithmetic operations
     * on the values in the given IntExpression list.  Results in string form are added to the given list,
     * where the string form of a value is obtained from the toString() of the Value object.
     * Special rules are: 1) you are not required to use all given numbers, and 2) division
     * is integer division and is only allowed when remainder is zero.  For addition
     * and multiplication, a + b and b + a are considered to be distinct solutions, and
     * likewise a * b and b * a are considered as different solutions.  See the
     * pdf for detailed examples.
     *
     * @param list    the values to be used
     * @param target  the target number to be obtained from the values in the list
     * @param results list of all results, as strings
     */
    public static void findSolution(ArrayList<IntExpression> list, int target, ArrayList<String> results) {
        ArrayList<IntExpression> _list = new ArrayList<>(list);
        ArrayList<IntExpression> _copy = new ArrayList<>();
        IntExpression _exp = new IntExpression(0);
        IntExpression _xyz;
        char _op = ' ';

        if (list.size() == 1) {
            if (list.get(0).getIntValue() == target) {
                results.add(list.get(0).toString());
            }
        } else {
            for (IntExpression x : list) {
                _copy.addAll(list);
                _exp = _copy.remove(0);
                findSolution(_copy, target, results);
            }

            // for each pair of numbers x, y in the list
            //    for each allowable arithmetic combination z of x and y
            //        create a copy of the list without x and y, but z added.
            //        find solutions using that list
        }
    }
}