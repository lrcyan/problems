/**
 * The method read(buf, n) reads n characters, given a method read4 that tries to read 4 characters into an array, returns the number of characters successfully read, and is
 * defined as follows in a class Reader4:
 *
 *     int read4(char[] buf4); 
 * 
 * The method can be called arbitrarily many times.
 */

public class Readk extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    LinkedList<Character> queue;
    
    public int read(char[] buf, int n) {
        if (queue == null) queue = new LinkedList<Character>();
        int numRead = 0;
        
        while (numRead < n) {
            if (queue.isEmpty()) readIntoQueue();
            if (queue.isEmpty()) break;
            
            buf[numRead] = (char)queue.pop();
            numRead++;
        }
        
        return numRead;
    }
    
    void readIntoQueue() {
        char[] buf4 = new char[4];
        int numRead = read4(buf4);
        
        for (int i = 0; i < numRead; i++) queue.addLast((Character)buf4[i]);
    }
}
