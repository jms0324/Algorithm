
import sys
input=sys.stdin.readline
from collections import deque

arr=[-1] * (100002)
S,B=map(int,input().split())
move=["forward","backward","teleport"]
queue=deque()
check=[0]*(100002)
queue.append(S)
arr[S]=0

def path(x) :
    result=[]
    result.append(x)
    for i in range(arr[x]) :  #방문
        result.append(check[x])
        x=check[x]
    list2=result[::-1]
    for i in list2 :
        print(i,end=" ")



while(queue):
    cur=queue.popleft()
    if(cur==B):
        print(arr[cur])
        path(cur)
        #경로추적
        break
    for i in move :
        nx=0
        if(i=="forward"):
            nx=cur+1
        elif(i=="backward") :
            nx=cur-1
        elif (i=="teleport") :
            nx=cur*2
        if(nx>100000 or nx<0):continue
        if(arr[nx]!=-1):continue
        arr[nx]=arr[cur]+1
        queue.append(nx)
        check[nx]=cur





