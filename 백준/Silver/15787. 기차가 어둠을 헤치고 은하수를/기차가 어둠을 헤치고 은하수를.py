import sys
input=sys.stdin.readline

N,M=map(int,input().strip().split())
train=[[0]*20 for _ in range(N)]

for i in range(M) : #명령
    order=list(map(int,input().strip().split()))
    if(order[0]==1) : #승차
        if(train[order[1]-1][order[2]-1]==0) :
            train[order[1]-1][order[2] - 1]=1


    elif(order[0]==2) : #하차
        if (train[order[1] - 1][order[2] - 1] == 1):
            train[order[1] - 1][order[2] - 1] -=1


    elif(order[0]==3) : #한칸씩뒤로 +1

        for i in range(19,0,-1) :
            train[order[1]-1][i]=train[order[1]-1][i-1]
        train[order[1]-1][0]=0





    elif(order[0]==4) : #한칸씩앞으로 -1

        for i in range(0,19) :
            train[order[1]-1][i]=train[order[1]-1][i+1]
        train[order[1]-1][19]=0


s=set(tuple(lst) for lst in train)

print(len(s))





