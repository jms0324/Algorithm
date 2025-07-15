import copy
import sys
input=sys.stdin.readline
T=int(input().strip())



for _ in range(T) :
    N, angle = map(int, input().strip().split())
    graph=[]

    for i in range(N) :
        graph.append(list(map(int,input().strip().split())))



    if(angle==360 or angle==0) : #그대로 출력
        for i in graph :
            print(*i)
    else :
        if (angle < 0):
            angle = 360 + angle

        angle = angle // 45
        result = [[0] * N for i in range(N)]  # 결과를 옮겨담을 그래프
        for w in range(angle):
            for i in range(N):
                for j in range(N):

                    if (i == j):  # 주대각선 -> 가운데 열
                        result[i][N // 2] = graph[i][j]

                    elif (j == N // 2):  # 가운데열 -> 부대각선
                        result[i][N - i - 1] = graph[i][j]

                    elif (i + j == N - 1):  # 부대각선 -> 가운데행
                        result[N // 2][j] = graph[i][j]


                    elif (i == N // 2):  # 가운데행 -> 주대각선
                        result[j][j] = graph[i][j]

                    else:  # 그외는 그냥 그대로
                        result[i][j] = graph[i][j]

            graph = copy.deepcopy(result)
            result = [[0] * N for i in range(N)]

        for i in range(N):
            print(*graph[i])




