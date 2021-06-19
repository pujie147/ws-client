/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nouk.ws.client.ui;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import org.apache.commons.lang3.StringUtils;
import org.nouk.ws.client.constants.ConnectStatusEnum;
import org.nouk.ws.client.data.AutoListModel;
import org.nouk.ws.client.data.ConnectModel;
import org.nouk.ws.client.data.ListModel;
import org.nouk.ws.client.data.ManualListModel;
import org.nouk.ws.client.netty.WebSocketClient;
import org.nouk.ws.client.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class App extends javax.swing.JFrame {
    private WebSocketClient webSocketClient = new WebSocketClient();
//    private ListModel listModel = new ListModel();
    private ManualListModel manualListModel;
    private AutoListModel autoListModel;
    private ConnectModel connectModel;

//    @Autowired
//    public void setListModel(ListModel listModel) {
//        this.listModel = listModel;
//    }
    @Autowired
    public void setManualListModel(ManualListModel manualListModel) {
        this.manualListModel = manualListModel;
    }
    @Autowired
    public void setAutoListModel(AutoListModel autoListModel) {
        this.autoListModel = autoListModel;
    }
    @Autowired
    public void setWebSocketClient(WebSocketClient webSocketClient) {
        this.webSocketClient = webSocketClient;
    }
    @Autowired
    public void setConnectModel(ConnectModel connectModel) {
        this.connectModel = connectModel;
    }

    /**
     * Creates new form main
     */
    public App() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        WSUrl = new javax.swing.JTextField();
        WSHeaders = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        WSHeadersKey = new javax.swing.JTextField();
        WSHeadersValue = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        sendEventList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        sendEvnetMessageArea = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        addSendEventButton = new javax.swing.JButton();
        delSendEventButton = new javax.swing.JButton();
        sendEventButton = new javax.swing.JButton();
        addSendEventNameText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        manualTextArea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        autoTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ws-connect", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setText("url");

        WSUrl.setText("ws://82.157.123.54:9010/ajaxchattest");
        WSUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WSUrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(WSUrl)
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(WSUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        WSHeaders.setBorder(javax.swing.BorderFactory.createTitledBorder("headers"));

        WSHeadersKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WSHeadersKeyActionPerformed(evt);
            }
        });

        WSHeadersValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WSHeadersValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WSHeadersKey, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(WSHeadersValue, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WSHeadersKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WSHeadersValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout WSHeadersLayout = new javax.swing.GroupLayout(WSHeaders);
        WSHeaders.setLayout(WSHeadersLayout);
        WSHeadersLayout.setHorizontalGroup(
            WSHeadersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WSHeadersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        WSHeadersLayout.setVerticalGroup(
            WSHeadersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        connectButton.setText("connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(WSHeaders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(connectButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(WSHeaders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectButton)
                .addContainerGap(366, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ws-connect", jPanel1);

        jSplitPane4.setDividerLocation(340);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        updateList();
        sendEventList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendEventListMouseClicked(evt);
            }
        });
        sendEventList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sendEventListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(sendEventList);

        jSplitPane1.setTopComponent(jScrollPane1);

        sendEvnetMessageArea.setColumns(20);
        sendEvnetMessageArea.setRows(5);
        sendEvnetMessageArea.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                sendEvnetMessageAreaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                sendEvnetMessageAreaInputMethodTextChanged(evt);
            }
        });
        jScrollPane4.setViewportView(sendEvnetMessageArea);
        //sendEvnetMessageArea.getDocument().addDocumentListener(new DocumentListener(){
            //
            //@Override
            //public void insertUpdate(DocumentEvent e) {
                //	System.out.println("insertUpdate");
                //}
            //
            //@Override
            //public void removeUpdate(DocumentEvent e) {
                //	System.out.println("removeUpdate");
                //}
            //
            //@Override
            //public void changedUpdate(DocumentEvent e) {
                //	System.out.println("changedUpdate");
                //}
            //});

    jSplitPane1.setRightComponent(jScrollPane4);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 339, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 505, Short.MAX_VALUE)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
    );

    jPanel7.add(jPanel5, java.awt.BorderLayout.CENTER);

    jPanel10.setPreferredSize(new java.awt.Dimension(339, 50));

    addSendEventButton.setText("add");
    addSendEventButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addSendEventButtonActionPerformed(evt);
        }
    });

    delSendEventButton.setText("del");
    delSendEventButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            delSendEventButtonActionPerformed(evt);
        }
    });

    sendEventButton.setText("send");
    sendEventButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sendEventButtonActionPerformed(evt);
        }
    });

    addSendEventNameText.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addSendEventNameTextActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(addSendEventNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(addSendEventButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(delSendEventButton)
            .addGap(18, 18, 18)
            .addComponent(sendEventButton)
            .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(delSendEventButton)
                .addComponent(sendEventButton)
                .addComponent(addSendEventNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(addSendEventButton))
            .addContainerGap(17, Short.MAX_VALUE))
    );

    jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_END);

    jSplitPane4.setLeftComponent(jPanel7);

    manualTextArea.setEditable(false);
    manualTextArea.setBackground(new java.awt.Color(244, 244, 244));
    manualTextArea.setColumns(20);
    manualTextArea.setRows(5);
    jScrollPane2.setViewportView(manualTextArea);

    jSplitPane4.setRightComponent(jScrollPane2);

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSplitPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSplitPane4, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    jTabbedPane2.addTab("manual-send", jPanel6);

    jSplitPane2.setDividerLocation(250);
    jSplitPane2.setMinimumSize(new java.awt.Dimension(250, 25));

    jTextArea2.setColumns(20);
    jTextArea2.setRows(5);
    jScrollPane3.setViewportView(jTextArea2);

    jLabel2.setText("interval: s");

    jButton3.setText("autoSend");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton3)
            .addGap(84, 84, 84))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton3))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, Short.MAX_VALUE)
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jSplitPane2.setLeftComponent(jPanel9);

    autoTextArea.setEditable(false);
    autoTextArea.setBackground(new java.awt.Color(243, 243, 243));
    autoTextArea.setColumns(20);
    autoTextArea.setRows(5);
    jScrollPane5.setViewportView(autoTextArea);

    jSplitPane2.setRightComponent(jScrollPane5);

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
    );
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jTabbedPane2.addTab("auto-send", jPanel8);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane2)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jTabbedPane2)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WSUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WSUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WSUrlActionPerformed

    private void WSHeadersKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WSHeadersKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WSHeadersKeyActionPerformed

    private void WSHeadersValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WSHeadersValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WSHeadersValueActionPerformed

    private void addSendEventNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSendEventNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSendEventNameTextActionPerformed

    private void sendEvnetMessageAreaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_sendEvnetMessageAreaCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sendEvnetMessageAreaCaretPositionChanged

    private void sendEvnetMessageAreaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_sendEvnetMessageAreaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sendEvnetMessageAreaInputMethodTextChanged

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        if(ConnectStatusEnum.connect.equals(ConnectStatusEnum.valueOf(connectButton.getText()))) {
            connect();
        }else if(ConnectStatusEnum.disConnect.equals(ConnectStatusEnum.valueOf(connectButton.getText()))){
            disConnect();
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void addSendEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSendEventButtonActionPerformed
        // TODO add your handling code here:
        String eventName = addSendEventNameText.getText();
        String eventMessage = sendEvnetMessageArea.getText();
        if(StringUtils.isNotEmpty(eventName)){
            manualListModel.addData(eventName, Optional.of(eventMessage).orElse(""));
            updateList();
        }
    }//GEN-LAST:event_addSendEventButtonActionPerformed

    private void delSendEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSendEventButtonActionPerformed
        // TODO add your handling code here:
        String selectEventName = sendEventList.getSelectedValue();
        if(StringUtils.isNotEmpty(selectEventName)){
            manualListModel.removeData(selectEventName);
            updateList();
        }
    }//GEN-LAST:event_delSendEventButtonActionPerformed

    private void sendEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendEventButtonActionPerformed
        // TODO add your handling code here:
        String message = sendEvnetMessageArea.getText();
        if(StringUtils.isNotEmpty(message)) {
            if (webSocketClient.sendMessage(message)) {
                appendRequestManualTextArea(JsonUtil.toPrettyFormat(message));
            }else{
                System.out.println("Message sending error !!!!!!!");
            }
        }
    }//GEN-LAST:event_sendEventButtonActionPerformed

    private void sendEventListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sendEventListValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sendEventListValueChanged

    private void sendEventListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendEventListMouseClicked
        // TODO add your handling code here:
        String value = manualListModel.getData(sendEventList.getSelectedValue());
        if(StringUtils.isNotEmpty(value)){
            sendEvnetMessageArea.setText(JsonUtil.toPrettyFormat(value));
        }
    }//GEN-LAST:event_sendEventListMouseClicked

    public void connect(){
        String url = WSUrl.getText();
        String headerKey = WSHeadersKey.getText();
        String headerValue = WSHeadersValue.getText();
        if (StringUtils.isNotEmpty(url)) {
            HttpHeaders entries = new DefaultHttpHeaders();
            if (StringUtils.isNotEmpty(headerKey) && StringUtils.isNotEmpty(headerValue)) {
                entries.add(headerKey, headerValue);
            }
            try {
                if (webSocketClient.connect(url, entries)) {
                    connectModel.data2File();
                    connectButton.setText(ConnectStatusEnum.disConnect.name());
                    connectButton.updateUI();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void disConnect(){
        if(webSocketClient.disConnect()){
            connectButton.setText(ConnectStatusEnum.connect.name());
            connectButton.updateUI();
        }
    }

    private void updateList(){
        sendEventList.setModel(new AbstractListModel(){
            @Override
            public int getSize() {
                if (manualListModel==null) {
                    return 0;
                }
                return manualListModel.getSize();
            }

            @Override
            public Object getElementAt(int index) {
                return manualListModel.getElementAt(index);
            }
        });
        sendEventList.updateUI();
    }

    public void appendRequestManualTextArea(String str){
        insertRequestDocs(manualTextArea,"\n\nclient-------------->>>>>>>>>-------------server\n");
        insertRequestDocs(manualTextArea,str);
    }
    public void appendResponseManualTextArea(String str){
        insertResponseDocs(manualTextArea,"\n\nclient--------------<<<<<<<<<-------------server\n");
//        manualTextArea.append(str);
        insertResponseDocs(manualTextArea,str);
    }

    public void appendRequestAutoTextArea(String str){
        autoTextArea.append("\n\nclient-------------->>>>>>>>>-------------server\n");
        autoTextArea.append(str);
    }
    public void appendResponseAutoTextArea(String str){
        autoTextArea.append("\n\nclient--------------<<<<<<<<<-------------server\n");
        autoTextArea.append(str);
    }

    private void insertRequestDocs(javax.swing.JTextArea textArea,String str){
        insertDocs(textArea,str,Color.GREEN,false,20);
    }

    private void insertResponseDocs(javax.swing.JTextArea textArea,String str){
        insertDocs(textArea,str,Color.BLUE,false,20);
    }

    private void insertDocs(javax.swing.JTextArea textArea,String str, Color col, boolean bold, int fontSize) {
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attrSet, col);
        //颜色
        if (bold == true) {
            StyleConstants.setBold(attrSet, true);
        }//字体类型
        StyleConstants.setFontSize(attrSet, fontSize);
        //字体大小
//        insert(textArea,str, attrSet);
        Document doc = textArea.getDocument();
        try {
            doc.insertString(doc.getLength(), str, attrSet);
        } catch (BadLocationException e) {
            System.out.println("BadLocationException:   " + e);
        }
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel WSHeaders;
    private javax.swing.JTextField WSHeadersKey;
    private javax.swing.JTextField WSHeadersValue;
    private javax.swing.JTextField WSUrl;
    private javax.swing.JButton addSendEventButton;
    private javax.swing.JTextField addSendEventNameText;
    private javax.swing.JTextArea autoTextArea;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton delSendEventButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextArea manualTextArea;
    private javax.swing.JButton sendEventButton;
    private javax.swing.JList<String> sendEventList;
    private javax.swing.JTextArea sendEvnetMessageArea;
    // End of variables declaration//GEN-END:variables
}
