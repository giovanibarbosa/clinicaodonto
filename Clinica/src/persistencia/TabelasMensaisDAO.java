package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Data;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TabelasMensaisDAO {
	private final static String SEPARADOR = System
			.getProperty("file.separator");
	private final static String CAMINHO = "arquivos" + SEPARADOR
			+ "tabelasMensais" + SEPARADOR;
	private final static String TIPO_DE_ARQUIVO = ".xml";
	private static TabelasMensaisDAO instancia;
	private static XStream xstream = new XStream(new DomDriver("ISO-8859-1"));

	private TabelasMensaisDAO() {
	}

	public static synchronized TabelasMensaisDAO getInstance() {
		if (instancia == null)
			instancia = new TabelasMensaisDAO();
		return instancia;

	}

	public void criar(Object[][] entradas, Object[][] saidas) throws Exception, IOException {
		if (entradas == null || saidas == null)
			throw new Exception("Tabela n�o p�de ser salva");
		File file = new File(CAMINHO + new Data().dataInPersistenceMonth()
				+ TIPO_DE_ARQUIVO);
		file.getParentFile().mkdirs();
		Object[][][] tupla = new Object[2][][];
		tupla[0] = entradas;
		tupla[1] = saidas;
		xstream.toXML(tupla, new FileOutputStream(file));
	}

	public List<Object[][][]> recuperaTabelas() throws Exception {
		List<Object[][][]> tabelas = new ArrayList<Object[][][]>();
		for (File arquivo : arrayDosArquivos()) {

			if (arquivo.getName().endsWith(TIPO_DE_ARQUIVO)) {
				arquivo.getParentFile().mkdirs();
				Object[][][] tabela = (Object[][][]) xstream
						.fromXML(new FileInputStream(arquivo));
				tabelas.add(tabela);
			}
		}
		
		if (tabelas.isEmpty())
			throw new Exception("Nenhuma tabela mensal foi criada");
		return tabelas;
	}
	
	public String[] recuperarTabelasPorData() throws Exception {
		List<String> datas = new ArrayList<String>();
		for (File file : arrayDosArquivos()) {
			if (file.getName().endsWith(TIPO_DE_ARQUIVO)) {
				file.getParentFile().mkdirs();
				String nomeData = file.getName().replace(TIPO_DE_ARQUIVO, "");
				datas.add(nomeData);
			}
		}
		if (datas.isEmpty())
			throw new Exception("Nenhuma tabela foi criada");
		return listToArray(datas);
	}
	
	private String[] listToArray(List<String> lista) {
		String[] retorno = new String[lista.size()];
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = lista.get(i);
		}
		return retorno;
	}

	public void limparTabelas() {
		for (File arquivo : arrayDosArquivos()) {
			if (arquivo.getName().endsWith(TIPO_DE_ARQUIVO)) {
				System.gc();
				arquivo.delete();
			}
		}
	}
	
	public Object[][][] recuperaTupla(String data) throws FileNotFoundException {
		for (File file : arrayDosArquivos()) {			
			if (file.getName().endsWith(TIPO_DE_ARQUIVO) && 
					file.getName().startsWith(data)) {
				return (Object[][][]) xstream
				.fromXML(new FileInputStream(file));
			}
		}
		return null;
	}

	private File[] arrayDosArquivos() {
		File file = new File(CAMINHO);
		file.mkdirs();
		return file.listFiles();
	}
	
	public void atualizar(Object[][] entradas, Object[][] saidas, String data)
			throws Exception {
		if(entradas == null || saidas == null || data == null)
			throw new Exception("N�oo p�de atualizar a tabela");
		File file = new File(CAMINHO + data
				+ TIPO_DE_ARQUIVO);
		file.getParentFile().mkdirs();
		Object[][][] tupla = new Object[2][][];
		tupla[0] = entradas;
		tupla[1] = saidas;
		xstream.toXML(tupla, new FileOutputStream(file));
	}
}
