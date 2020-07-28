import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, Integer> contest = new HashMap<>();
        Map<String, Integer> contestCount = new HashMap<>();
        List<String> banned = new ArrayList<>();

        while (!"exam finished".equals(input)) {
            String[] tokens = input.split("-");
            String user = tokens[0];

            if ("banned".equals(tokens[1])) {
                banned.add(user);
                input = scan.nextLine();
                continue;
            }

            String language = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            if (!contestCount.containsKey(language)) {
                contestCount.put(language, 0);
            }

            if (!contest.containsKey(user))
                contest.put(user, points);
            else {
                if (contest.get(user) < points)
                    contest.put(user, points);
            }

            contestCount.put(language, contestCount.get(language) + 1);

            input = scan.nextLine();
        }

        System.out.println("Results:");
        contest.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = Integer.compare(i2.getValue(), i1.getValue());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                        if (!banned.contains(entry.getKey()))
                            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
                });

        System.out.println("Submissions:");
        contestCount.entrySet()
                .stream()
                .sorted((i1, i2) -> {
                    int result = Integer.compare(i2.getValue(), i1.getValue());
                    if (result == 0) {
                        result = i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}

