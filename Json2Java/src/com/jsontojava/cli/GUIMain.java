package com.jsontojava.cli;
import com.jsontojava.JsonToJava;
import com.jsontojava.OutputOption;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class GUIMain {

    private JFrame mMainFrame;
    JPanel pnPanel0;
    JLabel lbLabel0;
    JCheckBox mShouldUseWrapperClass;
    JTextArea mJsonString;
    JButton mBtnGenerateSource;
    JTextField mClassName;
    JLabel lbLabel1;
    JLabel lbLabel2;
    JTextField mPackageName;
    JCheckBox mShouldUseArrayInsteadOfList;
    JLabel lbLabel7;
    private JButton mBtnChooseFile;
    private JTextField mFilePath;

    public static void main(String[] args) {
       GUIMain guiMain = new GUIMain();
        guiMain.showUI();
    }

    private void showUI() {
        mMainFrame = new JFrame("Clean Code Generator");
        mMainFrame.setSize(700, 400);

        pnPanel0 = new JPanel();
        pnPanel0.setBorder( BorderFactory.createTitledBorder( "Java-Json Parser" ) );
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout( gbPanel0 );

        lbLabel0 = new JLabel( "JSON String*"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel0, gbcPanel0);
        pnPanel0.add( lbLabel0 );

        mShouldUseWrapperClass = new JCheckBox( "Use Wrapper Class"  );
        gbcPanel0.gridx = 11;
        gbcPanel0.gridy = 24;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(mShouldUseWrapperClass, gbcPanel0);
        pnPanel0.add(mShouldUseWrapperClass);

        mJsonString = new JTextArea(10,10);
        JScrollPane scpTextJsonString = new JScrollPane(mJsonString);
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 10;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 11;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTHWEST;
        gbPanel0.setConstraints(scpTextJsonString, gbcPanel0);
        pnPanel0.add( scpTextJsonString );

        mBtnGenerateSource = new JButton( "Generate Source"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 25;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(mBtnGenerateSource, gbcPanel0);
        pnPanel0.add(mBtnGenerateSource);

        mClassName = new JTextField( );
        gbcPanel0.gridx = 4;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 9;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(mClassName, gbcPanel0);
        pnPanel0.add(mClassName);

        lbLabel1 = new JLabel( "Class name*"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 6;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel1, gbcPanel0);
        pnPanel0.add( lbLabel1 );

        lbLabel2 = new JLabel( "Package Name*"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 7;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(lbLabel2, gbcPanel0);
        pnPanel0.add( lbLabel2 );

        mPackageName = new JTextField( );
        gbcPanel0.gridx = 4;
        gbcPanel0.gridy = 7;
        gbcPanel0.gridwidth = 9;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(mPackageName, gbcPanel0);
        pnPanel0.add(mPackageName);

        mShouldUseArrayInsteadOfList = new JCheckBox( "Use Array instead of List"  );
        gbcPanel0.gridx = 5;
        gbcPanel0.gridy = 24;
        gbcPanel0.gridwidth = 2;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(mShouldUseArrayInsteadOfList, gbcPanel0);
        pnPanel0.add(mShouldUseArrayInsteadOfList);

        mFilePath = new JTextField( );
        gbcPanel0.gridx = 4;
        gbcPanel0.gridy = 22;
        gbcPanel0.gridwidth = 8;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( mFilePath, gbcPanel0 );
        pnPanel0.add( mFilePath );

        lbLabel7 = new JLabel( "Generated Path*"  );
        gbcPanel0.gridx = 3;
        gbcPanel0.gridy = 22;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( lbLabel7, gbcPanel0 );
        pnPanel0.add( lbLabel7 );

        mBtnChooseFile = new JButton( "Choose File"  );
        mBtnChooseFile.addActionListener(new PathListener());
        gbcPanel0.gridx = 12;
        gbcPanel0.gridy = 22;
        gbcPanel0.gridwidth = 1;
        gbcPanel0.gridheight = 1;
        gbcPanel0.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints( mBtnChooseFile, gbcPanel0 );
        pnPanel0.add( mBtnChooseFile );

        mMainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });


        mBtnGenerateSource.setActionCommand("Generate Source");
        mBtnGenerateSource.addActionListener(new ButtonClickListener());

        mMainFrame.add(pnPanel0);
        mMainFrame.setVisible(true);
    }

    private class PathListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (!mFilePath.getText().isEmpty()) {
                chooser.setCurrentDirectory(new File(mFilePath.getText()));
            }
            int option = chooser.showOpenDialog(mMainFrame);
            if (option == JFileChooser.APPROVE_OPTION) {

                mFilePath.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if( command.equals( "Generate Source" ))  {
                if (isSelectionValid()) {
                    JsonToJava jsonToJava = new JsonToJava();
                    jsonToJava.setJson(mJsonString.getText());
                    jsonToJava.setPackage(mPackageName.getText());
                    jsonToJava.setBaseType(mClassName.getText());
                    jsonToJava.addOutputOption(OutputOption.GSON);
                    jsonToJava.setShouldUseWrapperClasses(mShouldUseWrapperClass.isSelected());
                    jsonToJava.setShouldUseArrayInsteadofList(mShouldUseArrayInsteadOfList.isSelected());

                    try {
                        jsonToJava.fetchJson();
                    } catch (JSONException e1) {
                        JOptionPane.showMessageDialog(mMainFrame, "Something Wrong with Json\n" + e1.getMessage() , "Alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    File directory = new File(mFilePath.getText());

                    if (!directory.exists()) {
                        JOptionPane.showMessageDialog(mMainFrame, "Wrong Output Path\nDirectory Doesn't Exists!!", "Alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        jsonToJava.outputClassFile(directory);
                        JOptionPane.showMessageDialog(mMainFrame, "Classes Generated Successfully!!\nPlease Check Your Output Folder" , "Alert", JOptionPane.INFORMATION_MESSAGE);
                        mJsonString.setText("");
                        mClassName.setText("");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(mMainFrame, "Some Mandatory information not provided", "Alert", JOptionPane.ERROR_MESSAGE);
                }


            }
        }

        private boolean isSelectionValid() {
            return isClassNameValid() && isPackageNameValid() && isJsonValid() && isGeneratedPathValid();
        }

        private boolean isClassNameValid() {
            return !mClassName.getText().isEmpty();
        }

        private boolean isPackageNameValid() {
            return !mPackageName.getText().isEmpty();
        }

        private boolean isJsonValid() {
            return !mJsonString.getText().isEmpty();
        }

        private boolean isGeneratedPathValid() {
            return !mFilePath.getText().isEmpty();
        }
    }


}
