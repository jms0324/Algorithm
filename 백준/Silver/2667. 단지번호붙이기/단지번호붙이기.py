import sys
from collections import deque
movex=[-1,0,1,0]
movey=[0,1,0,-1]
cnt=0
count=0

bag=[]

N=int(input())
graph=[[] for _ in range(N)]

for i in range(N):
    graph[i]=list(map(int,input().strip()))


visited=[[0] * N for i in range (N)]

def BFS(x,y) :
    count=0
    visited[x][y]=1
    queue=deque()
    queue.append([x,y])
    count+=1
    while(queue) :
        cur=queue.popleft()
        for i in range(4):
            nx = cur[0] + movex[i]
            ny = cur[1] + movey[i]
            if (nx < 0 or nx >= N or ny < 0 or ny >= N): continue
            if (visited[nx][ny] != 0 or graph[nx][ny] == 0): continue
            queue.append([nx,ny])
            visited[nx][ny]=1
            count+=1
    bag.append(count)


for x in range(N):

    for y in range(N) :
        if(graph[x][y]==1 and visited[x][y]==0) :
            BFS(x,y)
            cnt+=1

bag.sort()


print(cnt)
for i in bag :
    print(i)
