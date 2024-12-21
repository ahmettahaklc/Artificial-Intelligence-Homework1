package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main extends AlgorithmUtils{

    public static void main(String[] args) {
        int size = 0;
        LinkedList<int[][]> initialStates = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < 10; i++) {
            int index = 0;
            int[][] initial_state = new int[3][3];
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                numbers.add(j);
            }
            Collections.shuffle(numbers);

            // Fill initial state matrix with shuffled numbers
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    initial_state[k][j] = numbers.get(index);
                    index++;
                }
            }
            initialStates.add(initial_state);
        }

        System.out.println("Initial States are created");

        // Run all search algorithms for each initial state
        for (int i = 0; i < 10; i++) {
            System.out.println("Breadth First Search algorithm is started");
            queue.add(initialStates.get(i));
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();
                numberOfStep++;
                if (CheckingState(currentState)) {
                    System.out.println("Goal State is found");
                    size = queue.size();
                    found = true;
                    break;
                }
                BFS(currentState);
            }
            if (!found) {
                System.out.println("Breadth First Search could not found goal state");
                size = numberOfStep;
            }
            System.out.println("Maximum size of fringe: "+ size);
            System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);

            numberOfStep=0;
            queue.clear();
            seenStates.clear();
            found=false;
            System.out.println();

            System.out.println("Depth First Search algorithm is started");
            queue.add(initialStates.get(i));
            while (!queue.isEmpty()) {
                numberOfStep++;
                int[][] currentState = queue.removeFirst();
                if (CheckingState(currentState)) {
                    size = queue.size();
                    System.out.println("Goal State is founded");
                    found = true;
                    break;
                }
                DFS(currentState);
            }
            if (!found) {
                System.out.println("Depth First Search could not found goal state");
                size = numberOfStep;
            }
            System.out.println("Maximum size of fringe: "+size);
            System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);

            numberOfStep=0;
            queue.clear();
            seenStates.clear();
            found=false;
            System.out.println();

            System.out.println("DFS(Limited) search algorithm is started");
            queue.add(initialStates.get(i));
            int[][] currentState = queue.removeFirst();
            DFSLimited(currentState, 10);
            while (!queue.isEmpty()) {
                numberOfStep++;
                currentState = queue.removeFirst();
                if (CheckingState(currentState)) {
                    size = queue.size();
                    System.out.println("Goal State is found");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Depth First Search(Limited) could not found goal state");
                size = numberOfStep;
            }
            System.out.println("Maximum size of fringe: "+size);
            System.out.println("Number of nodes expanded for solved problems:" + --numberOfStep);

            numberOfStep=0;
            queue.clear();
            seenStates.clear();
            found=false;
            System.out.println();

            System.out.println("Iterative Deepening Search algorithm is started");
            IterativeDeepeningSearch(10, initialStates.get(i));

            numberOfStep=0;
            queue.clear();
            seenStates.clear();
            found=false;
            System.out.println();

            System.out.println("------------------------------------------");
            System.out.println();

        }
    }
}