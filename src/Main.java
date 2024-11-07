import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static LinkedList<int[][]> queue = new LinkedList<>();
    public static final int[][] goal_state = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    private static Set<List<List<Integer>>> seenStates = new HashSet<>();

    public static void BFS(int[][] a) {
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
                queue.add(fringe);
            }
        }

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

        if (--limit == 0) {
            return;
        }

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

    public static void main(String[] args) {

        int[][] initial_state = new int[3][3];
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                initial_state[i][j]=numbers.get(index);
                index++;
            }
        }

        //Print initial state
        System.out.println("Initial State:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(initial_state[i][j]);
            }
            System.out.println();
        }
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Please choose search algorithm for find out the goal state
                
                1-BFS
                2-DFS
                3-DFS(Limited)""");

        String choose = scanner.nextLine();

        if (choose.equals("1")) {
            System.out.println("Breadth First Search algorithm is selected");
            queue.add(initial_state);
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();

                //Print current state
                /*for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(currentState[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("---");
                */

                if (CheckingState(currentState)) {
                    System.out.println("Goal State is founded");
                    break;
                }

                BFS(currentState);
            }
        } else if (choose.equals("2")) {
            System.out.println("Depth First Search algorithm is selected");
            queue.add(initial_state);
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();

                //Print current state
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(currentState[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("---");


                if (CheckingState(currentState)) {
                    System.out.println("Goal State is founded");
                    break;
                }

                DFS(currentState);

            }
        } else if (choose.equals("3")) {
            System.out.println("DFS(Limited) search algorithm is selected");
            queue.add(initial_state);
            while (!queue.isEmpty()) {
                int[][] currentState = queue.removeFirst();

                //Print current state
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(currentState[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("---");

                if (CheckingState(currentState)) {
                    System.out.println("Goal State is founded");
                    break;
                } else {
                    System.out.println("Goal state is not founded");
                }

                DFSLimited(currentState, 3);
            }
        } else {
            System.out.println("Error: Input is not correct");
        }

    }
}
