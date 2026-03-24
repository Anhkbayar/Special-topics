def find_user(users, username):
    for user in users:
        if user['name'] == username:
            return user
    return None  # Хэрэглэгч олдохгүй бол None буцаана

users = [{'name': 'Ankha'}, {'name': 'Bataa'}]
result = find_user(users, 'Tsetseg')

print(result['name'])  #TypeError