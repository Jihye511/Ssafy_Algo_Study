import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

left, right = 0, N - 1
ans = [arr[left], arr[right]]
min_val = abs(arr[left] + arr[right])

while left < right:
    s = arr[left] + arr[right]

    if abs(s) < min_val:
        min_val = abs(s)
        ans = [arr[left], arr[right]]

    if s == 0:
        break
    elif s < 0:
        left += 1  
    else:
        right -= 1 

print(ans[0], ans[1])
