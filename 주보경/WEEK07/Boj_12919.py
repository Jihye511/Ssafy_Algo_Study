import sys 
 
sys.setrecursionlimit(3000)

start =  input()
target = input()

def dfs(t):
    if start == t:
        print(1)
        exit(0)

    if len(t) == 0:
        return
        
    if (t[-1] == 'A'):
        dfs(t[:-1])
    if t[0] == 'B':
        new = t[1:]
        dfs(new[::-1])

dfs(target)
print(0)
