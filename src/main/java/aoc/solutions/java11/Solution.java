package aoc.solutions.java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author in-rahul.khandelwal
 */
public class Solution {

    public static void main(String[] args) {
        part2_countOfOccupied();
    }

    private static void part1_countOfOccupied() {
        var input = input();
        int changesDone = 0;

        do {
            changesDone = 0;
            char[][] newGrid = new char[input.length][input[0].length];
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    char[][] finalInput = input;
                    long occupied = getAdjacents(i, j, input.length, input[0].length)
                            .filter(entry -> finalInput[entry.getKey()][entry.getValue()] == '#').count();

                    if (getChanges(input, newGrid, i, j, occupied, 4)) {
                        changesDone++;
                    }
                }
            }
            input = newGrid;
        } while (changesDone > 0);

        System.out.println(count(input, '#'));
    }

    private static void part2_countOfOccupied() {
        var input = input();
        int changesDone;

        do {
            changesDone = 0;
            char[][] newGrid = new char[input.length][input[0].length];
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    long occupied = countOccupied(input, i, j);

                    if (getChanges(input, newGrid, i, j, occupied, 5)) {
                        changesDone++;
                    }
                }
            }
            input = newGrid;
        } while (changesDone > 0);

        System.out.println(count(input, '#'));
    }

    private static Stream<Map.Entry<Integer, Integer>> getAdjacents(int i, int j, int rows, int columns) {
        List<Map.Entry<Integer, Integer>> ad = new ArrayList<>();

        ad.add(new HashMap.SimpleImmutableEntry<>(i, j + 1));
        ad.add(new HashMap.SimpleImmutableEntry<>(i, j - 1));
        ad.add(new HashMap.SimpleImmutableEntry<>(i - 1, j));
        ad.add(new HashMap.SimpleImmutableEntry<>(i + 1, j));
        ad.add(new HashMap.SimpleImmutableEntry<>(i - 1, j + 1));
        ad.add(new HashMap.SimpleImmutableEntry<>(i + 1, j - 1));
        ad.add(new HashMap.SimpleImmutableEntry<>(i - 1, j - 1));
        ad.add(new HashMap.SimpleImmutableEntry<>(i + 1, j + 1));

        return ad.stream().filter(entry -> entry.getKey() >= 0 && entry.getKey() < rows && entry.getValue() >= 0 && entry.getValue() < columns);
    }

    private static boolean getChanges(char[][] input, char[][] newGrid, int i, int j, long occupied, int minOccupiedRequired) {
        if (occupied == 0 && input[i][j] == 'L') {
            newGrid[i][j] = '#';
            return true;
        } else if (occupied >= minOccupiedRequired && input[i][j] == '#') {
            newGrid[i][j] = 'L';
            return true;
        } else {
            newGrid[i][j] = input[i][j];
        }

        return false;
    }

    private static int countOccupied(char[][] input, int i, int j) {
        int occupied = 0;

        // Move top
        int posX = i - 1;
        int posY = j;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX--;
        }

        // Move bottom
        posX = i + 1;
        posY = j;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX++;
        }

        // Move left
        posX = i;
        posY = j - 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posY--;
        }

        // Move right
        posX = i;
        posY = j + 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posY++;
        }

        // Move top left
        posX = i - 1;
        posY = j - 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX--;
            posY--;
        }

        // Move top right
        posX = i - 1;
        posY = j + 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX--;
            posY++;
        }

        // Move bottom left
        posX = i + 1;
        posY = j - 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX++;
            posY--;
        }

        // Move bottom right
        posX = i + 1;
        posY = j + 1;
        while (posX >= 0 && posX < input.length && posY >= 0 && posY < input[0].length && input[posX][posY] != 'L') {
            if (input[posX][posY] == '#') {
                occupied++;
                break;
            }
            posX++;
            posY++;
        }

        return occupied;
    }

    private static long count(char[][] grid, char ch) {
        return Arrays.stream(grid)
                .flatMapToInt(c -> new String(c).chars())
                .filter(c -> c == ch)
                .count();
    }

    private static char[][] input() {
        var inputStr = "LLLLLLLLLLLLLLL.LL.L.LLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLL..L.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLL.LLLLL.L.LLLLLL.\n"
                + "LLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LL.LL.LLLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLLLLLL.L.LLLLLLLLLLLLLL.\n"
                + "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLL.L\n"
                + "LLLL..LLLLL.LLLLLLLL..LLLLLLLLLLLLLL..LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL..LLLL.LLL.LLLLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLL.L.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLLLLL.L\n"
                + ".LLLLL..LLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLL.LLLLL.LLLLLLLL.LLLL.LLLLLL.LLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLL.LLL.LLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLL.L.LLLLLLLLLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLL.L.LLL.LLLLLLLL.LLLLLLLLL..LL.LLLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLL..LLLLL.LLLLL.LLL.LLLLL\n"
                + "L..L.L...LL.LL...L....LL......L.L.L...L....LL........LL.L..L...L.......L.L...L...LL......LL...L\n"
                + "LLLLL.LLLLLLLLLLLL.LLLLLLLLLLL.LLLLL.LLLLL.LLL.LLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLL.LLLLLLLL.\n"
                + "LL.LL.LL.LL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.L.LLLLLLLLLLLLLL.LLLL..LLLLLLLLLLLLLLL\n"
                + "LLLL..LLLLLLLLLLLLLL.LLLLLLLLLLLL.LL.LLLLLLLLL.LLLLLL.LLLLLLL.LL.L.LLLLLL...LLLLLLLLL.LLLLLLLLL\n"
                + "LLLLL..LLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL\n"
                + "L.LLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LL........LL....L.L.....LLL......LLL..L.L.LLLLL...LL....L.....LL..LL.L.......L.L.L.LL.L.L.L....\n"
                + ".LLLLLLLLLLLL.LL.LLLLLLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLL.LLLL..LLLLLLLLLLLL..LLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL..LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.L.L.LLLLLLLLLLLLL.LLLLLLL\n"
                + "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LL..LLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLL\n"
                + "LLLLL..LLLL.LLLLLLLL.L.LLLLLLL.LLL.L..LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLL.LLL\n"
                + "LLLL..LLL.L...LLLLLL.LL.LLLLLL.LLLL.LLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LL.LL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLLLLLLLLLLLL..LLLLLLL.LLLLLL.LLLL.LLLL.LLLLLLLLL.LLLLLL.LLL...LLLLLL.LLLLLLLL\n"
                + "....LLL.......L...LL.L..........L....LLL.L.LL..L..L........LLL..LL...L......L..LLL..L....L.....\n"
                + "LLLLL.LLLLLLLL.LLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLL.LL.LL.LL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLL.LLL.LLL.LLLLL.LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.L.LLLLLLLLLLLLLLLLL.L\n"
                + "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL...LLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LL.LLLLLLLLLLLLLLLLLLL..LLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLLLLLLLL.LL.LLLLLLLLL.LLLLLLLLLLLLL.LL.LLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LL.LL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLL.L.LLL.L.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLL..LL.LL.LLLLL.LLLLL.LLLLLLLLL\n"
                + ".LL.L...LLLL..L..L..LL...LL....LL..L...LL.L..L...L...L.................LLL....L..L...L.LLL..L..\n"
                + "LLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n"
                + "LLLLLLLLLLL.LLLLLLLL.L.LLLLLLL.LLLLL.LLLLLLLLL.LLLLLL.LL.LLL.LLLLLLLLLLLL..L.LLLLLLLLLLLLLLLLLL\n"
                + "LLL.L.LLL.LLLLLL.LLL.LL.LL.LLLLL.LLL.LLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLL..LLLLLLL.L.LLLLLLLLL.LLLLLL.LLLLL.LLLL..LLLLLLLLL\n"
                + "LLLLL.L.LLLLLLLL.LL..LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.L.LLLLL.LLL.L.LLLL.LLLLL.LLLLLLLLLLLLLLL\n"
                + "LLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLLLLLLL.LLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LL.L.LLL..LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLLLLLLL\n"
                + "LL.L....L.L..........L...L.L.......LL......L.LL...LL.....L.L.L...L....LL.L..L......L..LL..L....\n"
                + "LLLLL.LLLLL.LLLLLLLL..LLLLLLLL.LLLLLL.LLLLLLL.LLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.L.LLL.LLLLLLLLL\n"
                + "L.LLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLLL.LLLLL.LLL.LLLLL.LLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLL.LLLLLLLLL\n"
                + "LLLL.LLLLLLLLLLLLLLL.LLLLL.LLL.LL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLLL..LL\n"
                + "LLLLL.LLLLL.LL.LLLLL..LLLLL.LL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.L.LL.LLLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLL.L.LLLLL.LLLLL.LLLLLLLLL\n"
                + "........L....LLL.L....L...L...L.LL.......L..L..L.LL.L.L.L..L...L..L..L.........LLL.....LL.L..L.\n"
                + "LLLLL.LL.LL.LLLLLLLLLLLLLLLLLL.L.LLL..LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL..L.LLL.LL\n"
                + "LLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL..LLLLLLLL.LL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLLLL.LLLLL..LL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLL.L.LLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLL.L.LLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.L.L.LL.LLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLL.L.LLLL.LLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLL.LLLLLLLL.LL.LLLLLL.LLLLLLLLLLLLLL..LLLLLLLLL.LLLLLLLLL.LLLL.L.LLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLL.L.LLL.LLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.L.LLLLLLL.LLLLLLLLLL.LLLL.LLLL.LLLL.LLLLLLLLL.LLLLLL..LLLL.LLLLL.LLLLLLLLL\n"
                + "...L.....LL.L...L......LL..L.....LL.L...L..L...L....L......L....L......L.LL..L........L.......L\n"
                + "LLLLLLLL..L.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLLLLL..LLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL.L.LLLLLLL\n"
                + "LLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLL.LL..LLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLL.L\n"
                + "LLLLLLLLLLLL.LLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLL..LLLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLLLLLLL\n"
                + "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLL\n"
                + "....L..L....L....L..L..LL.L......LL..LLL..L.L.L.LL......L.LLLL.L...LLL...L.....L.L.L.L.LLLL....\n"
                + "L.LLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLL..LLLL.LLL..LLLLLLLLL.LLLLLLLLLLL..LLLLLLLLLLLL.LL\n"
                + "L.L.L.LLLLLLLLLLLL.LLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLL..LLLLLLLLL.LLLLLL.L..LL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLLLLLLLLLLLLL.LLLLL.L.LLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLL.LLL\n"
                + "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL..LLLLLLLLLLLL.LLLLL.LLL\n"
                + "LLLLL.LLLLLLLLLLLL...LLL.LLLLLLLLLLL.LLLLLLLLL.LLLLL.LLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LL.LLLLLLLLLLLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL..LLLLLLLL\n"
                + ".L.LLLL..L.........LLL...L..L.L..LLL....LL...L..L......LL...L...L...L...L.....LLL.L...L.L..LLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLLLLLLLLL.L.LLLLLLLLLL.L.LL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLL.LLLLLLLLL.L.LLLLLLLLL\n"
                + "LLLLLLL.LLL.L.LLLLLL.LLLLLLLLL.L.LLL.LLLLLLLLL..LLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLL.LL.LLLLLLLLL.L.LLL.L.LLLLLLLLLL.LLLLLL.LLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLL\n"
                + "LLLLL.L.L.LLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LL.L.LLL.LLLLLLLLLLLL.LL.LL.LL.LLLLLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLL..LLLLLLL.L.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLL..LLLLLLLLL.LLLLLLLL..LLLL.LLLL.LLLLLLLLL.LL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LL.LLL.LL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL\n"
                + "LLLLLLLLLLL.LLLLLLLL.LLLLLL.LL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLL\n"
                + ".L.....L..LL.L.L.L.LL.L.L..L...L...L....LL.L..L.L..L...L..L.L.L..L........L.L.L.L..L.LL.L.L....\n"
                + "LLLLL.LLLLL.LLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLL..LLLLLLLL.LL.LLLLLLLLL.LLLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLL.LLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLLLLLLL.L.LLLLL.LL.LL.LLLLLLLLL\n"
                + "LLLL.LLLLLL.LLLLLLL..LL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LL.LLL.LLLLL..LLLL.LLLLLLLLL\n"
                + ".LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL\n"
                + "LLLLLLLLLLLLLL.LLLLL.L.LLLLLLL.LLLLL..LLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLL.LL..LLLLL\n"
                + "LLLLL.LLLLLLL.L.LLLL.LLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLL..LLLLL.LLLL.LLL.\n"
                + "LLLLLLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLL.LLLLLLLLLL.LLLLLLL.LLLLL.LLL\n"
                + "..L..LLLL....L...L.L.L....L.....LL..L.....L..L............L.L....L.L..L.LL...L.L........L...L..\n"
                + "LLLLL..LLLLLLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLL..LLL.LLLL\n"
                + "LLLLL.LLLLL.LLLLLLLL.LLLLLL.LL.LLLLLLL.LLLLLLL.LLLLLLLLL.LL.LLL.LL.LLLLLL..LLLL.LLLLLLLLLLLLLLL\n"
                + "LLLLL.LLLLLLLL.LLLLL.LL.LLLLL..LLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLL\n"
                + "LLLLL.LLL.LLLLLLLLL..LLLLLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLL\n"
                + "LLLLL.LLLLL.L.LLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL.LL.LL.LLLL.LLLL";

        return Arrays.stream(inputStr.split("\n"))
                .map(line -> line.toCharArray())
                .collect(Collectors.toList())
                .toArray(new char[0][0]);
    }
}
