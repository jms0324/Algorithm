import sys
from collections import deque
input=sys.stdin.readline
N,M,V=map(int,input().split())

visited=[0]*(N+1)

graph=[[] for i in range(N+1)]

for i in range(M) :
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph :
    i.sort(reverse=True)

cnt=2
queue=deque()
queue.append(V)
visited[V]=1
while(queue) :
    current=queue.popleft()

    for i in graph[current] :
        if (visited[i]==0) :
            queue.append(i)
            visited[i]=cnt
            cnt+=1

for i in range(1,N+1) :
    print(visited[i])