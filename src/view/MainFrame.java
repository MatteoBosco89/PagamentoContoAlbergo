package view;

import util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import controller.*;
import model.Conto;
import model.Pagamento;
import model.RigaOrdineBibita;
import model.RigaOrdineRistorante;
import model.Scontrino;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;


import java.awt.Label;



public class MainFrame {

	private JFrame frmPagamentoContoAlbergo;
	private JTextField cfTxt;
	private JList<RigaOrdineRistorante> ordiniR;
	private JList<RigaOrdineBibita> ordiniB;
	private Conto conto;
	private Pagamento pagamento;
	private Scontrino scontrino;
	private PagamentoContoController c = new PagamentoContoController();
	private BufferedImage bPic = null; 
	private BufferedImage yPic = null; 
	private BufferedImage nPic = null;
	private Icon loadPic = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmPagamentoContoAlbergo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPagamentoContoAlbergo = new JFrame();
		frmPagamentoContoAlbergo.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		frmPagamentoContoAlbergo.setTitle("Pagamento Conto Albergo");
		frmPagamentoContoAlbergo.setBounds(100, 100, 1664, 720);
		frmPagamentoContoAlbergo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPagamentoContoAlbergo.getContentPane().setLayout(null);
		
		try {
			bPic = ImageIO.read(new File("./src/img/blank.png"));
			yPic = ImageIO.read(new File("./src/img/y.png"));
			nPic = ImageIO.read(new File("./src/img/n.png"));
			loadPic = new ImageIcon("./src/img/loader.gif");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JPanel contoPanel = new JPanel();
		contoPanel.setBackground(Color.WHITE);
		contoPanel.setBounds(0, 0, 1646, 673);
		frmPagamentoContoAlbergo.getContentPane().add(contoPanel);
		contoPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ordinazioni");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(1212, 184, 422, 34);
		contoPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Totale da pagare");
		lblNewLabel_2.setBounds(12, 19, 1622, 50);
		contoPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane ordiniScrollPane = new JScrollPane();
		ordiniScrollPane.setBounds(1212, 231, 422, 429);
		contoPanel.add(ordiniScrollPane);
		
		JLabel totLabel = new JLabel("");
		totLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		totLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totLabel.setBounds(12, 121, 1188, 60);
		contoPanel.add(totLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Modalit\u00E0 di pagamento");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 209, 1188, 60);
		contoPanel.add(lblNewLabel_4);
		
		JButton contantiBtn = new JButton("Contanti");
		contantiBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contantiBtn.setBounds(320, 300, 230, 65);
		contoPanel.add(contantiBtn);
		
		JButton cartaBtn = new JButton("Carta di credito");
		cartaBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cartaBtn.setBounds(650, 300, 230, 65);
		contoPanel.add(cartaBtn);
		
		JLabel saldoCameraLabel = new JLabel("");
		saldoCameraLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saldoCameraLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saldoCameraLabel.setBounds(1212, 121, 422, 50);
		contoPanel.add(saldoCameraLabel);
		
		JButton annullaBtn = new JButton("Annulla");
		annullaBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		annullaBtn.setBounds(956, 584, 230, 65);
		contoPanel.add(annullaBtn);
		
		JPanel scontrinoDettagliPanel = new JPanel();
		scontrinoDettagliPanel.setBackground(Color.WHITE);
		scontrinoDettagliPanel.setBounds(12, 430, 908, 230);
		contoPanel.add(scontrinoDettagliPanel);
		scontrinoDettagliPanel.setLayout(null);
		
		Label nomeDetLabel = new Label("");
		nomeDetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeDetLabel.setBounds(10, 10, 1035, 40);
		scontrinoDettagliPanel.add(nomeDetLabel);
		
		Label dataDetLabel = new Label("");
		dataDetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dataDetLabel.setBounds(10, 60, 1035, 40);
		scontrinoDettagliPanel.add(dataDetLabel);
		
		Label quantitaDetLabel = new Label("");
		quantitaDetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		quantitaDetLabel.setBounds(10, 110, 1035, 40);
		scontrinoDettagliPanel.add(quantitaDetLabel);
		
		Label prezzoDetLabel = new Label("");
		prezzoDetLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prezzoDetLabel.setBounds(10, 160, 1035, 40);
		scontrinoDettagliPanel.add(prezzoDetLabel);
		
		contoPanel.setVisible(false);
		
		JPanel succPanel = new JPanel();
		succPanel.setBackground(Color.WHITE);
		succPanel.setBounds(0, 0, 1646, 673);
		frmPagamentoContoAlbergo.getContentPane().add(succPanel);
		succPanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Pagamento Effettuato");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 172, 1622, 58);
		succPanel.add(lblNewLabel_5);
		
		JButton homeBtn = new JButton("Torna alla schermata principale");
		homeBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		homeBtn.setBounds(645, 264, 382, 83);
		succPanel.add(homeBtn);
		succPanel.setVisible(false);
		
		JPanel insPanel = new JPanel();
		insPanel.setBackground(Color.WHITE);
		insPanel.setBounds(0, 13, 1646, 418);
		frmPagamentoContoAlbergo.getContentPane().add(insPanel);
		insPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calcolo conto del cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(12, 13, 1622, 86);
		insPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inserire codice fiscale");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(483, 123, 239, 86);
		insPanel.add(lblNewLabel_1);
		
		JLabel checkLabel = new JLabel(new ImageIcon(bPic));
		checkLabel.setBackground(Color.WHITE);
		checkLabel.setBounds(1234, 140, 54, 54);
		insPanel.add(checkLabel);
		
		JLabel errLabel = new JLabel("");
		errLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		errLabel.setForeground(Color.RED);
		errLabel.setBounds(12, 239, 1622, 31);
		insPanel.add(errLabel);
		
		JButton calcBtn = new JButton("CALCOLO CONTO");
		calcBtn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		calcBtn.setBounds(715, 294, 215, 73);
		calcBtn.setEnabled(false);
		insPanel.add(calcBtn);
		
		cfTxt = new JTextField();
		cfTxt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cfTxt.setBounds(782, 140, 440, 54);
		insPanel.add(cfTxt);
		cfTxt.setColumns(10);
		
		JPanel resPanel = new JPanel();
		resPanel.setBackground(Color.WHITE);
		resPanel.setBounds(0, 430, 1646, 230);
		frmPagamentoContoAlbergo.getContentPane().add(resPanel);
		resPanel.setLayout(null);
		
		JLabel loadLabel = new JLabel(loadPic);
		loadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadLabel.setBounds(12, 13, 1622, 204);
		loadLabel.setVisible(false);
		
		JLabel cfResL = new JLabel("");
		cfResL.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cfResL.setBounds(290, 13, 505, 46);
		resPanel.add(cfResL);
		
		JLabel nomeResL = new JLabel("");
		nomeResL.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nomeResL.setBounds(290, 78, 505, 46);
		resPanel.add(nomeResL);
		
		JLabel cognomeResL = new JLabel("");
		cognomeResL.setFont(new Font("Tahoma", Font.PLAIN, 22));
		cognomeResL.setBounds(290, 148, 505, 46);
		resPanel.add(cognomeResL);
		resPanel.add(loadLabel);
		
		
		cfTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				cfTxt.setText(cfTxt.getText().toUpperCase());
				if(cfTxt.getText().length() < 16 || cfTxt.getText().length() > 16) {
					checkLabel.setIcon(new ImageIcon(nPic));
					errLabel.setText("Inserire 16 caratteri");
					nomeResL.setText("");
					cognomeResL.setText("");
					cfResL.setText("");
					calcBtn.setEnabled(false);
				}else {
					errLabel.setText("");
					loadLabel.setVisible(true);
					if(c.check(cfTxt.getText())) {
						checkLabel.setIcon(new ImageIcon(yPic));
						ArrayList<String> cliente = c.getClientePrewiev(cfTxt.getText());
						nomeResL.setText("Nome: "+cliente.get(0));
						cognomeResL.setText("Cognome: "+cliente.get(1));
						cfResL.setText("Codice Fiscale: "+cliente.get(2));
						nomeResL.setVisible(true);
						cognomeResL.setVisible(true);
						cfResL.setVisible(true);
						loadLabel.setVisible(false);
						calcBtn.setEnabled(true);
					}else {
						nomeResL.setText("Nessun cliente trovato");
						checkLabel.setIcon(new ImageIcon(nPic));
						loadLabel.setVisible(false);
					}
					
				}
			}
		});
		
		
		
		
		
		
		calcBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					calcoloConto(cfTxt.getText());
				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
				insPanel.setVisible(false);
				resPanel.setVisible(false);
				contoPanel.setVisible(true);
				totLabel.setText("Importo totale da pagare: "+pagamento.getImportoTotale()+"€");
				
				DefaultListModel<RigaOrdineRistorante> model = new DefaultListModel<>();
				for(RigaOrdineRistorante val : scontrino.getOrdiniRistorante().getOrdine()) {
					model.addElement(val);
				}
				ordiniR = new JList<RigaOrdineRistorante>(model);
				ordiniR.setCellRenderer(new ListCellRenderer<RigaOrdineRistorante>() {
					@Override
					public Component getListCellRendererComponent(JList<? extends RigaOrdineRistorante> list,
							RigaOrdineRistorante value, int index, boolean isSelected, boolean cellHasFocus) {
						
						String nome = value.getPietanza().getDesc();
						String quantita = ""+value.getQuantita();
						JLabel l = new JLabel();
						l.setFont(new Font("Tahoma", Font.PLAIN, 20));
						l.setText(nome+"..............."+quantita);
						return l;
					}
				});
				
				DefaultListModel<RigaOrdineBibita> modelB = new DefaultListModel<>();
				for(RigaOrdineBibita val : scontrino.getOrdiniBibite().getOrdine()) {
					modelB.addElement(val);
				}
				ordiniB = new JList<RigaOrdineBibita>(modelB);
				ordiniB.setCellRenderer(new ListCellRenderer<RigaOrdineBibita>() {
					@Override
					public Component getListCellRendererComponent(JList<? extends RigaOrdineBibita> list,
							RigaOrdineBibita value, int index, boolean isSelected, boolean cellHasFocus) {
						String nome = value.getBibita().getDesc();
						String quantita = ""+value.getQuantita();
						JLabel l = new JLabel();
						l.setHorizontalAlignment(SwingConstants.LEFT);
						l.setFont(new Font("Tahoma", Font.PLAIN, 20));
						l.setText(nome+"..............."+quantita);
						return l;
					}
				});
				
				
				ordiniB.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						RigaOrdineBibita r = ordiniB.getModel().getElementAt(ordiniB.getSelectedIndex());
						nomeDetLabel.setText("Ordine: "+r.getBibita().getDesc());
						quantitaDetLabel.setText("Quantità: "+r.getQuantita());
						dataDetLabel.setText("In data: "+Util.dateToString(r.getData()));
						prezzoDetLabel.setText("Prezzo: "+r.getBibita().getPrezzoBibita());
					}
				}); 
				
				ordiniR.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						RigaOrdineRistorante r = ordiniR.getModel().getElementAt(ordiniR.getSelectedIndex());
						nomeDetLabel.setText("Ordine: "+r.getPietanza().getDesc());
						quantitaDetLabel.setText("Quantità: "+r.getQuantita());
						dataDetLabel.setText("In data: "+Util.dateToString(r.getData()));
						prezzoDetLabel.setText("Prezzo: "+r.getPietanza().getPrezzoPietanza());
					}
				});
				
				JPanel p = new JPanel();
				p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
				p.setBackground(Color.WHITE);
				p.add(ordiniB);
				p.add(ordiniR);
				ordiniScrollPane.setViewportView(p);
				saldoCameraLabel.setText("Saldo affitto camera: "+scontrino.getSaldoCamera()+"€");
				
			}
		});		
		
		annullaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contoPanel.setVisible(false);
				succPanel.setVisible(false);
				nomeDetLabel.setText("");
				prezzoDetLabel.setText("");
				quantitaDetLabel.setText("");
				dataDetLabel.setText("");
				cfTxt.setText("");
				nomeResL.setVisible(true);
				nomeResL.setText("");
				errLabel.setText("");
				cognomeResL.setVisible(true);
				cognomeResL.setText("");
				cfResL.setVisible(true);
				cfResL.setText("");
				calcBtn.setEnabled(false);
				checkLabel.setIcon(new ImageIcon(bPic));
				insPanel.setVisible(true);
				resPanel.setVisible(true);
			}
		});
		
		
		contantiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.pagaConto(conto, pagamento, 0);
				contoPanel.setVisible(false);
				succPanel.setVisible(true);
			}
		});
		
		cartaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.pagaConto(conto, pagamento, 1);
				contoPanel.setVisible(false);
				succPanel.setVisible(true);
			}
		});
		
		
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contoPanel.setVisible(false);
				succPanel.setVisible(false);
				nomeDetLabel.setText("");
				prezzoDetLabel.setText("");
				quantitaDetLabel.setText("");
				dataDetLabel.setText("");
				cfTxt.setText("");
				nomeResL.setVisible(true);
				nomeResL.setText("");
				errLabel.setText("");
				cognomeResL.setVisible(true);
				cognomeResL.setText("");
				cfResL.setVisible(true);
				cfResL.setText("");
				calcBtn.setEnabled(false);
				checkLabel.setIcon(new ImageIcon(bPic));
				insPanel.setVisible(true);
				resPanel.setVisible(true);
			}
		});
		
	}
	
	
	
	
	public void calcoloConto(String cf) throws NumberFormatException, ParseException {
		conto = c.calcoloConto(cf);
		pagamento = c.createPagamento(conto);
		scontrino = c.createScontrino(conto);
	}
}
