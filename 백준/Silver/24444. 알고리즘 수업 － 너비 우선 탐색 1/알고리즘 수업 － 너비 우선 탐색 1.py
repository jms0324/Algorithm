import sys
from collections import deque

input=sys.stdin.readline
N,M,V=map(int,input().split())

visited=[0]*(N+1)
graph=[[] for _ in range(N+1)]
for i in range(M):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph :
    i.sort()
queue=deque()
visited[V]=1
queue.append(V)
cnt=2
while(queue) :
    current=queue.popleft()

    for i in graph[current] :
        if(visited[i]==0):
            queue.append(i)
            visited[i]=cnt
            cnt+=1


for i in range(1,N+1) :
    print(visited[i])