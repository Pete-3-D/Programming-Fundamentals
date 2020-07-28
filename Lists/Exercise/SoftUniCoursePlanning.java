import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> schedule = Arrays.stream(scan.nextLine().split(",\\s+"))
                                .collect(Collectors.toList());
        String input = scan.nextLine();

        while (!"course start".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add": {
                    String lessonTitle = tokens[1];
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                }
                    break;
                case "Insert": {
                    String lessonTitle = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                }
                    break;
                case "Remove": {
                    String lessonTitle = tokens[1];
                    String exercise = lessonTitle + "-Exercise";

                    if (schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                    }

                    if (schedule.contains(exercise)) {
                        schedule.remove(exercise);
                    }
                }
                    break;
                case "Swap": {
                    String firstLesson = tokens[1];
                    String secondLesson = tokens[2];

                    if (schedule.contains(firstLesson) && schedule.contains(secondLesson)) {
                        int firstIndex = schedule.indexOf(firstLesson);
                        int secondIndex = schedule.indexOf(secondLesson);

                        schedule.set(firstIndex, secondLesson);
                        schedule.set(secondIndex, firstLesson);

                        String firstExercise = firstLesson + "-Exercise";
                        String secondExercise = secondLesson + "-Exercise";

                        if (schedule.contains(firstExercise)) {
                            schedule.remove(firstExercise);
                            schedule.add(secondIndex + 1, firstExercise);
                        }

                        if (schedule.contains(secondExercise)) {
                            schedule.remove(secondExercise);
                            schedule.add(firstIndex + 1, secondExercise);
                        }
                    }
                    break;
                }
                case "Exercise": {
                    String lessonTitle = tokens[1];
                    String exercise = lessonTitle + "-Exercise";
                    if (schedule.contains(lessonTitle)) {
                        int index = schedule.indexOf(lessonTitle);
                        if (!schedule.contains(exercise)) {
                            schedule.add(index + 1, exercise);
                        }
                    } else {
                        schedule.add(lessonTitle);
                        int index = schedule.indexOf(lessonTitle);
                        schedule.add(index + 1, exercise);
                    }
                    break;
                }
            }

            input = scan.nextLine();
        }

        printList(schedule);
    }

    private static void printList(List<String> schedule) {
        for (int i = 0; i < schedule.size(); i++) {
            String currentLesson = schedule.get(i);
            System.out.printf("%d.%s%n", i+1, currentLesson);
        }
    }
}
