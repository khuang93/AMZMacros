// STAR-CCM+ macro: Streamlines.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import java.io.File;

public class Streamlines extends StarMacro {

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

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.093782750985234, 0);

    partDisplayer_0.setVisibilityOverrideMode(2);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Default");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Default");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Default");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Default");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Default");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Default");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Default");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Default");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Default");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Default");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Default");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Default");

    scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_0.setTransparencyOverrideMode(1);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    scene_0.getCreatorGroup().setObjects(region_1, region_0);

    StreamDisplayer streamDisplayer_0 = 
      scene_0.getDisplayerManager().createStreamDisplayer("Streamline Stream");

    streamDisplayer_0.initialize();

    scene_0.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

    StreamPart streamPart_0 = 
      simulation_0.getPartManager().createStreamPart(new NeoObjectVector(new Object[] {region_1, region_0}), new DoubleVector(new double[] {-1.37, 0.26, 0.75}), primitiveFieldFunction_0, 0.15, 100, 2);

    PointSeed pointSeed_0 = 
      streamPart_0.getPointSeed();

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    pointSeed_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      pointSeed_0.getCenterCoordinate();

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.37, 0.26, 0.75}));

    coordinate_0.setValue(new DoubleVector(new double[] {-1.37, 0.26, 0.75}));

    pointSeed_0.getRadius().setUnits(units_0);

    pointSeed_0.getRadius().setValue(0.15);

    streamDisplayer_0.getParts().addParts(streamPart_0);

    scene_0.setTransparencyOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.093782750985234, 0);

    VectorMagnitudeFieldFunction vectorMagnitudeFieldFunction_0 = 
      ((VectorMagnitudeFieldFunction) primitiveFieldFunction_0.getMagnitudeFunction());

    streamDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorMagnitudeFieldFunction_0);

    streamDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 18.02594843542887}));
 
    streamDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 20.0}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.8688665808016511, 0.9229932768406732, 0.35152501298741234}), new DoubleVector(new double[] {0.2626726680833447, -3.3714628633799513, 0.9602892172796282}), new DoubleVector(new double[] {-8.533134142746368E-4, 0.14013220900396853, 0.9901324334935632}), 1.1701825196656899, 0);

    scene_0.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Streamline_RW.png"), 1, 1920, 1080);

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.22, 0.3, 0.1}));

    pointSeed_0.getRadius().setValue(0.2);

    currentView_0.setInput(new DoubleVector(new double[] {-0.7962798427629675, 0.5071062103036976, 0.12081682818136966}), new DoubleVector(new double[] {0.8801475726879283, 3.708944845712928, 2.087204371875961}), new DoubleVector(new double[] {-0.42703872439350943, -0.30023394213234467, 0.8529346445420284}), 1.0740920810422974, 0);
	
	scene_0.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Streamline_UB.png"), 1, 1920, 1080);
	
	
    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.885, 0.485, 0.02}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.36765565546280704, 0.312989561793691, 0.2739992526462106}), new DoubleVector(new double[] {3.379174338420045, 3.342012354344376, -0.3898869765840446}), new DoubleVector(new double[] {-0.004900732944725414, 0.21987100323420172, 0.9755166450416879}), 1.2696504599422824, 0);

    scene_0.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Streamline_FW_aussen.png"), 1, 1920, 1080);
	
    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.885, 0.17, 0.045}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.1720617013625512, 0.41118978352798047, 0.2984320488271663}), new DoubleVector(new double[] {5.364650715463079, 1.5622508755981743, 1.9290194587987142}), new DoubleVector(new double[] {-0.2973787064556225, 0.08303684137202036, 0.951141833756532}), 1.5364200622878834, 0);
    
	scene_0.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\Streamline_FW_innen.png"), 1, 1920, 1080);
	
    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_15}));

    StreamPart streamPart_1 = 
      ((StreamPart) simulation_0.getPartManager().getObject("streamline"));

    simulation_0.getPartManager().removeObjects(streamPart_0);
  }
}
