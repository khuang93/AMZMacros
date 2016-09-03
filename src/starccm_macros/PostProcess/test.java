// STAR-CCM+ macro: test.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class test extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_4.setTransparencyOverrideMode(1);

    scene_4.setTransparencyOverrideMode(1);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region Radiator");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Region");

    planeSection_1.getInputParts().setObjects(region_0, region_1);

    Coordinate coordinate_2 = 
      planeSection_1.getOriginCoordinate();

    coordinate_2.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_2.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_3 = 
      planeSection_1.getOrientationCoordinate();

    coordinate_3.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_3.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_1 = 
      planeSection_1.getSingleValue();

    singleValue_1.getValueQuantity().setValue(0.0);

    singleValue_1.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_1 = 
      planeSection_1.getRangeMultiValue();

    rangeMultiValue_1.setNValues(2);

    rangeMultiValue_1.getStartQuantity().setValue(0.0);

    rangeMultiValue_1.getStartQuantity().setUnits(units_0);

    rangeMultiValue_1.getEndQuantity().setValue(1.0);

    rangeMultiValue_1.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_1 = 
      planeSection_1.getDeltaMultiValue();

    deltaMultiValue_1.setNValues(2);

    deltaMultiValue_1.getStartQuantity().setValue(0.0);

    deltaMultiValue_1.getStartQuantity().setUnits(units_0);

    deltaMultiValue_1.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_1.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_1 = 
      planeSection_1.getArbitraryMultiValue();

    multiValue_1.getValueQuantities().setUnits(units_0);

    multiValue_1.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_1.setValueMode(0);

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_4.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_2.getVisibleParts().addParts(planeSection_1);

    scene_4.setTransparencyOverrideMode(0);
  }
}
