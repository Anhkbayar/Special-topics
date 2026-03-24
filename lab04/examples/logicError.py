def divide_by_value(x):
    if x == 0:   # only checks for 0
        return "Cannot divide by zero"
    return 10 / x

value = None
result = divide_by_value(value)
print(result)