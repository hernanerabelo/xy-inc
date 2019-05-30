package br.com.xyinc.gps.service;

import br.com.xyinc.gps.Boot;
import br.com.xyinc.gps.model.PointInterest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Boot.class})
public class PointInterestServiceTest {

  private static final Logger LOGGER = LogManager.getLogger(PointInterestServiceTest.class);


  @Autowired
  PointInterestService pointInterestService;

  @Test
  public void validSavePoints(){
    Assert.assertTrue( "Quantidade inválida de POIs, validar insert in schema.sql", pointInterestService.findAll().size() == 7 );

    pointInterestService.save( new PointInterest( 270L, 121L, "local1" ) );

    Assert.assertTrue( "Quantidade inválida de POIs, não foi inserido os POIs", pointInterestService.findAll().size() == 8 );

  }

  @Test
  public void findNearPois(){


    List<PointInterest> pointInteres = pointInterestService.findAllNear(20L, 10L, 10L );

    pointInteres.forEach(LOGGER::info);

    Assert.assertTrue( "Não foi encontrado a Lanchonete",
        pointInteres.stream().anyMatch( p -> "Lanchonete".equalsIgnoreCase( p.getName() ) ) );
  }

  @Test
  public void findNearPoisWithSql(){


    List<PointInterest> pointInteres = pointInterestService.findAllNearUsingQuery(20L, 10L, 10L );

    pointInteres.forEach(LOGGER::info);

    Assert.assertTrue( "Não foi encontrado a Lanchonete",
        pointInteres.stream().anyMatch( p -> "Lanchonete".equalsIgnoreCase( p.getName() ) ) );
  }



  @Test
  public void testTimeUsingSql(){

    for( long i  = 100; i < 50000; i++ ){
      pointInterestService.save(new PointInterest( i, i, "local" + i ));
    }

    long init = new Date().getTime();
    List<PointInterest> pointInteres = pointInterestService.findAllNear(20L, 10L, 10L );
    LOGGER.info("Calc in java " + ( new Date().getTime() - init ) + "ms" );

    init = new Date().getTime();
    pointInteres = pointInterestService.findAllNearUsingQuery(20L, 10L, 10L );
    LOGGER.info("Calc in sql " + ( new Date().getTime() - init ) + "ms" );
  }







}
