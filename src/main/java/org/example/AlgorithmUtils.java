package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class AlgorithmUtils {

    public static int numberOfStep=0;
    public static LinkedList<int[][]> queue = new LinkedList<>();
    public static final int[][] goal_state = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    public static Set<List<List<Integer>>> seenStates = new HashSet<>();

    public static void BFS(int[][] a) {

        // Locate the blank space (0) in the current state
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        // Move the blank up if possible, check uniqueness
        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;

            // Check if this state is unique; if so, add it to the queue.
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank down if possible, check uniqueness
        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank left if possible, check uniqueness
        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }

        // Move the blank right if possible, check uniqueness
        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            if (isUnique(fringe)) {
                queue.add(fringe);
            }
        }
    }

    public static void DFS(int[][] a) {
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        // Move the blank up if possible, check uniqueness
        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
            }
        }

        // Move the blank down if possible, check uniqueness
        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
            }
        }

        // Move the blank left if possible, check uniqueness
        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
            }
        }

        // Move the blank right if possible, check uniqueness
        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
            }
        }
    }

    public static void DFSLimited(int[][] a, int limit) {

        // Locate the blank space (0) in the current state
        int column = 0;
        int line = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 0) {
                    line = i;
                    column = j;
                }
            }
        }

        // Return if depth limit is reached
        if (--limit == 0) {
            return;
        }

        // Move the blank up if possible, check uniqueness, and recursively continue DFS
        if (line > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line - 1][column];
            fringe[line - 1][column] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
                DFSLimited(fringe, limit);
            }
        }

        // Move the blank down if possible, check uniqueness, and continue DFS
        if (line < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line + 1][column];
            fringe[line + 1][column] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
                DFSLimited(fringe, limit);
            }
        }

        // Move the blank left if possible, check uniqueness, and continue DFS
        if (column > 0) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column - 1];
            fringe[line][column - 1] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
                DFSLimited(fringe, limit);
            }
        }

        // Move the blank right if possible, check uniqueness, and continue DFS
        if (column < 2) {
            int[][] fringe = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    fringe[i][j] = a[i][j];
                }
            }
            fringe[line][column] = fringe[line][column + 1];
            fringe[line][column + 1] = 0;
            if (isUnique(fringe)) {
                queue.addFirst(fringe);
                DFSLimited(fringe, limit);
            }
        }
    }

    // Iterative Deepening Search with increasing depth limit
    public static void IterativeDeepeningSearch(int limit, int[][] initialState) {
        int increaseLimit = limit;
        while (true) {
            queue.add(initialState);
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();

                if (CheckingState(currentState)) {
                    System.out.println("Goal State is founded");
                    System.out.println("Maximum size of fringe: "+queue.size());
                    System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);
                    return;
                }

                DFSLimited(currentState, limit);
                numberOfStep++;
            }
            limit += increaseLimit;
            if (limit == 500) { // Exit condition if limit reaches 500
                System.out.println("Iterative Deepening Search could not found goal state");
                System.out.println("Maximum size of fringe: "+numberOfStep);
                System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);
                return;
            }
        }

    }

    // Check if a given state is unique in seen states
    public static boolean isUnique(int[][] state) {
        // Convert the 2D array to a list of lists for easy hashing and equality checking
        List<List<Integer>> stateAsList = Arrays.stream(state)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        // Check if the state is already in the set
        if (seenStates.add(stateAsList)) {
            // If it's unique, add it to both the queue and the set
            queue.add(state);
            return true;
        }
        return false;
    }

    // Check if the current state matches the goal state
    public static boolean CheckingState(int[][] currentState) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (goal_state[i][j] != currentState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
