import time
f = open("Murder-on-the-2nd-Floor-Raw-Data-v01.json","r")
dict1 = {}

def key_finder(a):
    b = a.split('"')
    c = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime(int(b[1])))
    return c

def values(a):
    b = a.split('"')
    return b[1],b[3]

while True:
    line = f.readline()
    if ":" in line and "{" in line:
        dict2 = {}
        key = key_finder(line)
        device = values(f.readline())
        device_id = values(f.readline())
        event = values(f.readline())
        guest_id = values(f.readline())
        dict2[device[0]] = device[1]
        dict2[device_id[0]] = device_id[1]
        dict2[event[0]] = event[1]
        dict2[guest_id[0]] = guest_id[1]
        dict1[key] = dict2




    elif "," not in line and "}" in line:
        break

for i in dict1:
    print(i,dict1[i])




