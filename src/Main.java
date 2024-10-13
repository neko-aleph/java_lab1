import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Point> points = fillList();
        Triangle maxTriangle = findMaxPerimeterTriangle(points);
        printResult(maxTriangle);
    }

    public static Triangle findMaxPerimeterTriangle(List<Point> points) {
        Triangle maxTriangle = null;

        int n = points.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    Point p3 = points.get(k);

                    Triangle triangle = new Triangle(p1, p2, p3);
                    if (maxTriangle == null || triangle.getPerimeter() > maxTriangle.getPerimeter()) {
                        maxTriangle = triangle;
                    }
                }
            }
        }

        return maxTriangle;
    }

    public static List<Point> fillList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество точек:");
        int n = scanner.nextInt();
        while (n < 3) {
            System.out.println("Количество точек не может быть меньше 3! Введите количество точек:");
            n = scanner.nextInt();
        }

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.printf("Введите координаты точки %d:\n", i + 1);
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        return points;
    }

    public static void printResult(Triangle result) {
        if (result != null) {
            System.out.println("Точки треугольника с наибольшим периметром:");
            for (Point p : result.getPoints()) {
                p.print();
            }
            System.out.printf("Периметр: %g\n", result.getPerimeter());
        } else {
            System.out.println("Треугольник не найден.");
        }
    }
}