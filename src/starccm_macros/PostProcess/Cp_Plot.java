// STAR-CCM+ macro: Cp_Plot.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.base.report.*;
import java.io.File;

public class Cp_Plot extends StarMacro {

  public void execute() {
    execute0();
	execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
	  
	String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
    File dir = new File(Path+getSimulation().getPresentationName());
    dir.mkdir();
	  
    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    pressureCoefficientFunction_0.getReferenceDensity().setValue(1.225);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("kph"));

    pressureCoefficientFunction_0.getReferenceVelocity().setUnits(units_0);

    pressureCoefficientFunction_0.getReferenceVelocity().setValue(40.0);

    PlaneSection planeSection_0 = 
      (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[] {}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), new DoubleVector(new double[] {0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[] {0.0}));

    Coordinate coordinate_0 = 
      planeSection_0.getOrientationCoordinate();

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("m"));

    coordinate_0.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[] {0.0, 1.0, 0.0}));

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Default");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Default");

    planeSection_0.getInputParts().setObjects(boundary_0, boundary_1);

    FvRepresentation fvRepresentation_0 = 
      ((FvRepresentation) simulation_0.getRepresentationManager().getObject("Volume Mesh"));

    simulation_0.getDataSourceManager().getPartExtents(new NeoObjectVector(new Object[] {boundary_0, boundary_1}), fvRepresentation_0);

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.1);

    XYPlot xYPlot_0 = 
      simulation_0.getPlotManager().createXYPlot();

    xYPlot_0.refreshAndWait();

    xYPlot_0.getParts().setObjects(planeSection_0);

    AxisType axisType_0 = 
      xYPlot_0.getXAxisType();

    axisType_0.setDirection(new DoubleVector(new double[] {-1.0, 0.0, 0.0}));

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    yAxisType_0.setFieldFunction(pressureCoefficientFunction_0);

    Axes axes_0 = 
      xYPlot_0.getAxes();

    Axis axis_0 = 
      axes_0.getYAxis();

    AxisLabels axisLabels_0 = 
      axis_0.getLabels();

    axisLabels_0.setMinIsDefault(true);

    axisLabels_0.setMaxIsDefault(true);

    InternalDataSet internalDataSet_0 = 
      ((InternalDataSet) yAxisType_0.getDataSets().getDataSet("plane section"));

    internalDataSet_0.setSeriesName("plane section");

    Axis axis_1 = 
      axes_0.getXAxis();

    AxisLabels axisLabels_1 = 
      axis_1.getLabels();

    axisLabels_1.setMin(-0.9);

    axisLabels_1.setMax(-0.3);

    axisLabels_0.setMin(-4.0);

    axisLabels_0.setMax(1.2);

    FileTable fileTable_0 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_FW_Cp_Schnitt1.csv"));

    ExternalDataSet externalDataSet_0 = 
      simulation_0.getDataSetManager().createExternalDataSet(xYPlot_0);

    xYPlot_0.getDataSetGroup().addObjects(externalDataSet_0);

    xYPlot_0.getExternal().add(externalDataSet_0);

    externalDataSet_0.setTable(fileTable_0);

    externalDataSet_0.setXValuesName("Position [-1.0, 0.0, 0.0] -plane section");

    externalDataSet_0.setYValuesName("Pressure Coefficient-plane section");

    externalDataSet_0.setSeriesName("Krei2_ref");

    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_FW1.png"), "png", 1920, 1080);

    singleValue_0.getValueQuantity().setValue(0.4);

    FileTable fileTable_1 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_FW_Cp_Schnitt2.csv"));

    externalDataSet_0.setTable(fileTable_1);
  
    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_FW2.png"), "png", 1920, 1080);
	
    singleValue_0.getValueQuantity().setValue(0.55);

    FileTable fileTable_2 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_FW_Cp_Schnitt3.csv"));

    externalDataSet_0.setTable(fileTable_2);
  
    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_FW3.png"), "png", 1920, 1080);
	}
		
  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();
	  
	String Path = "Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\";
    File dir = new File(Path+getSimulation().getPresentationName());
    dir.mkdir();
	  
    FileTable fileTable_1 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_UB_Cp_Schnitt.csv"));

    FileTable fileTable_2 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_RW_Cp_Schnitt1.csv"));

    FileTable fileTable_3 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2015\\Aero\\PostProcess\\Kreis2_ref_RW_Cp_Schnitt2.csv"));

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("XY Plot 1"));

    xYPlot_0.refreshAndWait();

    PlaneSection planeSection_0 = 
      ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

    SingleValue singleValue_0 = 
      planeSection_0.getSingleValue();

    singleValue_0.getValueQuantity().setValue(0.4);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Default");

    planeSection_0.getInputParts().setObjects(boundary_0);

    ExternalDataSet externalDataSet_0 = 
      ((ExternalDataSet) xYPlot_0.getDataSetGroup().getDataSet("tabular"));

    externalDataSet_0.setTable(fileTable_1);

    Axes axes_0 = 
      xYPlot_0.getAxes();

    Axis axis_0 = 
      axes_0.getXAxis();

    AxisLabels axisLabels_0 = 
      axis_0.getLabels();

    axisLabels_0.setMin(0.2);

    axisLabels_0.setMax(1.3);

    Axis axis_1 = 
      axes_0.getYAxis();

    AxisLabels axisLabels_1 = 
      axis_1.getLabels();

    axisLabels_1.setMin(-1.5);

    axisLabels_1.setMax(0.2);
  
    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_UB.png"), "png", 1920, 1080);

    singleValue_0.getValueQuantity().setValue(0.05);

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Default");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Default");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Default");

    planeSection_0.getInputParts().setObjects(boundary_1, boundary_2, boundary_3);

    externalDataSet_0.setTable(fileTable_2);

    axisLabels_0.setMin(1.3);

    axisLabels_0.setMax(2.0);

    axisLabels_0.setMin(1.3);

    axisLabels_0.setMax(2.0);

    axisLabels_0.setNumSpacingIsDefault(true);

    axisLabels_0.setTickSpacingIsDefault(true);

    axisLabels_0.setPrecisionIsDefault(true);

    axisLabels_1.setMin(-1.5);

    axisLabels_1.setMax(0.2);

    axisLabels_1.setNumSpacingIsDefault(true);

    axisLabels_1.setTickSpacingIsDefault(true);

    axisLabels_1.setPrecisionIsDefault(true);

    axisLabels_1.setMax(0.7);

    axisLabels_1.setMax(0.8);
  
    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_RW1.png"), "png", 1920, 1080);

    singleValue_0.getValueQuantity().setValue(0.3);

    externalDataSet_0.setTable(fileTable_3);

    axisLabels_1.setMin(-2.0);

    axisLabels_1.setMax(1.2);
	
    xYPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\Cp_Plot_RW2.png"), "png", 1920, 1080);
  }
}
