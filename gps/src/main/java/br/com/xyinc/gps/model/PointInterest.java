package br.com.xyinc.gps.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="GPS_POI")
@SuppressWarnings("unused")
public class PointInterest {

  public PointInterest(){}

  public PointInterest( Long x, Long y, String name ){
    this.setX( x );
    this.setY( y );
    this.setName( name );
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column( name = "ID" )
  private Long id;

  @Column( name = "POINT_X", nullable = false )
  private Long x;

  @Column( name = "POINT_Y", nullable = false )
  private Long y;

  @Column( name = "NAME", nullable = false )
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getX() {
    return x;
  }

  public void setX(Long x) {
    this.x = x;
  }

  public Long getY() {
    return y;
  }

  public void setY(Long y) {
    this.y = y;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PointInterest that = (PointInterest) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(x, that.x) &&
        Objects.equals(y, that.y) &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, x, y, name);
  }

  @Override
  public String toString() {
    return "PointInterest{" +
        "id=" + id +
        ", x=" + x +
        ", y=" + y +
        ", name='" + name + '\'' +
        '}';
  }
}
