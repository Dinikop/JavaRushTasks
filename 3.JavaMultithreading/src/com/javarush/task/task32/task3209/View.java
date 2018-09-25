package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.management.JMException;
import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);


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
        switch (e.getActionCommand()) {
            case "Новый": controller.createNewDocument();
            break;
            case "Открыть": controller.openDocument();
            break;
            case "Сохранить": controller.saveDocument();
            break;
            case "Сохранить как...": controller.saveDocumentAs();
            break;
            case "Выход": controller.exit();
            break;
            case "О программе": showAbout();
        }
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
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
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
        }

        resetUndo();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void exit() {
        controller.exit();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(null, "сообщение", "About the program: ",  JOptionPane.INFORMATION_MESSAGE);
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }
}
