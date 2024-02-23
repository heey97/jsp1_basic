package day4.mybatis.dto;

import java.util.Date;

import lombok.AllArgsConstructor; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//웹에서는 vo 단어 대신 dto 마니 씁니다.
//data transfer object. 서블릿(컨트롤러), jsp(부) 사이에서 데이터를 전달해주는 역할


//마이바티스에서 매핑 할때 객체는 기본생성자가 있으면 기본생성자로 없으면 커스텀 생성자로 객체 생성
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor			//커스텀 생성자 : 컬럼명과 변수명 일치 안해도 된다.
							//			  변수선선 순서와 컬럼순서는 일치해야 합니다.
//@NoArgsConstructor		//기본  생성자 : 객체 생성 후 setter 로 동작하므로 컬럼명과 변수명 일치해야함.
public class BuyDto {
	private int buyIdx;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buyDate;
}
