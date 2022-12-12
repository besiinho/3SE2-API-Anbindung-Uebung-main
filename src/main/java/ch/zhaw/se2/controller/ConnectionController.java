package ch.zhaw.se2.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.se2.model.connection.Connection;
import ch.zhaw.se2.model.connection.Root;
import ch.zhaw.se2.model.dto.ConnectionDto;
import ch.zhaw.se2.service.ConnectionService;

@RestController
@RequestMapping("/api/v1")
public class ConnectionController {

    @Autowired
    ConnectionService connectionService;

    @GetMapping("connection")
    public ResponseEntity<List<ConnectionDto>> connection(@RequestParam List<String> from,
            @RequestParam List<String> to) {
       
                //variablen abfüllen
        int a = 0;
        int b = from.size();
        //schleife einsetzen
        if (a < b) {
            List<ConnectionDto> connectionsDTO = new ArrayList<>();
            Root connections = connectionService.getConnection(from.get(a), to.get(a));

                   for (Connection connection : connections.connections) {
                ConnectionDto dto = new ConnectionDto(connection.from.station.name,
                        connection.myto.station.name,
                        connection.from.departure,
                        connection.myto.arrival);
             
                        //dto zu connections einfügen
                        connectionsDTO.add(dto);
               

            }
            

            ++a;
        }
        connectionsDTO.sort(Comparator.comparing(o -> o.getDeparture()));
        return new ResponseEntity<>(connectionsDTO, HttpStatus.OK);

    }
}