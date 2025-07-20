package model;

//Implementacao do DAO para JavaDB
/**
 * @author Plinio Vilela - prvilela@unicamp.br
 * @date April 14, 2020
 */
import java.sql.*;

public abstract class DAO {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://xmysql3.sipop.com.br:3306/sipop7";
    private static Connection con;

    // metodo para criar a conexao com JavaDB
    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(DBURL, "sipop7", "plinio123456");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query,Object... params) {
        PreparedStatement s;
        ResultSet rs = null;
        try {
            s =  con.prepareStatement(query);
            for(int i=0;i<params.length;i++){
                s.setObject(i+1, params[i]);
            }
            rs = s.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}