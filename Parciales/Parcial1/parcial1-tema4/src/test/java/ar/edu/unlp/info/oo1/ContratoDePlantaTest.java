package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ContratoDePlantaTest {
    private Empleado juanPerez;
    private ContratoPorHoras contratoPorHorasJuan;
    private ContratoDePlanta contratoDePlantaJuan;
    private Empleado anaGarcia;
    private ContratoPorHoras contratoPorHorasAna;
    private ContratoDePlanta contratoDePlantaAna;

    @BeforeEach
    void setUp() {
        juanPerez = new Empleado("Juan Perez", LocalDate.of(1985, 5, 10), 2, true);
        contratoPorHorasJuan = new ContratoPorHoras(LocalDate.of(2020, 06, 01), 900, 160, LocalDate.of(2023, 01, 31));
        contratoDePlantaJuan = new ContratoDePlanta(LocalDate.of(2023, 02, 01), 120000, 6000, 10000);
        juanPerez.agregarContrato(contratoDePlantaJuan);
        juanPerez.agregarContrato(contratoPorHorasJuan);
        anaGarcia = new Empleado("Ana García", LocalDate.of(1990, 8, 15), 1, false);
        contratoPorHorasAna = new ContratoPorHoras(LocalDate.of(2024, 10, 01), 1100, 150, LocalDate.of(2025, 12, 15));
        contratoDePlantaAna = new ContratoDePlanta(LocalDate.of(2022, 07, 01), 80000, 6000, 8000);
        anaGarcia.agregarContrato(contratoDePlantaAna);
        anaGarcia.agregarContrato(contratoPorHorasAna);
    }
}
