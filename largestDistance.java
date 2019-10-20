/* https://app.codesignal.com/challenge/8RggMQ75MYrgomqnY
 *
 * You are given a set of points on the Cartesian plane. Consider the distance between
 * two points as the maximum difference of their coordinates. For example, the distance
 * between points (1, 2) and (4, 6) is equal to max(|4 - 1|, |6 - 2|) = 4.
 * 
 * Given a set of points, find the pair with the largest distance and return the value
 * of their distance.
 * 
 * Example
 * 
 * For a = [7, 6, 6, 8, 1, 2, 8, 6], the output should be
 * largestDistance(a) = 7.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer a
 * 
 * Points are given in one array a, where a[2 * i] is the x coordinate of the ith point,
 * and a[2 * i + 1] is the y coordinate of the ith point. All coordinates are positive.
 * The number of points is less than 1000. The points are not necessarily distinct.
 *
 * Guaranteed constraints:
 * 4 ≤ a.length ≤ 10,
 * 0 ≤ a[i] ≤ 50.
 * 
 * [output] integer
 * 
 * The maximum distance between two points from the input set.
 */
 
// I created a class just to store points in. It just has the variables x and y
// and a constructor to set them.

class Point {
    
    int x,y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
} 

// I define a method to find the distance between two points
// as defined by the problem, using methods from the
// java.lang.Math class: abs to find absolute value, and max
// to find the maximum of two integer values.

int distance(Point p1, Point p2) {
    return Math.max(Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y));
}

int largestDistance(int[] a) {

    // Initialize an array of Points half as long as array a,
    // which contains all of the coordinates individually
    Point[] points = new Point[a.length/2];
    
    // Initialize storage for the maximum distance we've found so far
    int max = 0;
    
    // Fill the array points with new Points, getting the x and
    // y coordinates for each Point from array a at indexes 2i
    // and 2i+1, respectively
    for (int i = 0; i < a.length/2; i++)
        points[i] = new Point(a[2*i],a[2*i+1]);
      
    // Iterate through all of the points in the array except
    // the last one
    for (int j = 0; j < points.length - 1; j++)
    {
        // Iterate through all the points that come after it
        for (int k = j; k < points.length; k++)
        {
            // Check if the distance between points j and k
            // is greater than what we've seen so far
            if (distance(points[j],points[k]) > max)
                // If so, update max to this distance
                max = distance(points[j],points[k]);
        }
    }
    return max;
}
