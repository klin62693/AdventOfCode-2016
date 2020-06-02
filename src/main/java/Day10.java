package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day10 {
    public static class Bot {
        private List<Integer> values;
        private boolean isLowBot;
        private int low;
        private boolean isHighBot;
        private int high;

        Bot() {
            this.values = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Bot{" +
                    "values=" + values +
                    ", isLowBot=" + isLowBot +
                    ", low=" + low +
                    ", isHighBot=" + isHighBot +
                    ", high=" + high +
                    '}';
        }
    }

    public static void dayTen() {
        List<String> bots = new ArrayList<>();

        try {
            FileReader fr = new FileReader(new File("src/main/resources/Day10.txt"));
            BufferedReader br = new BufferedReader(fr);

            String line = "";

            while ((line = br.readLine()) != null) {
                bots.add(line);
            }
        } catch (IOException e) {
            System.out.println("file not found");
        }

        int value1 = 61, value2 = 17;
        partOne(bots, value1, value2);

        int output1 = 0, output2 = 1, output3 = 2;
        partTwo(bots, output1, output2, output3);
    }

    public static int partOne(List<String> bots, int value1, int value2) {
        Map<Integer, Bot> botMap = buildBotMap(bots);

        while (botMap.values().stream()
                .noneMatch(bot -> bot.values.size() == 2 && bot.values.contains(value1) && bot.values.contains(value2))) {
            List<Integer> botsWithTwoChips = botMap.entrySet().stream()
                    .filter(bot -> bot.getValue().values.size() == 2)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            for (int botNumber : botsWithTwoChips) {
                Bot bot = botMap.get(botNumber);
                int low = bot.values.stream().mapToInt(e -> e).min().getAsInt();
                int high = bot.values.stream().mapToInt(e -> e).max().getAsInt();

                if (bot.isLowBot) {
                    botMap.get(bot.low).values.add(low);
                }
                if (bot.isHighBot) {
                    botMap.get(bot.high).values.add(high);
                }

                bot.values.clear();
            }
        }

        int res = botMap.entrySet().stream()
                .filter(bot -> bot.getValue().values.size() == 2
                        && bot.getValue().values.contains(value1)
                        && bot.getValue().values.contains(value2))
                .findFirst()
                .map(Map.Entry::getKey)
                .get();

        System.out.println("Day10 Part One Result: " + res);
        return res;
    }

    public static int partTwo(List<String> bots, int output1, int output2, int output3) {
        Map<Integer, Bot> botMap = buildBotMap(bots);
        Map<Integer, Integer> outputs = new HashMap<>();

        while (!outputs.containsKey(output1) || !outputs.containsKey(output2) || !outputs.containsKey(output3)) {
            List<Integer> botsWithTwoChips = botMap.entrySet().stream()
                    .filter(bot -> bot.getValue().values.size() == 2).map(Map.Entry::getKey).collect(Collectors.toList());

            for (int botNum : botsWithTwoChips) {
                Bot bot = botMap.get(botNum);
                int low = bot.values.stream().mapToInt(e -> e).min().getAsInt();
                int high = bot.values.stream().mapToInt(e -> e).max().getAsInt();

                if (bot.isLowBot) {
                    botMap.get(bot.low).values.add(low);
                } else {
                    outputs.putIfAbsent(bot.low, low);
                }
                if (bot.isHighBot) {
                    botMap.get(bot.high).values.add(high);
                } else {
                    outputs.putIfAbsent(bot.high, high);
                }

                bot.values.clear();
            }
        }

        int res = outputs.get(output1) * outputs.get(output2) * outputs.get(output3);
        System.out.println("Day10 Part Two Result: " + res);

        return res;
    }

    private static Map<Integer, Bot> buildBotMap(List<String> bots) {
        Map<Integer, Bot> botMap = new HashMap<>();

        bots.forEach(b -> {
            String[] bot = b.split(" ");

            if (bot[0].equals("value")) {
                int value = Integer.parseInt(bot[1]);
                int botNum = Integer.parseInt(bot[bot.length - 1]);

                if (!botMap.containsKey(botNum)) {
                    botMap.put(botNum, new Bot());
                }
                botMap.get(botNum).values.add(value);
            } else if (bot[0].equals("bot")) {
                int bot1 = Integer.parseInt(bot[1]);
                boolean isLowBot = bot[5].equals("bot");
                int bot2 = Integer.parseInt(bot[6]);
                boolean isHighBot = bot[10].equals("bot");
                int bot3 = Integer.parseInt(bot[bot.length - 1]);

                if (!botMap.containsKey(bot1)) {
                    botMap.put(bot1, new Bot());
                }

                botMap.get(bot1).isLowBot = isLowBot;
                botMap.get(bot1).low = bot2;
                botMap.get(bot1).isHighBot = isHighBot;
                botMap.get(bot1).high = bot3;
            }
        });

//        botMap.forEach((key, value) -> System.out.println(key + ", " + value.toString()));
        return botMap;
    }
}
