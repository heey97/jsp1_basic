package project.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomBuyVo {
    private int buy_IDX;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp Buy_date;

    @Override
    public String toString() {
        return buy_IDX + ", " + pcode + ", " + pname + ", " + price
                + ", " + quantity + ", " + Buy_date+"\n";
    }
}
