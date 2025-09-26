import sys
import heapq

input = sys.stdin.readline

def dijkstra(start, adj, N):
    INF = 10**15
    dist = [INF] * (N + 1)
    dist[start] = 0
    hq = [(0, start)]
    while hq:
        d, u = heapq.heappop(hq)
        if d > dist[u]:
            continue
        for v, w in adj[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                heapq.heappush(hq, (nd, v))
    return dist

N, M, X = map(int, input().split())
adj = [[] for _ in range(N + 1)]
rev_adj = [[] for _ in range(N + 1)]
for _ in range(M):
    u, v, w = map(int, input().split())
    adj[u].append((v, w))
    rev_adj[v].append((u, w))

dist_from_X = dijkstra(X, adj, N)
dist_to_X = dijkstra(X, rev_adj, N)

answer = 0
for i in range(1, N + 1):
    total = dist_to_X[i] + dist_from_X[i]
    if total > answer:
        answer = total

print(answer)
