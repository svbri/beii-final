package com.dh.catalogservice.domain.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieWS {
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
