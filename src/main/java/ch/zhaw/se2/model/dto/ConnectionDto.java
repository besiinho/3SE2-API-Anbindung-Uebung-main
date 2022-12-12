package ch.zhaw.se2.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConnectionDto {
    private String from;
    private String to;
    private Date departure;
    private Date arrival;
}
