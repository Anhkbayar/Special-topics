package com.mycompany.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserRepository {
    private final DataSource dataSource;

    public UserRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public User getUserById(int id) throws SQLException{
        String sql = "SELECT id, name, email FROM users WHERE id = ?";

        try(Connection conn = dataSource.getConnection();
    PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }

        return null;
    }
    }
}
