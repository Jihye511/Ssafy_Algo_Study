import sys

MAX = 1000

num = [0] * (MAX + 1)
num[1] = 1
num[2] = 3
num[3] = 5

pow2 = [1] * (MAX + 1)
for i in range(1, MAX + 1):
    pow2[i] = pow2[i-1] * 2

for i in range(4, MAX + 1):

    best = 10**50

    for j in range(i - 1, i // 2 - 1, -1):

        temp = num[j] * 2 + (pow2[i - j] - 1)

        if temp < best:
            best = temp

        if temp > best:
            break

    num[i] = best

case = 1
for line in sys.stdin:
    line = line.strip()
    if not line:
        break
    n = int(line)
    print(f"Case {case}: {num[n]}")
    case += 1
