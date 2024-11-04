package com.olpasa.config;

import com.olpasa.dto.ConductorDto;
import com.olpasa.dto.EmpresaTransporteDto;
import com.olpasa.model.Conductor;
import com.olpasa.model.EmpresaTransporte;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean(name = "conductorMapper")
    public ModelMapper conductorMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // escritura de datos
        modelMapper.createTypeMap(ConductorDto.class, Conductor.class)
                .addMapping(ConductorDto::getCodigo_et, (dest, v) -> dest.setCodigo_et((EmpresaTransporte) v));

        modelMapper.createTypeMap(Conductor.class, ConductorDto.class)
                .addMapping(Conductor::getCodigo_et, (dest, v) -> dest.setCodigo_et((EmpresaTransporte) v));

        return modelMapper;
    }
    @Bean(name = "empresaTransporteMapper")
    public ModelMapper empresaTransporteMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // escritura de datos
        modelMapper.createTypeMap(EmpresaTransporteDto.class, EmpresaTransporte.class)
                .addMapping(EmpresaTransporteDto::getCodigo_et, (dest, v) -> dest.setCodigo_et((Integer) v));

        modelMapper.createTypeMap(EmpresaTransporte.class, EmpresaTransporteDto.class)
                .addMapping(EmpresaTransporte::getCodigo_et, (dest, v) -> dest.setCodigo_et((Integer) v));

        return modelMapper;
    }
}
