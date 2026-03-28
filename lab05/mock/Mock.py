import unittest
from unittest.mock import Mock

from Service import OrderService

class TestOrderService(unittest.TestCase):
    def test_place_order_send_email_successfully(self):
        # 1. Mock объект үүсгэх
        mock_email_service = Mock()

        # 2. OrderService-ийн байгуулагч руу Mock-оо дамжуулах
        order_service = OrderService(mock_email_service)

        # 3. Тестлэх гэж буй функцээ дуудах
        user_email = "anka@example.com"
        order_service.place_order("ID1234", user_email)

        # 4. Шалгалт (Assertion)
        mock_email_service.send_email.assert_called_once_with(
            user_email, 
            "Order completed"
        )

if __name__ == '__main__':
    unittest.main()