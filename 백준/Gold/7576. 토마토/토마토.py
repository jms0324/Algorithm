M,N=map(int,input().split())
from collections import deque
graph=[]
for i in range(N) :
    graph.append(list(map(int, input().split())))  #배열입력받고
visited=[[0]*M for _ in range(N)]
dirx=[1,0,-1,0]
diry=[0,-1,0,1]
def BFS(x,y,visited,queue) :

    while(queue) :
        curx,cury=queue.popleft()

        for i in range(4) :
            nx=curx+dirx[i]
            ny=cury+diry[i]
            if(nx<0 or nx>=N or ny<0 or ny>= M): continue
            if(graph[nx][ny]==-1 or visited[nx][ny]!=0) : continue
            queue.append((nx,ny))
            visited[nx][ny]=visited[curx][cury]+1
    maxValue=0
    for x in range(N):
        for y in range(M) :
            if(visited[x][y])==0 :
                return -1
            if (maxValue < visited[x][y]): maxValue = visited[x][y]

    return maxValue-1





queue=deque()
for x in range(N) :
    for y in range(M) :
        if(graph[x][y]==1) :
            queue.append((x,y))
            visited[x][y]=1
        elif(graph[x][y]==-1):
            visited[x][y]=-1

print(BFS(x,y,visited,queue))