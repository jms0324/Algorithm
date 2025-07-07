N=int(input())
T=[0]*N
P=[0]*N
for i in range(N):
    a,b=map(int,input().split())
    T[i]=a
    P[i]=b
ans=0



def DFS(n,sum):
    global ans

    #종료조건
    if(n>=N):
        ans=max(sum,ans)
        return
    else :
        if(n+T[n]<=N) :
            DFS(n+T[n],sum+P[n])

        DFS(n+1,sum)


DFS(0,0)

print(ans)

