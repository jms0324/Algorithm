#제일 위에있는 카드 바닥에버림
#그다음 위에있는 카드 바닥에 옮김
from collections import deque
queue=deque()

N=int(input())
queue=deque(range(1,N+1))



while(len(queue)!=1) :
    queue.popleft()
    queue.append(queue.popleft())

print(queue[0])