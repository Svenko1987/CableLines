package application;

import data.Cable;
import data.Line;

import java.util.Collection;

public interface Controller {

  int sumSameFloor(Collection<Line> lines,int floor);

  void addToCables(Collection <Cable> cables, Cable newCable);


}
