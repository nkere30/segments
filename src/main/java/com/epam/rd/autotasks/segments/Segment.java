package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private Point start;
    private Point end;
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Segment(Point start, Point end) {
        if(start.equals(end)) {
            throw new IllegalArgumentException("No such segment");
        }
        this.start = start;
        this.end = end;
        startX = start.getX();
        startY = start.getY();
        endX = end.getX();
        endY = end.getY();
    }
    /*
    Returns length of the segment line
     */
    double length() {
        return sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }

    /*
    Returns middle point of segment
     */
    Point middle() {
        return new Point((endX + startX)/2, (endY + startY)/2);
    }

    Point intersection(Segment another) {
        return intersectionPoint(another);
    }

    /*
    Takes segment as argument and returns point of intersection of two segments, if there is such.
    Intersection point is calculated by the formula of given two points on each line segment, where
    t and u are real numbers.
     */
    Point intersectionPoint(Segment another) {
            double t = ((startX - another.startX)*(another.startY - another.endY)-(startY - another.startY)*(another.startX - another.endX))/
                    ((startX - endX)*(another.startY - another.endY) - (startY - endY)*(another.startX - another.endX));
            double u = ((startX - another.startX)*(startY - endY)-(startY - another.startY)*(startX - endX))/
                    ((startX - endX)*(another.startY - another.endY) - (startY - endY)*(another.startX - another.endX));
            if(0 <= t && t <= 1 && 0 <= u && u <= 1) {
                double intersectionX = startX + t * (endX - startX);
                double intersectionY = startY + t * (endY - startY);
                return new Point(intersectionX, intersectionY);
            }
            return null;
    }
}
