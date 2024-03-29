#!/usr/local/bin/python3
"""
n명의 택배 배달원은 쌓인 택배를 배달해야 합니다.
각 택배는 접수된 순서로 배달이 되며 택배 마다 거리가 주어집니다. 
거리1당 1의 시간이 걸린다고 가정하였을 때 모든 택배가 배달 완료될 시간을 구하세요.
1. 모든 택배의 배송 시간 1 이상이며 배달지에 도착하고 돌아오는 왕복시간입니다.
2. 택배는 물류창고에서 출발합니다.
3. 배달을 완료하면 다시 물류창고로 돌아가 택배를 받습니다.
4. 물류창고로 돌아가 택배를 받으면 배달을 시작합니다.
5. 택배를 상차 할 때 시간은 걸리지 않습니다.
입력은 배달원의 수와 택배를 배달하는 배달 시간이 주어집니다.
ex) 배달원이 3명이고 각 거리가 [1,2,1,3,3,3]인 순서로 들어오는 경우
"""

def deliever(man,order):
    num=[0 for i in range(man)]
    n=0
    m=0
    for i in range(man):
        for j in range(0,len(order),man):
            num[i]+=order[n+m]
            n+=man
            if n > len(order):
                break
        n=0
        m+=1  
    return max(num)

man=3
order=[1,2,1,3,3,3]
print(deliever(man,order))
