package org.hightail.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.hightail.AuthenticationInfo;
import org.hightail.Config;
import org.hightail.ContestScheduler;
import org.hightail.Problem;
import org.hightail.SupportedSites;
import org.hightail.parsers.contest.ContestParser;
import org.htmlparser.util.ParserException;


public class NewContestJDialog extends javax.swing.JDialog {
    
    protected ArrayList<Problem> problemList = new ArrayList<>();
    protected Thread thread;
    private boolean parsingSucceeded = false;
    
    /**
     * Creates new form NewContestJDialog
     */
    public NewContestJDialog(java.awt.Frame parent) {
        super(parent, true); // makes it modal
        initComponents();
        
        setTitle("New contest");
        
        makeShortcuts();
        
        setLocationRelativeTo(parent);
        
        contestDirectoryField.setText(Config.get("workingDirectory"));
        
        DocumentListener clearErrorLabel = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                contestURLChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                contestURLChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                contestURLChanged();
            }
            
        };
        contestUrlField.getDocument().addDocumentListener(clearErrorLabel);
        
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        minute = (minute + 14) / 15 * 15;
        if (minute == 60) {
            hour = (hour + 1) % 24;
            minute = 0;
        }
        scheduleHourComboBox.setSelectedIndex(hour);
        scheduleMinuteComboBox.setSelectedIndex(minute);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contestUrlLabel = new javax.swing.JLabel();
        parseContestButton = new javax.swing.JButton();
        contestUrlField = new javax.swing.JTextField();
        contestParseStatusLabel = new javax.swing.JLabel();
        abortParsingButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        scheduleCheckBox = new javax.swing.JCheckBox();
        scheduleHourComboBox = new javax.swing.JComboBox();
        scheduleMinuteComboBox = new javax.swing.JComboBox();
        delayLabel = new javax.swing.JLabel();
        contestDirectoryLabel = new javax.swing.JLabel();
        contestDirectoryField = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        addContestButton = new javax.swing.JButton();
        usernamePasswordLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        contestUrlLabel.setText("Contest URL:");

        parseContestButton.setText("Parse");
        parseContestButton.setEnabled(false);
        parseContestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parseContestButtonActionPerformed(evt);
            }
        });

        abortParsingButton.setText("Abort");
        abortParsingButton.setEnabled(false);
        abortParsingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortParsingButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        errorMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        scheduleCheckBox.setText("Schedule");
        scheduleCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                scheduleCheckBoxItemStateChanged(evt);
            }
        });

        scheduleHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        scheduleHourComboBox.setEnabled(false);

        scheduleMinuteComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        scheduleMinuteComboBox.setEnabled(false);

        delayLabel.setText("(+ 10-20 seconds of delay)");
        delayLabel.setEnabled(false);

        contestDirectoryLabel.setText("Directory:");

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        addContestButton.setText("Add contest");
        addContestButton.setEnabled(false);
        addContestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContestButtonActionPerformed(evt);
            }
        });

        usernamePasswordLabel.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        usernamePasswordLabel.setText("Only for atcoder online contest:");
        usernamePasswordLabel.setName(""); // NOI18N

        usernameLabel.setText("Username");

        passwordLabel.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contestParseStatusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scheduleCheckBox)
                            .addComponent(contestDirectoryLabel))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scheduleHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scheduleMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delayLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contestDirectoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernamePasswordLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usernameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(abortParsingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(parseContestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(passwordLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(selectButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addComponent(contestUrlField)))
                            .addComponent(contestUrlLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addContestButton)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contestUrlLabel)
                    .addComponent(contestUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamePasswordLabel)
                    .addComponent(usernameLabel)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(errorMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parseContestButton)
                            .addComponent(abortParsingButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contestDirectoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectButton)
                    .addComponent(contestDirectoryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delayLabel)
                    .addComponent(scheduleCheckBox)
                    .addComponent(scheduleHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduleMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(addContestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contestParseStatusLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void contestURLChanged() {
        parseContestButton.setEnabled(!contestUrlField.getText().isEmpty() && !scheduleCheckBox.isSelected());
        errorMessageLabel.setText(null);
        errorMessageLabel.setToolTipText(null);
        parsingSucceeded = false;
        addContestButton.setEnabled(scheduleCheckBox.isSelected());
    }
    
    private void makeShortcuts() {
        // escape key will close the dialog
        getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close");
        getRootPane().getActionMap().put("close", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        // hitting enter will perform the same action as clicking parse contest button
        contestUrlField.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        contestUrlField.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseContest();
            }
        });
        // hitting enter will perform the same action as clicking parse contest button
        scheduleHourComboBox.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        scheduleHourComboBox.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseContest();
            }
        });
        scheduleMinuteComboBox.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        scheduleMinuteComboBox.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseContest();
            }
        });
    }
    
    private AuthenticationInfo getAuthenticationInfo() {
        return new AuthenticationInfo(usernameField.getText(), new String(passwordField.getPassword()));
    }
    private void scheduleContest() {
        Calendar calendar = Calendar.getInstance();
        int hour = Integer.parseInt((String) scheduleHourComboBox.getSelectedItem());
        int minute = Integer.parseInt((String) scheduleMinuteComboBox.getSelectedItem());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        // sets a few (10-20) seconds delay
        calendar.set(Calendar.SECOND, new Random().nextInt(11) + 10);
        Date date = calendar.getTime();
        if (date.before(Calendar.getInstance().getTime())) {
            date = new Date(calendar.getTimeInMillis() + 24*3600*1000);
        }
        ContestScheduler.schedule(contestUrlField.getText(), getAuthenticationInfo(), contestDirectoryField.getText(), (MainJFrame) getParent(), date);
        JOptionPane.showMessageDialog(this, "Contest scheduled.", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
    
    private void parseContest() {
        if (!parseContestButton.isEnabled()) {
            return;
        }
        problemList.clear();
        parseContestButton.setEnabled(false);
        abortParsingButton.setEnabled(true);
        
        // TODO: what about the cancel button?
        startParsing(contestUrlField.getText(), getAuthenticationInfo());
    }
    
    private void parseContestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parseContestButtonActionPerformed
        parseContest();
    }//GEN-LAST:event_parseContestButtonActionPerformed
    
    private void abortParsingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortParsingButtonActionPerformed
        abortParsing();
    }//GEN-LAST:event_abortParsingButtonActionPerformed
    
    private void cancel() {
        problemList.clear();
        this.dispose();
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancel();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void scheduleCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_scheduleCheckBoxItemStateChanged
        boolean selected = (evt.getStateChange() == ItemEvent.SELECTED);
        scheduleHourComboBox.setEnabled(selected);
        scheduleMinuteComboBox.setEnabled(selected);
        delayLabel.setEnabled(selected);
        parseContestButton.setEnabled(!selected && !contestUrlField.getText().isEmpty());
        errorMessageLabel.setText(null);
        errorMessageLabel.setToolTipText(null);
        addContestButton.setEnabled(selected | parsingSucceeded);
    }//GEN-LAST:event_scheduleCheckBoxItemStateChanged

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        JFileChooser fc = new JFileChooser(contestDirectoryField.getText());
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            contestDirectoryField.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    private void addContestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContestButtonActionPerformed
        if (scheduleCheckBox.isSelected()) {
            scheduleContest();
            dispose();
            return;
        }
        if (!parsingSucceeded) {
            JOptionPane.showMessageDialog(this, "Parse contest first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dispose();
    }//GEN-LAST:event_addContestButtonActionPerformed

    private void setWorkingDirectoryDependingOnSite() {
        SupportedSites site = SupportedSites.getSite(contestUrlField.getText());
        if (site == null) {
            return;
        }
        contestDirectoryField.setText(
                Config.get("workingDirectory")
                + java.io.File.separator
                + site.getDirectory());
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortParsingButton;
    private javax.swing.JButton addContestButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contestDirectoryField;
    private javax.swing.JLabel contestDirectoryLabel;
    private javax.swing.JLabel contestParseStatusLabel;
    private javax.swing.JTextField contestUrlField;
    private javax.swing.JLabel contestUrlLabel;
    private javax.swing.JLabel delayLabel;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JButton parseContestButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JCheckBox scheduleCheckBox;
    private javax.swing.JComboBox scheduleHourComboBox;
    private javax.swing.JComboBox scheduleMinuteComboBox;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernamePasswordLabel;
    // End of variables declaration//GEN-END:variables
    
    ArrayList<Problem> getProblemList() {
        return problemList;
    }
    
    private void startParsing(final String URL, final AuthenticationInfo authenticationInfo) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String errorMessage;
                String errorMessageTooltip = null;
                parsingSucceeded = false;
                try {
                    errorMessageLabel.setText("Parsing...");
                    errorMessageLabel.setToolTipText(null);
                    ContestParser contestParser = SupportedSites.getContestParser(URL);
                    ArrayList<Problem> tasks = contestParser.getProblemListFromContestURL(URL, authenticationInfo);
                    if (tasks.isEmpty()) {
                        throw new ParserException();
                    }
                    for (Problem problem : tasks) {
                        problem.setWorkingDirectory(contestDirectoryField.getText());
                        problemList.add(problem);
                    }
                    parsingSucceeded = true;
                    errorMessage = "Parsing ok.";
                } catch (ParserException ex) {
                    errorMessage = "Parsing failed.";
                    errorMessageTooltip = ex.getMessage();
                } catch (InterruptedException ex) {
                    errorMessage = "Parsing aborted.";
                }
                errorMessageLabel.setText(errorMessage);
                errorMessageLabel.setToolTipText(errorMessageTooltip);
                addContestButton.setEnabled(parsingSucceeded);
                parseContestButton.setEnabled(true);
                abortParsingButton.setEnabled(false);
                if (!parsingSucceeded) {
                    problemList.clear();
                }
            }
        });
        thread.start();
    }
    
    private void abortParsing() {
        errorMessageLabel.setText("Aborting...");
        errorMessageLabel.setToolTipText(null);
        abortParsingButton.setEnabled(false);
        thread.interrupt();
    }
}
