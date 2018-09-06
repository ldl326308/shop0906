package util;

import java.sql.*;

public class DBUtil {

    static Connection conn = null ;   //连接对象
    static Statement stmt = null ;  //执行命令对象
    static String DBDRIVER = "com.mysql.jdbc.Driver";  //驱动
    static String DBURL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=GMT%2B8";    //服务器地址
    static String DBUSER ="root";   //登入用户名
    static String DBPWD ="root";    //登入密码


    //打开连接方法
    public static void open(){
        try {
            //加载驱动
            Class.forName(DBDRIVER);
            //获得连接对象
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    public static void close(){
            try {
                if(stmt != null){
                stmt.close();
                }
                if(conn != null && conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    //获得连接对象方法
    public static Connection getConnection(){
        try{
            if(conn==null || conn.isClosed()){
                open();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }


    //查询方法
    public static ResultSet executeQuery(String sql){
            try {
                open(); //打开连接
                stmt = conn.createStatement();
                return stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    public static int executeUpdate(String sql){
        try {
            open();
            stmt = conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }


    public static ResultSet executeQuery(String sql,Object[] in){
        try {
            open();
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i=0;i<in.length;i++){
                pst.setObject(i+1,in[i]);
            }
            stmt = pst;
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static int executeUpdate(String sql,Object[] in){
        try {
            open();
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i=0;i<in.length;i++){
                pst.setObject(i+1,in[i]);
            }
            stmt = pst;
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close();
        }
        return 0;
    }
}
