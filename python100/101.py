#!/usr/local/bin/python3
"""
항상 상대방의 기분을 살피는 윤석이는 이제는 상대방의 시각마저도 고려하려 합니다.
그래서 숫자로 예시를 들때 자신이 보는 숫자와 상대방이 보는 숫자를 예시로 들어주려합니다.
윤석이는 예시로 들기 좋은 숫자만을 꺼내기위해 자신이 적으려는 숫자가 상대방에게도 똑같이 보이는지 확인하고 싶습니다.범위가 주어지면 위와 같이 판별하여 나의시점과 너의시점이 일치하는 함수
"""
def solution(start, end):
    tem=[]
    fin=[]
    for i in range(start,end):
        i = str(i)
        tem += i
        if (len(tem) == 1) and (tem[0] == '0' or tem[0] == '1' or tem[0] == '3' or tem[0] == '8'):
            fin.append(i)
        if (len(tem) > 1) and (tem[0] == '0' or tem[0] == '1' or tem[0] == '3' or tem[0] == '8'):
            if len(tem)%2 == 0:
                if (tem[0] == tem[len(tem)-1]) and (tem == tem[::-1]):
                    fin.append(i)
            if len(tem)%2 == 1:
                if (tem[0] == tem[len(tem)-1]) and (tem[len(tem)//2] == '0' or tem[len(tem)//2] == '1' or tem[len(tem)//2] == '3' or tem[len(tem)//2] == '8'):
                    if tem == tem[::-1]:
                        fin.append(i)
        if (len(tem) == 2) and ((tem[0] == '6' and tem[len(tem)-1] == '9') or (tem[0] == '9' and tem[len(tem)-1] == '6')):
            fin.append(i)
        if (len(tem) > 2) and ((tem[0] == '6' and tem[len(tem)-1] == '9') or (tem[0] == '9' and tem[len(tem)-1] == '6')):
            del tem[0]
            del tem[len(tem)-1]
            if len(tem)%2 == 0:
                if tem == tem[::-1]:
                    fin.append(i)
            if len(tem)%2 == 1:
                if tem[len(tem)//2] == '0' or tem[len(tem)//2] =='1' or tem[len(tem)//2] =='3' or tem[len(tem)//2] =='8':
                    if tem == tem[::-1]:
                        fin.append(i)
        tem.clear()
                        
    print(fin)
        
start = int(input("start number?")
end = int(input("end number?")

solution(start,end)
#solution(0,101)

