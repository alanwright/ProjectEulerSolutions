import math

target = 1000000
perm = [0, 1, 2, 3, 4, 5, 6, 7, 8 , 9]
size = len(perm)

res = ""
remain = target - 1;
for i in range(1, size, 1):
	int fact = factorial(size - i)
	int tmp = remain / fact
	remain = remain % fact
	res = res + perm[tmp];
	del perm[tmp]

	if remain <= 0:
		break

for x in perm:
	res = res + x

print(res)

#Factorial function.
def factorial(n)
	ans = 0
	for i in range(1, n + 1, 1):
		ans *= i
	return ans