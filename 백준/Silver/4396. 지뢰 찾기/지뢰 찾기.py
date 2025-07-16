N=int(input())
trap=[list(input()) for _ in range(N)]
maap=[list(input()) for _ in range(N)]


dx=[1,1,1,-1,-1,-1,0,0]
dy=[0,1,-1,0,1,-1,1,-1]

def check(x,y) :
    cnt=0
    for i in range(8):
        nx=x+dx[i]
        ny=y+dy[i]
        if(nx<0 or nx>=N or ny<0 or ny>=N) :continue #인덱스에러방지
        if(trap[nx][ny]=='*'):
            cnt+=1


    return cnt

Flag=False

for x in range(N):
    for y in range(N) :
        if(maap[x][y]=="x" and trap[x][y]=='*'): #지뢰가 있는 칸이 열렸다면 ?
            Flag=True
            break
#지뢰밟았는지 먼저체크한다  좀이따 값을 덮어쓸거기때문에 그전에 미리 체크해야함 

for x in range(N):
    for y in range(N) :
        if(maap[x][y]=="x"):
            maap[x][y]=check(x,y)  
#값 덮어쓰기 

if(Flag) :
    for x in range(N):
        for y in range(N):
            if(trap[x][y]=='*') :  
                maap[x][y]='*'

for i in range(N):
    for j in range(N):
        print(maap[i][j],end="")
    print()
