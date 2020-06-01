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

        partOne(bots);
        partTwo(bots);
    }

    private static void partOne(List<String> bots) {
        Map<Integer, Bot> botMap = buildBotMap(bots);
//         botMap.forEach((key, value) -> System.out.println(key + ", " + value.toString()));

        int value1 = 61, value2 = 17;
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

        int matchingBot = botMap.entrySet().stream()
                .filter(bot -> bot.getValue().values.size() == 2
                        && bot.getValue().values.contains(value1)
                        && bot.getValue().values.contains(value2))
                .findFirst()
                .map(Map.Entry::getKey)
                .get();

        System.out.println("Part One: " + matchingBot);
    }

    private static void partTwo(List<String> bots) {
        Map<Integer, Bot> botMap = buildBotMap(bots);

        Map<Integer, Integer> outputs = new HashMap<>();

        // Process
        while (!outputs.containsKey(0) || !outputs.containsKey(1) || !outputs.containsKey(2)) {

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

        System.out.println("Part Two: " + outputs.get(0) * outputs.get(1) * outputs.get(2));
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
            } else {
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

        return botMap;
    }
}
