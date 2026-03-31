from typing import Optional

def greet(name: Optional[str] = None)-> None:
    print(name.upper())

greet("ankhbayar")
greet(456)