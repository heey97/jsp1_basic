package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;
import project.vo.ProductVo;

public class MybatisProductDao {
	
	private static SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisProductDao() {
		//테스트 db연결 나중에는 지울겁니다
		SqlSession sqlSession = sessionFactory.openSession();
		System.out.println("db연결 및 sql 실행객체 : " + sqlSession);
	}
	//SqlSession 객체 insert,update,delete,select 메소드는 SQL을 실행합니다.
	//			ㄴ 첫번째 인자 sql매퍼 파일은 namespace속성.id속성
	//			ㄴ 두번째 인자는 sql 실행에 파라미터가 있으면 작성합니다.
	public List<ProductDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproducts.selAll");
		sqlSession.close();
		return list;
	}
	public List<ProductDto> selCtg(String s){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproducts.selCtg");
		sqlSession.close();
		return list;
	}
//	public int delete(int buyidx) {
//		SqlSession sqlSession=sessionFactory.openSession();
//		int result = sqlSession.delete("tblbuy.delete",buyidx);
//		sqlSession.close();
//		return result;
//	}
	//마이바티스는 auto commit이 아닙니다. 그래서 커밋을 직접찍어줘야댑니다 sqlSession.commit();
//	public int insert(BuyDto dto) {
//		SqlSession sqlSession = sessionFactory.openSession();
//		int result = sqlSession.delete("tblbuy.insert",dto);
//		sqlSession.commit();
//		sqlSession.close();
//		return result;
//	}
//	public int update(Map<String,Integer>map) {
//		SqlSession sqlSession = sessionFactory.openSession();
//		int result = sqlSession.delete("tblbuy.update",map);
//		sqlSession.close();
//		return result;
//	}
}
