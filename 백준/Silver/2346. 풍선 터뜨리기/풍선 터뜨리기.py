N=int(input())
from collections import deque
arr=[]
queue=deque(enumerate(map(int,input().split())))

#deque.rotate #덱을 회전
#enumerate #인덱스와 값을 반환
while queue :
    idx,now_turn = queue.popleft()
    arr.append(idx+1) #인덱스는 0부터 시작하는데 문제는 1부터임
    if now_turn>0 : #양수면 어떻게 회전시킬까
        queue.rotate(-(now_turn-1))
    elif now_turn<0 :
        queue.rotate(-now_turn)

for i in range(len(arr)) :
    print(arr[i],end=" ")











