import sys

s = sys.stdin.readline().strip()
k = s.count('a')

if k == 0 or k == len(s):
    print(0)
else:
    t = s + s
    window_b = t[:k].count('b')
    ans = window_b

    for i in range(k, k + len(s)):
        if t[i] == 'b':
            window_b += 1
        if t[i - k] == 'b':
            window_b -= 1
        if window_b < ans:
            ans = window_b

    print(ans)
