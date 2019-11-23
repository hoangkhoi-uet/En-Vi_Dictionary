/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_swing;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import com.sun.speech.freetts.*;
/**
 *
 * @author Dell
 */
public class MainForm extends javax.swing.JFrame {

    public static DefaultListModel dlm = new DefaultListModel();
    public Dictionary dic = new Dictionary();
    public static String wordNeedReplacing = null;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        dic.insertFromFile();                       //Insert from file
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Dictionary");                     //Title
        showAllWords();                             //Show list 
        
        explainArea.setWrapStyleWord(true);
        explainArea.setLineWrap(true);
    }

    public void showAllWords() {
        dlm.addElement(null);
        for (int i = 0; i < Dictionary.dictionary.size(); i++) {
            dlm.addElement(Dictionary.dictionary.get(i).getWord_target());
        }
        listView.setModel(dlm);
    }
    /**
     * remove from list and text area
     */
    public void removeAllWords() {
        dlm.removeAllElements();
        explainArea.setText("");
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
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listView = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        explainArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        add = new javax.swing.JButton();
        replace = new javax.swing.JButton();
        ExitProgram = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        translateParagraph = new javax.swing.JButton();
        speak = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exitItemMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutItemMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        listView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listView);

        explainArea.setColumns(20);
        explainArea.setRows(5);
        jScrollPane2.setViewportView(explainArea);

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\OOP\\Dictionary_Swing\\image\\if_Search_132289.png")); // NOI18N
        jLabel1.setText("Search");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ý nghĩa");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("English");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));

        deleteButton.setText("Xóa");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        add.setText("Thêm từ");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        replace.setText("Sửa từ");
        replace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                replaceMouseClicked(evt);
            }
        });

        ExitProgram.setText("Thoát");
        ExitProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitProgramActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\OOP\\Dictionary_Swing\\image\\if_Book_132247.png")); // NOI18N

        refresh.setText("Refresh");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });

        translateParagraph.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\OOP\\Dictionary_Swing\\image\\ShowImage.png")); // NOI18N
        translateParagraph.setText("Dịch đoạn văn");
        translateParagraph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                translateParagraphMouseClicked(evt);
            }
        });

        speak.setText("Phát âm");
        speak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(translateParagraph))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(replace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(speak))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitProgram)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(translateParagraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(speak)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(add)
                        .addGap(18, 18, 18)
                        .addComponent(replace)
                        .addGap(18, 18, 18)
                        .addComponent(refresh)
                        .addContainerGap(195, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addComponent(ExitProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenu1.setText("File");

        exitItemMenu.setText("Exit");
        exitItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitItemMenu);

        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");

        jMenuItem1.setText("Thêm từ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        jMenuBar1.add(editMenu);

        jMenu2.setText("About");

        aboutItemMenu.setText("About us");
        aboutItemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemMenuActionPerformed(evt);
            }
        });
        jMenu2.add(aboutItemMenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        removeAllWords();
        dlm.addElement(null);
        String searchField = this.searchField.getText().toLowerCase();
        for (int i = 0; i < Dictionary.dictionary.size(); i++) {
            if (Dictionary.dictionary.get(i).getWord_target().startsWith(searchField)) {
                dlm.addElement(Dictionary.dictionary.get(i).getWord_target());
            }
        }
        listView.setModel(dlm);
        if (searchField.equals("")) {
            removeAllWords();
            showAllWords();
        }

    }//GEN-LAST:event_searchFieldKeyReleased

    private void listViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listViewMouseClicked
        String selectedWord = listView.getSelectedValue();
        int i = binarySearch(selectedWord);         //Search word on list
        explainArea.setText(Dictionary.dictionary.get(i).getWord_explain());    //get explain
    }//GEN-LAST:event_listViewMouseClicked
    /**
     * Delete button
     * @param evt 
     */
    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        String selectedWord = listView.getSelectedValue();          //Pick up by mouse
        if (selectedWord == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn từ nào!");
        } else {
            int i = binarySearch(selectedWord);
            String deleteWord = Dictionary.dictionary.get(i).getWord_target();
            //Show dialog and process
            int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa từ \"" + deleteWord + "\"?");
            if (choose == JOptionPane.YES_OPTION) {
                Dictionary.dictionary.remove(i);
                dic.dictionaryExportToFile();
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công!");
                refreshMouseClicked(evt);
            }
        }
    }//GEN-LAST:event_deleteButtonMouseClicked
    /**
     * add button
     * @param evt 
     */
    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        new AddWordDialog().setVisible(true);     //change to add word function
    }//GEN-LAST:event_addMouseClicked
    /**
     * replace word button
     * @param evt 
     */
    private void replaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_replaceMouseClicked
        wordNeedReplacing = listView.getSelectedValue();    //Add selected word by mouse
        if (wordNeedReplacing == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn từ nào!");
        } else {
            new ReplaceWordDialog().setVisible(true);
        }
    }//GEN-LAST:event_replaceMouseClicked
    /**
     * exit button
     * @param evt 
     */
    private void ExitProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitProgramActionPerformed
        int choose = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn thoát?");
        if (choose == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_ExitProgramActionPerformed

    private void aboutItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemMenuActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Từ điển cơ bản JavaSwing 1.0\nSử dụng google translate");
    }//GEN-LAST:event_aboutItemMenuActionPerformed

    private void exitItemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemMenuActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitItemMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AddWordDialog().setVisible(true);     //change to add word function
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //Refresh face
    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        searchField.setText("");
        removeAllWords();
        showAllWords();
    }//GEN-LAST:event_refreshMouseClicked

    private void translateParagraphMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translateParagraphMouseClicked
        new UseTranslate().setVisible(true);
    }//GEN-LAST:event_translateParagraphMouseClicked
    /**
     * speak with voice
     */
    public static final String VOICENAME = "kevin16";
    private void speakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speakActionPerformed
        String wordNeedSpeaking = listView.getSelectedValue();
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        
        voice.allocate();
        try {
            voice.speak(wordNeedSpeaking);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_speakActionPerformed
    /**
     * Binary search return position of word
     * @param needingSearch
     * @return 
     */
    public static int binarySearch(String needingSearch) {
        int left = 0;
        int right = Dictionary.dictionary.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Dictionary.dictionary.get(mid).getWord_target().compareTo(needingSearch) == 0) {
                return mid;
            } else if (Dictionary.dictionary.get(mid).getWord_target().compareTo(needingSearch) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitProgram;
    private javax.swing.JMenuItem aboutItemMenu;
    private javax.swing.JButton add;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItemMenu;
    private javax.swing.JTextArea explainArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listView;
    private javax.swing.JButton refresh;
    private javax.swing.JButton replace;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton speak;
    private javax.swing.JButton translateParagraph;
    // End of variables declaration//GEN-END:variables
}
