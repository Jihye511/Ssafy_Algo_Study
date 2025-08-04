import sys

input = sys.stdin.readline
N = int(input().strip())
arr = list(map(int, input().split()))
result = [0] * N

for i, left_count in enumerate(arr):
    cnt = 0
    for j in range(N):
        if result[j] == 0:
            if cnt == left_count:
                result[j] = i + 1
                break
            cnt += 1

print(*result)
