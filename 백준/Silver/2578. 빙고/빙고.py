board=[list(map(int,input().split())) for _ in range(5)]
visited=[[0]*5 for _ in range(5)]

def check() :
    realcount=0
    for i in range(5): #행
        if(all(num==1 for num in visited[i])) :
            realcount+=1
    for j in range(5) : #열
        if(all(visited[i][j]==1 for i in range(5))) :
            realcount+=1
    if(all (visited[i][i]==1 for i in range(5))) :
        realcount+=1
    if(all(visited[i][4-i]==1 for i in range(5))) :
        realcount+=1
    if(realcount>=3) :
        return True
    else:
        return False




cnt=0
for _ in range(5) :
    arr=list(map(int,input().split()))
    for want in arr :
        cnt+=1
        for x in range(5) :

            for y in range(5) :
                if(board[x][y]==want):
                    visited[x][y]=1
                    if(check()) :
                        print(cnt)
                        exit()









