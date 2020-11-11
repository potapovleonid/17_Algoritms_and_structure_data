package geekbrains.home.des;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Anagramm {

    private final char[] chars;
    private String word;
    private Set<String> anagramms = new LinkedHashSet<>();

    public static void main(String[] args) {
        Anagramm anagramm = new Anagramm("мышка");
        Collection<String> words = anagramm.getAnagramm();
        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }

    public Anagramm(String word) {
        this.word = word;
        this.chars = word.toCharArray();
    }

    private Collection<String> getAnagramm(){
        anagramms.clear();
        processAnagramm(word.length());
        return anagramms;
    }

    private void processAnagramm(int length) {
        if (length == 1){
            return;
        }

        for (int i = 0; i < length; i++) {
            processAnagramm(length-1);
            anagramms.add(String.valueOf(chars));
            swap(length);
        }
    }

    private void swap(int length) {
        int pos = word.length() - length;
        char temp = chars[pos];
        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }
}
