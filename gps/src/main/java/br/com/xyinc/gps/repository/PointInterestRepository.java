package br.com.xyinc.gps.repository;

import br.com.xyinc.gps.model.PointInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointInterestRepository extends JpaRepository<PointInterest, Long> {

  @Query( nativeQuery = true, value = "select * from GPS_POI p " +
      "where ?1 >= sqrt( ( (p.point_x -?2) * (p.point_x -?2) ) + ( (p.point_y -?3) * (p.point_y -?3) ) )  " )
  List<PointInterest> findAllNearUsingQuery( Long dist, Long x, Long y );
}
