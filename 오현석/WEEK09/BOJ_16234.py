from collections import deque

n, l, r = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j, visited):
    q = deque()
    union = []
    q.append((i, j))
    union.append((i, j))
    visited[i][j] = True
    total_population = A[i][j]

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if l <= abs(A[nx][ny] - A[x][y]) <= r:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    union.append((nx, ny))
                    total_population += A[nx][ny]

    return union, total_population

days = 0
while True:
    visited = [[False] * n for _ in range(n)]
    movement = False

    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                union, population_sum = bfs(i, j, visited)
                if len(union) > 1:
                    movement = True
                    avg = population_sum // len(union)
                    for x, y in union:
                        A[x][y] = avg

    if not movement:
        print(days)
        break
    days += 1
