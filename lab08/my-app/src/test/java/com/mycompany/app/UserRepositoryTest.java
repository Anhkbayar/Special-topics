package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.mycompany.app.repository.User;
import com.mycompany.app.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserRepositoryTest {

  private UserRepository userRepository;

  @Mock private DataSource dataSource;

  @Mock private Connection connection;

  @Mock private PreparedStatement preparedStatement;

  @Mock private ResultSet resultSet;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    userRepository = new UserRepository(dataSource);
  }

  @Test
  void getUserById_shouldReturnUser_whenUserExists() throws SQLException {
    // Arrange
    int userId = 1;
    String userName = "John Doe";
    String userEmail = "john@example.com";

    when(dataSource.getConnection()).thenReturn(connection);
    when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(resultSet.next()).thenReturn(true);
    when(resultSet.getInt("id")).thenReturn(userId);
    when(resultSet.getString("name")).thenReturn(userName);
    when(resultSet.getString("email")).thenReturn(userEmail);

    // Act
    User result = userRepository.getUserById(userId);

    // Assert
    assertNotNull(result);
    assertEquals(userId, result.getId());
    assertEquals(userName, result.getName());
    assertEquals(userEmail, result.getEmail());

    // Verify interactions
    verify(dataSource).getConnection();
    verify(connection).prepareStatement("SELECT id, name, email FROM users WHERE id = ?");
    verify(preparedStatement).setInt(1, userId);
    verify(preparedStatement).executeQuery();
  }

  @Test
  void getUserById_shouldReturnNull_whenUserDoesNotExist() throws SQLException {
    // Arrange
    int userId = 999;

    when(dataSource.getConnection()).thenReturn(connection);
    when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(resultSet.next()).thenReturn(false);

    // Act
    User result = userRepository.getUserById(userId);

    // Assert
    assertNull(result);

    // Verify interactions
    verify(dataSource).getConnection();
    verify(preparedStatement).setInt(1, userId);
    verify(preparedStatement).executeQuery();
  }

  @Test
  void getUserById_shouldThrowSQLException_whenDatabaseConnectionFails() throws SQLException {
    // Arrange
    int userId = 1;
    when(dataSource.getConnection()).thenThrow(new SQLException("Database connection failed"));

    // Act & Assert
    assertThrows(SQLException.class, () -> userRepository.getUserById(userId));

    // Verify
    verify(dataSource).getConnection();
  }

  @Test
  void getUserById_shouldSetCorrectParameter_inPreparedStatement() throws SQLException {
    // Arrange
    int userId = 42;
    when(dataSource.getConnection()).thenReturn(connection);
    when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(resultSet.next()).thenReturn(false);

    // Act
    userRepository.getUserById(userId);

    // Assert
    verify(preparedStatement).setInt(1, userId);
  }
}
