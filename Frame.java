/* Proiect Geometrie, Problema 4
 * Descriere: Algoritmica + Rezolvare Grafica
 * Autori: Raul M. Crivineanu, Mihai Moiseanu, Catalin Chimerel
 * FMI UNIBUC, Anul II, Semestrul I
 */

import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Frame extends javax.swing.JFrame implements ActionListener, MouseListener{

	static int atm = 0;
	static int c = 0;
	static JLabel clear, lbl1;
	Jarvis j = new Jarvis();
	ArrayList<Point> points = new ArrayList<>();;
	int x,y;
	public Frame() {
		setResizable(false);
		setTitle("Problema 4 - Proiect geometrie");
		initComponents();
		jPanel1.addMouseListener(this);
	}
	
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX() + " " + e.getY()); // ca sa fim siguri
			x=e.getX();
			y=e.getY();
			Graphics g=jPanel1.getGraphics();
			g.setColor(Color.RED);
			drawCenteredCircle(g, x, y, 10);
			points.add(new Point(e.getX(), e.getY()));
			lbl1 = new JLabel("." + atm);
			lbl1.setForeground(new Color(255, 0, 0));
			jPanel1.add(lbl1);
			lbl1.setLocation(e.getX()+5, e.getY()+5);
			lbl1.setSize(36, 14);
			atm = atm + 1;
		}
		
		public void drawCenteredCircle(Graphics g, int x, int y, int r) {
			  x = x-(r/2);
			  y = y-(r/2);
			  g.fillOval(x,y,r,r);
			}
		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">

	private void initComponents() {

		jPanel1 = new JPanel(null);
		jPanel1.setPreferredSize(new Dimension(500, 100));
		jPanel1.setBackground(Color.DARK_GRAY);
		jPanel1.setForeground(new Color(255, 0, 0));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JButton btnx = new JButton("Desenare frontiera");
		btnx.setForeground(new Color(0, 0, 0));

		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Integer> n = new ArrayList<>();
				n = j.convexHull(points);
				Graphics g = jPanel1.getGraphics();
				if (c == 0)
					g.setColor(Color.RED);
				else
					g.setColor(Color.BLUE);
				for (int i = 0; i < n.size() - 1; i++) {
					g.drawLine(points.get(n.get(i)).x, points.get(n.get(i)).y, points.get(n.get(i + 1)).x,
							points.get(n.get(i + 1)).y);
				}

				c++;
			}
		});

		JButton btnreset = new JButton("Resetare puncte");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				points.clear();
				atm = 0;
				javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
				jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				jPanel1.removeAll();
				jPanel1.revalidate();
				repaint();
				jPanel1.repaint();
				c = 0;
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGap(53)
						.addComponent(btnx, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE).addGap(45)
						.addComponent(btnreset, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(52)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout
								.createParallelGroup(Alignment.BASELINE).addComponent(btnreset).addComponent(btnx))
				.addContainerGap()));
		jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Frame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private JPanel jPanel1;
	// End of variables declaration

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}