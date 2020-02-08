import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;

public class TestPostProcessing {
    @Test
    public void testFindsMidpoint() {
        MatOfPoint contourA = new MatOfPoint(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,0));
        // MatOfPoint contourB = new MatOfPoint(new Point(2, 2), new Point(3,3), new Point(3,2));
        ArrayList<MatOfPoint> results = new ArrayList<>(){{add(contourA);}};

        double[] data = PostProcessing.findTarget(results);

        Assert.assertEquals(0.5, data[0], 0.0001);
        Assert.assertEquals(0.5, data[1], 0.0001);
        Assert.assertEquals(1.0, data[2], 0.0001);
    }
    @Test
    public void testSalutationMessage() {
       System.out.println("Inside testSalutationMessage()");
       String message = "Hi!" + "Robert";
       Assert.assertEquals(message,"Hi!Robert");
    }
}