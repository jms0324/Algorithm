from collections import deque
import sys
input=sys.stdin.readline
N,K=map(int,input().split())
graph=[0]*100002
move=["forward","backward","mul"]
research=[0]*100002


def path(x) :
    result = []
    result.append(x)
    for i in range(graph[x]) :  #graph[x]가 경로의 길이 이므로
        result.append(research[x])
        x=research[x]
    res2=result[::-1]
    for i in res2 :
        print(i,end=" ")


queue=deque()
queue.append(N)

while(queue) :
    cur=queue.popleft()
    if(cur==K) :
        print(graph[cur])
        path(cur)
        exit()


    for i in move :
        if(i == "forward") :
            nx=cur+1
        elif(i== "backward") :
            nx=cur-1
        else :
            nx=cur*2
        if(nx<0 or nx>=100002) :continue
        elif(graph[nx]!=0):continue #이미 방문한
        research[nx]=cur #역추적하기위해
        graph[nx]=graph[cur]+1
        queue.append(nx)


