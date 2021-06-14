package com.vikas.cartesiancoordinatesystem;

import com.vikas.cartesiancoordinatesystem.pojo.Line;
import com.vikas.cartesiancoordinatesystem.pojo.Point;

/**
 * @author vikasramireddy
 *
 */
public class CoordinateSystem {

	/**
	 * Definition of a line by means of two points
	 * 
	 * @param p1  Point Object
	 * @param p2  Point Object
	 * @return Returns true if line is using two points
	 */
	public boolean isLineUsingTwoPoints(Point p1, Point p2) {

		if (p1 != null && p2 != null) {
			double x1 = p1.getX();
			double y1 = p1.getY();

			double x2 = p2.getX();
			double y2 = p2.getY();

			return x1 != x2 && y1 != y2;
		}
		return false;
	}

	/**
	 * Definition of a line by means of gradient and y-intercept
	 * 
	 * @param p1 Point Object
	 * @param p2 Point Object
	 * @return String
	 */
	public String findGradientAndYIntercept(Point p1, Point p2) {

		if (p1 != null && p2 != null) {
			double x0 = p1.getX();
			double y0 = p1.getY();

			// Second pair of point (x1, y1)
			double x1 = p2.getX();
			double y1 = p2.getY();

			double a = y0 - y1;
			double b = x0 - x1;

			// if line is parallel to y axis
			if (b == 0) {
				// y - intercept will be infinity
				return "infinity";
			}

			// if line is parallel to x axis
			if (a == 0) {
				// y - intercept will be p[1]
				return String.valueOf(y0);
			}

			// Slope of the line
			double m = a / (b * 1.0);

			// y = mx + c in where c is unknown Use any of the given point to find c
			double c = y0 - m * x0;

			// For finding the y-intercept put x = 0
			x0 = 0;
			int y = (int) (m * x0 + c);
			return String.valueOf(y);
		}
		return null;
	}

	/**
	 * Condition of parallelism of two lines
	 * 
	 * @param l1  Line Object
 	 * @param l2  Line Object
	 * @return Check to see if Line is Parallel
	 */
	public boolean isParallel(Line l1, Line l2) {

		if (l1 != null && l2 != null) {
			double a1 = l1.getEnd().getY() - l1.getStart().getY();
			double b1 = l1.getStart().getY() - l1.getEnd().getX();

			double a2 = l2.getEnd().getY() - l2.getStart().getY();
			double b2 = l2.getStart().getX() - l2.getEnd().getX();

			double determinant = a1 * b2 - a2 * b1;

			return determinant == 0;
		}
		return false;
	}

	/**
	 * Condition of perpendicularity of two lines
	 * @param l1  Line Object
	 * @param l2  Line Object
	 * @return Return true or false to ensure Line is Perpendicular
	 */
	public boolean isPerpendicular(Line l1, Line l2) {

		if (l1 != null && l2 != null) {
			double x1 = l1.getStart().getX();
			double y1 = l1.getStart().getY();

			double x2 = l1.getEnd().getX();
			double y2 = l1.getEnd().getY();

			double x3 = l2.getStart().getX();
			double y3 = l2.getStart().getY();

			double x4 = l2.getEnd().getX();
			double y4 = l2.getEnd().getY();

			double m1, m2;

			// Both lines have infinite slope
			if (x2 - x1 == 0 && x4 - x3 == 0) {
				return false;
			}
			// Only line 1 has infinite slope
			else if (x2 - x1 == 0) {
				m2 = (y4 - y3) / (x4 - x3);
				return m2 == 0;
			}

			// Only line 2 has infinite slope
			else if (x4 - x3 == 0) {
				m1 = (y2 - y1) / (x2 - x1);
				return m1 == 0;
			} else {
				// Find slopes of the lines
				m1 = (y2 - y1) / (x2 - x1);
				m2 = (y4 - y3) / (x4 - x3);

				// Check if their product is -1
				return m1 * m2 == -1;
			}
		}
		return false;
	}

	/**
	 * Condition of incidence of two lines and definition of the incidence point
	 * @param l1  Line Object
	 * @param l2  Line Object
	 * @return Returns the Point where the Incidence happens
	 */
	public Point lineIncidencePoint(Line l1, Line l2) {
		if (l1 != null && l2 != null) {
			double x1 = l1.getStart().getX();
			double y1 = l1.getStart().getY();

			double x2 = l1.getEnd().getX();
			double y2 = l1.getEnd().getY();

			double x3 = l2.getStart().getX();
			double y3 = l2.getStart().getY();

			double x4 = l2.getEnd().getX();
			double y4 = l2.getEnd().getY();

			// Line l1 represented as a1x + b1y = c1
			double a1 = y2 - y1;
			double b1 = x1 - x2;
			double c1 = a1 * (x1) + b1 * (y1);

			// Line l2 represented as a2x + b2y = c2
			double a2 = y4 - y3;
			double b2 = x3 - x4;
			double c2 = a2 * (x3) + b2 * (y3);

			double determinant = a1 * b2 - a2 * b1;

			if (determinant == 0) {
				// The lines are parallel. This is simplified
				// by returning a pair of FLT_MAX
				return null;
			} else {
				double x = (b2 * c1 - b1 * c2) / determinant;
				double y = (a1 * c2 - a2 * c1) / determinant;
				return new Point(x, y);
			}
		}
		return null;
	}

}
