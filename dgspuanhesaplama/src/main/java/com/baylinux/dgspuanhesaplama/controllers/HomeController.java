package com.baylinux.dgspuanhesaplama.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class HomeController 
{
	
	@GetMapping("/")
	public String dgssayisalpuanhesapla(double diplomanotu,boolean oncekiseneyerlesmedurumu,
			int sayisaldogrusayisi,int sayisalyanlissayisi,
			int sozeldogrusayisi,int sozelyanlissayisi) 
	{	
		
		if(diplomanotu>4) return "Eksik veya hatalı değer";
		if(sayisaldogrusayisi<0 ||sayisalyanlissayisi<0 ||sozeldogrusayisi<0||sozelyanlissayisi<0) return "Eksik veya hatalı değer";
		if(sayisaldogrusayisi+sayisalyanlissayisi>50 || sozeldogrusayisi+sozelyanlissayisi>50) return "Eksik veya hatalı değer";
		double sayisalnet= (double) sayisaldogrusayisi-(double) sayisalyanlissayisi/4;
		double sozelnet=(double) sozeldogrusayisi- (double) sozelyanlissayisi/4;
		if (diplomanotu<2) diplomanotu=2;
		if(oncekiseneyerlesmedurumu==true)
		{
			diplomanotu=diplomanotu*9;
		}
		else diplomanotu=diplomanotu*12;
		double sayisalpuani=0;
		double esitagirlikpuani=0;
		double sozelpuani=0;
		if(sayisalnet >=1 && sozelnet>=1)
		{
			sayisalpuani = diplomanotu+sayisalnet*3+sozelnet*0.7+150;
			esitagirlikpuani = diplomanotu+sayisalnet*1.7+sozelnet*1.7+150;
			sozelpuani = diplomanotu+sayisalnet*0.5+sozelnet*2.7+150;
			
			return "DGS sayısal puanınız: "+sayisalpuani+"<br>"
					+"DGS eşit ağırlık puanınız: "+esitagirlikpuani+"<br>"
					+"DGS sozel puanınız: "+sozelpuani;
					
		}
		return "Eksik veya hatalı değer";
	}
	
	
}


