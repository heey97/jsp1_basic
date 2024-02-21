package project.vo;

import java.util.ArrayList;
import java.util.List;

import project.dao.TblCustomerDao;

public class main1 {
	public static void main(String[] args) {
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = new ArrayList<>();
		list = dao.allCustomers();
		
		for(CustomerVo vo : list) {
			System.out.println(vo);
		}
	}
}
