#!/usr/local/bin/python3
"""2020년 1월 1일은 수요일입니다. 2020년 a월 b일은 무슨 요일일까요?
두 수 a, b를 입력받아 2020년 a월 b일이 무슨 요일인지 리턴
일요일부터 토요일까지 각각 SUN, MON, TUE, WED, THU, FRI, SAT 입니다.
예를 들어 a = 5, b = 24라면 5월 24일은 일요일이므로 문자열 "SUN"를 반환하세요.
제한 조건
2020년은 윤년입니다.2020년 a월 b일은 실제로 있는 날입니다. 
(13월 26일이나 2월 45일 같은 날짜는 주어지지 않습니다.)
import datetime 모듈 사용
https://blog.naver.com/esak97/221706656741
--------------
def Day(a,b):
   day = ["TUE","WED","THU","FRI","SAT","SUN","MON"]

   if a == 1:
      rem = b%7
      ans = day[rem]
      print(ans)
   if a == 2:
      rem = (31 + b)%7
      ans = day[rem]
      print(ans)
   if a == 3:
      rem = ((a-1)*30 + b)%7
      ans = day[rem]
      print(ans)
   if 3 < a < 8:
      rem = ((a-1)*30 + a//3 + b)%7
      ans = day[rem]
      print(ans)
   if 8 <= a < 11 or a == 12:
      rem = ((a-1)*30 + a//3 + b + 1)%7
      ans = day[rem]
      print(ans)
   if a == 11:
      rem = ((a-1)*30 + a//3 + b + 2)%7
      ans = day[rem]
      print(ans)


a = int(input("Month?"))

while a <= 0 or a > 12:
   print("try again!")
   a = int(input("Month?"))

if a == 2:
   b = int(input("Day?"))
   while b < 0 or b > 29:
      print("try again!")
      b = int(input("Day?"))
      Day(a,b)
   Day(a,b)
if a == 1 or a ==3 or a ==5 or a ==7 or a ==8 or a ==10 or a ==12:
   b = int(input("Day?"))     
   while b < 0 or b > 31:
      print("try again!")
      b = int(input("Day?"))
      Day(a,b)
   Day(a,b)
if a == 4 or a ==6 or a ==9 or a ==11:
   b = int(input("Day?"))       
   while b < 0 or b > 30:
     print("try again!")
     b = int(input("Day?"))
     Day(a,b)
   Day(a,b)
"""
import datetime
m = int(input())
d = int(input())
def findDay(a,b):
    day = ["MON","TUE","WED","THU","FRI","SAT","SUN"]
    return day[datetime.date(2020,a,b).weekday()]
print(findDay(m,d))
