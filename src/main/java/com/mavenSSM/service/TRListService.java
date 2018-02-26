package com.mavenSSM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mavenSSM.dao.TRListDao;
import com.mavenSSM.model.Trlist;

@Service
public class TRListService {
	@Autowired
	private TRListDao listDao;
	
	public List<Trlist> getAllTrlist(){
		return listDao.getAllTRList();
	}
	
	public int addNewItem(Trlist trlist){
		final String finishTime = trlist.getFinished_date();
		if(finishTime == "")
			trlist.setFinished_date(null);
		listDao.addNewItem(trlist);
		return trlist.getId();
	}
	
	public int editItem(Trlist trlist){
		final String finishTime = trlist.getFinished_date();
		if(finishTime == "" || finishTime.matches("\\s+"))
			trlist.setFinished_date(null);
		return listDao.editItem(trlist);
	}
}
