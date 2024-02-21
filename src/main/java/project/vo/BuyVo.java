package project.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
public class BuyVo {
	private int buyIdx;
	private String customid;
	private String pcode;
	private int quantity;
	private Date buyDate;
	
	public BuyVo(int buyIdx, String customid, String pcode, int quantity, Date buyDate) {
		this.buyIdx = buyIdx;
		this.customid = customid;
		this.pcode = pcode;
		this.quantity = quantity;
		this.buyDate = buyDate;
	}

	@Override
	public String toString() {
		return buyIdx + ", " + customid + ", " + pcode + ", " + quantity
				+ ", " + buyDate;
	}
}
//필드값이 모두 값으면 equals 로 true 가 되도록 하고싶다.
//-> equals 와 hashcode 를 재정의해야 합니다. (vo 객체)
//-> 이러한 객체는 테스트 과정에서 객체를 비교할 때 사용할 수 있습니다.