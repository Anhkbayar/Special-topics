def find_user(users, username):
    for user in users:
        if user['name'] == username:
            return user
    raise ValueError(f"User {username} not found")

users = [{'name': 'Ankha'}, {'name': 'Bataa'}]
result = find_user(users, 'Tsetseg')  # ValueError: User Tsetseg not found