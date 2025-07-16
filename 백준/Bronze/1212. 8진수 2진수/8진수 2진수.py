#8진수를 2진수로
# N=input()
# result=0
# for i in range(len(N)):
#     result+=int(N[i])*(8**(len(N)-1-i))
#
# #8진수로르 10진수로 변환한 값이 result
# list1=[]
# while(result!=0) :
#     list1.append(result%2)
#     result=result//2
#
# for i in range(len(list1)-1,-1,-1) :
#     print(list1[i],end="")
N=input()
N=int(N,8)
print(format(N,'b'))