import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;
 
/** Class point **/
class Point
{
    int x, y;
    Point(int x,int y)
    {
    	this.x=x;
    	this.y=y;
    }
}
 
/** Class Jarvis **/
public class Jarvis
{    
    private boolean CCW(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
 
         if (val >= 0)
             return false;
         return true;
    }
    public ArrayList<Integer> convexHull(ArrayList<Point> points)
    {
        int n = points.size();
        /** if less than 3 points return **/        
             
        ArrayList<Integer> next=new ArrayList<>();
 
        /** find the leftmost point **/
        int leftMost = 0;
        for (int i = 1; i < n; i++)
            if (points.get(i).x < points.get(leftMost).x)
                leftMost = i;
        int p = leftMost, q;
        
        next.add(p);
        /** iterate till p becomes leftMost **/
        do
        {
            /** wrapping **/
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
              if (CCW(points.get(p), points.get(i), points.get(q)))
                 q = i;
 
            next.add(q);
            p = q; 
        } while (p != leftMost);
 
        /** Display result **/
        return next;
    }
}