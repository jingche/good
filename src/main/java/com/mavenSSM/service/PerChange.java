package com.mavenSSM.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mavenSSM.model.Listp; 

 
@Component 
 @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
 public class PerChange { 
	public static void change(List<? extends Listp> list){ 
		for(Listp l: list){ 
 			l.setEffectiveness(changePer(l.getEffectiveness())); 
			l.setStability(changePer(l.getStability())); 
 		} 
 	} 
 	 
	private static String changePer(String num){
		if(num.endsWith("%")){
			Matcher m = Pattern.compile("^(\\d+\\.)(\\d+)%$").matcher(num);
			if(m.find()){
				final String dot = m.group(2);
				return m.group(1) + (dot.length() > 2 ? dot.substring(0,2) : dot) + "%";
			}
			return num;
		}
		if(num.matches("^0(\\.0*)?$"))
			return "0%";
		if(num.matches("^1(\\.0*)?$"))
			return "100%";
		StringBuilder sb = new StringBuilder();
		Matcher m = Pattern.compile("^\\d+\\.(\\d{1,2})(\\d*)$").matcher(num);
		if(m.find()){
			String pre = m.group(1);
			if(pre.length() == 1 && pre != "0")
				pre+="0";
			sb.append(pre);
			
			String dot = m.group(2);
			if(dot != null && dot.length() > 0){
				dot = dot.substring(0, Math.min(2, dot.length()));
				System.out.println(dot);
				sb.append(".").append(dot);
			}
			sb.append("%");
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}

 } 
