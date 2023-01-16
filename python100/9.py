#!/usr/local/bin/python3
"""
[문제9 : sep과 end를활용한 출력방법]
2019/04/26 11:34:27
"""
year = '2019'
month = '04'
day = '26'
hour = '11'
minute = '34'
second = '27'

print(year, month, day, sep='/', end=' ')
print(hour, minute, second, sep=':')
