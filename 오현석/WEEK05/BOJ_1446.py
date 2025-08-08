import sys
input = sys.stdin.readline

N, D = map(int, input().split())

adj = [[] for _ in range(D + 1)]
for _ in range(N):
    s, e, l = map(int, input().split())
    if s <= D and e <= D and l < (e - s):
        adj[s].append((e, l))

INF = 10**15
dp = [INF] * (D + 1)
dp[0] = 0

for x in range(D):
    if dp[x] + 1 < dp[x + 1]:
        dp[x + 1] = dp[x] + 1
    for e, l in adj[x]:
        if dp[x] + l < dp[e]:
            dp[e] = dp[x] + l

print(dp[D])
