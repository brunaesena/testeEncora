package org.testEncora.questao9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InfiniteCoins {

    // The function below calls a helper method to calculate all possible ways to make change for a given value n and stores the results in a Set.
    public static Set<List<Integer>> makeChange(int n) {
        Set<List<Integer>> result = new HashSet<>();
        makeChangeHelper(n, 0, 0, 0, 0, result);
        return result;
    }

    // Helper method to recursively calculate the possible combinations of coins for a given value n.
    private static void makeChangeHelper(int n, int quarters, int dimes, int nickels, int pennies, Set<List<Integer>> result) {
        if (n == 0) {
            List<Integer> combination = new ArrayList<>();
            combination.add(quarters);
            combination.add(dimes);
            combination.add(nickels);
            combination.add(pennies);
            combination.add(0);
            result.add(combination);
            return;
        }

        // Recursively check and add combinations of coins.
        if (n >= 25) {
            makeChangeHelper(n - 25, quarters + 1, dimes, nickels, pennies, result);
        }
        if (n >= 10) {
            makeChangeHelper(n - 10, quarters, dimes + 1, nickels, pennies, result);
        }
        if (n >= 5) {
            makeChangeHelper(n - 5, quarters, dimes, nickels + 1, pennies, result);
        }
        if (n >= 1) {
            makeChangeHelper(n - 1, quarters, dimes, nickels, pennies + 1, result);
        }
    }

    // Main method to calculate and print all combinations of coins for a given value n.
    public static void main(String[] args) {
        int n = 12;
        Set<List<Integer>> combinations = makeChange(n);
        for (List<Integer> combination : combinations) {
            System.out.println("[" + combination.get(0) + ", " + combination.get(1) + ", " + combination.get(2) + ", " + combination.get(3) + "]");
        }
    }
}