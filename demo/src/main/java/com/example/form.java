package com.example;


import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.example.DAO.CursoDAO;
import com.example.DAO.GenericDao;

import javax.swing.JLabel;

public class form {

    private JFrame frame;
    private JTextField nome_curso;
    private JTextField nomeCoordenador;
    private JTextField departamento;
    private JTextField cargaHoraria;
    private JComboBox <String> turno;
    private JComboBox <String> modalidade;
	private DefaultTableModel modelo = new DefaultTableModel();

    public form() {
        initialize();
    }

    public static boolean isInt(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    private void initialize() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 510, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        nome_curso = new JTextField();

    JLabel lblCadastro = new JLabel("SISTEMA DE CADASTRO DE CURSOS",SwingConstants.CENTER);
    lblCadastro.setBounds(10, 20, 300, 14);
    lblCadastro.setFont(new Font("Arial", Font.BOLD, 14));
    frame.getContentPane().add(lblCadastro);
    
    //Label para os  dos campos solicitados:
    JLabel lblDisciplina = new JLabel("Nome:* ");
    lblDisciplina.setBounds(65, 70, 150, 14);
    frame.getContentPane().add(lblDisciplina);

    JLabel lblProfessor = new JLabel("Coordenador:* ");
    lblProfessor.setBounds(65, 110, 150, 14);
    frame.getContentPane().add(lblProfessor);
         
    JLabel lblCurso = new JLabel("Departamento:* ");
    lblCurso.setBounds(65, 150, 150, 14);
    frame.getContentPane().add(lblCurso);
     
    JLabel lblcargaHoraria = new JLabel("Carga Horaria:* ");
    lblcargaHoraria.setBounds(65, 190, 150, 14);
    frame.getContentPane().add(lblcargaHoraria);
    
    JLabel lblTurno = new JLabel("Turno:* ");
    lblTurno.setBounds(65, 230, 150, 20);
    frame.getContentPane().add(lblTurno);

    JLabel lalModalidade = new JLabel("Modalidade:* ");
    lalModalidade.setBounds(65, 275, 150, 20);
    frame.getContentPane().add(lalModalidade);
    
    //Campos de imput das informações
    nome_curso.setBounds(200, 70, 240, 20);
    frame.getContentPane().add(nome_curso);
    nome_curso.setColumns(10);

    nomeCoordenador = new JTextField();
    nomeCoordenador.setBounds(200, 110, 240, 20);
    frame.getContentPane().add(nomeCoordenador);
    nomeCoordenador.setColumns(10);

    departamento = new JTextField(); 
    departamento.setBounds(200, 150,240, 20);
    frame.getContentPane().add(departamento);
    departamento.setColumns(10);

    cargaHoraria = new JTextField();
    cargaHoraria.setBounds(200, 190, 240, 20);
    frame.getContentPane().add(cargaHoraria);
    cargaHoraria.setColumns(10);

    turno = new JComboBox <String> ();
    turno.addItem("");
    turno.addItem("Matutino");
    turno.addItem("Vespertino");
    turno.addItem("Noturno");
    turno.addItem("Integral");
    turno.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        }
    });
    turno.setBounds(200, 230, 240, 20);
    frame.getContentPane().add(turno);

    
    modalidade = new JComboBox <String> ();
    modalidade.addItem("");
    modalidade.addItem("Presencial");
    modalidade.addItem("Online");
    modalidade.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg1) {
        }
    });
    modalidade.setBounds(200, 275, 240, 20);
    frame.getContentPane().add(modalidade);
     
    JButton btnClear = new JButton("LIMPAR");
    btnClear.setBackground(Color.RED);
    btnClear.setForeground(Color.BLACK);
     
    btnClear.setBounds(312, 350, 100, 30);
    frame.getContentPane().add(btnClear);
     
    JButton btnSubmit = new JButton("ENVIAR");
     
    btnSubmit.setBackground(Color.GREEN);
    btnSubmit.setForeground(Color.BLACK);
    btnSubmit.setBounds(65, 350, 100, 30);
    frame.getContentPane().add(btnSubmit);

    btnSubmit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            if(modalidade.getSelectedItem().equals("")||turno.getSelectedItem().equals("")||nome_curso.getText().isEmpty()||nomeCoordenador.getText().isEmpty()||departamento.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Preencher campos Obrigatorios");
        } else {  
            if (isInt(cargaHoraria.getText())){
                Curso curso = new Curso(nome_curso.getText(), nomeCoordenador.getText(), departamento.getText(), Integer.parseInt(cargaHoraria.getText()),turno.getSelectedItem().toString(),modalidade.getSelectedItem().toString());
                GenericDao insert = new CursoDAO(); 
                insert.create(curso);
                JOptionPane.showMessageDialog(null, "Inserido com Sucesso");
                frame.setVisible(false);

                TableCursos.pesquisar(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "Carga Horario deve conter apenas números");
            }
        }
        }
    });
   
    btnClear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            nome_curso.setText(null);
            nomeCoordenador.setText(null);
            departamento.setText(null);
            cargaHoraria.setText(null);           
            turno.setSelectedItem("");
            modalidade.setSelectedItem("");

        }
    });
 
       }

}
