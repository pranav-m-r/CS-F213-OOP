// RectangleManager.java

import java.util.*;

public class RectangleManager {
    public static void analyzeRectangles(List<Rectangle> rectangles) {
        int first = 0, second = 0, third = 0, fourth = 0;

        for (int i = 1; i < rectangles.size(); i++) {
            if (rectangles.get(i).canFit(rectangles.get(0))) first++;
        }

        for (int i = 1; i < rectangles.size(); i++) {
            if (rectangles.get(0).canFit(rectangles.get(i))) second++;
        }

        double minDifference = Double.MAX_VALUE;
        double aspectRatio0 = rectangles.get(0).getWidth() / rectangles.get(0).getHeight();

        for (int i = 1; i < rectangles.size(); i++) {
            double aspectRatioi = rectangles.get(i).getWidth() / rectangles.get(i).getHeight();
            double difference1 = Math.abs(aspectRatio0 - aspectRatioi);
            double difference2 = Math.abs((1 / aspectRatio0) - (1 / aspectRatioi));
            double differenceInverse1 = Math.abs(aspectRatio0 - (1 / aspectRatioi));
            double differenceInverse2 = Math.abs((1 / aspectRatio0) - aspectRatioi);
            if (difference1 < minDifference) {
                minDifference = difference1;
                third = i;
            }
            if (difference2 < minDifference) {
                minDifference = difference2;
                third = i;
            }
            if (differenceInverse1 < minDifference) {
                minDifference = differenceInverse1;
                third = i;
            }
            if (differenceInverse2 < minDifference) {
                minDifference = differenceInverse2;
                third = i;
            }
        }

        Object[] rectangleArray = rectangles.toArray();
        Arrays.sort(rectangleArray);
        int n = rectangleArray.length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            Rectangle ri = (Rectangle) rectangleArray[i];
            for (int j = 0; j < i; j++) {
                Rectangle rj = (Rectangle) rectangleArray[j];
                if (ri.canFit(rj)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] > fourth) fourth = dp[i];
        }

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
    }
}
