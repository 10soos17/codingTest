#!/usr/bin/python3
"""369 게임- 3이나 6, 9 일 때만 박수.예를 들어 13, 16과 같이 3과 6, 9 만으로 된 숫자가 아닐 경우엔 박수를 치지 않습니다. 박수를 몇 번 쳤는지 확인하고 싶습니다. 36일 때 박수를 쳤다면 박수를 친 횟수는 5번입니다.

def three(num):
    count = 0
    a=0
    for i in range(1,num+1):
        new = list(str(i))
        for j in new:
            if j != "3" and j!= "6" and j != "9":
                break
            a+=1
            if a == len(new):
               count += 1
        a=0
    return count

num = int(input("number?"))
print(three(num))
-----------------
"""
def sol(n):
    n = list(str(n))
    answer = 0
    count = 1
    d = {3 : 1, 6 : 2, 9 : 3}
    
    while n:
        answer += d[int(n.pop())] * count
        count *= 3
        
    return answer
print(sol(93))


