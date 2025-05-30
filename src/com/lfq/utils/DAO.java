package com.lfq.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {


    GameWin gameWin=new GameWin();
    {
        int score=gameWin.getScore();
    }
    /*
     * 增加分数的方法
     */
    public static void save(int score) throws Exception{
        score=0;
        PreparedStatement ps=null;
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            String sql ="INSERT INTO login values(null,null,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(3,score);
            int count=ps.executeUpdate();
            if(count>0){
                System.out.println("插入成功");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }

}