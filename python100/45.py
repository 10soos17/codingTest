#!/usr/local/bin/python3
"""
time 모듈은 1970년 1월 1일 0시 0분 0초 이후로부터 지금까지 흐른 시간을 초단위로 반환합니다. 현재 연도(2019)를 출력해보세요
print(time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(time.time())))
2019-11-14 03:06:07 출력됨
https://blog.naver.com/yuyyulee/221325508792
import time

print(time.strftime("%Y",time.localtime(time.time())))

--------
"""
import time
t = time.time()
t = int(t//(3600*24*365))+1970
print(t)
