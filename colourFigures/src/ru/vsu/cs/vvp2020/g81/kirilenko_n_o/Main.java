package ru.vsu.cs.vvp2020.g81.kirilenko_n_o;


import java.util.Scanner;

public class Main {

    public enum SimpleColor {
        GRAY,
        ORANGE,
        YELLOW,
        BLUE,
        WHITE
    }

    public static class Line {
        public double x0;
        public double y0;
        public double a;

        public Line(double x0, double y0, double a) {
            this.x0 = x0;
            this.y0 = y0;
            this.a = a;
        }

        public boolean isPointAboveLine(double x, double y) {

            return y > a * (x - x0) + y0;
        }
    }

    public static class HorizontalParabola {
        public double x0;
        public double y0;
        public double a;

        public HorizontalParabola(double x0, double y0, double a) {
            this.x0 = x0;
            this.y0 = y0;
            this.a = a;
        }

        public boolean isPointRightOfParabola(double x, double y) {

            return x > a * Math.pow(y - y0, 2) + x0;
        }

    }

    public static class Program {
        public static final Line L1 = new Line(3, 1, 3.0 / 5);
        public static final Line L2 = new Line(4, -1, 3.0 / 5);
        public static final HorizontalParabola P1 = new HorizontalParabola(-1, 4, 1.0 / 8);
        public static final HorizontalParabola P2 = new HorizontalParabola(-3, 2, 1.0 / 2);
        public static final HorizontalParabola P3 = new HorizontalParabola(-5, -6, 1.0 / 2);

        public static SimpleColor getColor(double x, double y) {
            if (P1.isPointRightOfParabola(x, y) && !P2.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)) {
                return SimpleColor.GRAY;
            }
            if (P1.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)) {
                return SimpleColor.YELLOW;
            }
            if (P2.isPointRightOfParabola(x, y) && L1.isPointAboveLine(x, y)) {
                    return SimpleColor.BLUE;
            }
            if (!P1.isPointRightOfParabola(x, y) && P2.isPointRightOfParabola(x, y)) {
                return SimpleColor.YELLOW;
            }
            if (P3.isPointRightOfParabola(x, y) && L2.isPointAboveLine(x, y)) {
                return SimpleColor.YELLOW;
            }
            if (P3.isPointRightOfParabola(x, y) && P2.isPointRightOfParabola(x, y)) {
                return SimpleColor.YELLOW;
            }
            if (P2.isPointRightOfParabola(x, y) && !L2.isPointAboveLine(x, y)) {
                return SimpleColor.ORANGE;
            }
            return SimpleColor.WHITE;

        }
    }

    public static void printColorForPoint(double x, double y) {
        System.out.println("(" + x + ", " + y + ") -> " + Program.getColor(x, y));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        printColorForPoint(1, 6);
        printColorForPoint(5, 3.92);
        printColorForPoint(-1, 0);
        printColorForPoint(-2, 3.121);
        printColorForPoint(6, -1);
        printColorForPoint(-4, -5);
        System.out.print("Input X: ");
        double x = scanner.nextDouble();
        System.out.print("Input Y: ");
        double y = scanner.nextDouble();
        printColorForPoint(x, y);
    }
}
