package by.alia.servletproject.builder;

import by.alia.servletproject.exception.RepositoryException;
import by.alia.servletproject.model.User;
import by.alia.servletproject.repository.dbconstans.UserTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {
    @Override
    public User build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(UserTableConstants.ID.getFieldName());
            String login = resultSet.getString(UserTableConstants.LOGIN.getFieldName());
            byte[] password = resultSet.getBytes(UserTableConstants.PASSWORD.getFieldName());
            return new User(login, password);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }
}
