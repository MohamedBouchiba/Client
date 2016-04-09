import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;



public class Fenetre extends JFrame {
	
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("connection");
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private String loging = null;
    private String mdp = null;
	public static Socket socket = null;
	public static Thread t1;
    
  public Fenetre(){
	  
	initComponents();  
    this.setTitle("Autentification");
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
    this.setVisible(true);
    
    
  }
  
  
  
  private void initComponents() {

      jButton1 = new javax.swing.JButton();
      jTextField1 = new javax.swing.JTextField();
      jTextField2 = new javax.swing.JTextField();
      jButton2 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jButton1.setText("Inscription");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              jButton1ActionPerformed(evt);
          }
      });

      jTextField1.setForeground(new java.awt.Color(140, 152, 153));
      jTextField1.setText("Saisir identifiant...");
      jTextField1.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              jTextField1ActionPerformed(evt);
          }
      });

      jTextField2.setForeground(new java.awt.Color(140, 152, 153));
      jTextField2.setText("Saisir mot de passe...");

      jButton2.setText("Connection");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              jButton2ActionPerformed(evt);
          }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                  .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jTextField1))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jButton2)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jButton1)
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
  }// </editor-fold>   
  
  
  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
      // TODO add your handling code here:
  }                                           

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	  this.loging = jTextField1.getText();
	  this.mdp = jTextField2.getText();
	  
		try {	
			
			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1",2010);
			System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté
			
			Connexion connec = new  Connexion(socket);
			connec.setLogin(this.loging);
			connec.setPass(this.mdp);
			t1 = new Thread(connec);
			t1.start();
			
			
			
		} catch (UnknownHostException e) {
		  System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
		  System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}
  }                                        

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
	  

      // TODO add your handling code here:
  }  
  
  
  
}