package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import com.example.DAO.GenericDao;

public class TableCursos  extends JFrame {
    
    private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JButton btInserir;
	private JButton btAt;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();

	private static GenericDao dao;

	public TableCursos(String titulo, GenericDao dao1 ) {
		super(titulo);
		dao = dao1;
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {

		btInserir = new JButton("Inserir");
		btAt = new JButton("Atualizar");

		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		painelBotoes.add(btInserir);
		painelBotoes.add(btAt);

		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 320);
		setVisible(true);

		btInserir.addActionListener(new BtInserirListener());
		btAt.addActionListener(new BtAtListener());

	}

	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			form window = new form();
		}
	}

	private class BtAtListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			TableCursos.pesquisar(modelo);	
		}
	}

	private void criaJTable() {

		tabela = new JTable(modelo);

		int columns = dao.getColunsQtn();
		
		for(int i = 0 ; i <= columns ; i++){

			modelo.addColumn(dao.getColunsNome(i));

		}

		tabela.getColumnModel().getColumn(0)
		.setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1)
		.setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2)
		.setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3)
		.setPreferredWidth(120);
		
		pesquisar(modelo);

	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);

		for (Curso c : dao.get()) {
			modelo.addRow(new Object[]{c.getNome(), c.getCoordenador(),
			c.getDepartamento(),c.getTurno(),c.getCarga_horaria(), c.getModalidade()});
		}

	}
}
