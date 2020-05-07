package memoryManger;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Color;
import javax.swing.UIManager;

public class Input {
    
	private JFrame frame;
	private JTable table;
	private JTextField start;
   	private JTextField holesize;
    public static int s1;
    public static int s2;
   	public static	Vector<Hole> finalVHole =new Vector<>(s1);
    public static  Vector Hole=new Vector();
    public static double memsize;
	public static int size;
	private JTextField memorysize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input window = new Input();
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
	public Input() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 692, 325);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				
				String startt=model.getValueAt(table.getSelectedRow(),0).toString();
				String holesizet=model.getValueAt(table.getSelectedRow(),1).toString();
			
				start.setText(startt);
				holesize.setText(holesizet);
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Start Address", "Hole Size"
			}
		
				
				) {
			
			Class[] columnTypes = new Class[] {
				 Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblNewLabel = new JLabel("Start Address");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 373, 153, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hole Size");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 413, 130, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		start = new JTextField();
		start.setBounds(201, 381, 146, 19);
		frame.getContentPane().add(start);
		start.setColumns(10);
		holesize = new JTextField();
		holesize.setBounds(201, 419, 146, 19);
		frame.getContentPane().add(holesize);
		holesize.setColumns(10);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				
				try {
					if(Double.parseDouble(start.getText())<=0||Double.parseDouble(holesize.getText())<0){
						JOptionPane.showMessageDialog(null, "Please Enter Valid Numbers ");
					}else {
					model.addRow(new Object[] {Double.parseDouble(start.getText()),Double.parseDouble(holesize.getText())});
					start.setText("");
					holesize.setText("");
			
				}
				}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "Please Enter Valid Numbers");
					}
				}
				
			}
		);
		add.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		add.setBounds(486, 369, 146, 34);
		frame.getContentPane().add(add);
		
	JButton submit = new JButton("GO");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				Hole=model.getDataVector();
				size=model.getRowCount();
				memsize= Double.parseDouble(memorysize.getText());
				if(model.getRowCount()==0)
				JOptionPane.showMessageDialog(null, "Table is Empty");
				else
				{	
					event event1=new event();
				    event1.setSize(size);
				    event1.setmemSize(memsize);
					event1.HoleV(Hole);
					//event1.busyV();
					s1=event1.finalVHole.size();
					finalVHole=event1.finalVHole;			
				
				input2 frame2=new input2();
				frame2.setVisible(true);
				
        
				}
			
				
				
			}
		});
		submit.setForeground(new Color(0, 204, 0));
		submit.setBackground(UIManager.getColor("ColorChooser.swatchesDefaultRecentColor"));
		submit.setFont(new Font("Tahoma", Font.BOLD, 18));
		submit.setBounds(247, 536, 193, 38);
		frame.getContentPane().add(submit);
		
		JLabel lblTotalMemorySize = new JLabel("Total Memory size");
		lblTotalMemorySize.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTotalMemorySize.setBounds(10, 487, 153, 30);
		frame.getContentPane().add(lblTotalMemorySize);
		
		memorysize = new JTextField();
		memorysize.setColumns(10);
		memorysize.setBounds(201, 487, 146, 19);
		frame.getContentPane().add(memorysize);
	}
}
