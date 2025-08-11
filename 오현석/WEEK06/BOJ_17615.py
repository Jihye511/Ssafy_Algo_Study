import sys

input = sys.stdin.readline
n = int(input().strip())
s = input().strip()

totalR = s.count('R')
totalB = n - totalR

lR = 0
while lR < n and s[lR] == 'R': lR += 1
lB = 0
while lB < n and s[lB] == 'B': lB += 1

rR = 0
i = n - 1
while i >= 0 and s[i] == 'R':
    rR += 1
    i -= 1

rB = 0
i = n - 1
while i >= 0 and s[i] == 'B':
    rB += 1
    i -= 1

ans = min(totalR - lR,totalR - rR,totalB - lB,totalB - rB)
print(ans)
