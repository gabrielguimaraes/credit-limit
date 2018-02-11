package br.com.gabrielguimaraes.limitecredito.crudui;

import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.form.factory.VerticalCrudFormFactory;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;

public class CustomGridCrud<T> extends GridCrud<T> {

	public CustomGridCrud(Class<T> domainType) {
		super(domainType, new CustomWindowBasedCrudLayout(), new VerticalCrudFormFactory<>(domainType), null);
	    this.rowCountCaption = "%d item(s) encontrados";
	    this.savedMessage = "Item salvo";
	    this.deletedMessage = "Item deletado";
	}

	private static final long serialVersionUID = -120105242058798162L;
	
	
	@Override
	protected void initLayout() {
		findAllButton = new Button("", e -> findAllButtonClicked());
        findAllButton.setDescription("Atualizar lista");
        findAllButton.setIcon(VaadinIcons.REFRESH);
        crudLayout.addToolbarComponent(findAllButton);

        addButton = new Button("", e -> addButtonClicked());
        addButton.setDescription("Adicionar");
        addButton.setIcon(VaadinIcons.PLUS);
        crudLayout.addToolbarComponent(addButton);

        updateButton = new Button("", e -> updateButtonClicked());
        updateButton.setDescription("Editar");
        updateButton.setIcon(VaadinIcons.PENCIL);
        crudLayout.addToolbarComponent(updateButton);

        deleteButton = new Button("", e -> deleteButtonClicked());
        deleteButton.setDescription("Deletar");
        deleteButton.setIcon(VaadinIcons.TRASH);
        crudLayout.addToolbarComponent(deleteButton);

        grid = new Grid<>(domainType);
        grid.setSizeFull();
        grid.addSelectionListener(e -> gridSelectionChanged());
        crudLayout.setMainComponent(grid);

        updateButtons();
    }
}
