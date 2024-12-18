package com.dao;

import java.util.List;

import com.entity.Helper;

public interface HelperDao {
	public void insert(Helper h);

	public void insertByPS(Helper h);

	public void updateHelper(Helper h);

	public void deleteHelper(int id);

	public void getHelperById(int id);

	public void getHelperByName(String name);

	public void getAllHelper();
	
//	public List<Helper> getAllHelperRecord();

}
