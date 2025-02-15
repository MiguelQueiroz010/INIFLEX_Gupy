import java.math.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {

	//Formato de Data de Nascimento para Leitura
	static DateTimeFormatter Dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	//Formatar salário e data de nascimento
	static DecimalFormat paym_formatter = new DecimalFormat("#,##0.00R$");
	static DecimalFormat minimum_paymformt = new DecimalFormat("#,##0.00");
	static DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/**
	Programa principal.
	*/
	public static void main(String[] args) {
		
		//3.1: Adicionar Todos os Empregados
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(Employee.EmployeeAdd("Maria", LocalDate.parse("18/10/2000", Dateformatter),
				new BigDecimal("2009.44"), "Operador"));
		employees.add(Employee.EmployeeAdd("João", LocalDate.parse("12/05/1990", Dateformatter),
				new BigDecimal("2284.38"), "Operador"));
		employees.add(Employee.EmployeeAdd("Caio", LocalDate.parse("02/05/1961", Dateformatter),
				new BigDecimal("9836.14"), "Coordenador"));
		employees.add(Employee.EmployeeAdd("Miguel", LocalDate.parse("14/10/1988", Dateformatter),
				new BigDecimal("19119.88"), "Diretor"));
		employees.add(Employee.EmployeeAdd("Alice", LocalDate.parse("05/01/1995", Dateformatter),
				new BigDecimal("2234.68"), "Recepcionista"));
		employees.add(Employee.EmployeeAdd("Heitor", LocalDate.parse("19/11/1999", Dateformatter),
				new BigDecimal("1582.72"), "Operador"));
		employees.add(Employee.EmployeeAdd("Arthur", LocalDate.parse("31/03/1993", Dateformatter),
				new BigDecimal("4071.84"), "Contador"));
		employees.add(Employee.EmployeeAdd("Laura", LocalDate.parse("08/07/1994", Dateformatter),
				new BigDecimal("3017.45"), "Gerente"));
		employees.add(Employee.EmployeeAdd("Heloísa", LocalDate.parse("24/05/2003", Dateformatter),
				new BigDecimal("1606.85"), "Eletricista"));
		employees.add(Employee.EmployeeAdd("Helena", LocalDate.parse("02/09/1996", Dateformatter),
				new BigDecimal("2799.93"), "Gerente"));
		
		
		//3.2: Remover o João
		employees.removeIf(x -> x.Nome == "João");
		
		System.out.println("Teste de Programação JAVA Iniflex/Gupy"
				+ "\n------------------------\n\n"
				+ "Digite o número da operação e aperte ENTER para continuar:\n"
				+ "\n1 - Imprimir a Lista de Funcionários"
				+ "\n2 - Immprimir e Agrupar por Função"
				+ "\n3 - Lista de Aniversariantes [Outubro e Dezembro]"
				+"\n4 - O Funcionário mais Velho de Idade"
				+"\n5 - Imprimir [A a Z]"
				+"\n6 - Imprimir o Total dos Salários"
				+"\n7 - Imprimir [Quantidade de Salários Mínimos]"
				+"\n\n0 - Sair"
				+"\n\nDigite o código da operação: "
				);
		String readcode = System.console().readLine();
		int opcode = Integer.parseInt(readcode != "" ? readcode : "999");
		
		switch(opcode)
		{
			case 0:
				//Sair do programa
				System.exit(0);
				break;
				
			case 1:
				//Limpar console
				ClearConsole();
				
				//Imprimir Lista de Funcionários
				ImprimirFuncionários(employees, false);
				
				//Questão de retorno
				ReturnFunction();
				break;
			
			case 2:
				//Limpar console
				ClearConsole();
				
				//3.4: Aumento de 10% de Salário Aplicado
				employees.forEach(item ->
				item.payment = item.payment.add(item.payment.multiply(new BigDecimal(0.10))));
				System.out.println("AVISO!\n"
						+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
				
				
				//Ordenar por função/role
				Collections.sort(employees, new EmployeeComparator());
				
				//3.5: Agrupar por função/cargo num HashMap
				HashMap<String, List<Employee>> map_emp = new HashMap<String, List<Employee>>();
				employees.forEach(item-> 
				map_emp.put(item.role, new ArrayList<Employee>()));
				
				//Para cada funcionário adicionar na lista a partir das chaves [cargo]
				employees.forEach(item-> 
				map_emp.get(item.role).add(item));
				
				
				//Imprimir Lista de Funcionários ordenados por função
				ImprimirFuncionários(map_emp);
				
				//Questão de retorno
				ReturnFunction();
				break;
			case 3:
				//Limpar console
				ClearConsole();
				
				//3.4: Aumento de 10% de Salário Aplicado
				employees.forEach(item ->
				item.payment = item.payment.add(item.payment.multiply(new BigDecimal(0.10))));
				System.out.println("AVISO!\n"
						+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
				
				//Aniversariantes de Outubro e Dezembro
				List<Employee> oct_dec_employees = employees;
				oct_dec_employees.removeIf(x-> 
				x.BornDate.getMonthValue() != 10 && x.BornDate.getMonthValue() != 12
						);
				
				//3.8: Imprimir Aniversariantes do Mês 10 e 12, Outubro e Dezembro
				System.out.println("Listando aniversariantes de Outubro(10) e Dezembro(12)\n"
						+ "------------------------\n");
				
				ImprimirFuncionários(oct_dec_employees, true);
				//Questão de retorno
				ReturnFunction();
				
			case 4:
				//Limpar console
				ClearConsole();
				
				//3.9: O Funcionário mais velho de idade
				Collections.sort(employees, new EmployeeBornComparator());
				
				//Data local
				LocalDate dataAtual = LocalDate.now();
				
				System.out.println("Funcionário mais velho de Idade:\n"
						+"\nNome: "+ employees.get(0).Nome
						+"\nIdade: " + Period.between(employees.get(0).BornDate, dataAtual).getYears()+" Anos"
						+ "\n------------------------\n");

				
				//Questão de retorno
				ReturnFunction();
				break;
			case 5:
				//Limpar console
				ClearConsole();
				
				//3.4: Aumento de 10% de Salário Aplicado
				employees.forEach(item ->
				item.payment = item.payment.add(item.payment.multiply(new BigDecimal(0.10))));
				System.out.println("AVISO!\n"
						+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
				
				//3.10: Lista de funcionários em ordem alfabética
				Collections.sort(employees, new EmployeeNameComparator());
				
				
				ImprimirFuncionários(employees, true);
				
				//Questão de retorno
				ReturnFunction();
				break;
			case 6:
				//Limpar console
				ClearConsole();
				
				//3.4: Aumento de 10% de Salário Aplicado
				employees.forEach(item ->
				item.payment = item.payment.add(item.payment.multiply(new BigDecimal(0.10))));
				System.out.println("AVISO!\n"
						+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
				
				//3.11: Imprimir o total dos salários dos funcionários
				BigDecimal paym_total = new BigDecimal(0);
				
				//Obter os salários e somar todos numa variável só
				for(Employee paym: employees)
				{
					paym_total = paym_total.add(paym.payment);
				}
				
				//Limpar console
				ClearConsole();
				
				//Imprimir resultado
				System.out.println("Total dos salários dos funcionários: " + paym_formatter.format(paym_total)
				+"\n------------------------------");
				
				//Questão de retorno
				ReturnFunction();
				break;
			case 7:
				//Limpar console
				ClearConsole();
				
				//3.4: Aumento de 10% de Salário Aplicado
				employees.forEach(item ->
				item.payment = item.payment.add(item.payment.multiply(new BigDecimal(0.10))));
				System.out.println("AVISO!\n"
						+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
				
				//3.12: Imprimir a quantidade de salários mínimos por funcionário
				ImprimirFuncionários(employees, new BigDecimal(1212.0));
				
				//Questão de retorno
				ReturnFunction();
				break;
			default:
			//Limpar console
			ClearConsole();
			
			//Print error
			System.out.println("Código de operação incorreto!\nRetornando...");
			
			//Time to load again
			try {Thread.sleep(1600);  }catch(final Exception e) {e.printStackTrace();}
			
			//Limpar console
			ClearConsole();
			
			//Recarregar opções
			main(new String[0]);
			break;
		}
	}
	
	//Comparadores
	public static class EmployeeNameComparator implements Comparator<Employee> {
	    @Override
	    public int compare(Employee a, Employee b) {
	        return a.Nome.compareTo(b.Nome);
	    }
	}
	public static class EmployeeBornComparator implements Comparator<Employee> {
	    @Override
	    public int compare(Employee a, Employee b) {
	        return a.BornDate.compareTo(b.BornDate);
	    }
	}
	public static class EmployeeComparator implements Comparator<Employee> {
	    @Override
	    public int compare(Employee a, Employee b) {
	        return a.role.compareTo(b.role);
	    }
	}
	
	/**
	Esta função faz a pergunta de retorno à função de seleção de operação ou saída do programa.
	*/
	static void ReturnFunction() {
		
		
		//Question
		System.out.println("\n##############\nQuer voltar ao menu de opções?"
				+ "\n\nS - sim"
				+ "\nN - não");
		String readend = System.console().readLine().toUpperCase(); 
		switch(readend)
		{
			case "S":
				//Limpar console
				ClearConsole();
				
				//Recarregar opções
				main(new String[0]);
				break;
			default:
				System.exit(0);
				break;
		}
	}
	
	/**
	Esta função limpa todo o texto do console.
	*/
	static void ClearConsole() {
		
		try
		{
			final String os = System.getProperty("os.name");
			if (os.contains("Windows"))
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else if(os.contains("Linux"))
			{
				System.out.print("\033[H\033[2J");
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	Esta função imprime no console os funcionários a partir da lista com a "Quantidade de Salários Mínimos".
	@param employees : lista de funcionários.
	@param paym_minimum : valor do salário mínimo
	*/
	static void ImprimirFuncionários(List<Employee> employees, BigDecimal paym_minimum) 
	{
		//3.12: Imprimir todos os funcionários com quantidade de salários mínimos

		//Para cada item imprimir os dados
		employees.forEach(item ->
		System.out.println(
				"-------------------\n"+
				 "Funcionário: "+item.Nome+"\n"
				+ "Data de Nascimento: "+
				date.format(item.BornDate)
				+ "\n"
				+ "Salário: "+paym_formatter.format(item.payment)+"\n"
				+ "Salário equivalente: " +minimum_paymformt.format(item.payment.divide(paym_minimum, RoundingMode.HALF_UP))+ " Salários Mínimos\n"
				+ "Função: "+item.role+
				 "\n-------------------\n"));
		
	}
	/**
	Esta função imprime no console os funcionários a partir da lista.
	@param employees : lista de funcionários.
	@param nojhonmsg : Se TRUE não exibe a mensagem da remoção do João.
	*/
	static void ImprimirFuncionários(List<Employee> employees, boolean nojhonmsg)
	{
	
		
	//3.2: João foi demitido, if true
	if(nojhonmsg==false)
		System.out.println("AVISO!\n"
				+ "O funcionário João foi removido da lista de funcionários e afins.\n");
		
	//3.3: Imprimir todos os funcionários e informações afins

	//Para cada item imprimir os dados
	employees.forEach(item ->
	System.out.println(
			"-------------------\n"+
			 "Funcionário: "+item.Nome+"\n"
			+ "Data de Nascimento: "+
			date.format(item.BornDate)
			+ "\n"
			+ "Salário: "+paym_formatter.format(item.payment)+"\n"
			+ "Função: "+item.role+
			 "\n-------------------\n"));
	
	}
	/**
	Esta função imprime no console os funcionários Agrupando por Cargo.
	@param map : HashMap<String, List(Employee)> contendo cada empregado por função em chave.
	*/
	static void ImprimirFuncionários(HashMap<String, List<Employee>> map) {
		//Limpar console
		ClearConsole();
		
		//3.4: Aumento de 10% de Salário Aplicado
		System.out.println("AVISO!\n"
				+ "Todos os funcionários receberam 10% de aumento salarial!\n\n");
		
		//3.6: Imprimir todos os funcionários e informações afins agrupados por Função/Cargo

		//Para cada chave imprimir os dados da lista
		for (String key : map.keySet()) {
			System.out.println("Cargo: "+ key +"\n##################\n\n");
			for(Employee emp_select : map.get(key)) {
				
				System.out.println("-------------------\n"+
						 "Funcionário: "+emp_select.Nome+"\n"
						+ "Data de Nascimento: "+
						date.format(emp_select.BornDate)
						+ "\n"
						+ "Salário: "+paym_formatter.format(emp_select.payment)+"\n"
						+"-------------------\n");
			}
		     
		}
	}
	
}
