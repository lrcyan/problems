class LongestIncreasingPathinaMatrix {    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        
        int n = matrix[0].length;
        if (m == 1 && n == 1) return 1;
        
        ArrayList<Point> sorted = toposort(matrix);
        
        return longestPathInDAG(sorted, matrix);
    }
    
    int longestPathInDAG(ArrayList<Point> sorted, int[][] matrix) {
        int NINFTY = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] distance = new int[m][n];
        Point curr;
        Point nextChild;
        int currX;
        int currY;
        int nextChildX;
        int nextChildY;
        int maxDistance = 0;
        
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            distance[i][j] = NINFTY;
        }
        
        int[][] inDegree = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (i != 0 && matrix[i-1][j] < matrix[i][j]) inDegree[i][j]++;
            if (i != m-1 && matrix[i+1][j] < matrix[i][j]) inDegree[i][j]++;
            if (j != 0 && matrix[i][j-1] < matrix[i][j]) inDegree[i][j]++;
            if (j != n-1 && matrix[i][j+1] < matrix[i][j]) inDegree[i][j]++;
        }
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (inDegree[i][j] == 0) distance[i][j] = 0;
        }
        
        curr = (Point)sorted.get(0);
        currX = curr.x;
        currY = curr.y;
        distance[currX][currY] = 0;
        
        for (int i = 0; i < sorted.size(); i++) {
            curr = (Point)sorted.get(i);
            currX = curr.x;
            currY = curr.y;
            
            if (currX != 0 && matrix[currX-1][currY] > matrix[currX][currY] && distance[currX-1][currY] < distance[currX][currY] + 1) {
                distance[currX-1][currY] = distance[currX][currY] + 1;
            }
            
            if (currX != m-1 && matrix[currX+1][currY] > matrix[currX][currY] && distance[currX+1][currY] < distance[currX][currY] + 1) {
                distance[currX+1][currY] = distance[currX][currY] + 1;
            }
                
            if (currY != 0 && matrix[currX][currY-1] > matrix[currX][currY] && distance[currX][currY-1] < distance[currX][currY] + 1) {
                distance[currX][currY-1] = distance[currX][currY] + 1;
            }
                
            if (currY != n-1 && matrix[currX][currY+1] > matrix[currX][currY] && distance[currX][currY+1] < distance[currX][currY] + 1) {
                distance[currX][currY+1] = distance[currX][currY] + 1;
            }
        }
        
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (distance[i][j] > maxDistance) maxDistance = distance[i][j];
        }
        
        return maxDistance + 1;
    }
    
    ArrayList<Point> toposort(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] inDegree = new int[m][n];
        Stack<Point> sources = new Stack<Point>();
        ArrayList<Point> order = new ArrayList<Point>();            
        
        Point curr;
        int a;
        int b;
        
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (i != 0 && matrix[i-1][j] < matrix[i][j]) inDegree[i][j]++;
            if (i != m-1 && matrix[i+1][j] < matrix[i][j]) inDegree[i][j]++;
            if (j != 0 && matrix[i][j-1] < matrix[i][j]) inDegree[i][j]++;
            if (j != n-1 && matrix[i][j+1] < matrix[i][j]) inDegree[i][j]++;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (inDegree[i][j] == 0) {
                    sources.push(new Point(i, j));
                }
            }
        }
        
        while (!sources.isEmpty()) {
            curr = (Point)sources.pop();
            order.add(curr);
            a = curr.x;
            b = curr.y;
            
            if (a != 0 && matrix[a-1][b] > matrix[a][b]) {
                inDegree[a-1][b]--;
                if (inDegree[a-1][b] == 0) sources.push(new Point(a-1, b));
            }
            
            if (a != m-1 && matrix[a+1][b] > matrix[a][b]) {
                inDegree[a+1][b]--;
                if (inDegree[a+1][b] == 0) sources.push(new Point(a+1, b));
            }
            
            if (b != 0 && matrix[a][b-1] > matrix[a][b]) {
                inDegree[a][b-1]--;
                if (inDegree[a][b-1] == 0) sources.push(new Point(a, b-1));
            }
            
            if (b != n-1 && matrix[a][b+1] > matrix[a][b]) {
                inDegree[a][b+1]--;
                if (inDegree[a][b+1] == 0) sources.push(new Point(a, b+1));
            }
        }
        
        return order;
    }
    
    void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    void print(LinkedList<Point> order) {
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i).x + ", " + order.get(i).y + "; ");
        }
    }
}

class Point {
    int x;
    int y;
    
    public Point(int a, int b) {
        x = a;
        y = b;
    }
    
    boolean equals(Point p) {
        return this.x == p.x && this.y == p.y;
    }
}
