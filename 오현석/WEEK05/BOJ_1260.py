from collections import deque
import sys

input = sys.stdin.readline
print = sys.stdout.write
n,m,v = map(int, input().split())
ls_node = [[] for i in range(n+1)]
vis_DFS = [0] * (n+1)
vis_BFS = [0] * (n+1)
r_DFS = []
r_BFS = []

for i in range(m):
    x,y = map(int, input().split())
    ls_node[x].append(y)
    ls_node[y].append(x)

for i in range(1,n+1):
    ls_node[i].sort()

def dfs(v):
    vis_DFS[v]+=1
    r_DFS.append(v)
    for i in ls_node[v]:
        if not vis_DFS[i]:
            dfs(i)

def bfs(v):
    q_bfs = deque()
    q_bfs.appendleft(v)
    vis_BFS[v]+=1
    while q_bfs:
        tmp = q_bfs.pop()
        r_BFS.append(tmp)
        for i in ls_node[tmp]:
            if not vis_BFS[i]:
                vis_BFS[i]+=1
                q_bfs.appendleft(i)

bfs(v)
dfs(v)
for i in r_DFS:
    print(str(i)+' ')
print("\n")
for i in r_BFS:
    print(str(i)+' ')



