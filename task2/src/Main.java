import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        if(args.length == 2){
            String fileName1 = args[0];
            String fileName2 = args[1];
            action(fileName1,fileName2);
        }
    }

    public static void action(String fileName1, String fileName2){
        Circle circle = circleFileParser(fileName1);
        List<Point> pointList = pointFileParser(fileName2);
        double distance;

        for(Point point : pointList){
            distance = Point.distance(point, circle.center);
            if(Math.abs(distance - circle.radius) < 1E-5) System.out.println("0");      // точка на окружности
            else if(distance < circle.radius) System.out.println("1");                  // точка внутри
            else if(distance > circle.radius) System.out.println("2");                  // точка снаружи
        }

    }

    public static List<Point> pointFileParser(String fileName){
        List<Point> pointList = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            String[] nums;
            Point point;
            while((line = bf.readLine()) != null){
                nums = line.split(" ");
                point = new Point(Double.parseDouble(nums[0]),Double.parseDouble(nums[1]));
                pointList.add(point);

            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return pointList;
    }

    public static Circle circleFileParser(String fileName){
        Point center = new Point(0,0);
        double radius = 0;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            String[] nums = line.split(" ");
            center = new Point(Double.parseDouble(nums[0]), Double.parseDouble(nums[1]));
            radius = Double.parseDouble(bf.readLine());
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return new Circle(center, radius);

    }
}
