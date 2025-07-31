import sys
input = sys.stdin.readline

left = list(input().strip())
right = []

n = int(input())
for _ in range(n):
    cmd = input().strip()

    if cmd == 'L':
        if left:
            right.append(left.pop())
    elif cmd == 'D':
        if right:
            left.append(right.pop())
    elif cmd == 'B':
        if left:
            left.pop()
    else: 
        tmp, char = cmd.split()
        left.append(char)

print(''.join(left + right[::-1]))
