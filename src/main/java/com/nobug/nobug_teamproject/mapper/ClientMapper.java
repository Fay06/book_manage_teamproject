package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientMapper {
    Client searchClient(String clientName);
}
