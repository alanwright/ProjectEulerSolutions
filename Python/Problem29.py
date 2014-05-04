#64 ms
import timeit

tik = timeit.default_timer()

# A hashma will handle everything for us :)
map = {}

for base in range(2,101,1):
	for exp in range(2, 101, 1):
		map[base**exp] = str(base) + '^' + str(exp)

tok = timeit.default_timer()
print(len(map))
print("Soultion took:", (tok - tik) * 1000, "ms.")