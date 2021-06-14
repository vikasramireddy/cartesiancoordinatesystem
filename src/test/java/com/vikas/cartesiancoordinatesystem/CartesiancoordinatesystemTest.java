package com.vikas.cartesiancoordinatesystem;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.vikas.cartesiancoordinatesystem.pojo.Line;
import com.vikas.cartesiancoordinatesystem.pojo.Point;

/**
 * @author vikasramireddy
 *
 */
public class CartesiancoordinatesystemTest {

	@Test
	public void definitionOfLineUsingTwoPointsTest() {
		// SUCCESS CASE
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		boolean result = coordinateSystem.isLineUsingTwoPoints(new Point(3, 2), new Point(2, 6));

		assertTrue(result);
	}

	@Test
	public void definitionOfLineUsingTwoPointsFailureTest() {
		// FAILURE CASE
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		boolean result = coordinateSystem.isLineUsingTwoPoints(new Point(2, 2), new Point(2, 2));
		assertFalse(result);
	}

	@Test
	public void findGradientAndYInterceptTest() {
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		String result = coordinateSystem.findGradientAndYIntercept(new Point(5, 2), new Point(2, 7));
		assertEquals("10", result);
	}

	@Test
	public void isParallelTest() {
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		Line l1 = new Line();
		l1.setStart(new Point(2, 2));
		l1.setEnd(new Point(2, 8));

		Line l2 = new Line();
		l2.setStart(new Point(3, 3));
		l2.setEnd(new Point(3, 3));

		boolean result = coordinateSystem.isParallel(l1, l2);
		assertTrue(result);
	}

	@Test
	public void isPerpendicularTest() {
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		Line l1 = new Line();
		l1.setStart(new Point(1, 2));
		l1.setEnd(new Point(1, 8));

		Line l2 = new Line();
		l2.setStart(new Point(0, 1));
		l2.setEnd(new Point(8, 1));

		boolean result = coordinateSystem.isPerpendicular(l1, l2);
		assertTrue(result);
	}

	@Test
	public void islineIncidencePointTest() {
		CoordinateSystem coordinateSystem = new CoordinateSystem();
		Line l1 = new Line();
		l1.setStart(new Point(1, 1));
		l1.setEnd(new Point(4, 4));

		Line l2 = new Line();
		l2.setStart(new Point(1, 8));
		l2.setEnd(new Point(2, 4));

		Point point = coordinateSystem.lineIncidencePoint(l1, l2);
		boolean result = point != null && point.getX() == 2.4 && point.getY() == 2.4;
		assertTrue(result);
	}
}
