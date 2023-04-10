package mexeVetor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.*;

public class Calculador {

	JFrame janela=new JFrame("Programa Frame - V2LP5");
	JPanel painel1=new JPanel(new FlowLayout());
	JPanel painel2=new JPanel(new FlowLayout());
	JPanel painel3=new JPanel(new FlowLayout());
	
	Vector vetor = new Vector();
	
	JLabel digite, maior, menor, media, valores;
	JButton bOk,bExibir,bcalcular;
	JTextField txtDigite, txtMaior,txtMenor,txtMedia,txtValores;
	JComboBox comboBox;
	
	
	public Calculador() {
		
		digite=new JLabel("Digite o número");
		txtDigite=new JTextField(10);
		bOk=new JButton("OK");
		Ouvinte1 ouvinte1 = new Ouvinte1();
		bOk.addActionListener(ouvinte1);
		painel1.add(digite);
		painel1.add(txtDigite);
		painel1.add(bOk);
		
		
		painel2.setLayout(new GridLayout(4,3));
		maior=new JLabel("Maior>>>");
		txtMaior=new JTextField(10);
		menor=new JLabel("Menor>>>");
		txtMenor=new JTextField(10);
		bExibir=new JButton("Exibir");
		Ouvinte2 ouvinte2 = new Ouvinte2();
		bExibir.addActionListener(ouvinte2);
		media=new JLabel("Média>>>");
		txtMedia=new JTextField(10);
		valores=new JLabel("Valores");
		txtValores=new JTextField(12);
		
		

		//combo box
		String labels[]= {"Somar","Multiplicar"};
		comboBox = new JComboBox(labels);
		
		Ouvinte3 ouvinte3 = new Ouvinte3();
		bcalcular=new JButton("Calcular");
		bcalcular.addActionListener(ouvinte3);
		
	
		
		
		
		painel2.add(maior);
		painel2.add(txtMaior);
		painel2.add(new JLabel(""));
		painel2.add(menor);
		painel2.add(txtMenor);
		painel2.add(bExibir);
		painel2.add(media);
		painel2.add(txtMedia);
		painel2.add(new JLabel(""));
		painel2.add(valores);
		painel2.add(txtValores);


		painel3.add(comboBox);
		painel3.add(bcalcular);
		
		janela.add(painel1,BorderLayout.NORTH);
		janela.add(painel2,BorderLayout.CENTER);
		janela.add(painel3,BorderLayout.SOUTH);
		
		janela.setSize(400,300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}

	public class Ouvinte1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method
			vetor.add(Integer.valueOf(txtDigite.getText()));
			txtDigite.setText("");
		}
		
	}
	
	public class Ouvinte2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method
			float somal = Integer.valueOf(String.valueOf(vetor.get(0)));
			int maiorl = Integer.valueOf(String.valueOf(vetor.get(0)));
			int menorl = Integer.valueOf(String.valueOf(vetor.get(0)));
			for (int i = 1; i< vetor.size();i++) {
				somal += Float.valueOf(String.valueOf(vetor.get(i)));
				if (Integer.valueOf(String.valueOf(vetor.get(i))) > maiorl) {
					maiorl =Integer.valueOf(String.valueOf(vetor.get(i)));
				}
				if (Integer.valueOf(String.valueOf(vetor.get(i))) < menorl) {
					menorl =Integer.valueOf(String.valueOf(vetor.get(i)));
				}
			}
			
			
			maior.setText(String.valueOf(maiorl));
			menor.setText(String.valueOf(menorl));
			media.setText(String.valueOf(somal/vetor.size()));
		}
		
	}
	
	
	
	public class Ouvinte3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method
			if (comboBox.getSelectedIndex() == 0) { 
				int resultado = 0;
				
				for (int i = 0; i< 6; i++) {
					resultado += Integer.valueOf(txtValores.getText().substring(2*i , 2*i + 2));
				}
				JOptionPane.showMessageDialog(null,String.valueOf(resultado));
				
			} else if (comboBox.getSelectedIndex() == 1) {
				long resultado = 1;
				
				for (int i = 0; i< 6; i++) {
					resultado *= Integer.valueOf(txtValores.getText().substring(2*i , 2*i + 2));
				}
				JOptionPane.showMessageDialog(null,String.valueOf(resultado));
			}
		}
		
	}
}
