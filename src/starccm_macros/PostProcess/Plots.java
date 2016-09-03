// STAR-CCM+ macro: Plots.java
// Written by STAR-CCM+ 8.06.005
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

import star.base.report.*;

import java.io.File;
import star.flow.*;public class Plots extends StarMacro {

  public void execute() {
    execute0();
  
  }

private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

          String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
    File dir = new File(Path+getSimulation().getPresentationName());
    dir.mkdir();
	

   ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DragFW.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_0}));

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\Drag.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_1}));

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DragRW.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_2}));

    ReportMonitor reportMonitor_3 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DragUB.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_3}));

    ReportMonitor reportMonitor_4 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\LiftFW.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_4}));

    ReportMonitor reportMonitor_5 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\Lift.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_5}));

    ReportMonitor reportMonitor_6 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\LiftRW.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_6}));
    
    ReportMonitor reportMonitor_10 =
    ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 35 Monitor"));
    
    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\LiftFC.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_10}));

    ReportMonitor reportMonitor_7 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

    MonitorPlot monitorPlot_0 = 
      simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[] {reportMonitor_7}), "Lift UB Monitor Plot");

    monitorPlot_0.open();

    simulation_0.getPlotManager().deletePlots(new NeoObjectVector(new Object[] {monitorPlot_0}));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\LiftUB.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_7}));

    ReportMonitor reportMonitor_8 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\MomentPitch.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_8}));
/*
	  ReportMonitor reportMonitor_9 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P1 Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DRS_Moment_P1.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_9}));

    ReportMonitor reportMonitor_10 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P2 Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DRS_Moment_P2.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_10}));

    ReportMonitor reportMonitor_11 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("DRS_Moment_P3 Monitor"));

    simulation_0.getMonitorManager().export(resolvePath(Path+getSimulation().getPresentationName()+"\\DRS_Moment_P3.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_11}));
	*/
    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot"));
    
    Axes axes_1 =
    monitorPlot_1.getAxes();
    
    Axis axis_1 =
    axes_1.getYAxis();
    
    AxisLabels axisLabels_1 =
    axis_1.getLabels();
    
    axisLabels_1.setMin(-10.0);
    
    axisLabels_1.setMax(0.0);

    monitorPlot_1.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Drag FW Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot"));
    
    Axes axes_2 =
    monitorPlot_2.getAxes();
    
    Axis axis_2 =
    axes_2.getYAxis();
    
    AxisLabels axisLabels_2 =
    axis_2.getLabels();
    
    axisLabels_2.setMin(-60.0);
    
    axisLabels_2.setMax(-50.0);

    monitorPlot_2.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Drag Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot"));
    
    Axes axes_3 =
    monitorPlot_3.getAxes();
    
    Axis axis_3 =
    axes_3.getYAxis();
    
    AxisLabels axisLabels_3 =
    axis_3.getLabels();
    
    axisLabels_3.setMin(-30.0);
    
    axisLabels_3.setMax(-10.0);

    monitorPlot_3.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Drag RW Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_4 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot"));
    
    Axes axes_4 =
    monitorPlot_4.getAxes();
    
    Axis axis_4 =
    axes_4.getYAxis();
    
    AxisLabels axisLabels_4 =
    axis_4.getLabels();
    
    axisLabels_4.setMin(-10.0);
    
    axisLabels_4.setMax(0.0);

    monitorPlot_4.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Drag UB Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_5 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift FW Monitor Plot"));
    
    Axes axes_5 =
    monitorPlot_5.getAxes();
    
    Axis axis_5 =
    axes_5.getYAxis();
    
    AxisLabels axisLabels_5 =
    axis_5.getLabels();
    
    axisLabels_5.setMin(-50.0);
    
    axisLabels_5.setMax(-30.0);

    monitorPlot_5.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Lift FW Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_6 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift Monitor Plot"));


	  //Verstellen der Axen
    Axes axes_6 = 
      monitorPlot_6.getAxes();

    Axis axis_6 = 
      axes_6.getYAxis();

    AxisLabels axisLabels_6 = 
      axis_6.getLabels();

    axisLabels_6.setMin(-130.0);

    axisLabels_6.setMax(-100.0);
	  	  
    monitorPlot_6.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Lift Monitor Plot.png"), "png", 1089, 500);


    MonitorPlot monitorPlot_7 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift RW Monitor Plot"));
    
    Axes axes_7 =
    monitorPlot_7.getAxes();
    
    Axis axis_7 =
    axes_7.getYAxis();
    
    AxisLabels axisLabels_7 =
    axis_7.getLabels();
    
    axisLabels_7.setMin(-60.0);
    
    axisLabels_7.setMax(-40.0);

    monitorPlot_7.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Lift RW Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_8 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift UB Monitor Plot"));
    
    Axes axes_8 =
    monitorPlot_8.getAxes();
    
    Axis axis_8 =
    axes_8.getYAxis();
    
    AxisLabels axisLabels_8 =
    axis_8.getLabels();
    
    axisLabels_8.setMin(-60.0);
    
    axisLabels_8.setMax(-40.0);

    monitorPlot_8.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Lift UB Monitor Plot.png"), "png", 1089, 500);

    MonitorPlot monitorPlot_9 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moment pitch Monitor Plot"));
    
    Axes axes_9 =
    monitorPlot_9.getAxes();
    
    Axis axis_9 =
    axes_9.getYAxis();
    
    AxisLabels axisLabels_9 =
    axis_9.getLabels();
    
    axisLabels_9.setMin(-120.0);
    
    axisLabels_9.setMax(-80.0);

    monitorPlot_9.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Moment pitch Monitor Plot.png"), "png", 1089, 500);

    ResidualPlot residualPlot_0 = 
      ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));
    
    Axes axes_0 =
    residualPlot_0.getAxes();
    
    Axis axis_0 =
    axes_0.getYAxis();
    
    AxisLabels axisLabels_0 =
    axis_0.getLabels();
    
    axisLabels_0.setMin(0.000001);
    
    axisLabels_0.setMax(1.0);

    residualPlot_0.encode(resolvePath(Path+getSimulation().getPresentationName()+"\\"+getSimulation().getPresentationName()+"_Residuals.png"), "png", 1089, 500);


  }

}
