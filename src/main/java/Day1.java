package main.java;

import java.util.HashSet;

public class Day1 {
    public static String PUZZLE = "R5, L2, L1, R1, R3, R3, L3, R3, R4, L2, R4, L4, R4, R3, L2, L1, L1, R2, R4, R4, L4, R3, L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2, R2, L1, L4, R191, R5, L2, R46, R3, L1, R74, L2, R2, R187, R3, R4, R1, L4, L4, L2, R4, L5, R4, R3, L2, L1, R3, R3, R3, R1, R1, L4, R4, R1, R5, R2, R1, R3, L4, L2, L2, R1, L3, R1, R3, L5, L3, R5, R3, R4, L1, R3, R2, R1, R2, L4, L1, L1, R3, L3, R4, L2, L4, L5, L5, L4, R2, R5, L4, R4, L2, R3, L4, L3, L5, R5, L4, L2, R3, R5, R5, L1, L4, R3, L1, R2, L5, L1, R4, L1, R5, R1, L4, L4, L4, R4, R3, L5, R1, L3, R4, R3, L2, L1, R1, R2, R2, R2, L1, L1, L2, L5, L3, L1";
//    public static String PUZZLE = "R8, R4, R4, R8";
    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static void dayOne() {
        String[] directions = PUZZLE.split(", ");

        partOne(directions);
        partTwo(directions);
    }

    public static int partTwo(String[] directions) {
        int x = 0, y = 0;
        int dir = 0;

        HashSet<String> visited = new HashSet<>();

        for (String direction : directions) {
//            System.out.println(direction.charAt(0) + ", " + direction.substring(1));
            if (direction.charAt(0) == 'L') {
                dir = (dir + 3) % 4;
            } else if (direction.charAt(0) == 'R') {
                dir = (dir + 1) % 4;
            } else {
                System.out.println("input is invalid");
                return -1;
            }

            int distance = Integer.parseInt(direction.substring(1));

            for (int i = 0; i < distance; i++) {
                x += dirX[dir];
                y += dirY[dir];

                String cur = "x" + x + "y" + y;

                if (visited.contains(cur)) {
                    int res = Math.abs(x) + Math.abs(y);
                    System.out.println("Part Two: " + res);
                    return res;
                } else {
                    visited.add(cur);
                }
            }
        }
        int res = Math.abs(x) + Math.abs(y);
        System.out.println("Part Two: " + res);
        return res;
    }

    public static int partOne(String[] directions) {
        int x = 0, y = 0;
        int dir = 0;

        for (String direction : directions) {
//            System.out.println(direction.charAt(0) + ", " + direction.substring(1));
            if (direction.charAt(0) == 'L') {
                dir = (dir + 3) % 4;
            } else if (direction.charAt(0) == 'R') {
                dir = (dir + 1) % 4;
            } else {
                System.out.println("input is invalid");
                return -1;
            }

            int distance = Integer.parseInt(direction.substring(1));

            x += dirX[dir] * distance;
            y += dirY[dir] * distance;
        }

        int res = Math.abs(x) + Math.abs(y);
        System.out.println("Part One: " + res);
        return res;
    }
}
