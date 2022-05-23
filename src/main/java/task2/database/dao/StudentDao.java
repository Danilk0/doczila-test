package task2.database.dao;

import org.springframework.stereotype.Repository;
import task2.database.entety.Student;
import task2.database.util.HikariCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao implements CrudDao<Student,Integer> {
    private static final String SAVE_SQL= """
            insert into student(name, second_name, surname, birth_date, "group") 
            values (?,?,?,?,?);
            """;
    private static final String DELETE_SQL= """
            delete from student
            where id = ?
            """;
    private static final String FIND_ALL_SQL= """
            select * from student
            """;
    @Override
    public Integer save(Student object) {
        try(var connection = HikariCPDataSource.getConnection()){
            var preparedStatement = connection.prepareStatement(SAVE_SQL);
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getSecondName());
            preparedStatement.setString(3,object.getSurname());
            preparedStatement.setDate(4, Date.valueOf(object.getBirthDate()));
            preparedStatement.setInt(5,object.getGroup());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    @Override
    public boolean delete(Integer id) {
        try (var connection = HikariCPDataSource.getConnection();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        try (var connection = HikariCPDataSource.getConnection();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(buildStudent(resultSet));
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Student buildStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("second_name"),
                resultSet.getString("surname"),
                resultSet.getDate("birth_date").toLocalDate(),
                resultSet.getInt("group")
        );
    }
}
