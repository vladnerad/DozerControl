package database;

import java.sql.ResultSet;

public interface Processable {
    String getSQLcommand();
    void process(ResultSet resultSet);
}
