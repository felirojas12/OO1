package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
    private ClienteDeCorreo cliente;

    @BeforeEach
    void setUp() {
        cliente = new ClienteDeCorreo();
    }

    @Test
    void buscarEncuentraUnEmailPorSuTituloEnInbox() {
        Email email = new Email("Reunión del lunes", "Confirmar horario");
        cliente.recibir(email);

        assertSame(email, cliente.buscar("lunes"));
    }

    @Test
    void buscarEncuentraUnEmailPorSuCuerpoEnInbox() {
        Email email = new Email("Aviso", "La reunión será virtual");
        cliente.recibir(email);

        assertSame(email, cliente.buscar("virtual"));
    }

    @Test
    void buscarRecorreLasCarpetasCuandoNoEncuentraEnInbox() {
        Carpeta carpeta = new Carpeta();
        Email email = new Email("Factura", "Vence el viernes");
        carpeta.agregar(email);
        cliente.agregarCarpeta(carpeta);

        assertSame(email, cliente.buscar("viernes"));
    }

    @Test
    void buscarDevuelveElPrimerEmailQueCoincide() {
        Email primero = new Email("Proyecto", "Primera propuesta");
        Email segundo = new Email("Proyecto actualizado", "Segunda propuesta");
        cliente.recibir(primero);
        cliente.recibir(segundo);

        assertSame(primero, cliente.buscar("Proyecto"));
    }

    @Test
    void buscarDevuelveElPrimerEmailDeLaPrimeraCarpetaQueCoincide() {
        Carpeta primeraCarpeta = new Carpeta();
        Carpeta segundaCarpeta = new Carpeta();
        Email primero = new Email("Informe", "Datos del mes");
        Email segundo = new Email("Informe", "Datos del año");
        primeraCarpeta.agregar(primero);
        segundaCarpeta.agregar(segundo);
        cliente.agregarCarpeta(primeraCarpeta);
        cliente.agregarCarpeta(segundaCarpeta);

        assertSame(primero, cliente.buscar("Informe"));
    }

    @Test
    void buscarDevuelveNullCuandoNoHayCoincidencias() {
        cliente.recibir(new Email("Saludo", "¿Cómo estás?"));
        Carpeta carpeta = new Carpeta();
        carpeta.agregar(new Email("Recordatorio", "Llamar mañana"));
        cliente.agregarCarpeta(carpeta);

        assertNull(cliente.buscar("inexistente"));
    }

    @Test
    void buscarDevuelveNullEnUnClienteSinEmails() {
        assertNull(cliente.buscar("cualquier texto"));
    }
}
