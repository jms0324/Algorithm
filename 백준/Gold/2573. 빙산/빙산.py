import sys
input=sys.stdin.readline
from collections import deque
N,M=map(int,input().split()) #첫시작
graph=[]

dx=[0,0,1,-1]
dy=[1,-1,0,0]


def checking(nx,ny) :
    if(nx<0 or nx >= N or ny<0 or  ny >= M):return True
    else :return False
def BFS(x,y,visited) :
    queue=deque()
    visited[x][y]=1
    queue.append((x,y))
    while(queue) :
        curx,cury=queue.popleft()
        for i in range(4) :
            nx=curx+dx[i]
            ny=cury+dy[i]
            if(checking(nx,ny)):continue
            if(visited[nx][ny]!=0 or graph[nx][ny]==0): continue
            visited[nx][ny]=1
            queue.append((nx,ny))



def year() :
    count=[[0]*M for _ in range(N)]
    for i in range(N) :
        for j in range(M) :
            if(graph[i][j]>0) :
                cnt=0
                for k in range(4) :
                    nx=i+dx[k]
                    ny=j+dy[k]
                    if(checking(nx,ny)): continue
                    if(graph[nx][ny]==0):cnt+=1  #4방향에서 확인
                count[i][j]=cnt

    for i in range(N) :
        for j in range(M) :
            if(graph[i][j]>0) :
                graph[i][j]-=count[i][j] #카운트를  해놓고 뺄때 따로빼야됨 안그러면 틀림
                if(graph[i][j]<0) :graph[i][j]=0



for i in range(N) :
    graph.append(list(map(int,input().split())))  #그래프입력받음
yearCount=0

while(True) :


    check=True
    for i in range(N):
        for j in range(M):
            if(graph[i][j]>=1):
                check=False
                break
        if not check :
            break
    visited = [[0] * M for _ in range(N)]  # 방문처리배열

    if(check):
        print("0")
        exit()
        # 다 0이 됬는지 확인
    year() #1년지난다]
    yearCount += 1
    cnt=0
    for i in range(N) :
        for j in range(M):
            if(graph[i][j]!=0 and visited[i][j]==0):  #방문안하고 0이 아닌 원소가 잇으면 BFS시작
                BFS(i,j,visited)
                cnt+=1

    if(cnt>=2) :
        print(yearCount)
        break

