package conversorDeMoeda;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Converte extends JFrame{
	private JPanel valorOriginal = new JPanel(new FlowLayout());
	private JPanel selecaoDeMoeda = new JPanel(new FlowLayout());
	JPanel resultado = new JPanel(new FlowLayout());
    JRadioButton dolar, euro, libra;
    ButtonGroup grupo;
    
    
    JLabel valorTxT = new JLabel("Valor em real: ");
    JTextField valorInput=new JTextField(8);
    JLabel resultadoTxt=new JLabel("resultado :");
    JLabel resultadoOutput=new JLabel("");
    JButton converter=new JButton("Converter");
    OuvinteBotao ouvinte = new OuvinteBotao();

    public  Converte(){
        super("Converte moeda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setLayout( new BorderLayout() );

        
        converter.addActionListener(ouvinte);
          //Criando os JRadioButtons
          dolar = new JRadioButton("Dolar"); 
          dolar.setSelected(false);

          euro = new JRadioButton("Euro");
          euro.setSelected(false);

          libra = new JRadioButton("Libra");
          libra.setSelected(false);
          
          grupo = new ButtonGroup();
          grupo.add(dolar);
          grupo.add(euro);
          grupo.add(libra);
          
         

          
          add(valorOriginal,BorderLayout.NORTH);
          	valorOriginal.add(valorTxT);
          	valorOriginal.add(valorInput);
          add(selecaoDeMoeda,BorderLayout.CENTER);
          	selecaoDeMoeda.add(dolar);
          	selecaoDeMoeda.add(euro);
          	selecaoDeMoeda.add(libra);
          add(resultado,BorderLayout.SOUTH);
        	resultado.add(converter);
          	resultado.add(resultadoTxt);
          	resultado.add(resultadoOutput);

          setVisible(true);
    }
          
          public class OuvinteBotao implements ActionListener {

        		@Override
        		public void actionPerformed(ActionEvent e) {
        			// TODO Auto-generated method 

        			if (dolar.isSelected()) {

            			resultadoOutput.setText(String.valueOf(Double.valueOf(valorInput.getText())* 5));
        			} else if (euro.isSelected()) {

        				resultadoOutput.setText(String.valueOf(Double.valueOf(valorInput.getText())* 5.50));
        			} else if (libra.isSelected()) {

        				resultadoOutput.setText(String.valueOf(Double.valueOf(valorInput.getText())* 6.30));
        			}
        		}

        	}
       
}
