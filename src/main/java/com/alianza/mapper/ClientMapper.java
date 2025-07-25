package com.alianza.mapper;

import java.time.LocalDate;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.alianza.dto.ClientDto;
import com.alianza.entity.Client;

@Mapper
public interface ClientMapper {

	ClientMapper INSTANCIA= Mappers.getMapper(ClientMapper.class);
	
	@Mappings({
	    @Mapping(source = "dateAdd", target = "dateAdd"),
	    @Mapping(source = "startDate", target = "startDate"),
	    @Mapping(source = "endDate", target = "endDate"),
	    @Mapping(target = "id", ignore = true)
	})
	Client convertEntity(ClientDto client);
    
	@Mappings({
	    @Mapping(source = "dateAdd", target = "dateAdd"),
	    @Mapping(source = "startDate", target = "startDate"),
	    @Mapping(source = "endDate", target = "endDate"),
	    @Mapping(source = "email", target = "user", qualifiedByName = ("filterUser"))
	})
	ClientDto convertDto(Client client);
	
	
	default LocalDate mapSqlDateToLocalDate(Date date) {
        return date != null ? LocalDate.parse(date.toString()) : null;
    }

    default Date mapLocalDateToSqlDate(LocalDate date) {
        return date != null ? java.sql.Date.valueOf(date) : null;
    }
    
    @Named("filterUser")
    default String filterUser(String correo) {
    	if(correo!=null && correo.contains("@")) {
    		return correo.split("@")[0];
    	}
    	return "";
    }
}
