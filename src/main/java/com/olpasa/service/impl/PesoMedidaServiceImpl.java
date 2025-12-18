package com.olpasa.service.impl;

import com.olpasa.dto.PMDto;
import com.olpasa.model.PesoMedida;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPesoMedidaRepo;
import com.olpasa.service.IPesoMedidaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesoMedidaServiceImpl extends CRUDImpl<PesoMedida, Integer> implements IPesoMedidaService {

    private final IPesoMedidaRepo pesoMedidaRepo;

    @Override
    protected IGenericoRepo<PesoMedida, Integer> getRepo() {
        return pesoMedidaRepo;
    }

    @Override
    public List<PMDto> searchByDate(LocalDate date) {
        return pesoMedidaRepo.searchByFecha(date);
    }

    @Override
    public PMDto searchByIdPesoMedida(Integer id_peso_medida) {
        return pesoMedidaRepo.searchById_peso_medida(id_peso_medida);
    }

    @Override
    public byte[] generateReport(Integer id_peso_medida) throws Exception {
        byte[] data = null;

        // Cargar el archivo del reporte
        //File file = new ClassPathResource("/reports/PesoMedida.jasper").getFile();
        InputStream inputStream = new ClassPathResource("/reports/PesoMedida.jasper").getInputStream();

        // Obtener el DTO
        PMDto dto = searchByIdPesoMedida(id_peso_medida);

        // Envolver el DTO en una lista
        List<PMDto> dataList = Collections.singletonList(dto);

        // Llenar el reporte con la lista como fuente de datos
        JasperPrint print = JasperFillManager.fillReport(
                inputStream,
                new HashMap<>(), // Puedes agregar parámetros si tu reporte los necesita
                new JRBeanCollectionDataSource(dataList)
        );

        // Exportar el reporte a PDF (por ejemplo)
        data = JasperExportManager.exportReportToPdf(print);

        return data;
    }

    @Override
    @Transactional
    public int anularById(Integer idPesoMedida) {
        return pesoMedidaRepo.anularById(idPesoMedida);
    }

}
