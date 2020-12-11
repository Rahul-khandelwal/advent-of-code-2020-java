package aoc.solutions.day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author in-rahul.khandelwal
 */
public class Solution {

    public static void main(String[] args) {
        part2_possibleArrangementsCaching();
    }

    private static void part1_multiplicationOfOneAndThreeDiff() {
        var input = input();
        var deltas = IntStream.range(0, input.size() - 1)
                .map(i -> input.get(i + 1) - input.get(i)).boxed().collect(Collectors.toList());

        long oneDiff = deltas.stream().filter(i -> i == 1).count();
        long threeDiff = deltas.stream().filter(i -> i == 3).count() + 1; // Diff of last adaptor to device

        if (input.get(0) == 1) {
            oneDiff++;
        }
        System.out.println(oneDiff * threeDiff);
    }

    private static void part2_possibleArrangementsCaching() {
        Map<Integer, Map<List<Integer>, Long>> cache = new HashMap<>();
        long val = possibleArrangements(0, new LinkedList<Integer>(input()), cache);
        System.out.println(val);
    }

    private static long possibleArrangements(int last, List<Integer> remainingAdapters, Map<Integer, Map<List<Integer>, Long>> cache) {
        if (remainingAdapters.isEmpty()) {
            return 1L;
        }

        // Check in cache first
        var mapped = cache.get(last);
        if (mapped != null && mapped.get(remainingAdapters) != null) {
            return mapped.get(remainingAdapters);
        }

        Integer nextAdapter = remainingAdapters.remove(0);
        var count = possibleArrangements(nextAdapter, remainingAdapters, cache);

        if (!remainingAdapters.isEmpty() && remainingAdapters.get(0) - last <= 3) {
            count += possibleArrangements(last, remainingAdapters, cache);
        }
        remainingAdapters.add(0, nextAdapter);

        // Add to cache
        Map<List<Integer>, Long> map = new HashMap<>();
        map.put(remainingAdapters, count);
        cache.put(last, map);
        return count;
    }

    private static List<Integer> input() {
        var inputStr = "138\n" +
                        "3\n" +
                        "108\n" +
                        "64\n" +
                        "92\n" +
                        "112\n" +
                        "44\n" +
                        "53\n" +
                        "27\n" +
                        "20\n" +
                        "23\n" +
                        "77\n" +
                        "119\n" +
                        "62\n" +
                        "121\n" +
                        "11\n" +
                        "2\n" +
                        "37\n" +
                        "148\n" +
                        "34\n" +
                        "83\n" +
                        "24\n" +
                        "10\n" +
                        "79\n" +
                        "96\n" +
                        "98\n" +
                        "127\n" +
                        "7\n" +
                        "115\n" +
                        "19\n" +
                        "16\n" +
                        "78\n" +
                        "133\n" +
                        "61\n" +
                        "82\n" +
                        "91\n" +
                        "145\n" +
                        "39\n" +
                        "33\n" +
                        "13\n" +
                        "97\n" +
                        "55\n" +
                        "141\n" +
                        "1\n" +
                        "134\n" +
                        "40\n" +
                        "71\n" +
                        "54\n" +
                        "103\n" +
                        "101\n" +
                        "26\n" +
                        "47\n" +
                        "90\n" +
                        "72\n" +
                        "126\n" +
                        "124\n" +
                        "110\n" +
                        "131\n" +
                        "58\n" +
                        "12\n" +
                        "142\n" +
                        "105\n" +
                        "63\n" +
                        "75\n" +
                        "50\n" +
                        "95\n" +
                        "69\n" +
                        "25\n" +
                        "68\n" +
                        "144\n" +
                        "86\n" +
                        "132\n" +
                        "89\n" +
                        "128\n" +
                        "135\n" +
                        "65\n" +
                        "125\n" +
                        "76\n" +
                        "116\n" +
                        "32\n" +
                        "18\n" +
                        "6\n" +
                        "38\n" +
                        "109\n" +
                        "111\n" +
                        "30\n" +
                        "70\n" +
                        "143\n" +
                        "104\n" +
                        "102\n" +
                        "120\n" +
                        "31\n" +
                        "41\n" +
                        "17";

        return Arrays.stream(inputStr.split("\n"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
