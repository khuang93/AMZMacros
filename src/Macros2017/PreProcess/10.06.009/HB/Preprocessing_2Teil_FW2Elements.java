// STAR-CCM+ macro: Preprocessing_2Teil_FW2Elements.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.meshing.*;

public class Preprocessing_2Teil_FW2Elements extends StarMacro {

  public void execute() {
    execute0();
	execute1();
	execute2();
	execute3();
	execute4();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_0.getFloor().setValue(1.0E-4);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2);

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 11");

    HighlightDisplayer highlightDisplayer_0 = 
      scene_0.getHighlightDisplayer();

    highlightDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_1.getFloor().setValue(0.005);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    oneGroupContactPreventionSet_1.getBoundaryGroup().setObjects(boundary_3, boundary_4, boundary_5);

    highlightDisplayer_0.getParts().setObjects(boundary_3, boundary_4, boundary_5);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_2 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_2.getFloor().setValue(5.0E-4);

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    oneGroupContactPreventionSet_2.getBoundaryGroup().setObjects(boundary_6, boundary_4);

    highlightDisplayer_0.getParts().setObjects(boundary_6, boundary_4);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_3 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_3.getFloor().setValue(0.001);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    oneGroupContactPreventionSet_3.getBoundaryGroup().setObjects(boundary_7, boundary_8);

    highlightDisplayer_0.getParts().setObjects(boundary_7, boundary_8);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_4 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_4.getFloor().setValue(0.005);

    //Boundary boundary_9 = 
      //region_0.getBoundaryManager().getBoundary("FW_FLap2.Default");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    oneGroupContactPreventionSet_4.getBoundaryGroup().setObjects(/*boundary_9,*/ boundary_10, boundary_11);

    highlightDisplayer_0.getParts().setObjects(/*boundary_9,*/ boundary_10, boundary_11);
	
	
	 OneGroupContactPreventionSet oneGroupContactPreventionSet_5 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_5.getFloor().setValue(0.005);

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    //Boundary boundary_7 = 
      //region_0.getBoundaryManager().getBoundary("Body_MC.Default");

    oneGroupContactPreventionSet_5.getBoundaryGroup().setObjects(boundary_13, boundary_7);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_6 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_6.getFloor().setValue(0.005);

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    oneGroupContactPreventionSet_6.getBoundaryGroup().setObjects(boundary_14, boundary_30);

    highlightDisplayer_0.getParts().setObjects(boundary_14, boundary_30);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setMaximumNumberSteps(2000);

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    //Boundary boundary_13 = 
      //region_0.getBoundaryManager().getBoundary("Body_Driver.Default");

    //Boundary boundary_14 = 
      //region_0.getBoundaryManager().getBoundary("Body_QJ.Default");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface [Interface 1]"));

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 3 [Interface 2]"));

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    //Boundary boundary_30 = 
      //region_0.getBoundaryManager().getBoundary("UB_Diffusor.Default");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    forceReport_0.getParts().setObjects(boundary_12, boundary_13, boundary_7, boundary_14, boundary_15, boundary_8, /*boundary_9,*/ boundary_10, boundary_11, boundary_16, boundary_17, boundary_6, boundary_3, boundary_4, boundary_5, boundary_18, boundary_19, boundary_20, interfaceBoundary_0, boundary_21, boundary_22, interfaceBoundary_1, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_1, boundary_2, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag FW"));

    forceReport_1.getParts().setObjects(boundary_8, /*boundary_9,*/ boundary_10, boundary_11);

    ForceReport forceReport_2 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag RW"));

    forceReport_2.getParts().setObjects(boundary_6, boundary_3, boundary_4, boundary_5);

    ForceReport forceReport_3 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag UB"));

    forceReport_3.getParts().setObjects(boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35);

    ForceReport forceReport_4 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    forceReport_4.getParts().setObjects(boundary_12, boundary_13, boundary_7, boundary_14, boundary_15, boundary_8,/* boundary_9,*/ boundary_10, boundary_11, boundary_16, boundary_17, boundary_6, boundary_3, boundary_4, boundary_5, boundary_18, boundary_19, boundary_20, interfaceBoundary_0, boundary_21, boundary_22, interfaceBoundary_1, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_1, boundary_2, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37);

    ForceReport forceReport_5 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift FW"));

    forceReport_5.getParts().setObjects(boundary_8,/* boundary_9,*/ boundary_10, boundary_11);

    ForceReport forceReport_6 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift RW"));

    forceReport_6.getParts().setObjects(boundary_6, boundary_3, boundary_4, boundary_5);

    ForceReport forceReport_7 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift UB"));

