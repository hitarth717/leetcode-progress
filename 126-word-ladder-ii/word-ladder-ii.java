
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();

        currentLevel.add(beginWord);
        words.remove(beginWord);

        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {

            Set<String> nextLevel = new HashSet<>();

            for (String word : currentLevel) {

                char[] letters = word.toCharArray();

                for (int i = 0; i < letters.length; i++) {

                    char original = letters[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        if (ch == original) continue;

                        letters[i] = ch;
                        String newWord = new String(letters);

                        if (words.contains(newWord)) {

                            if (newWord.equals(endWord)) {
                                found = true;
                            }

                            nextLevel.add(newWord);

                            parents.computeIfAbsent(newWord, k -> new ArrayList<>())
                                   .add(word);
                        }
                    }

                    letters[i] = original;
                }
            }

            words.removeAll(nextLevel);
            currentLevel = nextLevel;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            buildPaths(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void buildPaths(String word, String beginWord,
                            Map<String, List<String>> parents,
                            List<String> path,
                            List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> answer = new ArrayList<>(path);
            Collections.reverse(answer);
            result.add(answer);
            return;
        }

        for (String parent : parents.getOrDefault(word, new ArrayList<>())) {

            path.add(parent);

            buildPaths(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}
