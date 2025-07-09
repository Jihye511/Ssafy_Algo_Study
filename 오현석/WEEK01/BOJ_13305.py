N  = int(input())
road = list(map(int,input().split()))
ls = list(map(int,input().split()))


ans = 0
now = ls[0]
for i in range(N-1):
    if now > ls[i] :
        now = ls[i]
    ans += now * road[i]

print(ans)