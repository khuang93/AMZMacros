// STAR-CCM+ macro: Velocity_j_neu.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import java.io.File;

public class Velocity_j_neu extends StarMacro {

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

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_2.initializeAndWait();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_2.getCreatorDisplayer());

    partDisplayer_4.initialize();

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_2.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_3.initialize();

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_2.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_1.initialize();

    scene_2.open(true);

    CurrentView currentView_1 = 
      scene_2.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.093782750985234, 1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

    scalarDisplayer_1.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_1);

    partDisplayer_3.setVisibilityOverrideMode(2);

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

    scalarDisplayer_1.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_2.setTransparencyOverrideMode(1);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    scene_2.getCreatorGroup().setObjects(region_1, region_0);

    PartDisplayer partDisplayer_5 = 
      scene_2.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);
      
     partDisplayer_5.setVisibilityOverrideMode(2);

    partDisplayer_5.initialize();

    scene_2.setTransparencyOverrideMode(1);

    PlaneSection planeSection_1 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {region_1, region_0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_2 = 
      planeSection_1.getOriginCoordinate();

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    Coordinate coordinate_3 = 
      planeSection_1.getOrientationCoordinate();

    coordinate_3.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_3.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_2.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

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

    partDisplayer_5.getParts().addParts(planeSection_1);

    scene_2.setTransparencyOverrideMode(0);

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-6.0, 6.0}));

    scalarDisplayer_1.setFillMode(1);

    scalarDisplayer_1.getParts().setObjects(planeSection_1);
	
	currentView_1.setInput(new DoubleVector(new double[] {0.7048695285137621, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {-4.202606419819978, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.2811082978949793, 1);
		
   double x=0.80;
   for(int i=1; x>-2.06;x=x-0.04){
 
	coordinate_2.setValue(new DoubleVector(new double[] {x, 0.0, 0.0}));
   scene_2.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Vj_X"+(i)+"_x="+(840-i*40)+".png"), 1, 1920, 1080);
      i++;
   
   }
   
    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

    simulation_0.getPartManager().removeObjects(planeSection_1);
      
    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_2}));
   
   
  }
}
