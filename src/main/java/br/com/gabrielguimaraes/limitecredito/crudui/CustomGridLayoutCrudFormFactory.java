package br.com.gabrielguimaraes.limitecredito.crudui;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.form.impl.form.factory.GridLayoutCrudFormFactory;

public class CustomGridLayoutCrudFormFactory<T> extends GridLayoutCrudFormFactory<T> {
	private static final long serialVersionUID = 4877779778164856663L;

	public CustomGridLayoutCrudFormFactory(Class<T> domainType, int columns, int rows) {
		super(domainType, columns, rows);
		cancelButtonCaption = "Cancelar";
	    validationErrorMessage = "Formulário contem erros. Por favor, corrija os erros e tente novamente";
	    
	    setButtonCaption(CrudOperation.READ, "Ok");
        setButtonCaption(CrudOperation.ADD, "Adicionar");
        setButtonCaption(CrudOperation.UPDATE, "Editar");
        setButtonCaption(CrudOperation.DELETE, "Sim, deletar");
	}
}
