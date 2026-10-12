class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);//We use this for more optimization as before we got TLE-->Time Limit Exceeded

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);

        int length = 1;//we dont have to increment it in the loop now

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return length;
                }

                char[] temp = current.toCharArray();

                for (int j = 0; j < temp.length; j++) {
                    char original = temp[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) {
                            continue;//if the same character then we simply move on
                        }

                        temp[j] = c;
                        String newWord = new String(temp);

                        if (words.contains(newWord)) {
                            queue.offer(newWord);
                            words.remove(newWord);
                        }
                    }

                    temp[j] = original;//then we backtrack our actions because we only need a single change right?
                }
            }
            length++;
        }

        return 0;
    }
}
