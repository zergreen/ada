import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class myKnapsack {
    int val;
    int wt;
    double diff;

    myKnapsack(){}
    
    myKnapsack(int val, int wt, double diff) {
        this.val = val;
        this.wt = wt;
        this.diff = diff;
    }

    public String toString() {
        return String.format("%d: %d: %.2f \n", val, wt, diff);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int val[] = { 96, 90, 50, 30, 15};
        int wt[] = { 8, 20, 12, 13, 15 };
        int W = 45;
        int n = val.length;

        // manual input
        // for (int i = 0; i < n; i++) {
        //     System.out.printf("Enter val[%d] : ",i);
        //     val[i] = sc.nextInt();
        //     System.out.printf("Enter wt[%d] : ",i);
        //     wt[i] = sc.nextInt();
        // }

        myKnapsack green[];
        green = new myKnapsack[n];

        int sum = 0;
        double diff[] = new double[n];
        
        for(int i = 0; i < n; i++) {
            diff[i] = (double)val[i]/(double)wt[i];
        }

        for(int i = 0; i < n; i++) {
            green[i] = new myKnapsack(val[i], wt[i], diff[i]);
        }

        ArrayList<myKnapsack> list = new ArrayList<myKnapsack>();
        ArrayList<myKnapsack> temp = new ArrayList<myKnapsack>();

        for(int i = 0; i < n ; i++) {
            temp.add(green[i]);
        }

        double min = 0;
        double z = 0;
        int index = -1;    
        int wt_t = 0;    

        // core calculate 
        for(int i = 0 ; i < temp.size(); i++) {
            //println("ROUND : " + i);
            for(int j = 0 ; j < temp.size() ; j++) {
                // System.out.printf("I = %d, J = %d, Size = %d\n", i, j, temp.size());
                z = temp.get(j).diff;
                wt_t = temp.get(j).wt;
                //println(wt_t+" : wt_t");

                if(min < z && wt_t < W) {
                    min = z;
                    index = j;
                    W -= temp.get(j).wt;
                    sum += temp.get(j).val;     
                    // System.out.printf("min = %f | index = %d | W = %d | sum = %d\n", min, index, W, sum);                       
                }    
            }

            if(index == -1) continue;

            list.add(temp.get(index));
            temp.remove(index);
            
            //println(list);
            //println(temp);            
            
            min = 0;
            z = 0;
            index = -1;
            wt_t = 0;

        }

       println("sum: " + sum);
       println("val : wt : diff");
       println(list);
       println("Program END");

    }

    public static void println(Object line){
       System.out.println(line);
    }

}
