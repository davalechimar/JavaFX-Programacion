package main.java.co.edu.uniquindio.programacion.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.java.co.edu.uniquindio.programacion.aplicacion.aplicacion;
import main.java.co.edu.uniquindio.programacion.model.Cliente;


public class ControladorClientes {
    private Cliente clienteSeleccionado; // Agrega esta línea
    public static ControladorClientes instanciaClientes;
    @FXML
    private Button bttVolver;

    @FXML
    private RadioButton personaNaturalRadio;

    @FXML
    private RadioButton personaJuridicaRadio;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private TextField identificacionField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker fechaNacimientoPicker;

    @FXML
    private TextField nitField;

    private ToggleGroup tipoClienteGroup;

    @FXML
    private Button botonRegistrar;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private TableColumn<Cliente, String> columnaNombre;

    @FXML
    private TableColumn<Cliente, String> columnaApellidos;

    @FXML
    private TableColumn<Cliente, String> columnaIdentificacion;

    @FXML
    private TableColumn<Cliente, String> columnaDireccion;

    @FXML
    private TableColumn<Cliente, String> columnaTelefono;

    @FXML
    private TableColumn<Cliente, String> columnaEmail;

    @FXML
    private TableColumn<Cliente, String> columnaPersonaNatural;

    @FXML
    private TableColumn<Cliente, String> columnaPersonaJuridica;
    @FXML
    private Button botonEditar;

    @FXML
    private Button botonActualizar;

    @FXML
    private Button botonEliminar;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    private void registrarCliente(ActionEvent event) {
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        String identificacion = identificacionField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();

        // Determinar el tipo de cliente seleccionado
        String personaNatural = personaNaturalRadio.isSelected() ? "Persona Natural" : "";
        String personaJuridica = personaJuridicaRadio.isSelected() ? "Persona Jurídica" : "";

        // Crear el cliente
        Cliente cliente = new Cliente(nombre, apellidos, identificacion, direccion, telefono, email, personaNatural, personaJuridica);

        // Agregar el cliente a la lista
        listaClientes.add(cliente);

        // Limpiar campos
        limpiarCampos();

        // Imprimir la lista de clientes (esto es solo para verificar)
        System.out.println("Clientes registrados:");
        for (Cliente c : listaClientes) {
            System.out.println(c.getNombre() + " " + c.getApellidos());
        }
        // Campos de la tabla
        tablaClientes.setItems(listaClientes);

    }
    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    @FXML
    private void editarCliente(ActionEvent event) {
        clienteSeleccionado = tablaClientes.getSelectionModel().getSelectedItem();
        if (clienteSeleccionado != null) {
            // Lógica para cargar los datos del cliente seleccionado en los campos de edición
            nombreField.setText(clienteSeleccionado.getNombre());
            apellidosField.setText(clienteSeleccionado.getApellidos());
            identificacionField.setText(clienteSeleccionado.getIdentificacion());
            direccionField.setText(clienteSeleccionado.getDireccion());
            telefonoField.setText(clienteSeleccionado.getTelefono());
            emailField.setText(clienteSeleccionado.getEmail());
            // Configurar los valores de los RadioButtons según el tipo de cliente
            personaNaturalRadio.setSelected(clienteSeleccionado.getPersonaNatural().equals("Persona Natural"));
            personaJuridicaRadio.setSelected(clienteSeleccionado.getPersonaJuridica().equals("Persona Jurídica"));
        } else {
            // No se ha seleccionado ningún cliente
            // Aquí puedes mostrar un mensaje de error o realizar alguna acción
        }
    }
    @FXML
    private void actualizarCliente(ActionEvent event) {
        if (clienteSeleccionado != null) {
            // Actualizar los datos del cliente seleccionado con los valores de los campos de edición
            clienteSeleccionado.setNombre(nombreField.getText());
            clienteSeleccionado.setApellido(apellidosField.getText());
            clienteSeleccionado.setIdentificacion(identificacionField.getText());
            clienteSeleccionado.setDireccion(direccionField.getText());
            clienteSeleccionado.setTelefono(telefonoField.getText());
            clienteSeleccionado.setEmail(emailField.getText());
            clienteSeleccionado.setPersonaNatural(personaNaturalRadio.isSelected() ? "Persona Natural" : "");
            clienteSeleccionado.setPersonaJuridica(personaJuridicaRadio.isSelected() ? "Persona Jurídica" : "");
            // Actualizar la tabla
            tablaClientes.refresh();
            // Limpiar campos
            limpiarCampos();
            mostrarMensaje("Actualizar Cliente", "Cliente actualizado exitosamente.");
        } else {
            // No se ha seleccionado ningún cliente
            // Aquí puedes mostrar un mensaje de error o realizar alguna acción
        }
    }

    @FXML
    private void eliminarCliente(ActionEvent event) {
        Cliente clienteAEliminar = tablaClientes.getSelectionModel().getSelectedItem();
        if (clienteAEliminar != null) {
            listaClientes.remove(clienteAEliminar);
            tablaClientes.refresh();
            limpiarCampos();
            mostrarMensaje("Eliminar Cliente", "Cliente eliminado exitosamente.");
        } else {
            // No se ha seleccionado ningún cliente
            // Aquí puedes mostrar un mensaje de error o realizar alguna acción
        }
    }
    @FXML
    private void limpiarCampos() {
        nombreField.clear();
        apellidosField.clear();
        identificacionField.clear();
        direccionField.clear();
        telefonoField.clear();
        emailField.clear();
        fechaNacimientoPicker.setValue(null);
        nitField.clear();
        personaNaturalRadio.setSelected(false);
        personaJuridicaRadio.setSelected(false);
        emailField.setVisible(false);
        fechaNacimientoPicker.setVisible(false);
        nitField.setVisible(false);
    }
    @FXML
    void volver(MouseEvent event) {
        aplicacion.cambiarAPanelOpciones();
    }

    @FXML
    private void initialize() {
        instanciaClientes = this;
        tipoClienteGroup = new ToggleGroup();
        personaNaturalRadio.setToggleGroup(tipoClienteGroup);
        personaJuridicaRadio.setToggleGroup(tipoClienteGroup);

        personaNaturalRadio.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                emailField.setVisible(true);
                fechaNacimientoPicker.setVisible(true);
                nitField.setVisible(false);
            }
        });

        personaJuridicaRadio.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                emailField.setVisible(false);
                fechaNacimientoPicker.setVisible(false);
                nitField.setVisible(true);
            }
        });

        // Configurar las columnas para usar los atributos de Cliente
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnaIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaPersonaNatural.setCellValueFactory(new PropertyValueFactory<>("personaNatural"));
        columnaPersonaJuridica.setCellValueFactory(new PropertyValueFactory<>("personaJuridica"));
    }

}

// ... otros métodos ...
