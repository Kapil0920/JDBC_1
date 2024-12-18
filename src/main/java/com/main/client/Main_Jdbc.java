package com.main.client;

import com.dao.HelperDao;
import com.dao.HelperDaoImpl;
import com.entity.Helper;

public class Main_Jdbc {
	

	public static void main(String[] args) {
		Helper h = new Helper(55,"'Monu'","male",500);
		
		HelperDaoImpl dao=new HelperDaoImpl();
//		dao.insert(h);
		
//		dao.updateHelper(h);
		
//		dao.insertByPS(h);
		
//		dao.deleteHelper(2);
		
		
//		dao.getHelperById(3);
		
//		dao.getAllHelper();
		
		
//		dao.getHelperByName("'Sonu' ");
		
		
		

	}

}
