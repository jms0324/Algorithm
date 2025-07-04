import sys

board=[list(map(int,input().split())) for i in range(19)]

#왼쪽부터 검사하니까 오른쪽, 아래, 아래오른쪽대각 , 위오른쪽대각

dx=[0,1,1,-1]
dy=[1,0,1,1]

for x in range(19) :
    for y in range(19) :

        if(board[x][y]!=0):   #0이면 하지말고 넘어가
            standard=board[x][y] #시작점 저장 그리고 0은 출발안하니까 제외
            for i in range(4):
                cnt = 1

                nx = x + dx[i]
                ny = y + dy[i]
                while (0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == standard):
                    cnt += 1
                    if (cnt == 5):
                        if (0 <= x - dx[i] < 19 and 0 <= y - dy[i] < 19 and board[x - dx[i]][y - dy[i]] == standard):
                            break  # 전꺼 검사
                        if (0 <= nx + dx[i] < 19 and 0 <= ny + dy[i] < 19 and board[nx + dx[i]][ny + dy[i]] == standard):
                            break

                        print(standard)
                        print(x + 1, y + 1)
                        exit(0)

                    nx += dx[i]  # 내가생각못함
                    ny += dy[i]

print(0)
