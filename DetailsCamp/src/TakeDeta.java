import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.w3c.dom.NameList;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings({ "unused", "serial" })
public class TakeDeta extends JFrame {

	private JPanel contentPane;
	private JTextField Fname;
	private JTextField IdNo;
	private JTextField Pno;
	private JTextArea Details;
	@SuppressWarnings("rawtypes")
	private JComboBox Lname;
	//private JComboBox<?> Lname;
	int xside=0;
	int yside=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakeDeta frame = new TakeDeta();
					frame.setVisible(true);
					//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\\\Users\\\\hp\\\\Pictures\\\\CaptureSmoke"));
					//frame.setAlwaysOnTop(true);
					Toolkit tk= Toolkit.getDefaultToolkit();
				 	int xside=(int) tk.getScreenSize().getWidth();
				 	int yside= (int) tk.getScreenSize().getHeight();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTable table;
	ResultSet rsa=null;
	ResultSet rsw=null;
	private JTextField NameL;
	/**
	 * Create the frame.
	 */
	//clock thread isnt working as i was expecting. but that is the code that was supposed to handle clock. 
	/**
	public void shClock() {
		
	Thread lock=new Thread() {
		public void ShowClock() {
			try {
				
				Calendar cal= new GregorianCalendar();
				int Hour=cal.get(Calendar.HOUR_OF_DAY);
				int Min=cal.get(Calendar.MINUTE);
				int Second=cal.get(Calendar.SECOND);
				TimeL.setText("Time "+Hour+":"+Min+":"+":"+Second);
				
				sleep(1000);
				
			}catch(InterruptedException e) {
			e.printStackTrace();	
			}
		}
	};
	lock.start();
	
	
	}**/
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TakeDeta() {
		//shClock();
		this.setSize(xside, yside);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\LERESIC4D\\Yetu2.jpg"));
		con=MyConD.dbCon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 2800, 3090);
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(58, 41, 5, 41));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 255, 102));
		panel_4.setForeground(new Color(0, 255, 102));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1492, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 1474, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 625, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(68))
		);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Visitors Record System");
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 38));
		lblNewLabel_1.setBounds(516, 11, 447, 54);
		panel_4.add(lblNewLabel_1);
		panel_3.setLayout(null);
		
		
		
		
		
		NameL = new JTextField();
		NameL.setBounds(40, 6, 224, 47);
		panel_3.add(NameL);
		NameL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		NameL.setToolTipText("Type your Last Name here");
		NameL.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 21));
		NameL.setColumns(10);
		
		JTextArea Details = new JTextArea();
		Details.setBackground(new Color(51, 0, 51));
		Details.setForeground(Color.GREEN);
		Details.setFont(new Font("Segoe Print", Font.BOLD, 23));
		Details.setBounds(40, 64, 449, 216);
		panel_3.add(Details);
		panel_2.setLayout(null);
		
		
		JComboBox Lname = new JComboBox();
		Lname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Lname.setModel(new DefaultComboBoxModel(new String[] {"", "1st Floor", "2nd Floor", "3rd Floor", "4th Floor ", "5th Floor", "6th Floor", "7th Floor"}));
		Lname.setBounds(226, 85, 303, 35);
		panel_2.add(Lname);
		panel_1.setLayout(null);
		
		JButton btnSearch = new JButton("search");
		btnSearch.setBounds(290, 7, 163, 35);
		panel_3.add(btnSearch);
		//long de = 0;
		//Date d = new Date();
		SimpleDateFormat f=new SimpleDateFormat("hh:mm:ss a");
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//handling check out of the individuals
				String sach="select * from People where Id=?";
				String st="UPDATE People  SET Timeout = 'checked out'where Id=?";
				
				try {
					/*handling user input in the search bar, if the Id typed return a a result, we prepare a 
					statement that will then update timeout column in the table*/
					PreparedStatement pre=con.prepareStatement(sach);
					pre.setInt(1, Integer.parseInt(NameL.getText()));
					
					ResultSet re=pre.executeQuery();
					
					int lere=0;
					while(re.next()) {
						lere++;
						//re.getLong(st);
					}
						if(lere==1)  {
							
							PreparedStatement pte=con.prepareStatement(st);
							pte.setInt(1, Integer.parseInt(NameL.getText()));
							pte.getResultSet();
							//re.getLong(d);
							//Details.setText(Lname.getText());
							pte.executeUpdate();
							String dt="select Last_Name, First_Name, Id_No, Phone_No, Age from People where Id=?";
							PreparedStatement t=con.prepareStatement(dt);
							t.setInt(1, Integer.parseInt(NameL.getText()));
							
							ResultSet r=t.executeQuery();
							//int q=0;
							while(r.next()) {
								
									Details.setText(" your name is:"+" "+r.getString(1) +"\n"+ f.format(d) + "\n"+ " your First Name:" +r.getString(2)+"\n"  +" your Id Number:" +r.getString(3) +"\n" +" your Phone Number:" +r.getString(4)+"\n" +" your Age:"
								+ r.getString(5));
								}
							
						JOptionPane.showMessageDialog(null, "checked out succefully");	
						}else if (lere<=1) {
							Details.setText("");
							JOptionPane.showMessageDialog(null, "you dont exist on our database");
							
						}
						else if (lere>1) {
							JOptionPane.showMessageDialog(null, "there are two users of the same name");
						
						}
						else {
							JOptionPane.showMessageDialog(null, "You dont exist on our database, register instead");
						}
					
				}catch(Exception exe) {
					//JOptionPane.showInternalMessageDialog(parentComponent, message, null, NORMAL);
				}
			}
		});
		btnSearch.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		
		JButton ConfirmCheck = new JButton("Confirm CheckOut");
		ConfirmCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConfirmCheckout c=new ConfirmCheckout();
				Details.setText("");
				NameL.setText("");
				//c.setVisible(true);
			}
		});
		ConfirmCheck.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		ConfirmCheck.setBounds(174, 304, 200, 37);
		panel_3.add(ConfirmCheck);
		
		
		
		JLabel lblFullname = new JLabel("Full Name");
		lblFullname.setBounds(78, 24, 138, 33);
		panel_2.add(lblFullname);
		lblFullname.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		
		Fname = new JTextField();
		Fname.setBounds(226, 22, 303, 35);
		panel_2.add(Fname);
		Fname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Fname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Visiting");
		lblNewLabel.setBounds(78, 87, 138, 33);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		
		JLabel lblIdNo = new JLabel("ID No");
		lblIdNo.setBounds(89, 159, 61, 33);
		panel_2.add(lblIdNo);
		lblIdNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		
		IdNo = new JTextField();
		IdNo.setBounds(226, 157, 303, 35);
		panel_2.add(IdNo);
		IdNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		IdNo.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(67, 213, 149, 33);
		panel_2.add(lblPhoneNumber);
		lblPhoneNumber.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		
		Pno = new JTextField();
		Pno.setBounds(226, 211, 303, 35);
		panel_2.add(Pno);
		Pno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Pno.setColumns(10);
		
		JButton btnNewButton = new JButton("Check In");
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(226, 275, 138, 33);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String Quer="insert into People (First_Name, Last_Name, Id_No, Age) Values(?, ?, ?,?)";
				String com=Lname.getSelectedItem().toString();
				
				try {
					
					PreparedStatement pstq=con.prepareStatement(Quer);
					pstq.setString(1, Fname.getText());	
					pstq.setString(2, com);
					pstq.setInt(3, Integer.parseInt(IdNo.getText()));
					//pstq.setInt(4, Integer.parseInt(Pno.getText()));
					pstq.setInt(4, Integer.parseInt(Pno.getText()));
					//pst1.setString(6, Pword.getText());
				
					
					pstq.executeUpdate();
					Fname.setText("");
					Lname.setSelectedItem("");
					IdNo.setText("");
					Pno.setText("");
					//Pno.setText("");
					
					JOptionPane.showMessageDialog(null, "data is uploaded successfully");
				}catch(Exception ex) { 
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1482, 227);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 140, 0));
		panel.setBorder(new TitledBorder(null, "Peoples", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 16, 1462, 200);
		panel.add(scrollPane);
		
		
		//table.setRowHeight(12);
		//TableColumnModel tcm= table.getColumnModel();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Load Table");
		btnNewButton_1.setBounds(377, 249, 196, 37);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Tebo="select * from People";
					PreparedStatement pre=con.prepareStatement(Tebo);
					ResultSet result=pre.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(result));
					
				}catch(Exception ero) {
					JOptionPane.showMessageDialog(null, ero);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("List Of People who Visited this Place today");
				MessageFormat footer= new MessageFormat("page, 0, number, integer");
				try {
					try {
						//int r=200;
						String Tebo="select * from People";
						PreparedStatement pre=con.prepareStatement(Tebo);
						ResultSet result=pre.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(result));
						//table.setRowHeight(r);
						//table.setSize(getMinimumSize());
						//table.sizeColumnsToFit(isMinimumSizeSet());;
						
						
						
					}catch(Exception ero) {
						JOptionPane.showMessageDialog(null, ero);
					}
					table.print(JTable.PrintMode.NORMAL, header, footer);
				}
				catch(java.awt.print.PrinterException er) {
					System.err.format(" this is the error %s%n",er.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 21));
		btnPrint.setBounds(814, 248, 196, 37);
		panel_1.add(btnPrint);
		contentPane.setLayout(gl_contentPane);
		
	}
}
