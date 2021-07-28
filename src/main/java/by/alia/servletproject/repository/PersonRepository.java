package by.alia.servletproject.repository;

import by.alia.servletproject.builder.PersonBuilder;
import by.alia.servletproject.exception.RepositoryException;
import by.alia.servletproject.model.Person;
import by.alia.servletproject.repository.dbconstans.PersonTableConstants;
import by.alia.servletproject.repository.specification.Parameter;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonRepository extends AbstractRepository<Person> {
    private static final String TABLE_NAME = "persons";
    public PersonRepository(Connection connection) {
        super(connection);
    }

    @Override protected String getTableName() {
        return TABLE_NAME;
    }

    @Override public List<Person> query(String sqlString, Parameter paramater) throws RepositoryException {
        String query = sqlString;
        List<Person> persons = executeQuery(query, new PersonBuilder(), paramater.getParameters());
        return persons;
    }

    @Override
    public Optional<Person> queryForSingleResult(String sqlString, Parameter parameter) throws RepositoryException {
        List<Person> person = query(sqlString, parameter);
        return person.size() == 1 ? Optional.of(person.get(0)) : Optional.empty();
    }
    public Map<String,Object> getFields(Person person) {
        Map<String,Object> fields = new HashMap<>();
        fields.put(PersonTableConstants.NAME.getFieldName(), person.getName());
        fields.put(PersonTableConstants.PHONE.getFieldName(), person.getPhone());
        fields.put(PersonTableConstants.EMAIL.getFieldName(), person.getEmail());
        return fields;
    }
}