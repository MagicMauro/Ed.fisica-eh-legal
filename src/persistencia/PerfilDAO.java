package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PerfilDAO implements DAO<Perfil>  {
	public void save(Perfil f) {
		try {
			// diretório
			File dir = new File("usuarios");
			if(dir.list().length==0){
				Perfil p = new Perfil();
				p.setNumero(1);
				p.setNome("teste");
				p.setPeso(4);
				p.setAltura(2); 
			}else{
			int n= dir.list().length;
			if (!dir.exists()) dir.mkdir();
			f.setNumero(n++);
			// arquivo individual
			File arq = new File("usuarios/" + f.getNumero()+ ".csv");
			if (arq.exists()) return;
			// gravar os dados
			FileWriter writer = new FileWriter(arq);
			writer.write(f.getNumero() + ";");
			writer.write(f.getNome() + ";");
			writer.write(f.getAltura() + ";");
			writer.write(f.getPeso() + "\n");
			// fechar o arquivo
			writer.flush();
			writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void delete(Perfil f) {
		try {
			File arq = new File("usuarios/" + f.getNumero() + ".csv");
			// se o arquivo não existe não continua
			if ( ! arq.exists()) return; // pára a execução do método
			// exclui o arquivo
			arq.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	
	public Perfil load(int numero) {		
		try {
			File arq = new File("usuarios/" + numero + ".csv");
			
			if ( ! arq.exists()) return null;
			
			Scanner scan = new Scanner(arq);
			String linha = scan.nextLine();
			String[] colunas = linha.split(";");
			
			Perfil f = new Perfil();
	
			f.setNumero(numero);
			f.setNome(colunas[1]);
			f.setPeso(Double.parseDouble(colunas[2]));
			f.setAltura(Double.parseDouble(colunas[3]));
			f.setImc(Double.parseDouble(colunas[4]));
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void update(Perfil f) {
		// substituir o arquivo antigo por um novo
		// excluir o arquivo antigo
		// e persistir novo
	}

	public ArrayList<Perfil> findAll() {
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		try {
			File dir = new File("usuarios");		
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				if(arq.toString().endsWith(".csv")){
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");
				
				Perfil f = new Perfil();
				f.setNumero(Integer.parseInt(colunas[0]));
				f.setNome(colunas[1]);
				f.setPeso(Double.parseDouble(colunas[2]));
				f.setAltura(Double.parseDouble(colunas[3]));
				f.setImc(Double.parseDouble(colunas[4]));
				lista.add(f);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}



}
