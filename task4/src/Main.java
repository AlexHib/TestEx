import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args){
        if(args.length != 0){
            String fileName = args[0];
            int steps = action(fileName);
            System.out.println(steps);
        }
    }

    public static int action(String fileName){
        List<Integer> arrList = fileParse(fileName);
        int[] diffs = new int[arrList.size()];          //максимальные разности каждого элемента
        int maxDiff;
        int diff;

        for(int i = 0; i < arrList.size(); i++){
            maxDiff = 0;
            for(int j = 0; j < arrList.size(); j++){
                diff = Math.abs(arrList.get(i) - arrList.get(j));
                if(maxDiff < diff) maxDiff = diff;
            }
            diffs[i] = maxDiff;
        }

        int optimElem = arrList.get(searchIndexOfMin(diffs));
        int result = 0;

        for(int i = 0; i < arrList.size(); i++){
            result += Math.abs(arrList.get(i) - optimElem);
        }

        return result;
    }

    public static List<Integer> fileParse(String fileName){
        List<Integer> arrList = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while((line = bf.readLine()) != null){
                arrList.add(Integer.parseInt(line));
            }
            bf.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return arrList;
    }

    public static int searchIndexOfMin(int[] arr){
        int min = arr[0];
        int indexMin = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                indexMin = i;
            }
        }
        return indexMin;
    }
}
