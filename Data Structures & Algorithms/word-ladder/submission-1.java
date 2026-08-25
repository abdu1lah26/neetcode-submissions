class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Set<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                String word = q.poll();

                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c)
                            continue;

                        chars[j] = c;

                        String variation = new String(chars);

                        if (set.contains(variation)) {
                            if (variation.equals(endWord))
                                return level + 1;

                            set.remove(variation);
                            q.offer(variation);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
