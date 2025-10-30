import sys
input = sys.stdin.readline

MOD = 1000

def mat_mult(A, B, n):
    C = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            s = 0
            for k in range(n):
                s += A[i][k] * B[k][j]
            C[i][j] = s % MOD
    return C

def mat_pow(A, exp, n):
    if exp == 1:
        return A
    half = mat_pow(A, exp // 2, n)
    result = mat_mult(half, half, n)
    if exp % 2 == 1:
        result = mat_mult(result, A, n)
    return result

n, b = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        A[i][j] %= MOD

result = mat_pow(A, b, n)

for i in range(n):
    print(" ".join(str(result[i][j]) for j in range(n)))
