package com.vikas.cartesiancoordinatesystem;

import com.vikas.cartesiancoordinatesystem.pojo.Line;
import com.vikas.cartesiancoordinatesystem.pojo.Point;

/**
 * @author vikasramireddy
 *
 */
public class CoordinateSystemMain {

	public static void main(String[] args) {

		CoordinateSystem coordinateSystem = new CoordinateSystem();

		/* 
		 * Definition of a line by means of two points
		 */
		boolean result = coordinateSystem.isLineUsingTwoPoints(new Point(3, 2), new Point(2, 6));

		if (result) {
			System.out.println("Given Points is a line.");
		} else {
			System.out.println("Given Point is not a line.");
		}

		/* 
		 * Definition of a line by means of gradient and y-intercept 
		 */
		String yinterceptPoint = coordinateSystem.findGradientAndYIntercept(new Point(5, 2), new Point(2, 7));

		if (yinterceptPoint != null) {
			System.out.println("y-intercept at " + yinterceptPoint);
		} else {
			System.out.println("Y did not intercept.");
		}

		/* 
		 * Condition of parallelism of two lines 
		 */
		Line l1 = null;
		Line l2 = null;

		l1 = new Line();
		l1.setStart(new Point(2, 2));
		l1.setEnd(new Point(2, 8));

		l2 = new Line();
		l2.setStart(new Point(3, 3));
		l2.setEnd(new Point(3, 3));

		result = coordinateSystem.isParallel(l1, l2);

		if (result) {
			System.out.println("Both lines are in parallel.");
		} else {
			System.out.println("Both lines are not in parallel.");
		}

		/* 
		 * Condition of perpendicularity of two lines 
		 */
		l1 = new Line();
		l1.setStart(new Point(1, 2));
		l1.setEnd(new Point(1, 8));

		l2 = new Line();
		l2.setStart(new Point(0, 1));
		l2.setEnd(new Point(8, 1));

		result = coordinateSystem.isPerpendicular(l1, l2);

		if (result) {
			System.out.println("Both lines are in perpendicular.");
		} else {
			System.out.println("Both lines are not in perpendicular.");
		}

		/* 
		 * Condition of incidence of two lines and definition of the incidence point 
		 */
		l1 = new Line();
		l1.setStart(new Point(1, 1));
		l1.setEnd(new Point(4, 4));

		l2 = new Line();
		l2.setStart(new Point(1, 8));
		l2.setEnd(new Point(2, 4));

		Point point = coordinateSystem.lineIncidencePoint(l1, l2);
		if (point != null) {
			System.out.println("The incidence point of two lines is X : " + point.getX() + " Y : " + point.getY());
		} else {
			System.out.println("There is no incidence point of two lines");
		}

	}

}
