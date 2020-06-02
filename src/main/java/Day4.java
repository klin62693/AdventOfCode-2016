package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day4 {
    public static void dayFour() {
        List<String> rooms = new ArrayList<>();

        try {
            FileReader fr = new FileReader(new File("src/main/resources/Day4.txt"));
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            while ((line = br.readLine()) != null) {
                rooms.add(line);
            }
        } catch (IOException e) {
            System.out.println("file not found");
        }

        partOne(rooms);

        String target = "northpoleobjectstorage";
        partTwo(rooms, target);
    }

    public static int partOne(List<String> rooms) {
        List<Integer> validRoom = new ArrayList<>();

        rooms.forEach(room -> {
            String[] r = room.split("-");
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < r.length - 1; i++) {
                for (char c : r[i].toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }

            StringBuilder nameValidation = new StringBuilder();

            map.entrySet().stream()
                    .sorted(new Comparator<Map.Entry<Character, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                            if (a.getValue().equals(b.getValue())) {
                                return a.getKey() - b.getKey();
                            } else {
                                return b.getValue() - a.getValue();
                            }
                        }
                    })
                    .forEach(m -> nameValidation.append(m.getKey()));


            String lastElement = r[r.length - 1];
            int splitIndex = lastElement.indexOf("[");

            if (splitIndex == -1 ) {
                System.out.println("Day4 Part One Invalid input");
                return;
            }

            String id = lastElement.substring(0, splitIndex);
            String checksum = lastElement.substring(splitIndex + 1, lastElement.length() - 1);

            if ((nameValidation.toString().substring(0, 5)).equals(checksum.substring(0, 5))) {
                validRoom.add(Integer.valueOf(id));
            }
        });

        if (validRoom.isEmpty()) {
            return -1;
        }

        int result = validRoom.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Day4 Part One Result: " + result);

        return result;
    }

    public static int partTwo(List<String> rooms, String target) {
        int[] res = new int[1];
        res[0] = -1;

        rooms.forEach(room -> {
            String[] r = room.split("-");

            String lastElement = r[r.length - 1];
            int splitIndex = lastElement.indexOf("[");

            if (splitIndex == -1 ) {
                System.out.println("Day4 Part Two Invalid input");
                return;
            }

            String id = lastElement.substring(0, splitIndex);

            StringBuilder name = new StringBuilder();

            for (int i = 0; i < r.length - 1; i++) {
                name.append(r[i]);
            }

            StringBuilder validation = new StringBuilder();

            for (char c : name.toString().toCharArray()) {
                validation.append((char)((c - 'a'+ Integer.parseInt(id)) % 26 + 'a'));
            }

            // System.out.println(validation.toString());
            if (validation.toString().equals(target)) {
                res[0] = Integer.parseInt(id);
                System.out.println("Day4 Part Two Result: " + id);
                return;
            }
        });

        return res[0];
    }
}