import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;

public final class PostProcessing {
    public static double[] findTarget(ArrayList<MatOfPoint> results) {

        double maxMidX = Double.NEGATIVE_INFINITY;
        double maxMidY = Double.NEGATIVE_INFINITY;
        double maxArea = Double.NEGATIVE_INFINITY;

        
        for (MatOfPoint contour : results) {
            Point[] points = contour.toArray();
            
            Double MaxX = Double.NEGATIVE_INFINITY;
            Double MinX = Double.POSITIVE_INFINITY;
            Double MaxY = Double.NEGATIVE_INFINITY;
            Double MinY = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < points.length; i++) {
                Point point = points[i];
                
                double x = point.x;
                double y = point.y;
                
                if (x > MaxX) {
                    MaxX = x;
                }
                if (x < MinX) {
                    MinX = x;
                }
                
                if (y > MaxY) {
                    MaxY = y;
                }
                if (y < MinY) {
                    MinY = y;
                }
            }
            
            double midX = (MaxX + MinX) / 2;
            double midY = (MaxY + MinY) / 2;
            
            double lenght = MaxY - MinY;
            double width = MaxX - MinX;
            double area = lenght * width;
            
            if (area > maxArea) {
                maxArea = area;
            }
            if (midX > maxMidX) {
                maxMidX = midX;
            }
            if (midY > maxMidY) {
                maxMidY = midY;
            }
        }
        
        double[] targetData = new double[] {maxMidX, maxMidY, maxArea};
        return targetData;
    }
}