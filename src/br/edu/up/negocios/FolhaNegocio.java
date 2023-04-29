package br.edu.up.negocios;

import br.edu.up.entidades.Folha;

	public class FolhaNegocio {

	//Calculo Salário Bruto 
	public static Folha calSb (Folha func) {
		func.setSb(func.getNumHoras() * func.getValHoras());
		return func;
		}
	
	//Calculo Imposto de Renda
	public static Folha calIr(Folha func) {
			if (func.getSb()<1372.81) {
				func.setIr(0);
				return func;
			}
				if(func.getSb()<2743.25) {
					func.setIr(func.getSb()*15/100-205.92);
					return func;
				} else {
					func.setIr(func.getSb()*27.5/100-548.82);
					return func;
				}
	}
	
	//Calculo INSS
	public static Folha calInss(Folha func) {
			if (func.getSb()<868.29) {
				func.setInss(func.getSb() * 8/100);
				return func;
			}
				if (func.getSb()<1447.14) {
				func.setInss(func.getSb() * 9/100);
				return func;
				}
					if (func.getSb()<2894.28) {
						func.setInss(func.getSb() * 11/100);
						return func;
						}
							else {
								func.setInss(318.38);
								return func;
							}
	}
	
	//Calculo FGTS
	public static Folha calFgts(Folha func) {
		func.setFgts(func.getSb() * 8/100);
		return func;

	}
	
	//Calculo Salário Líquido
	public static Folha calSl(Folha func) {
		func.setSl(func.getSb() - func.getInss() - func.getIr());
		return func;
	}
	

	
}