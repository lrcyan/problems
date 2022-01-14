import java.util.*;


/**
 * The StreamChecker object is to be instantiated and called as:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

class StreamChecker {
    SuffixTrie root;
    SuffixTrie curr;
    String buffer;
    int MAX_STRING_LENGTH;
    
    public StreamChecker(String[] words) {
        root = new SuffixTrie();
        for (String word : words) root.add(word);
        
        curr = root;
        buffer = "";
        MAX_STRING_LENGTH = 2000;
    }
    
    public boolean query(char letter) {
        if (buffer.length() == MAX_STRING_LENGTH) buffer = buffer.substring(1, MAX_STRING_LENGTH);
        buffer = buffer + letter;
        curr = root;
        
        if (!curr.children.containsKey((Character)letter)) return false; 
        else curr = (SuffixTrie)curr.children.get((Character)letter);
        
        if (curr.children.containsKey((Character)'\0')) return true;
        
        for (int i = buffer.length() - 2; i >= 0; i--) {
            if (curr.children.containsKey((Character)buffer.charAt(i))) curr = (SuffixTrie)curr.children.get((Character)buffer.charAt(i));
            else break;
            
            if (curr.children.containsKey((Character)'\0')) return true;
        }
        return false;
    }
}


class SuffixTrie {
    HashMap<Character, SuffixTrie> children;
    
    public SuffixTrie(String[] words) {
        children = new HashMap<Character, SuffixTrie>();
        for (String word : words) add(word);
    }
    
    public SuffixTrie() {
        children = new HashMap<Character, SuffixTrie>();
    }
    
    void add(String word) {
        SuffixTrie curr = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (!curr.children.containsKey((Character)word.charAt(i))) {
                curr.children.put((Character)word.charAt(i), new SuffixTrie());
            }
            curr = (SuffixTrie)(curr.children.get((Character)word.charAt(i)));
        }
        if (!curr.children.containsKey((Character)'\0')) {
            curr.children.put((Character)'\0', null);
        }
    }
}
