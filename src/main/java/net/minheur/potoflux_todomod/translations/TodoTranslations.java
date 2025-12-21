package net.minheur.potoflux_todomod.translations;

import net.minheur.potoflux.translations.AbstractTranslationsRegistry;
import net.minheur.potoflux_todomod.TodoMod;

public class TodoTranslations extends AbstractTranslationsRegistry {
    public TodoTranslations() {
        super(TodoMod.MOD_ID);
    }

    @Override
    protected void makeTranslation() {
        addTodoTab("name")
                .en("TODO")
                .fr("Taches");
        addTodoTab("button", "add")
                .en("Add a todo")
                .fr("Ajouter une tache");
        addTodoTab("button", "clear")
                .en("Clear all todos")
                .fr("Supprimer toutes les taches");
        addTodoTab("new", "name")
                .en("New task: ")
                .fr("Nouvelle tache : ");
        addTodoTab("new", "pinned")
                .en("Pin the todo")
                .fr("Épingler la tache");
        addTodoTab("empty")
                .en("Todo can't be empty.")
                .fr("La tache ne peut pas être vide.");
        addTodoTab("empty_list")
                .en("The list is empty !")
                .fr("La liste est vide !");
        addTodoTab("edit")
                .en("Edit task")
                .fr("Modifier la tache");
        addTodoTab("done")
                .en("Set as done")
                .fr("Marquer faite");
        addTodoTab("new_name")
                .en("New name: ")
                .fr("Nouveau nom : ");
        addTodoTab("delete", "confirm")
                .en("Tod you want to delete this task ?")
                .fr("Voulez-vous vraiment supprimer cette tache ?");
        addTodoTab("delete", "title")
                .en("Delete task")
                .fr("Supprier la tache");
    }

    // tabs helper
    private TranslationBuilder addTodoTab(String... children) {
        return addTab("todo", children);
    }
}
