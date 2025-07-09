N,M=map(int,input().split())
visited=[[[0]*2 for _ in range(M)]for _ in range(N)] #3차원배열
#visted[x][y][0]->벽안부수고 x,y까지옴
#visited[x][y][1]->벽부수고 x,y까지옴

from collections import deque

def BFS(x,y,z,visited) :
    queue=deque()
    queue.append((x,y,z))
    visited[x][y][0]=1
    while(queue) :
        curx,cury,broke=queue.popleft()
        if(curx==N-1 and cury == M-1) :
            return visited[curx][cury][broke]

        for i in [(-1,0),(1,0),(0,1),(0,-1)] :
            nx=curx+i[0]
            ny=cury+i[1]
            if(nx<0 or nx>=N or ny<0 or ny>=M) : continue #범위 넘을경우 넘김
            if(visited[nx][ny][broke]!=0): continue #이미 방문한경우
            if(arr[nx][ny]==1) : #벽이라면
                if(broke==0) : #아직 벽을 부수지않았다면
                    visited[nx][ny][1]=visited[curx][cury][broke]+1
                    queue.append((nx,ny,1))
            else :
                visited[nx][ny][broke] = visited[curx][cury][broke] + 1
                queue.append((nx,ny,broke))



    return -1




arr=[list(map(int,input().strip())) for _ in range(N)]


print(BFS(0,0,0,visited))