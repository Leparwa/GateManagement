import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class ConfirmCheckout extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfirmCheckout dialog = new ConfirmCheckout();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmCheckout() {
		setBounds(1000, 160, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GREEN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Temperature");
			lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
			lblNewLabel.setBounds(39, 31, 138, 37);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblTime = new JLabel("Time");
			lblTime.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
			lblTime.setBounds(39, 89, 138, 37);
			contentPanel.add(lblTime);
		}
		{
			textField = new JTextField();
			textField.setBounds(209, 37, 118, 31);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(209, 95, 118, 31);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.GREEN);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 17));
				buttonPane.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
