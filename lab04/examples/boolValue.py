def user_exists(users, username):
    return any(user['name'] == username for user in users)

users = [{'name': 'Ankha'}, {'name': 'Bataa'}]
if user_exists(users, 'Tsetseg'):
    print("Found")
else:
    print("Not found")  # Not found