package controller;
import estructurasDatos.listas.DoubleLinkedList;
import model.MotivoCita.Control;
import model.MotivoCita.Examen;
import model.MotivoCita.Valoracion;
import model.citas.Cita;
/*import model.Especialidad.Especialidad;
import model.MotivoCita;*/
import model.Paciente;
import model.citas.CitaControl;
import model.citas.CitaExamen;
import model.citas.CitaValoracion;

public class CitasController {
    private DoubleLinkedList<Cita> listaCitas;
    public DoubleLinkedList<Paciente> listaPacientes;
    public DoubleLinkedList<Paciente> listaExamenes;

    // Constructor
    public CitasController() {
        this.listaCitas = new DoubleLinkedList<>();
        this.listaPacientes = new DoubleLinkedList<>();
        this.listaExamenes = new DoubleLinkedList<>();
    }
    public void agendarCitaControl(String idPaciente, boolean pagado, boolean tomado, Control motivoCitaControl) {

        // Ubica el paciente en la listaPacientes por si id,  para evitar agregar todos los datos del paciente
        Paciente pacienteTemp =  listaPacientes.buscarPacientePorId(idPaciente);
        // Verificar si el paciente ya está registrado
        int indicePaciente = listaPacientes.buscarElemento(pacienteTemp);
        if (indicePaciente == -1) { // El paciente no está registrado, se agrega a la lista de pacientes
            listaPacientes.agregarAlFinal(pacienteTemp);
        }

        // Crear la cita para el paciente y asociarla al paciente
        Cita cita = new CitaControl(idPaciente, false, false, motivoCitaControl);
        listaCitas.agregarAlFinal(cita);

        // Agregar la cita al historial de citas del paciente
        pacienteTemp.agregarCitaAlHistorial(cita);
    }

    public void agendarCitaValoracion(String idPaciente, boolean pagado, boolean tomado, Valoracion motivoCitaValoracion) {

        // Ubica el paciente en la listaPacientes por si id,  para evitar agregar todos los datos del paciente
        Paciente pacienteTemp =  listaPacientes.buscarPacientePorId(idPaciente);
        // Verificar si el paciente ya está registrado
        int indicePaciente = listaPacientes.buscarElemento(pacienteTemp);
        if (indicePaciente == -1) { // El paciente no está registrado, se agrega a la lista de pacientes
            listaPacientes.agregarAlFinal(pacienteTemp);
        }

        // Crear la cita para el paciente y asociarla al paciente
        Cita cita = new CitaValoracion(idPaciente, false, false, motivoCitaValoracion);
        listaCitas.agregarAlFinal(cita);

        // Agregar la cita al historial de citas del paciente
        pacienteTemp.agregarCitaAlHistorial(cita);
    }

    public void agendarCitaExamen(String idPaciente, boolean pagado, boolean tomado, Examen motivoCitaExamen) {

        // Ubica el paciente en la listaPacientes por si id,  para evitar agregar todos los datos del paciente
        Paciente pacienteTemp =  listaPacientes.buscarPacientePorId(idPaciente);
        // Verificar si el paciente ya está registrado
        int indicePaciente = listaPacientes.buscarElemento(pacienteTemp);
        if (indicePaciente == -1) { // El paciente no está registrado, se agrega a la lista de pacientes
            listaPacientes.agregarAlFinal(pacienteTemp);
        }

        // Crear la cita para el paciente y asociarla al paciente
        Cita cita = new CitaExamen(idPaciente, false, false, motivoCitaExamen);
        listaCitas.agregarAlFinal(cita);

        // Agregar la cita al historial de citas del paciente
        pacienteTemp.agregarCitaAlHistorial(cita);
    }


//metodo para validar si el tipo de cita es  Control y cambiar el boolean de pagado a true
}
