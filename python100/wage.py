#!/usr/bin/python3

wage = int(input("wage?"))

nPensionPer = 0.09
hInsurancePer = 0.0667
LNurInsurancePer = 0.1025
eInsurancePer = 0.008

nPension = wage * (nPensionPer/2)
hInsurance = wage * (hInsurancePer/2)
LNurInsurance = (wage * hInsurancePer * LNurInsurancePer)/2
eInsurance = wage * eInsurancePer

duruPer = float(input("Duru?"))
nPensionDuruPer = 1- duruPer
eInsuranceDuruPer = 1 - duruPer

nPensionDuru = nPension * nPensionDuruPer
eInsuranceDuru = eInsurance * eInsuranceDuruPer

taxWage = wage - (nPension + hInsurance + LNurInsurance + eInsurance)
duruWage = wage - (nPensionDuru + hInsurance + LNurInsurance + eInsuranceDuru)

print("National pension:{}\nHealth insurance:{}\nLongterm nursing insurance:{}\nemployment insurance:{}\nDuru national insurance:{}\nDuru employment insurance:{}".
format(nPension,hInsurance,LNurInsurance,eInsurance,nPensionDuru,eInsuranceDuru))
print("Basic wage: {}\nNet wage: {}\nDuru wage: {}\n".format(wage, taxWage, duruWage))

