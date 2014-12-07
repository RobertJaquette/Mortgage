package MainPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Mortgage_estimator implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mortgage_estimator window = new Mortgage_estimator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mortgage_estimator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][][][][][][][][]"));
		
		JLabel lblMonthly_Debt = new JLabel("Total Monthly Debt");
		frame.getContentPane().add(lblMonthly_Debt, "cell 1 0,alignx trailing");
		
		textField_1 = new JTextField();
		lblMonthly_Debt.setLabelFor(textField_1);
		frame.getContentPane().add(textField_1, "cell 2 0,alignx left");
		textField_1.setColumns(10);
		
		JLabel lblTotalGrossIncome = new JLabel("Total Gross Income");
		frame.getContentPane().add(lblTotalGrossIncome, "cell 1 1");
		
		textField = new JTextField();
		lblTotalGrossIncome.setLabelFor(textField);
		frame.getContentPane().add(textField, "cell 2 1,alignx leading");
		textField.setColumns(10);
		
		JLabel lblInterestRate = new JLabel("Mortgage Interest Rate (%)");
		frame.getContentPane().add(lblInterestRate, "cell 1 2,alignx trailing");
		
		textField_2 = new JTextField();
		lblInterestRate.setLabelFor(textField_2);
		frame.getContentPane().add(textField_2, "cell 2 2,alignx left");
		textField_2.setColumns(10);
		
		JLabel Term = new JLabel("Term");
		frame.getContentPane().add(Term, "cell 1 3,alignx trailing");
		
		String[] term = { "5", "10", "15" };
		JComboBox comboBox = new JComboBox(term);
		Term.setLabelFor(comboBox);
		frame.getContentPane().add(comboBox, "flowx,cell 2 3,alignx left");
		
		
		JLabel lblDownPayment = new JLabel("Down Payment");
		frame.getContentPane().add(lblDownPayment, "cell 1 4,alignx trailing");
		
		textField_3 = new JTextField();
		lblDownPayment.setLabelFor(textField_3);
		frame.getContentPane().add(textField_3, "cell 2 4,alignx left");
		textField_3.setColumns(10);
		
		JLabel lblhouse_payments = new JLabel("house payments");
		frame.getContentPane().add(lblhouse_payments, "cell 1 5,alignx trailing");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		lblhouse_payments.setLabelFor(textField_4);
		frame.getContentPane().add(textField_4, "cell 2 5,alignx left");
		textField_4.setColumns(10);
		
		JLabel lblHouse_dailydebt = new JLabel("house payment + daily debts");
		lblHouse_dailydebt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(lblHouse_dailydebt, "cell 1 6,alignx trailing");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		lblHouse_dailydebt.setLabelFor(textField_5);
		frame.getContentPane().add(textField_5, "cell 2 6,alignx left");
		textField_5.setColumns(10);
		
		JLabel lblMaximum = new JLabel("Maximum payment");
		frame.getContentPane().add(lblMaximum, "flowx,cell 1 7,alignx trailing");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		lblMaximum.setLabelFor(textField_7);
		frame.getContentPane().add(textField_7, "cell 2 7,alignx left");
		textField_7.setColumns(10);
		
		JLabel lblMaximumHouseValue = new JLabel("Maximum Mortgage ");
		frame.getContentPane().add(lblMaximumHouseValue, "cell 1 8,alignx trailing");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		lblMaximumHouseValue.setLabelFor(textField_6);
		frame.getContentPane().add(textField_6, "cell 2 8,alignx left");
		textField_6.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		frame.getContentPane().add(btnCalculate, "cell 2 9");
		btnCalculate.addActionListener(this);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		double income = Double.parseDouble(textField.getText());
		double debt = Double.parseDouble(textField_1.getText());
		double interest = Double.parseDouble(textField_2.getText());
		int years = Integer.parseInt(comboBox.getSelectedItem().toString());
		double downpayment = Double.parseDouble(textField_3.getText());
		double housepaymentonly = Calculator.housepaymentOnly(income);
		double housewithdebt = Calculator.housewithdebt(income, debt);
		double maxpayment = Calculator.allowedPayment(income, debt);
		double housevalue = Calculator.housevalue(maxpayment, interest, years) + downpayment;
		textField_4.setText(String.valueOf(housepaymentonly));
		textField_5.setText(String.valueOf(housewithdebt));
		textField_7.setText(String.valueOf(maxpayment));
		textField_6.setText(String.valueOf(housevalue));
	}
	
}
