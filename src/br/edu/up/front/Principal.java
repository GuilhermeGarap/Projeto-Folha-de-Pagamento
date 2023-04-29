package br.edu.up.front;

import br.edu.up.persistencia.FolhaPersistencia;
import br.edu.up.negocios.*;
import br.edu.up.entidades.Folha;

public class Principal {
		
		public static void main(String[] args) {
			int op;
			Folha func;
			
			do {
			criarMenu();
			op = Console.readInt ("Informe o valor: ");
			switch(op) {
			case 1:
				func = new Folha();
				func.setNome(Console.readString("Informe o nome do funcionário: "));
				func.setMes(Console.readInt("Informe o mês: "));
				func.setAno(Console.readInt("Informe o ano: "));
				if (FolhaPersistencia.buscarFolha(func) == null) {
				func.setNumHoras(Console.readInt("Informe o número de horas trabalhadas: "));
				func.setValHoras(Console.readFloat("Informe o valor da hora trabalhada: "));
				FolhaPersistencia.incluirFolha(func);
				} else {
					System.out.println("Já existe uma folha de pagamento com esse nome, mês ou ano.");
				}
			break;
			case 2:
					func = new Folha();
					func.setNome(Console.readString("Informe o nome do funcionário: "));
					func.setMes(Console.readInt("Informe o mês: "));
					func.setAno(Console.readInt("Informe o ano: "));
					func = FolhaPersistencia.buscarFolha(func);
					if (func != null) {
					System.out.println("\nNome: " + func.getNome());
					System.out.println("Mês: " + func.getMes());
					System.out.println("Ano: " + func.getAno());
					System.out.println("Horas Trabalhadas: " + func.getNumHoras());
					System.out.println("Valor da Hora: " + func.getValHoras());
					func = FolhaNegocio.calSb(func);
					func = FolhaNegocio.calIr(func);
					func = FolhaNegocio.calInss(func);
					func = FolhaNegocio.calFgts(func);
					func = FolhaNegocio.calSl(func);
					System.out.println("O salário bruto é de " + func.getSb());
					System.out.println("O Imposto de Renda é de " + func.getIr());
					System.out.println("O valor do INSS é de: " + func.getInss());
					System.out.println("O valor do FGTS é de: " + func.getFgts());
					System.out.println("O salário líquido é de : " + func.getSl());
					} else {
						System.out.println("Não existe uma folha de pagamento com os dados informados.");
					}
			break;
			case 3:
				func = new Folha();
				func.setMes(Console.readInt("Informe o mês: "));
				func.setAno(Console.readInt("Informe o ano: "));
				FolhaPersistencia.listarFolhasPorMesAno(func);
			    break;

					}
						
			} while(op!=4);
		}
		
		//Menu Visual
		private static void criarMenu() {
			System.out.println("\n\n*** MENU PRINCIPAL ***");
			System.out.println("1 - Cadastrar Folha");
			System.out.println("2 - Consultar Folha");
			System.out.println("3 - Lista Folha");
			System.out.println("4 - Sair");
		}
		


		

		
		
		

}

		
		



