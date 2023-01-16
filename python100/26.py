#!/usr/local/bin/python3
"""
행성의 한글 이름을 입력하면 영어 이름을 반환하는 프로그램
"""
planet = str(input("planet?"))
planets={"수성":"Mercury","금성":"Venus","지구":"Earth","화성":"Mars","목성":"Jupiter","토성":"Saturn","명왕성":"Uranus","해왕성":"Neptune"}
print(planets[planet])
