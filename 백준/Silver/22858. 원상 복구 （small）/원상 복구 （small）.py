N,K=map(int,input().split())

result=list(map(int,input().split()))
listn=list(map(int,input().split()))

ans = [0] * (N)
for i in range(K) :

    ans = [0] * (N)
    for index in range(len(listn)) :

        cur=result[index]
        ans[listn[index]-1]=cur
    result = ans[:]





print(*ans)





