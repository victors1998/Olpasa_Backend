package com.olpasa.service.impl;

import com.olpasa.dto.SDTO;
import com.olpasa.dto.SolicitudDTO;
import com.olpasa.model.Solicitud;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ISolicitudRepo;
import com.olpasa.service.ISolicitudSevice;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl extends CRUDImpl<Solicitud, Integer> implements ISolicitudSevice {

    private final ISolicitudRepo solicitudRepo;


    @Override
    protected IGenericoRepo<Solicitud, Integer> getRepo() {
        return solicitudRepo;
    }

    @Override
    public List<SDTO> solicitudesPendientes() {
        return solicitudRepo.solicitudesPendientes();
    }

    @Override
    public byte[] generarReporte(List<SolicitudDTO> solicitudes) throws Exception {
        // 1. Cargar el archivo jasper
        InputStream reporteStream = getClass().getResourceAsStream("/reports/report_adelantos.jasper");

        // 2. Crear DataSource con la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(solicitudes);

        // 3. Parámetros adicionales
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("montoTotal", solicitudes.stream()
                .mapToDouble(s -> s.getMontoaprobado().doubleValue())
                .sum());

        // 4. Llenar el reporte
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporteStream, parametros, dataSource);

        // 5. Exportar a PDF
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
