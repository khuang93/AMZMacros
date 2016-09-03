// STAR-CCM+ macro: TotPressCoeffx.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.base.report.*;
import java.io.File;

public class TotPressCoeffx extends StarMacro {

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

    Scene scene_19 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    scene_19.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_19.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_19.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_19.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();
	
    scalarDisplayer_0.setFillMode(1);

    scene_19.open(true);

    CurrentView currentView_0 = 
      scene_19.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[] {-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.093782750985234, 1);

    TotalPressureCoefficientFunction totalPressureCoefficientFunction_0 = 
      ((TotalPressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressureCoefficient"));

    totalPressureCoefficientFunction_0.getReferenceDensity().setValue(1.225);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("kph"));

    totalPressureCoefficientFunction_0.getReferenceVelocity().setUnits(units_0);

    totalPressureCoefficientFunction_0.getReferenceVelocity().setValue(40.0);

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(totalPressureCoefficientFunction_0);

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

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_19.setTransparencyOverrideMode(1);

    Region region_1 =
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    scene_19.getCreatorGroup().setObjects(region_1, region_0);

    PartDisplayer partDisplayer_2 = 
      scene_19.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

    partDisplayer_2.initialize();
      
    partDisplayer_2.setVisibilityOverrideMode(2);

    scene_19.setTransparencyOverrideMode(1);
      
 
// Ebene wird eingefügt
    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {region_1, region_0}), new DoubleVector(new double[] {1.0, 0.0, 0.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_0 = 
      planeSection_0.getOriginCoordinate();

    coordinate_0.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    Coordinate coordinate_1 = 
      planeSection_0.getOrientationCoordinate();

    coordinate_1.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_1.setValue(new DoubleVector(new double[] {1.0, 0.0, 0.0}));

    coordinate_0.setValue(new DoubleVector(new double[] {0.0, 0.0, 0.0}));

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.0);

    singleValue_0.getValueQuantity().setUnits(units_1);

    RangeMultiValue rangeMultiValue_0 = 
      planeSection_0.getRangeMultiValue();

    rangeMultiValue_0.setNValues(2);

    rangeMultiValue_0.getStartQuantity().setValue(0.0);

    rangeMultiValue_0.getStartQuantity().setUnits(units_1);

    rangeMultiValue_0.getEndQuantity().setValue(1.0);

    rangeMultiValue_0.getEndQuantity().setUnits(units_1);

    DeltaMultiValue deltaMultiValue_0 = 
      planeSection_0.getDeltaMultiValue();

    deltaMultiValue_0.setNValues(2);

    deltaMultiValue_0.getStartQuantity().setValue(0.0);

    deltaMultiValue_0.getStartQuantity().setUnits(units_1);

    deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

    deltaMultiValue_0.getDeltaQuantity().setUnits(units_1);

    MultiValue multiValue_0 = 
      planeSection_0.getArbitraryMultiValue();

    multiValue_0.getValueQuantities().setUnits(units_1);

    multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[] {0.0}));

    planeSection_0.setValueMode(0);

    partDisplayer_2.getParts().addParts(planeSection_0);

    scene_19.setTransparencyOverrideMode(0);

    scalarDisplayer_0.getParts().setObjects(planeSection_0);

   
   scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-0.9, 1.4}));

    partDisplayer_0.setVisibilityOverrideMode(2);

      currentView_0.setInput(new DoubleVector(new double[] {0.7048695285137621, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {-4.202606419819978, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 1.2811082978949793, 1);
 
      /*   //Vektoren einfügen
      UserFieldFunction userFieldFunction_1 =
      simulation_0.getFieldFunctionManager().createFieldFunction();
      
      userFieldFunction_1.getTypeOption().setSelected(FieldFunctionTypeOption.VECTOR);
      
      userFieldFunction_1.setDimensionsVector(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
      
      userFieldFunction_1.setDefinition("[0,$$Velocity[1],$$Velocity[2]]");
  
      Scene scene_19 =
      simulation_0.getSceneManager().getScene("Scalar Scene 1");
  
      VectorDisplayer vectorDisplayer_1 =
      scene_19.getDisplayerManager().createVectorDisplayer("Vector");
      
      vectorDisplayer_1.initialize();
     
      PlaneSection planeSection_0 =
      ((PlaneSection) simulation_0.getPartManager().getObject("plane section_0"));
      
      vectorDisplayer_1.getParts().setObjects(planeSection_0);
      
      vectorDisplayer_1.getVectorDisplayQuantity().setFieldFunction(userFieldFunction_1);
      
      Legend legend_1 =
      vectorDisplayer_1.getLegend();
      
      BlackWhiteLookupTable blackWhiteLookupTable_0 =
      ((BlackWhiteLookupTable) simulation_0.get(LookupTableManager.class).getObject("grayscale"));
      
      legend_1.setLookupTable(blackWhiteLookupTable_0);
      
      GlyphSettings glyphSettings_1 =
      vectorDisplayer_1.getGlyphSettings();
      
      glyphSettings_1.setRelativeToModelLength(0.4);
      
      GeometricGlyphSpacingOption geometricGlyphSpacingOption_1 =
      glyphSettings_1.getGeometricSpacing();
      
     geometricGlyphSpacingOption_1.setOnRatio(5);
      
      geometricGlyphSpacingOption_1.setRandom(true);

  */
		
    double x=1.00;
    for(int i=1; x>-2.06;x=x-0.04){
 
	coordinate_0.setValue(new DoubleVector(new double[] {x, 0.0, 0.0}));
    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+"\\TPC_X"+(i)+"_x="+(840-i*40)+".png"), 1, 4096, 2160);
      i++;
  }
  
    Scene scene_14 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_14}));
	
    PlaneSection planeSection_1 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

    simulation_0.getPartManager().removeObjects(planeSection_0);
  
      
}
}