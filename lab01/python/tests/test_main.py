import unittest
from src import main

class TestInsertionSort(unittest.TestCase):
    def test_insertion_sort(self):
        lst = [12,3,7,9,14,6,11,2]
        main.insertion_sort(lst, len(lst))
        self.assertEqual([2,3,6,7,9,11,12,14],lst)

if __name__ == "__main__":
    unittest.main()