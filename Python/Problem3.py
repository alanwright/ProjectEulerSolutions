import math

bound = 600851475143
size = math.floor(math.sqrt(bound))
sieve = [True]*size

#Lets do sieve :)
for i in range(2, size - 1, 1):
	for j in range(i*2, size-1, i):
		sieve[j] = False

#Loop backwards and print largest prime that is a multiple of bound
for i in range(size - 1, 0, -1):
	if sieve[i] and bound % i == 0:
		print(i)
		break