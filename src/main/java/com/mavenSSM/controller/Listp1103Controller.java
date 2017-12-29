package com.mavenSSM.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mavenSSM.model.Listp1103;
import com.mavenSSM.service.Listp1103Service;

@Controller
@RequestMapping("/testing")
public class Listp1103Controller {
	
	@Autowired
	private Listp1103Service listpService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String totesting(){
		return "testing";
	}
	
	@RequestMapping(value="/getAllList", method=RequestMethod.POST)
	@ResponseBody
	public List<Listp1103> handlerGetAllListAjax(){
		return listpService.getAllListp1103();
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Integer> handlerAddItemAjax(@RequestBody Listp1103 list){
		int id = listpService.addNewItem(list);
		Map<String, Integer>map = new HashMap<>();
		map.put("id", id);
		return map;
	}
	
	@RequestMapping(value="/editItem", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> handlerEditItemAjax(@RequestBody Listp1103 list){
		Map<String,Boolean> map = new HashMap<>();
		map.put("success", true);
		listpService.editItem(list);
		return map;
	}
}
