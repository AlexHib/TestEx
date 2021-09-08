public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double distance(Point point1, Point point2){
        double result =  Math.sqrt(Math.pow((point1.x - point2.x),2) + Math.pow((point1.y - point2.y),2));
        return result;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}
