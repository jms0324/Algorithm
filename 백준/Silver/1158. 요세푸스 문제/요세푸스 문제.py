n,k=map(int,input().split())
from collections import deque
queue=deque(range(1,n+1))

answer=[]
while(queue) :
    for i in range(k-1) :
        queue.append(queue.popleft())
    answer.append(queue.popleft())

result="<"
for i in range(len(answer)-1) :
    result+=str(answer[i])
    result+=", "
result+=str(answer[-1])
result+=">"
print(result)




