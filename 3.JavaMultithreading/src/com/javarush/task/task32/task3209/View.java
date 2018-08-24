package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public boolean canRedo() {
        return false;
    }

    public boolean canUndo() {
        return false;
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
        JMenuBar mainMenu = new JMenuBar();
        MenuHelper.initFileMenu(this, mainMenu);
        MenuHelper.initEditMenu(this, mainMenu);
        MenuHelper.initStyleMenu(this, mainMenu);
        MenuHelper.initAlignMenu(this, mainMenu);
        MenuHelper.initColorMenu(this, mainMenu);
        MenuHelper.initFontMenu(this, mainMenu);
        MenuHelper.initHelpMenu(this, mainMenu);

        getContentPane().add(mainMenu, BorderLayout.NORTH);
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
