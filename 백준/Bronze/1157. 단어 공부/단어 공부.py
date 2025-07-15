result=input()

result=result.upper()

list1=[0]*26
# for i in range(len(result)) :
#     for j in range(0,26):
#         if(result[i]==chr(j+65)):
#             list1[j]+=1
for i in range(len(result)):
    list1[ord(result[i])-65]+=1
max=0
index=0
for i in range(len(list1)):
    if(max<list1[i]):
        max=list1[i]
        index=i
for i in range(len(list1)):
    if(max==list1[i] and i != index) :
        print("?")
        exit()
print(chr(index+65))




