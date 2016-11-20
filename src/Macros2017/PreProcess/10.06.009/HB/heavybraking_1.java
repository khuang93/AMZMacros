// STAR-CCM+ macro: heavybraking_1.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;
import star.flow.*;
import star.meshing.*;

public class heavybraking_1 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      labCoordinateSystem_0.getLocalCoordinateSystemManager().createLocalCoordinateSystem(CartesianCoordinateSystem.class, "Cartesian");

    cartesianCoordinateSystem_0.setBasis0(new DoubleVector(new double[] {1530, 0.0, 30}));

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

    simpleBlockPart_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_1 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 3"));

    simpleBlockPart_1.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_2 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_1Verf"));

    simpleBlockPart_2.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_3 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_2Verf"));

    simpleBlockPart_3.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_4 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_4Verf"));

    simpleBlockPart_4.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_5 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_vorFahrzeug"));

    CartesianCoordinateSystem cartesianCoordinateSystem_1 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("frtwe_coord"));

    simpleBlockPart_5.setCoordinateSystem(cartesianCoordinateSystem_1);

    simpleBlockPart_5.setCoordinateSystem(cartesianCoordinateSystem_0);

    SimpleBlockPart simpleBlockPart_6 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("BlockKanal"));

    simpleBlockPart_6.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      
      Coordinate coordinate_0 =
      simpleBlockPart_6.getCorner1();
      
      Units units_0 =
      ((Units) simulation_0.getUnitsManager().getObject("m"));
      
      coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-40.0, 0.0, 0.025}));

    SimpleBlockPart simpleBlockPart_7 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Boden"));

    simpleBlockPart_7.setCoordinateSystem(cartesianCoordinateSystem_0);

    ForceReport forceReport_0 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift"));

    forceReport_0.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    ForceReport forceReport_1 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift FW"));

    forceReport_1.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    ForceReport forceReport_2 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift RW"));

    forceReport_2.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    ForceReport forceReport_3 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Lift UB"));

    forceReport_3.getDirection().setComponents(-0.016337688416039733, 0.0, 0.9998665310616315);

    ForceReport forceReport_4 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag"));

    forceReport_4.getDirection().setComponents(0.9998665310616315, 0.0, 0.016337688416039733);

    ForceReport forceReport_5 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag FW"));

    forceReport_5.getDirection().setComponents(0.9998665310616315, 0.0, 0.016337688416039733);

    ForceReport forceReport_6 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag RW"));

    forceReport_6.getDirection().setComponents(0.9998665310616315, 0.0, 0.016337688416039733);

    ForceReport forceReport_7 = 
      ((ForceReport) simulation_0.getReportManager().getReport("Drag UB"));

    forceReport_7.getDirection().setComponents(0.9998665310616315, 0.0, 0.016337688416039733);

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    VelocityProfile velocityProfile_0 = 
      physicsContinuum_0.getInitialConditions().get(VelocityProfile.class);

      
      velocityProfile_0.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      
      
  }
}
