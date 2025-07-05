n=int(input())

for _ in range(n) :


    N, angle=map(int,input().split())

    basic=[list(map(int,input().split())) for i in range(N)]


    ans=[[0] * N for _ in range(N)]  #답을 입력할배열
    if(angle<0) :
        angle=360+angle

    if (angle == 360 or angle ==0) : #360일때
        for i in basic:
            print(*i) #unpack문법

    else :
        for _ in range(angle//45) :

            mid=N//2
            for i in range(N):
                for j in range(N) :

                    if(j==mid) :  #주대각선 -> 가운데열
                        ans[i][j] = basic[i][i]

                    elif (i + j == N - 1):  # 가운데열 -> 부대각선
                        ans[i][j] = basic[i][mid]

                    elif (i == mid):  # 부대각선 -> 가운데행  이거 몰랏음
                        ans[i][j] = basic[N - j - 1][j]

                    elif(i==j)  :  #가운데행 -> 주대각선
                        ans[i][j] = basic[mid][j]


                    else:
                        ans[i][j]=basic[i][j]

            for x in range(N):
                for y in range(N) :
                    basic[x][y]=ans[x][y]

        for k in basic:
            print(*k)







