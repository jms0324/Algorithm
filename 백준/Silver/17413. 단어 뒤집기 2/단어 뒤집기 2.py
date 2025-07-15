import sys


s=input()
temp=[]
answer=[]
for i in range(len(s)) :
    #닫힌 괄호가 나오면
    if(s[i]=='>') :
        temp.append(s[i])
        answer.append(''.join(temp)) #join함수 문자들을 이어붙여하나의 문자열
        #임시리스트 초기화
        temp=[]


    #열린 괄호가 나오면
    elif(s[i]=='<') :
        temp.reverse()
        answer.append(''.join(temp))
        temp=[s[i]]



    #공백 문자인데 괄호밖이라면
    elif(s[i]==' 'and '<' not in temp) :
        temp.reverse()
        answer.append(''.join(temp))
        answer.append(' ')
        temp=[]
    #그냥 변수
    else :
        temp.append(s[i])

if(temp) :
    temp.reverse()
    answer.append(''.join(temp))

print(''.join(answer))






