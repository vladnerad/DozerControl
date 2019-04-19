package id;

import database.Processable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AbstractIntermediateId implements Processable {

    private int id;
    private String query;
    private StringBuffer sb;

    private static volatile AbstractIntermediateId instance;

    private AbstractIntermediateId(String table, HashMap<String, String> conditions) {
        sb = new StringBuffer(String.format("SELECT id FROM %s WHERE ", table));
        for(Map.Entry entry: conditions.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" AND ");
        }
        sb.delete(sb.length()-5, sb.length()).append(";");
        query = sb.toString();
//        System.out.println(query);
    }


    public static AbstractIntermediateId getInstance(String table, HashMap<String, String> conditions){
        AbstractIntermediateId result = instance;
        if (result == null) {
            synchronized (AbstractIntermediateId.class) {
                result = instance;
                if (result == null) {
                    instance = result = new AbstractIntermediateId(table, conditions);
                }
            }
        }
        return instance;
    }

    public static void reset(){
        instance = null;
    }

    public int getId(){
        return id;
    }

    @Override
    public String getSQLcommand() {
        return query;
    }

    @Override
    public void process(ResultSet resultSet) {
        try {
            id = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
