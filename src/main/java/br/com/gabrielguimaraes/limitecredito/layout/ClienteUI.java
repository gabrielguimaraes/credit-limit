package br.com.gabrielguimaraes.limitecredito.layout;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.impl.form.factory.GridLayoutCrudFormFactory;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.themes.ValoTheme;

import br.com.gabrielguimaraes.limitecredito.crudui.CustomGridCrud;
import br.com.gabrielguimaraes.limitecredito.crudui.CustomGridLayoutCrudFormFactory;
import br.com.gabrielguimaraes.limitecredito.model.Cliente;
import br.com.gabrielguimaraes.limitecredito.service.ClienteService;

@SpringUI(path = "/")
public class ClienteUI extends UI {
	private static final long serialVersionUID = 3503441275080739362L;

	private ClienteService clienteService;
	private final static Locale LOCALE = Locale.forLanguageTag("pt-BR");
	
	@Autowired
	public ClienteUI(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@Override
	protected void init(VaadinRequest request) {
		this.setLocale(LOCALE);
		this.getSession().setLocale( LOCALE );

		Label title = new Label("Clientes");
		title.addStyleName(ValoTheme.LABEL_H2);
		
		GridCrud<Cliente> clienteCrud = new CustomGridCrud<>(Cliente.class);
		
		configurarLayout(clienteCrud);
		
		addOperationProperties(clienteCrud);
		updateOperationProperties(clienteCrud);
		deleteOperationProperties(clienteCrud);
		findAllOperationProperties(clienteCrud);
		
		VerticalLayout mainLayout = new VerticalLayout(title, clienteCrud);
		setContent(mainLayout);
	}

	private void configurarLayout(GridCrud<Cliente> clienteCrud) {
		clienteCrud.setLocale(LOCALE);
		clienteCrud.setErrorHandler(e -> Notification.show("Erro ao salvar!", Notification.Type.ERROR_MESSAGE));
		configureFormButtons(clienteCrud);
		configureFormFields(clienteCrud);
		configureGridFields(clienteCrud);
	}

	private void configureFormButtons(GridCrud<Cliente> clienteCrud) {
		GridLayoutCrudFormFactory<Cliente> formFactory = new CustomGridLayoutCrudFormFactory<>(Cliente.class, 1, 1);
		formFactory.setUseBeanValidation(true);
//		formFactory.setButtonCaption(CrudOperation.ADD, "Salvar");
//		formFactory.setButtonCaption(CrudOperation.UPDATE, "Editar");
//		formFactory.setButtonCaption(CrudOperation.DELETE, "Excluir");
//		formFactory.setCancelButtonCaption("Cancelar");
//		formFactory.setValidationErrorMessage("Formulário contem erros. Verifique os dados inseridos.");
		
		clienteCrud.setCrudFormFactory(formFactory);
	}

	private void configureGridFields(GridCrud<Cliente> clienteCrud) {
		clienteCrud.getGrid().setColumns("nome","limiteCredito","risco","endereco", "taxaJuros");
		clienteCrud.getGrid().getColumn("limiteCredito").setCaption("Limite de Crédito");
		clienteCrud.getGrid().getColumn("endereco").setCaption("Endereço");
		clienteCrud.getGrid().getColumn("taxaJuros").setCaption("Taxa de Juros");
		((Grid.Column<Cliente, Double>)clienteCrud.getGrid().getColumn("limiteCredito")).setRenderer(new NumberRenderer("R$%.2f", LOCALE));
		((Grid.Column<Cliente, Double>)clienteCrud.getGrid().getColumn("taxaJuros")).setRenderer(new NumberRenderer("%.2f %%", LOCALE));
	}
	
	private void configureFormFields(GridCrud<Cliente> clienteCrud) {
		clienteCrud.getCrudFormFactory().setVisibleProperties("nome","limiteCredito","risco","endereco");
		clienteCrud.getCrudFormFactory().setFieldCaptions("Nome", "Limite de Crédito R$", "Risco", "Endereço");
	}

	private void addOperationProperties(GridCrud<Cliente> clienteCrud) {
		clienteCrud.setAddOperation(clienteService::save);
//		clienteCrud.getAddButton().setCaption("Adicionar");
//		clienteCrud.getAddButton().setDescription("Adicionar");
	}

	private void updateOperationProperties(GridCrud<Cliente> clienteCrud) {
		clienteCrud.setUpdateOperation(clienteService::save);
//		clienteCrud.getUpdateButton().setCaption("Editar");
//		clienteCrud.getUpdateButton().setDescription("Editar");
	}

	private void deleteOperationProperties(GridCrud<Cliente> clienteCrud) {
		clienteCrud.setDeleteOperation(clienteService::delete);
		clienteCrud.getCrudFormFactory().setVisibleProperties(CrudOperation.DELETE, "nome");
//		clienteCrud.getDeleteButton().setCaption("Excluir");
//		clienteCrud.getDeleteButton().setDescription("Excluir");
	}

	private void findAllOperationProperties(GridCrud<Cliente> clienteCrud) {
		clienteCrud.setFindAllOperation(clienteService::findAll);
	}

}
