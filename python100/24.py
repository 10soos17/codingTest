#!/usr/local/bin/python3
"""
민지는 국제 포럼에서 아르바이트를 하게 되었습니다. 민지는 각 국에서 온 참가자들의 명단을 엑셀로 정리하고 있는데 참가자들 이름이 어떤 이는 전부 소문자, 어떤 이는 전부 대문자로 써져 있는 등 형식이 제각각이었습니다.
민지를 위해 이름이 입력되면 전부 대문자로 출력되는 프로그램을 만들어주세요.
name = input("이름?")
new = ""
for i in name:
   if i.islower():
     new += i.upper()
   else:
      new += i
print(new)
--------------
name = str(input("name?"))
upperName=""
for i in name:
    upperName+=i.upper()

print(upperName)
---------------------
"""
name = input()
print(name.upper())      
