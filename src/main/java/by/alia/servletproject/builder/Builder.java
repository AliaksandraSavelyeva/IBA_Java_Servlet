package by.alia.servletproject.builder;

import by.alia.servletproject.exception.RepositoryException;
import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
