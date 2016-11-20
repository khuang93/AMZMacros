// STAR-CCM+ macro: heavybraking_3.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.trimmer.*;
import star.base.neo.*;
import star.surfacewrapper.*;
import star.meshing.*;
import star.vis.*;

public class heavybraking_2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();
      
      Region region_0 =
      simulation_0.getRegionManager().getRegion("Region");
      
      Boundary boundary_0 =
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");
      
      region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0}));
      
      Boundary boundary_22 =
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");
      
      region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_22}));

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    TrimmerMeshingModel trimmerMeshingModel_0 = 
      meshContinuum_0.getModelManager().getModel(TrimmerMeshingModel.class);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("Cartesian 2"));

    trimmerMeshingModel_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("MeshRadiator"));

    TrimmerMeshingModel trimmerMeshingModel_1 = 
      meshContinuum_1.getModelManager().getModel(TrimmerMeshingModel.class);

    trimmerMeshingModel_1.setCoordinateSystem(cartesianCoordinateSystem_0);
   
      
    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 =
    region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();
      
    oneGroupContactPreventionSet_1.getFloor().setValue(0.0001);
      
      Boundary boundary_3 =
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");
      
      Boundary boundary_8 =
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");
      
      Boundary boundary_2 =
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");
      
      Boundary boundary_5 =
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");
      
      Boundary boundary_6 =
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");
      
      Boundary boundary_1 =
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");
      
      Boundary boundary_7 =
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");
      
      oneGroupContactPreventionSet_1.getBoundaryGroup().setObjects(boundary_3, boundary_8, boundary_2, boundary_5, boundary_6, boundary_1, boundary_7);
      
      Scene scene_0 =
      simulation_0.getSceneManager().getScene("Geometry Scene 12");
      
      scene_0.setTransparencyOverrideMode(1);
      
      Units units_0 =
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
      
      scene_0.setTransparencyOverrideMode(1);
      
      MeshPartFactory meshPartFactory_0 =
      simulation_0.get(MeshPartFactory.class);
      
      SimpleBlockPart simpleBlockPart_8 =
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));
      
      simpleBlockPart_8.setDoNotRetessellate(true);
      
      Coordinate coordinate_6 =
      simpleBlockPart_8.getCorner1();
      
      
      coordinate_6.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      Coordinate coordinate_7 =
      simpleBlockPart_8.getCorner2();
      
      coordinate_7.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      coordinate_6.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.0, -1.0, -1.0}));
      
      coordinate_7.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 1.0, 1.0}));
      
      coordinate_6.setValue(new DoubleVector(new double[] {0.26, 0.46, 0.029}));
      
      coordinate_7.setValue(new DoubleVector(new double[] {-0.26, 0.74, 0.124}));
      
      simpleBlockPart_8.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      simpleBlockPart_8.rebuildSimpleShapePart();
      
      simpleBlockPart_8.setDoNotRetessellate(false);
      
      scene_0.setTransparencyOverrideMode(0);
      
      scene_0.setTransparencyOverrideMode(1);
      
      scene_0.setTransparencyOverrideMode(1);
      
      SimpleBlockPart simpleBlockPart_9 =
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));
      
      simpleBlockPart_9.setDoNotRetessellate(true);
      
      Coordinate coordinate_8 =
      simpleBlockPart_9.getCorner1();
      
      coordinate_8.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      Coordinate coordinate_9 =
      simpleBlockPart_9.getCorner2();
      
      coordinate_9.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      coordinate_8.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.0, -1.0, -1.0}));
      
      coordinate_9.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.0, 1.0, 1.0}));
      
      coordinate_8.setValue(new DoubleVector(new double[] {-1.26, 0.46, 0.029}));
      
      coordinate_9.setValue(new DoubleVector(new double[] {-1.78, 0.74, 0.124}));
      
      simpleBlockPart_9.setCoordinateSystem(cartesianCoordinateSystem_0);
      
      simpleBlockPart_9.rebuildSimpleShapePart();
      
      simpleBlockPart_9.setDoNotRetessellate(false);
      
      scene_0.setTransparencyOverrideMode(0);
      
      VolumeSource volumeSource_0 =
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 5"));
      
      SimpleBlockPart simpleBlockPart_0 =
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 2"));
      
      SimpleBlockPart simpleBlockPart_1 =
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 4"));
      
      volumeSource_0.getPartGroup().setObjects(simpleBlockPart_0, simpleBlockPart_1);
      
      OneGroupContactPreventionSet oneGroupContactPreventionSet_2 =
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();
      
      oneGroupContactPreventionSet_2.getFloor().setValue(1.0E-3);
      
      Boundary boundary_9 =
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");
      
      Boundary boundary_10 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface");
      
      InterfaceBoundary interfaceBoundary_0 =
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Fan_final.Surface [Interface 3]"));
      
      Boundary boundary_11 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");
      
      Boundary boundary_12 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");
      
      InterfaceBoundary interfaceBoundary_1 =
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3 [Interface 3]"));
      
      Boundary boundary_13 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");
      
      Boundary boundary_14 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");
      
      Boundary boundary_15 =
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");
      
      Boundary boundary_16 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");
      
      InterfaceBoundary interfaceBoundary_2 =
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface [Interface 1]"));
      
      Boundary boundary_17 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
      
      Boundary boundary_18 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");
      
      InterfaceBoundary interfaceBoundary_3 =
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 3 [Interface 2]"));
      
      Boundary boundary_19 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");
      
      Boundary boundary_20 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");
      
      Boundary boundary_21 =
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");
      
      oneGroupContactPreventionSet_2.getBoundaryGroup().setObjects(boundary_9, boundary_10, interfaceBoundary_0, boundary_11, boundary_12, interfaceBoundary_1, boundary_13, boundary_14, boundary_15, boundary_16, interfaceBoundary_2, boundary_17, boundary_18, interfaceBoundary_3, boundary_19, boundary_20, boundary_21);
  }
}
