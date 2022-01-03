from collections import Counter
data = [1, 2, -4 , -3]
for i ,num in enumerate(data):
     if num < 0:
          data[i] = 0

print(data,'',"\n")
#####
squares = []
for i in range(10):
     squares.append(i*i)

print(squares,'',"\n")

#####
data = [3, 5, 1, 10, 9]
sorted_data = sorted(data, reverse=True)

print(sorted_data,''," ")


my_dict = {"item":"football","price": 10.00}
count = my_dict.get("count")
print(count,'',"\n")

count = my_dict.setdefault("count",0)
print(count,'',"\n")
print(my_dict,'',"\n")

list_ = [10,10,10,5,5,5,2,9,9,7,7,7,3,3,5,5]

counter = Counter(list_)

print(counter[11],'',"\n")

name = "Bruno"

my_string = f"Hello {name}"
print(my_string,'',"\n")

list_of_strings = ["hello","my","friend"]

my_string = " ".join(list_of_strings)
print(list_of_strings,'',"\n")

d1 = {"name":"Bruno","age":23}
d2 = {"name": "Bruno","city": "Capiata"}
merge_dict = {**d1,**d2}
print(merge_dict,'',"\n")

colors = ["red","green","blue"]

c = "red"
if c in colors:
     print("is main color")