    forceReport_7.getParts().setObjects(boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35);

    MomentReport momentReport_0 = 
      ((MomentReport) simulation_0.getReportManager().getReport("Moment pitch"));

    momentReport_0.getParts().setObjects(boundary_12, boundary_13, boundary_7, boundary_14, boundary_15, boundary_8, /*boundary_9,*/ boundary_10, boundary_11, boundary_16, boundary_17, boundary_6, boundary_3, boundary_4, boundary_5, boundary_18, boundary_19, boundary_20, interfaceBoundary_0, boundary_21, boundary_22, interfaceBoundary_1, boundary_23, boundary_24, boundary_25, boundary_26, boundary_27, boundary_1, boundary_2, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37);

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_0}), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "Drag Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_1}), true, "%1$s Plot");

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

    MonitorPlot monitorPlot_1 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_1}), "Drag FW Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_2}), true, "%1$s Plot");

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

    MonitorPlot monitorPlot_2 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_2}), "Drag RW Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_3}), true, "%1$s Plot");

    ReportMonitor reportMonitor_3 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

    MonitorPlot monitorPlot_3 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_3}), "Drag UB Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_4}), true, "%1$s Plot");

    ReportMonitor reportMonitor_4 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

    MonitorPlot monitorPlot_4 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_4}), "Lift Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_5}), true, "%1$s Plot");

    ReportMonitor reportMonitor_5 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

    MonitorPlot monitorPlot_5 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_5}), "Lift FW Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_6}), true, "%1$s Plot");

    ReportMonitor reportMonitor_6 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

    MonitorPlot monitorPlot_6 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_6}), "Lift RW Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {forceReport_7}), true, "%1$s Plot");

    ReportMonitor reportMonitor_7 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

    MonitorPlot monitorPlot_7 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_7}), "Lift UB Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {momentReport_0}), true, "%1$s Plot");

    ReportMonitor reportMonitor_8 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

    MonitorPlot monitorPlot_8 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_8}), "Moment pitch Monitor Plot");
  }
  
  
   private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MomentReport momentReport_0 = 
      simulation_0.getReportManager().createReport(MomentReport.class);

    momentReport_0.getDirection().setComponents(0.0, -1.0, 0.0);

    momentReport_0.getOrigin().setComponents(-1.86, 0.0, 0.965);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    momentReport_0.getParts().setObjects(boundary_0);

    momentReport_0.setPresentationName("DRS_Moment_P1");

    MomentReport momentReport_1 = 
      simulation_0.getReportManager().createReport(MomentReport.class);

    momentReport_1.getDirection().setComponents(0.0, -1.0, 0.0);

    momentReport_1.getOrigin().setComponents(-1.9, 0.0, 1.0);

    momentReport_1.getParts().setObjects(boundary_0);

    momentReport_1.setPresentationName("DRS_Moment_P2");

    MomentReport momentReport_2 = 
      simulation_0.getReportManager().createReport(MomentReport.class);

    momentReport_2.getDirection().setComponents(0.0, -1.0, 0.0);

    momentReport_2.getOrigin().setComponents(-1.925, 0.0, 1.035);

    momentReport_2.getParts().setObjects(boundary_0);

    momentReport_2.setPresentationName("DRS_Moment_P3");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {momentReport_0}), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P1 Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "DRS_Moment_P1 Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {momentReport_1}), true, "%1$s Plot");

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P2 Monitor"));

    MonitorPlot monitorPlot_1 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_1}), "DRS_Moment_P2 Monitor Plot");

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {momentReport_2}), true, "%1$s Plot");

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P3 Monitor"));

    MonitorPlot monitorPlot_2 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_2}), "DRS_Moment_P3 Monitor Plot");
  } 
  
    private void execute2() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MassFlowReport massFlowReport_0 = 
      simulation_0.getReportManager().createReport(MassFlowReport.class);

    massFlowReport_0.setPresentationName("Massflow_Radiator");

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Radiator.Surface [Interface 1]"));

    massFlowReport_0.getParts().setObjects(interfaceBoundary_0);

    simulation_0.getMonitorManager().createMonitorAndPlot(new NeoObjectVector(new Object[] {massFlowReport_0}), true, "%1$s Plot");

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Massflow_Radiator Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_0}), "Massflow_Radiator Monitor Plot");
  }
  
  private void execute3() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");
      
      

    oneGroupContactPreventionSet_1.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7);

    oneGroupContactPreventionSet_1.getFloor().setValue(0.001);

  }
  
   private void execute4() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_0, boundary_1, boundary_2);

    oneGroupContactPreventionSet_0.getFloor().setValue(0.005);
  }
    

}
