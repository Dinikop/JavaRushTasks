package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public void init() {
        initGui();

        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        setVisible(true);
    }

    public void initGui() {
        initEditor();
        initMenuBar();
        pack();
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollHTMLPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollHTMLPane);
        JScrollPane scrollPlainTextPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPlainTextPane);

        tabbedPane.setPreferredSize(new Dimension(500, 500));

        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initMenuBar() {

    }

    public void selectedTabChanged(){

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void exit() {
        controller.exit();
    }
}
