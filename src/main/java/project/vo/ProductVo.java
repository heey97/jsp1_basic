package project.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ProductVo {
    private String category;
    private String pcode;
    private String pname;
    private int price;

    public ProductVo(String pcode,String category , String pname, int price) {
        this.category = category;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d",category,pcode,pname,price);
    }
}
