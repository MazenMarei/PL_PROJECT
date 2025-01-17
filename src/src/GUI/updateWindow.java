/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src.GUI;



import java.awt.Color;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JPanel;
import src.Product.*;

/**
 *
 * @author yamama
 */
public class updateWindow extends javax.swing.JFrame {

    public updateWindow() {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(updateWindow.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        nametxt.setText(updated.name);
        categtxt.setText(updated.categ);
        pricetxt.setText(String.valueOf(updated.price));
        quantitytxt.setText(String.valueOf(updated.quantity));
        prodtxt.setText(updated.Prod);
        exptxt.setText(updated.exp);
    }

    public void close() {
        WindowEvent CloseWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(CloseWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        categtxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pricetxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantitytxt = new javax.swing.JTextField();
        prodtxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exptxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        updatingbtn = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cancelingbtn = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        validationUpdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Name");

        nametxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        categtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categtxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("Category");

        pricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("Price");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setText("Quantity");

        quantitytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytxtActionPerformed(evt);
            }
        });

        prodtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodtxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setText("ProdDate");

        exptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exptxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setText("ExpDate");

        updatingbtn.setBackground(new java.awt.Color(40, 100, 163));
        updatingbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatingbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updatingbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updatingbtnMouseReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("update");

        javax.swing.GroupLayout updatingbtnLayout = new javax.swing.GroupLayout(updatingbtn);
        updatingbtn.setLayout(updatingbtnLayout);
        updatingbtnLayout.setHorizontalGroup(
            updatingbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatingbtnLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel11)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        updatingbtnLayout.setVerticalGroup(
            updatingbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatingbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelingbtn.setBackground(new java.awt.Color(40, 100, 163));
        cancelingbtn.setToolTipText("");
        cancelingbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelingbtnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelingbtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelingbtnMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("cancel");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cancelingbtnLayout = new javax.swing.GroupLayout(cancelingbtn);
        cancelingbtn.setLayout(cancelingbtnLayout);
        cancelingbtnLayout.setHorizontalGroup(
            cancelingbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelingbtnLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel12)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        cancelingbtnLayout.setVerticalGroup(
            cancelingbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelingbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(40, 100, 163));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("update window");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        validationUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(updatingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cancelingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(validationUpdate)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pricetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                            .addComponent(categtxt))))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantitytxt)
                            .addComponent(prodtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(exptxt))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(validationUpdate)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantitytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelingbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtActionPerformed

    private void quantitytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitytxtActionPerformed

    private void prodtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodtxtActionPerformed

    private void categtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categtxtActionPerformed

    private void updatingbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatingbtnMouseClicked

        Modification mod = new Modification();
        Product prod = new Product();
        prod.setName(nametxt.getText().toLowerCase());
        prod.setCategory(categtxt.getText().toLowerCase());
        
        LocalDate today = LocalDate.now();
        String formattedDate = today.toString();
        String[] temp=formattedDate.split("-");
        ArrayList<String> m=new ArrayList<>();
        m.add(temp[2]);
        m.add(temp[1]);
        m.add(temp[0]);
        String todayDate=m.get(0);
        todayDate=todayDate+"-";
        todayDate=todayDate+m.get(1);
        todayDate=todayDate+"-";
        todayDate=todayDate+m.get(2);
      
        prod.setProductionDate(prodtxt.getText());
        prod.setExpiringDate(exptxt.getText());
        prod.setID(updated.ID);
        if (nametxt.getText().length() != 0 && categtxt.getText().length() != 0 && mod.checkDate(prodtxt.getText()) != -2 && mod.checkDate(exptxt.getText()) != -2 && mod.validateProductExpire(prodtxt.getText(), exptxt.getText()) != 0 && pricetxt.getText().length()!=0 && quantitytxt.getText().length()!=0) {
            prod.setPrice(Integer.valueOf(pricetxt.getText()));
            prod.setQuantity(Integer.valueOf(quantitytxt.getText()));
            try {
                if (!(mod.checkDate(prod.getProductionDate()) == -2 || mod.checkDate(prod.getExpiringDate()) == -2 || mod.validateProductExpire(todayDate, prod.getExpiringDate()) == 0 || mod.validateProductExpire(prod.getProductionDate(), todayDate) == 0 || mod.validateProductExpire(prod.getProductionDate(), prod.getExpiringDate()) == 0)) {
                    mod.updateProduct(prod);
                    validationUpdate.setText("Updated successfully");
                    validationUpdate.setForeground(green);
                } else {
                    System.out.println("invalid date");
                    validationUpdate.setText("Update failed");
                    validationUpdate.setForeground(red);
                }
            } catch (FileNotFoundException ex) {
                validationUpdate.setText("Update failed");
                validationUpdate.setForeground(red);
                System.out.println("not updated");
            }
        } else {
            validationUpdate.setText("Update failed");
            validationUpdate.setForeground(red);
        }
    }//GEN-LAST:event_updatingbtnMouseClicked

    private void updatingbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatingbtnMousePressed
        // TODO add your handling code here:
        setColor(updatingbtn);

    }//GEN-LAST:event_updatingbtnMousePressed

    private void updatingbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatingbtnMouseReleased
        // TODO add your handling code here:
        resetColor(updatingbtn);

    }//GEN-LAST:event_updatingbtnMouseReleased

    private void cancelingbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelingbtnMouseClicked
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_cancelingbtnMouseClicked

    private void cancelingbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelingbtnMousePressed
        // TODO add your handling code here:
        setColor(cancelingbtn);
    }//GEN-LAST:event_cancelingbtnMousePressed

    private void cancelingbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelingbtnMouseReleased
        // TODO add your handling code here:
        resetColor(cancelingbtn);
    }//GEN-LAST:event_cancelingbtnMouseReleased

    private void exptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exptxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exptxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_jLabel12MouseClicked

    void setColor(JPanel panel) {
        panel.setBackground(new Color(0, 60, 123));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(40, 100, 163));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cancelingbtn;
    private javax.swing.JTextField categtxt;
    private javax.swing.JTextField exptxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTextField prodtxt;
    private javax.swing.JTextField quantitytxt;
    private javax.swing.JPanel updatingbtn;
    private javax.swing.JLabel validationUpdate;
    // End of variables declaration//GEN-END:variables
}
