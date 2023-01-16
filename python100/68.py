#!/usr/local/bin/python3
"""
버스시간표와 현재 시간이 주어졌을 때 버스 도착 시간이 얼마나 남았는지 알려주는 프로그램. 버스 시간표와 현재시간이 입력으루 주어집니다.
- 출력 포맷은 "00시00분"입니다.  만약 1시간 3분이 남았다면 "01시간03분"으로 출력- 버스 시간표에 현재 시간보다 이전인 버스가 있다면 "지나갔습니다."라고 출력
입력
["12:30", "13:20", "14:13"]
"12:40"
출력
['지나갔습니다', '0시간 40분', '1시간 33분']
def sol(tb, rt):
    answer = []
    rt = rt.split(':')
    for i in range(len(tb)):
        time = tb[i].split(':')
        time_to_min = ((int(time[0])*60 + int(time[1])) - (int(rt[0])*60+int(rt[1])))
        if time_to_min < 0:
            answer.append("지나갔습니다")
        else:
            a = (time_to_min) // 60
            b = (time_to_min) % 60
            answer.append(str(a).zfill(2)+'시간 '+str(b).zfill(2)+'분')
    return answer

sol(["12:30", "13:20", "14:13"], "12:40")
---------
"""
def bus(data,now):
    now=list(map(int,now.split(":")))
    res=[]
    for i in data:
        time= list(map(int,i.split(":")))
        if time[0] > now[0]:
            if time[1] >= now[1]:
                res.append(f"{time[0]-now[0]}:{time[1]-now[1]}")
            elif time[1] < now[1]:
                res.append(f"{time[0]-now[0]-1}:{60-now[1]+time[1]}")
            else:
                res.append("passed")
        elif time[0] == now[0]:
            if time[1] >= now[1]:
                res.append(f"0:{time[1]-now[1]}")
            else:
                res.append("passed")
        else:
            res.append("passed")
    return res
data=["12:30", "13:20", "14:13"]
now="12:40"
print(bus(data,now))
