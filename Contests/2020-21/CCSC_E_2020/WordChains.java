import java.util.*;
import java.util.stream.Collectors;

public class WordChains {
    static final String DELIM = " ";

    static int minDepth;
    static HashMap<String, HashSet<String>> wordmap;
    static HashSet<String> usedWords = new HashSet<>();
    static List<String> outputList;

    public static void dfs(String word, String out, int depth) {
        usedWords.add(word);
        for (String newWord : wordmap.get(word)) {
            if (!usedWords.contains(newWord)) {
                dfs(newWord, out + newWord + DELIM, depth + 1);
            }
        }
        if (depth >= minDepth) {
            outputList.add(out.substring(0, out.length() - DELIM.length()));
        }
        usedWords.remove(word);
    }

    public static boolean isOneEditDistance(String m, String n) {
        int mLen = m.length(), nLen = n.length();
        if (Math.abs(mLen - nLen) > 1)
            return false;
        int i = 0, j = 0, count = 0;
        while (i < mLen && j < nLen) {
            if (m.charAt(i) == n.charAt(j)) {
                i++;
                j++;
            } else {
                if (++count > 1)
                    return false;
                i += mLen >= nLen ? 1 : 0;
                j += mLen <= nLen ? 1 : 0;
            }
        }
        if (i < mLen || j < nLen)
            count++;
        return count == 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("quit")) {
            outputList = new ArrayList<>();
            String[] raw = line.split(" ");
            minDepth = Integer.parseInt(raw[0]);
            wordmap = new HashMap<>();

            HashSet<String> words = new HashSet<>(Arrays.asList(raw).subList(1, raw.length));
            for (String word : words) {
                wordmap.put(word, words.stream()
                        .filter(x -> !x.equals(word))
                        .filter(x -> isOneEditDistance(word, x))
                        .collect(Collectors.toCollection(HashSet::new)));
            }

            for (String word : wordmap.keySet())
                dfs(word, word + DELIM, 1);

            Collections.sort(outputList);
            for (String out : outputList)
                System.out.println(out);

            System.out.println("Done");
            line = scanner.nextLine();
        }
    }
}
