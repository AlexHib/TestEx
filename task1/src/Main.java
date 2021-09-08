
public class Main {
    public static void main(String[] args){
        if(args.length != 0) {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            System.out.println(action(n,m));
        }


    }

    public static String action(int n, int m){
        int[] array = new int[n];
        String result = "";

        for(int i = 0; i < n; i++){
            array[i] = i + 1;
        }

        boolean notFinish = true;
        int index = 0;
        while(notFinish){
            for(int i = 0; i < m; i++){
                if(index >= n) index = 0;
                if(i == 0) result += "" + array[index];
                if(i == m-1 && array[index] == array[0]) notFinish = false;
                if(i < m-1) index++;
            }
        }

        return result;
    }
}
