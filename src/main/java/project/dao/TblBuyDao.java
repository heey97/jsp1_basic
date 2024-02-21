package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import project.vo.BuyVo;
import project.vo.CustomBuyVo;

public class TblBuyDao {
    
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "9999";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //executeUpdate 메소드는 insert,update,delete 가 정상 실행되면(반영된 행이 있으면) 1을 리턴,
    //                       특히 update, delete 는 반영된 행이 없으면 0을 리턴한다.
    //구매하기
    public int insert(BuyVo vo){
        // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="INSERT INTO TBL_BUY \r\n" + 
                "VALUES (buy_pk_seq.nextval, ?,?,?,sysdate)";
        int result=0;
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
               pstmt.setString(1, vo.getCustomid());
               pstmt.setString(2, vo.getPcode());
               pstmt.setInt(3, vo.getQuantity());
               result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음

        return result;
    }
    
    //장바구니 모두 구매
    // ㄴ batch(배치)는 일괄처리 : 실행할 insert,update,delete 등의 데이터 저장DML을 여러개 모아 두었다가 한번에 실행시킵니다.
    // ㄴ 트랜잭션 : 특정 요구사항에 대한 기능을 실행할 '여러 SQL 명령들'로 구성된 '작업단위'
            // ㄴ 예시 : cart에 저장된 상품 중 하나라도 참조값이 없는 pcode 가 있으면 rollback, 모두 정상이면 commit
            //          트랜잭션 commit 모드가 auto에서 수동으로 변경
    public int insertMany(List<BuyVo> cart){                // 여러번 (cart 크기)의 insert 를 실행합니다.
        String sql="INSERT INTO TBL_BUY \r\n" +             // 위의 insert 복붙하세요.
                "VALUES (buy_pk_seq.nextval, ?,?,?,sysdate)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for(BuyVo vo: cart){
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();               // sql 을 batch 메소드로 메모리에 모아두었다가  for 문이 끝나면 executebatch 로 실행
                count++;
            }
        pstmt.executeBatch();       // 모아둔 sql 을 일괄 실행하기. 실행중에 무결성 오류 생기면
        conn.commit();              // catch에서 rollback
        }catch(SQLException e){     // 예외발생 : xmfoswortus cjfl
            try {
                conn.rollback();
            } catch (Exception e1) {}
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 예외: " + e.getMessage());
        }finally{
            try {
                pstmt.close();
                conn.close();    
            } catch (Exception e) {}
        }
        return count;
    }

    //회원정보수정
    public int modify(BuyVo vo) {
        int result=0;
        String sql=  "UPDATE tbl_buy " + 
                "SET QUANTITY = ? " + 
                "WHERE BUY_IDX = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setInt(1, vo.getQuantity());
                pstmt.setInt(2, vo.getBuyIdx());
                result = pstmt.executeUpdate();          //실행
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }
    //구매 취소
    public int delete(int buyIdx) {

        String sql=  "DELETE FROM tbl_buy \r\n" + //
                "WHERE BUY_IDX=?";

        int result=0;
        try (
            Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
        )
            {   
                //매개변수 바인딩
                pstmt.setInt(1, buyIdx);
                result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }
    public List<CustomBuyVo> selectBuyList(String id){
        String sql ="SELECT BUY_IDX ,tb.PCODE,PNAME,PRICE,QUANTITY ,BUY_DATE "+ 
                    "FROM TBL_BUY tb        "+
                    "JOIN TBL_PRODUCT tp    "+
                    "ON tb.PCODE =tp.PCODE  "+
                    "WHERE tb.CUSTOMID = ?  "+
                    "ORDER BY BUY_IDX";
        List<CustomBuyVo> list = new ArrayList<>();
        
        try (Connection conn = getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                CustomBuyVo vo =new CustomBuyVo(rs.getInt(1), rs.getString(2), rs.getString(3),
                							    rs.getInt(4), rs.getInt(5), rs.getTimestamp(6));
                list.add(vo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
 }
