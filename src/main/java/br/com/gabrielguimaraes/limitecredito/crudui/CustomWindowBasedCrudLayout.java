package br.com.gabrielguimaraes.limitecredito.crudui;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.layout.impl.WindowBasedCrudLayout;

public class CustomWindowBasedCrudLayout extends WindowBasedCrudLayout {

	private static final long serialVersionUID = 3648052131235517224L;
	
	public CustomWindowBasedCrudLayout() {
		super();
        setWindowCaption(CrudOperation.ADD, "Adicionar");
        setWindowCaption(CrudOperation.UPDATE, "Editar");
        setWindowCaption(CrudOperation.DELETE, "Você tem certeza que deseja deletar este item?");
	}

}
