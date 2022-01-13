import java.util.*;

class AlienDict {
    public String alienOrder(String[] words) {
        HashMap<Character, Node> adj = new HashMap<Character, Node>();
        HashSet<Character> chars = new HashSet<Character>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) chars.add(s.charAt(i));
        }
        Iterator iter = chars.iterator();
        while (iter.hasNext()) {
            Character next = (Character)iter.next();
            adj.put(next, new Node(next));
        }
        
        for (int i = 1; i < words.length; i++) {
            try {
                Edge e = getEdge(words[i - 1], words[i]);
                if (e != null) {
                    if (!adj.get(e.a).outCont.contains(e.b)) {
                        adj.get(e.a).out.add((Node)adj.get(e.b));
                        adj.get(e.a).outCont.add(e.b);

                        adj.get(e.b).addIn();
                    }
                }
            } catch(Exception e) {
                return "";
            }
        }
        
        StringBuilder ret = new StringBuilder("");
        
        PriorityQueue<Node> q = new PriorityQueue<Node>((Node n1, Node n2) -> n1.in - n2.in);
        iter = chars.iterator();
        while (iter.hasNext()) {
                Node next = (Node)adj.get((Character)iter.next());
                q.add(next);
        }
        // topological sort
        while (!q.isEmpty()) {
            Node next = q.remove();
            if (next.in != 0) return "";
            ret.append(next.val);
            iter = next.out.iterator();
            while (iter.hasNext()) {
                Node c = (Node)iter.next();
                q.remove(c);
                c.subIn();
                q.add(c);
            }
        }
        // return order
        return ret.toString();
    }
    
    static Edge getEdge(String s1, String s2) throws Exception {
        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) i++;
        if (i < s1.length() && i < s2.length()) return new Edge((Character)s1.charAt(i), (Character)s2.charAt(i));
        if (s1.length() > s2.length()) throw new Exception();
        return null;
    }
}

class Edge {
    Character a;
    Character b;
    
    public Edge(Character x, Character y) {
        a = x; b = y;
    }
}

class Node {
    Character val;
    int in;
    HashSet<Node> out;
    HashSet<Character> outCont;
    
    public Node(Character c) {
        val = c;
        in = 0;
        out = new HashSet<Node>();
        outCont = new HashSet<Character>();
    }
    
    void addIn() {
        in++;
    }
    
    void subIn() {
        in--;
    }
}
