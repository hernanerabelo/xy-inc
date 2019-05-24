package br.com.xyinc.gps.controller;

import br.com.xyinc.gps.model.PointInterest;
import br.com.xyinc.gps.service.PointInterestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/poi")
@SuppressWarnings("unused")
public class PointInterestController {
  private static final Logger LOGGER = LogManager.getLogger(PointInterestController.class);

  @Autowired
  private PointInterestService pointInterestService;

  @GetMapping
  public ResponseEntity findAllPage( Pageable pageable ) {

    Page pois = pointInterestService.findAllWithPage( pageable );
    LOGGER.info("POIs element:" + pois.getTotalElements() );

    return new ResponseEntity<>(pois, HttpStatus.OK);
  }

  @GetMapping( "/all" )
  public ResponseEntity findAll() {

    return new ResponseEntity<>(pointInterestService.findAll(), HttpStatus.OK);
  }

  @GetMapping( "/near" )
  public ResponseEntity findAllPage( @PathParam("x") Long x,
                                     @PathParam("y") Long y,
                                     @PathParam("dist") Long dist ) {

    List pois = pointInterestService.findAllNear( x, y, dist );
    LOGGER.info("POIs size:" + pois.size() );

    return new ResponseEntity<>(pois, HttpStatus.OK);
  }

  @RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity save( @RequestBody PointInterest poi ){

    pointInterestService.save( poi );
    return new ResponseEntity<>( poi , HttpStatus.CREATED);

  }

  @PostMapping( "/populate" )
  public ResponseEntity populate( ) {

    pointInterestService.save( new PointInterest( 27L, 12L, "Lanchonete" ) );
    pointInterestService.save( new PointInterest( 31L, 18L, "Posto" ) );
    pointInterestService.save( new PointInterest( 15L, 12L, "Joalheria" ) );
    pointInterestService.save( new PointInterest( 19L, 21L, "Floricultura" ) );
    pointInterestService.save( new PointInterest( 12L, 8L, "Pub" ) );
    pointInterestService.save( new PointInterest( 23L, 6L, "Supermercado" ) );
    pointInterestService.save( new PointInterest( 28L, 2L, "Churrascaria" ) );

    return new ResponseEntity<>( HttpStatus.OK );
  }
}
