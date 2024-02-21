package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import project.vo.ProductVo;

public class TblProductDao {
        public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";
    

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    public List<ProductVo> selectByCategory(String category){
        String sql = "SELECT * FROM TBL_PRODUCT WHERE CATEGORY = ?";

        List<ProductVo> list = new ArrayList<>();
        try (Connection conn = getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                ProductVo vo = new ProductVo(rs.getString(1),
                                             rs.getString(2),
                                             rs.getString(3),
                                             rs.getInt(4));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("예외당");
        }
        
        return list;
    }


    /*                  리스트 */
    public List<ProductVo> selectByName(String name){
        String sql = "SELECT * FROM TBL_PRODUCT WHERE PNAME LIKE '%'||?||'%'";

        List<ProductVo> list = new ArrayList<>();
        try (Connection conn = getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                ProductVo vo = new ProductVo(rs.getString(1),
                                             rs.getString(2),
                                             rs.getString(3),
                                             rs.getInt(4));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("예외당");
        }
        
        return list;
    }
    public Map<String,Integer>getPriceTable(){
        String sql = "SELECT PCODE,PRICE FROM TBL_PRODUCT";
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                map.put(rs.getString(1),rs.getInt(2));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return map;
    }


}
