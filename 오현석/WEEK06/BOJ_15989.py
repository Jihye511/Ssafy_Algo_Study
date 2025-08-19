import sys
input = sys.stdin.readline

MAX = 10000
dp = [[0] * (MAX + 1) for _ in range(4)]
dp[0][0] = 1 

for i in range(1, 4):  
    for j in range(MAX + 1):
        dp[i][j] = dp[i-1][j]  
        if j - i >= 0:
            dp[i][j] += dp[i][j - i]  

T = int(input())
for _ in range(T):
    n = int(input())
    print(dp[3][n])  
