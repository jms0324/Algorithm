import sys
sys.setrecursionlimit(10**5 + 10)
input = sys.stdin.readline

N,M,V=map(int,input().split())
cnt=0

def dfs(start) :
    global cnt
    cnt+=1
    visited[start]=cnt
    for i in graph[start] :
        if(visited[i]==0) :
            dfs(i)



graph=[[] for _ in range(N+1)]
for _ in range(M) :
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited=[0]*(N+1)

for i in graph :
    i.sort(reverse= True)


dfs(V)
for i in range(1,N+1):
    sys.stdout.write(str(visited[i])+"\n")