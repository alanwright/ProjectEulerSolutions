#725 ms
import timeit

tik = timeit.default_timer()

#All values would need to be a long in java or C, C#, etc.
mod = 10**10       # this keeps only 10 digits	
sum = 1

for i in range(2, 1001, 1):
	tmp = i

	# Multiply tmp by i, i times for i^i
	for j in range (1, i, 1):
		tmp *= i
		tmp %= mod	# this mod keeps only the last 10 digits

	sum += tmp
	sum %= mod		# this mod keeps only the last 10 digits

tok = timeit.default_timer()
print(sum)
print("Soultion took:", (tok - tik) * 1000, "ms.")