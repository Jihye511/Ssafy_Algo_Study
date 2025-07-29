import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    prices = list(map(int, input().split()))
    
    stack = prices[:]  
    max_price = 0      
    ans = 0       

    while stack:
        p = stack.pop()
        if p > max_price:
            max_price = p
        else:
            ans += (max_price - p)
    
    print(ans)
