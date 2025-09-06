R=int(input())
from collections import deque

for i in range(R) :

    N,M= map(int,input().split()) #M은 인덱스
   
    datalist=list(map(int,input().split()))
    result = 1
    while datalist :


        if datalist[0]<max(datalist) : #중요도가 더 높은게 잇을때
            datalist.append(datalist.pop(0))

        else : #맨앞이 가장 중요할때
            if M==0 : break #이러면 원하는걸 구해서 바로끝
            datalist.pop(0)
            result+=1  #순서증가
        M=M-1 if M>0 else len(datalist)-1

    print(result)








