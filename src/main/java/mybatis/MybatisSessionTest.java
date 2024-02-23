package mybatis;

import java.util.List;

import day4.mybatis.dao.MybatisBuyDao;
import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.ProductDto;

public class MybatisSessionTest {

	public static void main(String[] args) {
		
		MybatisBuyDao dao = new MybatisBuyDao();
		MybatisProductDao daoP = new MybatisProductDao();
		System.out.println("dao객체 : "+dao);
		
		System.out.println("===== selectAll 테스트 =====");
		List<BuyDto> list = dao.selectAll();
		System.out.println(list+"\n");
		
//		System.out.println("===== insert 테스트 =====");
//		int result = dao.insert(new BuyDto(0, "mina012", "CJBAb12g", 3, null));
//		System.out.println("반영된 행 개수 : "+ result);
		
		System.out.println("------------------product--------------------");
		
		List<ProductDto> listP = daoP.selectAll();
		
		for(ProductDto dto : listP) {
			System.out.println(dto+"\n");
		}
		
		
		System.out.println("------------------product up--------------------");
		List<ProductDto> listP1 = daoP.selCtg("B1");
		
		for(ProductDto dto : listP1) {
			System.out.println(dto+"\n");
		}

	}
}
