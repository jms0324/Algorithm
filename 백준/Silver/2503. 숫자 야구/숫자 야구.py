#A가 정답으로 생각할 ㅅ ㅜ잇는 모든ㅇ수
#그리고 B가 도전한 내용에 맞는지 확인하
N=int(input())
hint = [list(map(int,input().split())) for _ in range(N)]
ans=0

for a in range(1,10) : #100의 자리수
    for b in range(1,10): #10의 자리수
        for c in range(1,10): #1의 자리수

            if (a == b or b==c or a==c):
                continue
            valid=True


            #숫자가 정해지면
            for arr in hint :
                number=arr[0]
                strike=arr[1]
                ball=arr[2]
                cnt=0


                # a,b,c라는 숫자를
                # number라는 숫자와 비교
                ball_count = 0
                strike_count = 0

                if (a == int(number) // 100):
                    strike_count += 1
                if (b == int(number % 100 // 10)):
                    strike_count += 1
                if (c == int(number % 10)):
                    strike_count += 1

                if (a == int(number % 100 // 10) or a == int(number % 10)):
                    ball_count += 1

                if (b == int(number // 100) or b == int(number % 10)):
                    ball_count += 1

                if (c == int(number // 100) or c == int(number % 100 // 10)):
                    ball_count += 1

                if(strike != strike_count or ball != ball_count):
                    valid=False

                    break



            if(valid) :
                ans+=1










print(ans)