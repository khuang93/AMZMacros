// STAR-CCM+ macro: Velocity_i_neu.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import java.io.File;

public class Velocity_i_neu extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
	  
	String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
    File dir = new File(Path+getSimulation().getPresentationName());
    dir.mkdir();  

    simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_1.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_1.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();

    scene_1.open(true);

    CurrentView currentView_0 = 
      scene_1.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.093782750985234, 1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    partDisplayer_0.setVisibilityOverrideMode(2);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Inlet");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Outlet");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

    scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_1.setTransparencyOverrideMode(1);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    scene_1.getCreatorGroup().setObjects(region_1, region_0);

    PartDisplayer partDisplayer_2 = 
      scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);
      
     partDisplayer_2.setVisibilityOverrideMode(2);  

    partDisplayer_2.initialize();

    scene_1.setTransparencyOverrideMode(1);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {region_1, region_0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_0);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_0);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_0);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_0);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

    MultiValue multiValue_0 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_0);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);

    partDisplayer_2.getParts().addParts(planeSection_0);

    scene_1.setTransparencyOverrideMode(0);

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-20.0, 5.0}));

    scalarDisplayer_0.getParts().setObjects(planeSection_0);

    scalarDisplayer_0.setFillMode(1);
   
   currentView_0.setInput(new DoubleVector(new double[] {0.7048695285137621, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {-4.202606419819978, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.2811082978949793, 1);
		
   double x=0.80;
   for(int i=1; x>-2.06;x=x-0.04){
 
	coordinate_0.setValue(new DoubleVector(new double[] {x, 0.0, 0.0}));
   scene_1.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Vi_X"+(i)+"_x="+(840-i*40)+".png"), 1, 1920, 1080);
      i++;
   
   }
   
	Scene scene_16 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_16}));

    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

    simulation_0.getPartManager().removeObjects(planeSection_1);
  }
}
