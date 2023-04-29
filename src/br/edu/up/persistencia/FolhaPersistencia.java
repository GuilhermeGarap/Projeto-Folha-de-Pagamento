package br.edu.up.persistencia;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.entidades.Folha;

public class FolhaPersistencia {
	
	static List<Folha> funcs = new ArrayList<Folha>();

	public static void incluirFolha(Folha functemp) {
		funcs.add(functemp);
	}
	
	public static Folha buscarFolha(Folha func) {
		for(Folha functemp: funcs) {
			if(functemp.getNome().equals(func.getNome()) && functemp.getMes() == func.getMes()) {
				if (functemp.getAno() == func.getAno()) {
				
				return functemp;
				}
			}
		}
		return null;
	}
	
	public static void listarFolhasPorMesAno(Folha func) {
	    float totalSl = 0;
	    System.out.println("Folhas de pagamento do mês " + func.getMes() + "/" + func.getAno() + ":\n");
	    for (Folha functemp : funcs) {
	        if (functemp.getMes() == func.getMes() && func.getAno() == functemp.getAno()) {
	            System.out.println("Funcionário: " + functemp.getNome() + "\nSalário líquido: " + functemp.getSl() + "\n");
	            totalSl += functemp.getSl();
	        }
	    }
	    System.out.println("\nTotal dos salários: " + totalSl);
	}
}
