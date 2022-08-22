package 백준.etc;

import java.util.Scanner;

//평행 사변형 4개 만들 수 있음
// x1, y1, x2, y2, x3, y3
// x4, y4 를 구해야 하는데

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pair[] points = new Pair[3];

        for (int i = 0; i < 3; i++) {
            points[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        Pair a = points[0];
        Pair b = points[1];
        Pair c = points[2];

        if (getSlope(a, b) == getSlope(a, c)) {
            System.out.println(-1.0);
        } else {
            double[] distances = {getDistance(a, b), getDistance(a, c), getDistance(b, c)};
            double min = distances[0];
            double max = distances[0];

            for (double distance : distances) {
                if (distance < min) min = distance;
                else if (distance > max) max = distance;
            }

            System.out.println(2 * (max - min));
        }
    }



    private static double getSlope(Pair pair1, Pair pair2) {
        double y = pair2.y - pair1.y;
        double x = pair2.x - pair1.x;
        if (x == 0) {
            x = y;
            y = 0;
        }
        return y/x;
    }

    private static double getDistance(Pair pair1, Pair pair2) {
        return Math.sqrt(Math.pow((pair2.x-pair1.x),2) + Math.pow((pair2.y-pair1.y),2));
    }


    static class Pair{
        private double x;
        private double y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}