// STAR-CCM+ macro: plane.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class plane extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_13.setTransparencyOverrideMode(1);

    scene_13.setTransparencyOverrideMode(1);

    PlaneSection planeSection_0 =
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_7.setCoordinateSystem(labCoordinateSystem_0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region Radiator");

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("Region");

    planeSection_7.getInputParts().setObjects(region_0, region_1);

    Coordinate coordinate_4 = 
      planeSection_7.getOriginCoordinate();

    coordinate_4.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_4.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    coordinate_4.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_5 = 
      planeSection_7.getOrientationCoordinate();

    coordinate_5.setValue(new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_5.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    coordinate_5.setCoordinateSystem(labCoordinateSystem_0);

    SingleValue singleValue_2 = 
      planeSection_7.getSingleValue();

    singleValue_2.getValueQuantity().setValue(0.0);

    singleValue_2.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_2 = 
      planeSection_7.getRangeMultiValue();

    rangeMultiValue_2.setNValues(2);

    rangeMultiValue_2.getStartQuantity().setValue(0.0);

    rangeMultiValue_2.getStartQuantity().setUnits(units_0);

    rangeMultiValue_2.getEndQuantity().setValue(1.0);

    rangeMultiValue_2.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_2 = 
      planeSection_7.getDeltaMultiValue();

    deltaMultiValue_2.setNValues(2);

    deltaMultiValue_2.getStartQuantity().setValue(0.0);

    deltaMultiValue_2.getStartQuantity().setUnits(units_0);

    deltaMultiValue_2.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_2.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_2 = 
      planeSection_7.getArbitraryMultiValue();

    multiValue_2.getValueQuantities().setUnits(units_0);

    multiValue_2.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_7.setValueMode(0);

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_13.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_3.getVisibleParts().addParts(planeSection_7);

    scene_13.setTransparencyOverrideMode(1);

    scalarDisplayer_3.getInputParts().setQuery(null);

    scalarDisplayer_3.getInputParts().setObjects(planeSection_7);

    CurrentView currentView_8 = 
      scene_13.getCurrentView();

    currentView_8.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {112.94000999002152, 7.5, 7.502499999944121}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 31.81921599051174, 1);

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_13.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.setVisibilityOverrideMode(2);
  }
}
