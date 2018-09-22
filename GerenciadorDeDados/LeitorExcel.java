package GerenciadorDeDados;
import caixa.Promocao;
import caixa.PromocaoRetiraProdutos;
import caixa.PromocaoRetiraValor;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;

import jxl.NumberCell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;

import javax.swing.JOptionPane;

public class LeitorExcel {

	public static ArrayList<Promocao> lerPromocao(String url) throws IOException, BiffException {
	
	Workbook workbook = Workbook.getWorkbook(new File(url));
	Sheet sheet = workbook.getSheet(0);
	int linhas = sheet.getRows();
	
	ArrayList<Promocao> promocoes = new ArrayList<Promocao>();;
	
	String csvDivisor = ",";
	for(int i = 1; i < linhas; i++){
		Cell l = sheet.getCell(0, i);
		String linha = l.getContents();
		String[] promocao = linha.split(csvDivisor);
		
		Promocao promocaoAdiciona ;
		Integer id = Integer.parseInt(promocao[0]);
		String descricao = promocao[1];
		String obs = promocao[2];
		
		
		Integer quantativa = Integer.parseInt(promocao[3]);
		
		if(promocao.length==6) {
			Integer quantpaga = Integer.parseInt(promocao[5]);	
			promocaoAdiciona = new PromocaoRetiraProdutos(id, descricao, obs, quantativa, quantpaga);
			promocoes.add(promocaoAdiciona);
			
		}else if(promocao.length==5) {
			float preco_final = Float.parseFloat(promocao[4]);
			promocaoAdiciona = new PromocaoRetiraValor(id, descricao, obs, quantativa, preco_final);
			promocoes.add(promocaoAdiciona);
		}
		

	}
	workbook.close();
	return extracted(promocoes);
	}

	private static ArrayList<Promocao> extracted(ArrayList<Promocao> promocoes) {
		return promocoes;
	}
}

