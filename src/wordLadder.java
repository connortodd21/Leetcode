import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wordLadder {
    class Word {
        String word;
        int length;

        Word(String word, int length){
            this.word = word;
            this.length = length;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(beginWord, 1));
        wordList.add(endWord);
        while (!queue.isEmpty()){
            Word top = queue.remove();
            String word = top.word;
            if (word.equals(endWord)){
                return top.length;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < beginWord.length(); i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    char temp = arr[i];
                    if (arr[i] != j){
                        arr[i] = j;
                    }
                    String newWord = new String(arr);
                    if (wordList.contains(newWord)){
                        queue.add(new Word(newWord, top.length+1));
                        wordList.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}
