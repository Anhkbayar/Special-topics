from typing import Optional

def greet(name: Optional[str]) -> None:
    if name is None:
        print("Hello, Guest!")
    else:
        print(f"Hello, {name}!")

greet("Anka")
greet(None)