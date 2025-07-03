N,M=map(int,input().split())
train=[]

for i in range(N):
    train.append([])

    for j in range(20):
        train[i].append(0)



for i in range(M) : ##명령의수

    command=list(map(int,input().split())) #명령하나

    if(len(command)==3) :


        if(command[0]==1) :  #command[1]이 몇번째 열차인지 의미함 command[2]는 좌석
            #승차
            train[command[1]-1][command[2]-1]=1

        else : #하차
            train[command[1]-1][command[2]-1]=0

    else :

        if(command[0]==3) :  #한칸씩뒤로 가

            train[command[1]-1].pop()
            train[command[1]-1].insert(0,0) #맨앞에 0 삽입

        else : #한칸씩 땡기기
            train[command[1]-1].pop(0) #맨앞제거
            train[command[1]-1].append(0)#뒤에 0 삽입




unique_trains = set()
for t in train:
    unique_trains.add(tuple(t))

print(len(unique_trains))



