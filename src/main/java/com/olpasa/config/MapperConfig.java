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
                .addMapping(ConductorDto::getCodigoEt, (dest, v) -> dest.setCodigoEt((EmpresaTransporte) v));

        modelMapper.createTypeMap(Conductor.class, ConductorDto.class)
                .addMapping(Conductor::getCodigoEt, (dest, v) -> dest.setCodigoEt((EmpresaTransporte) v));

        return modelMapper;
    }
    @Bean(name = "empresaTransporteMapper")
    public ModelMapper empresaTransporteMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // escritura de datos
        modelMapper.createTypeMap(EmpresaTransporteDto.class, EmpresaTransporte.class)
                .addMapping(EmpresaTransporteDto::getCodigoEt, (dest, v) -> dest.setCodigoEt((Integer) v));

        modelMapper.createTypeMap(EmpresaTransporte.class, EmpresaTransporteDto.class)
                .addMapping(EmpresaTransporte::getCodigoEt, (dest, v) -> dest.setCodigoEt((Integer) v));

        return modelMapper;
    }
}
