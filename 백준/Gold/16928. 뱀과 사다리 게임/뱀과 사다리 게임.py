N,M=map(int,input().split())
ladder={}
import sys
input=sys.stdin.readline
snakeShot={}
from collections import deque
for i in range(N) :
    a,b=map(int,input().split())
    ladder[a]=b

for i in range(M) :
    a,b=map(int,input().split())
    snakeShot[a]=b

visited=[-1]*101



queue=deque()

queue.append(1)
visited[1]=0
while(queue) :

    cur=queue.popleft()
    if(cur==100) :
        print(visited[cur])
        break
    for i in range(1,7) :
        nx=cur+i

        if(nx>100 or visited[nx]!=-1 ): continue

        if(nx in ladder) :
            nx=ladder[nx]
        elif(nx in snakeShot):
            nx=snakeShot[nx]
        if(visited[nx]==-1) :
            queue.append(nx)
            visited[nx] = visited[cur] + 1







#사다리칸에 도착하면 내려가야함
