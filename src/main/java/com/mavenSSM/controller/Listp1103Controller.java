package com.mavenSSM.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mavenSSM.model.Listp1103;
import com.mavenSSM.service.Listp1103Service;
import com.mavenSSM.service.Listp1104Service;
import com.mavenSSM.service.Listp1114Service;
import com.mavenSSM.service.Listp1115Service;

@Controller
@RequestMapping("/testing")
public class Listp1103Controller {
	
	@Autowired
	private Listp1103Service listp1103Service;
	@Autowired
	private Listp1104Service listp1104Service;
	@Autowired
	private Listp1114Service listp1114Service;
	@Autowired
	private Listp1115Service listp1115Service;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String totesting(){
		return "testing";
	}
	
	@RequestMapping(value="/getAllList", method=RequestMethod.POST)
	@ResponseBody
	public List handlerGetAllListAjax(@RequestParam("table") String table){
		switch(table){
			case "1103":
				return listp1103Service.getAllListp1103();
			case "1104":
				return listp1104Service.getAllListp1104();
			case "1114":
				return listp1114Service.getAllListp1114();
			case "1115":
				return listp1115Service.getAllListp1115();
		}
		return listp1103Service.getAllListp1103();
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Integer> handlerAddItemAjax(@RequestBody Listp1103 list){
		int id = listp1103Service.addNewItem(list);
		Map<String, Integer>map = new HashMap<>();
		map.put("id", id);
		return map;
	}
	
	@RequestMapping(value="/editItem", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> handlerEditItemAjax(@RequestBody Listp1103 list){
		Map<String,Boolean> map = new HashMap<>();
		map.put("success", true);
		listp1103Service.editItem(list);
		return map;
	}
}
