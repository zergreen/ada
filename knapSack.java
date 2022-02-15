// import java.util.*;
 
class knapSack {
  static int knapSack(int W, int wt[], int val[], int n)
  {
    // making and initializing dp array
    int []dp = new int[W + 1];
   
    for (int i = 0; i < n ; i++) {
      for (int w = W; w >= 0; w--) {
 
        if (wt[i] <= w)
           
          // finding the maximum value
          dp[w] = Math.max(dp[w],
                           dp[w - wt[i]] + val[i]);
      }
    }
    return dp[W]; // returning the maximum value of knapsack
  }
   
  // Driver code
  public static void main(String[] args)
  {
    int val[] = { 96, 90, 50, 30, 15};
    int wt[] = { 8, 20, 12, 13, 15 };
    int W = 45;
    int n = val.length;
    System.out.print(knapSack(W, wt, val, n));
  }
 
}
 
