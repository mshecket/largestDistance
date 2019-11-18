/* 
 * https://app.codesignal.com/challenge/8RggMQ75MYrgomqnY
 */
 
class Point {
    int x,y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    } 
} 

int distance(Point p1, Point p2) {
    return Math.max(Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y));
}

int largestDistance(int[] array) {

    Point[] points = new Point[array.length/2];
    
    int max = 0;
    
    for (int i = 0; i < array.length/2; i++)
        points[i] = new Point(array[2*i],array[2*i+1]);
      
    for (int j = 0; j < points.length - 1; j++)
    {
        for (int k = j; k < points.length; k++)
        {
            if (distance(points[j],points[k]) > max)
                max = distance(points[j],points[k]);
        }
    }
    return max;
}
