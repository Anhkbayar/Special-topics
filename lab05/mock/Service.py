class EmailService:
    def send_email(self, email_address, message):
        print(f"Sending real email to {email_address}")

class OrderService:
    def __init__(self, email_service):
        self.email_service = email_service
    
    def place_order(self, order_id, user_email):
        print(f"Order {order_id} saved to database")

        self.email_service.send_email(user_email, "Order completed")
