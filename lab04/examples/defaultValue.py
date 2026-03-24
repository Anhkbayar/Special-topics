def find_user(users, username):
    for user in users:
        if user['name'] == username:
            return user
    return {}  # None-ийн оронд хоосон dictionary буцаах

users = [{'name': 'Ankha'}, {'name': 'Bataa'}]
result = find_user(users, 'Tsetseg')

print(result.get('name', 'Not found'))  # "Not found"