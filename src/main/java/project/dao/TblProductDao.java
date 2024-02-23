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

import project.vo.CustomerVo;
import project.vo.ProductVo;

public class TblProductDao {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
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
    public List<ProductVo> selAll() {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM TBL_PRODUCT";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            	ProductVo vo = new ProductVo(rs.getString(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getInt(4));
                list.add(vo);
            }
            // dao 메소드에는 특별한 목적이 아니면 출력문 작성안합니다 출력은 메인에서
        } catch (SQLException e) {
            System.out.println("예외발생"+e.getMessage());
        }
        return list; // 자바객체 list와 매핑한 결과 list 를 리턴
    }
    
    public void insData(ProductVo vo) {

        String sql = "INSERT INTO TBL_PRODUCT " +
                "VALUES(?,?,?,?)";
        // auto close
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);) {
        	
            pstmt.setString(1, vo.getCategory());
            pstmt.setString(2, vo.getPcode());
            pstmt.setString(3, vo.getPname());
            pstmt.setInt(4, vo.getPrice());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }
}
