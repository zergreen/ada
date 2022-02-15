def knapSack(W, wt, val, n):
    dp = [0] * (W+1)
 
    for i in range(1, n+1):  # taking first i elements
        for w in range(W, 0, -1):  # starting from back,so that we also have data of
                                # previous computation when taking i-1 items
            if wt[i-1] <= w:
                # finding the maximum value
                dp[w] = max(dp[w], dp[w-wt[i-1]]+val[i-1])
 
    return dp[W] 
 

val = [96, 90, 50, 30, 15]
wt = [8, 20, 12, 13, 15]
W = 45
n = len(val)

print(knapSack(W, wt, val, n))