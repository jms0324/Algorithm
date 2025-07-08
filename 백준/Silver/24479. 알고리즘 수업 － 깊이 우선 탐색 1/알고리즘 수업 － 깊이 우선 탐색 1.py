
import sys
sys.setrecursionlimit(10**6)
N,M,V=map(int,input().split())
cnt=0

def dfs(start) :

    global cnt
    cnt+=1
    visited[start] = cnt
    for i in graph[start] :
        if(visited[i]==0) :
            dfs(i)


graph=[[] for i in range(N+1)]
for i in range(M) :
    a,b=map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)  #인접리스트

for i in range(1,N+1) :
    graph[i].sort() #정렬

visited=[0]*(N+1)

dfs(V)

for i in range(1,N+1) :

        print(visited[i])


