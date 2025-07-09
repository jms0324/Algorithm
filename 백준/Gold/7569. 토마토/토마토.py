import sys

M,N,H=map(int,input().split())
from collections import deque
input=sys.stdin.readline

#graph=[[[0 for col in range(M)]for row in range(N)] for depth in range(H)]
graph=[]
dx=[0,0,0,0,1,-1]
dy=[0,0,1,-1,0,0]
dz=[1,-1,0,0,0,0]
#파이썬에선 외부변수 읽기만 할때는 함수에서 사용가능
def BFS(graph,queue) :
    while(queue) :
        curx,cury,curz = queue.popleft()

        for i in range(6) :
            nx = curx+dx[i]
            ny = cury + dy[i]
            nz = curz + dz[i]
            if(nx<0 or nx>=N or nz<0 or nz >= H or ny<0 or ny>=M) : continue
            if(graph[nz][nx][ny]!=0) : continue
            graph[nz][nx][ny]=graph[curz][curx][cury]+1
            queue.append((nx,ny,nz))
    maxValue=0

    for z in range(H):
        for x in range(N):
            for y in range(M):
                if(graph[z][x][y]==0) :
                    return -1
                if(graph[z][x][y]>maxValue):
                    maxValue=graph[z][x][y]

    return maxValue-1



#visited=[[[0 for _ in range(M)]for _ in range(N)]for _ in range(H)]
for h in range(H) :

    list1=[]
    for x in range(N) :

        list1.append(list(map(int,input().split())))

    graph.append(list1)

queue=deque()

for z in range(H) :
    for x in range(N) :
        for y in range(M) :
            if(graph[z][x][y]==1) :

                queue.append((x,y,z))




print(BFS(graph,queue))











