class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;

        Map<String, List<String>> graph = new HashMap<>(); // word -> list of parents
        Set<String> visited = new HashSet<>();
        Set<String> currentLevel = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        visited.add(beginWord);
        boolean foundEnd = false;

        while (!queue.isEmpty() && !foundEnd) {
            int size = queue.size();
            currentLevel.clear();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char original = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        if (!wordSet.contains(nextWord) || nextWord.equals(word)) continue;

                        if (!visited.contains(nextWord)) {
                            if (!currentLevel.contains(nextWord)) {
                                queue.offer(nextWord);
                                currentLevel.add(nextWord);
                            }
                            graph.computeIfAbsent(nextWord, k -> new ArrayList<>()).add(word);
                        }
                        if (nextWord.equals(endWord)) foundEnd = true;
                    }
                    wordChars[j] = original;
                }
            }
            visited.addAll(currentLevel);
        }

        if (!foundEnd) return res;

        List<String> path = new LinkedList<>();
        path.add(endWord);
        backtrack(res, graph, path, endWord, beginWord);
        return res;
    }

    private void backtrack(List<List<String>> res, Map<String, List<String>> graph, List<String> path, String word, String beginWord) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        if (graph.get(word) == null) return;

        for (String parent : graph.get(word)) {
            path.add(parent);
            backtrack(res, graph, path, parent, beginWord);
            path.remove(path.size() - 1);
        }
    }
}
