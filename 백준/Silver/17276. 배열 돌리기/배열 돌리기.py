time = int(input())
for _ in range(time) :
    N,angle = map(int,input().split())
    basic=[list(map(int,input().split()))  for _ in range(N)]

    ans=[[0]* N for _ in range(N)]

    if(angle ==0 or angle == 360) :
        for i in basic :
            print(*i)
    else :
        count=0
        mid=N//2
        if(angle<0) :
            angle+=360
            count=angle//45
        else :
            count=angle//45


        for k in range(count) :


            for i in range(N):
                for j in range(N):

                    if(i==j) :#주대각선 -> 가운데열
                         ans[i][mid]=basic[i][j]

                    elif(j==mid) : #가운데열 -> 부대각선 i+j=N-1
                        ans[i][N-i-1] = basic[i][j]

                    elif(i+j==N-1) : #부대각선 -> 가운데행
                        ans[mid][j] = basic[i][j]

                    elif(i==mid) : #basic의 가운데행 -> 주대각선 i가 2일때
                        ans[j][j] = basic[i][j]
                    else :
                        ans[i][j]=basic[i][j]

            for x in range(N):
                for y in range(N):
                    basic[x][y]=ans[x][y]

        for a in basic  :
            print(*a)

