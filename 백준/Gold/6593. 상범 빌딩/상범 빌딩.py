import sys
input=sys.stdin.readline
from collections import deque
dx=[0,0,0,0,1,-1]
dy=[0,0,1,-1,0,0]
dz=[1,-1,0,0,0,0]
check=True
def BFS(z,x,y,visited) :
    global check
    queue=deque()
    queue.append((x,y,z))
    visited[z][x][y]=0
    while(queue) :
        curx,cury,curz=queue.popleft()
        if(arr[curz][curx][cury]=='E') :
            print(f"Escaped in {visited[curz][curx][cury]} minute(s).")
            check=False
            return

        for i in range(6) :
            nx=curx+dx[i]
            ny=cury+dy[i]
            nz=curz+dz[i]
            if(nx<0 or ny<0 or nz<0 or nx>=R or ny>=C or nz >= L):continue
            if(arr[nz][nx][ny]=='#' or visited[nz][nx][ny]!=-1):continue #방문체크
            queue.append((nx,ny,nz))
            visited[nz][nx][ny]=visited[curz][curx][cury]+1



while(True) :
    check=True
    L,R,C=map(int,input().split())
    if(L==0 and R==0 and C==0): break
    arr=[]
    visited=[[[-1]*C for _ in range(R)]for _ in range(L)]
    for _ in range(L):
        list1=[]
        for i in range(R):
            list1.append(list(input().strip()))
        arr.append(list1)
        input() #한칸비워서 받는다길래0

    for z in range(L):
        for x in range(R):
            for y in range(C) :
                if(arr[z][x][y]=='S') :BFS(z,x,y,visited)



    if (check):
        print("Trapped!")





