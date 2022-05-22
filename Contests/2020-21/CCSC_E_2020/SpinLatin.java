import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class SpinLatin {
    static int THRESHOLD = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());

        while (x > 0) {
            String word = scanner.nextLine();
            LinkedList<Character> queue = new LinkedList<>();
            HashMap<Character, TreeSet<Character>> mapping = new HashMap<>();
            HashMap<Character, Integer> count = new HashMap<>();

            Character last = null;
            for (Character next : word.toCharArray()) {
                queue.add(next);
                count.compute(next, (k, v) -> 0);
                if (last == null) {
                    last = next;
                    continue;
                }
                if (!mapping.containsKey(last))
                    mapping.put(last, new TreeSet<>());
                mapping.get(last).add(next);
                last = next;
            }

            mapping.putIfAbsent(last, new TreeSet<>());
            StringBuilder translation = new StringBuilder();
            while (queue.size() > 0) {
                Character current = queue.pop();
                if (count.get(current) < THRESHOLD) {
                    count.computeIfPresent(current, (k, v) -> v + 1);
                    translation.append(current);
                }
                if (count.get(current) >= THRESHOLD)
                    continue;
                for (Character next : mapping.get(current).descendingSet()) {
                    if (count.get(next) >= THRESHOLD)
                        continue;
                    queue.push(next);
                }
            }

            System.out.println(translation.toString());
            x--;
        }
    }
}
