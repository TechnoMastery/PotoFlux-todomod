package your.packagename.tabs.all;

import net.minheur.potoflux.PotoFlux;
import net.minheur.potoflux.screen.tabs.BaseTab;
import net.minheur.potoflux.translations.Translations;
import net.minheur.potoflux.utils.InputWithCheckboxResult;
import your.packagename.TodoMod;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static net.minheur.potoflux.Functions.removeProhibitedChar;

public class TodoTab extends BaseTab {
    private final List<TodoItem> todos = new ArrayList<>();
    private final JPanel listPanel = new JPanel();
    private final Path saveFile = TodoMod.getModDir().resolve("todo.json");

    public TodoTab() {
        super();

        loadTodos();
        refreshList();
    }

    @Override
    protected boolean invokeLater() {
        return true;
    }

    @Override
    protected void setPanel() {
        PANEL.setLayout(new BorderLayout());

        // --- main : title & buttons ---
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        top.setBorder(new EmptyBorder(10, 10, 10, 10));

        // -- title --
        JLabel title = new JLabel(getTitle());
        title.setFont(new Font("Consolas", Font.BOLD, 20));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        top.add(title);
        top.add(Box.createVerticalStrut(10));

        // -- add button --
        JButton addButton = new JButton(Translations.get("tabs.todo.button_add"));
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.addActionListener(e -> addNewTodo());
        top.add(addButton);
        top.add(Box.createVerticalStrut(10));

        // -- remove all button --
        JButton clearButton = new JButton(Translations.get("tabs.todo.button_clear"));
        clearButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        clearButton.addActionListener(e -> clearAll());
        top.add(clearButton);

        PANEL.add(top, BorderLayout.NORTH);

        // --- center : list ---
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // --- task list ---
        JScrollPane scroll = new JScrollPane(listPanel);
        scroll.setBorder(null);

        PANEL.add(scroll, BorderLayout.CENTER);
    }

    @Override
    protected boolean doPreset() {
        return false;
    }

    @Override
    protected String getTitle() {
        return "TODO";
    }

    private void clearAll() {
        todos.clear();
        saveTodos();
        refreshList();
    }

    private void addNewTodo() {
        InputWithCheckboxResult input = InputWithCheckboxResult.showInputWithCheckboxDialog(PANEL, Translations.get("tabs.todo.new.title"), Translations.get("tabs.todo.new.name"), Translations.get("tabs.todo.new.pinned")); // TODO
        String text = input.text;
        boolean pinned = input.pinned;

        if (text == null || text.trim().isEmpty()) {
            showTodoError();
            return;
        }
        text = removeProhibitedChar(text);

        if (!text.trim().isEmpty()) {
            todos.add(0, new net.minheur.potoflux.screen.tabs.all.TodoTab.TodoItem(text.trim(), false, pinned));
            saveTodos();
            refreshList();
        } else showTodoError();
    }

    private void showTodoError() {
        JOptionPane.showMessageDialog(PANEL, Translations.get("tabs.todo.no_empty"));
    }

    private void refreshList() {
        listPanel.removeAll();

        if (todos.isEmpty()) {

        }
    }

    private static class TodoItem {
        String text;
        boolean done;
        boolean pinned;

        public TodoItem(String text, boolean done, boolean pinned) {
            this.text = text;
            this.done = done;
            this.pinned = pinned;
        }
    }
}
