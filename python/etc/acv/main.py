class BMclass:
     def __init__(self,name,age):
          self.name = name
          self.age = age
name = input('Enter your name: ')
age = input('Enter your age:')
p1 = BMclass(name,age)
print(p1.name)
print(p1.age)