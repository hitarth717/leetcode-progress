
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        words.remove(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return count;
                }

                char[] letters = word.toCharArray();

                for (int j = 0; j < letters.length; j++) {

                    char old = letters[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        letters[j] = ch;
                        String newWord = new String(letters);

                        if (words.contains(newWord)) {
                            queue.add(newWord);
                            words.remove(newWord);
                        }
                    }

                    letters[j] = old;
                }
            }

            count++;
        }

        return 0;
    }
}
