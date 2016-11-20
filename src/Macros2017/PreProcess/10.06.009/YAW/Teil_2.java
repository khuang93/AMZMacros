// STAR-CCM+ macro: Teil_2.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.turbulence.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.prismmesher.*;
import star.meshing.*;

public class Teil_2 extends StarMacro {

  public void execute() {
    execute0();
    execute1();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    region_1.setRegionType(PorousRegion.class);

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh Radiator"));

    meshContinuum_0.add(region_1);

    PorousInertialResistance porousInertialResistance_0 = 
      region_1.getValues().get(PorousInertialResistance.class);

    ScalarProfile scalarProfile_0 = 
      porousInertialResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(0);

    scalarProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(31000.0);

    ScalarProfile scalarProfile_1 = 
      porousInertialResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(1);

    scalarProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(31.0);

    ScalarProfile scalarProfile_2 = 
      porousInertialResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(2);

    scalarProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(31000.0);

    PorousViscousResistance porousViscousResistance_0 = 
      region_1.getValues().get(PorousViscousResistance.class);

    ScalarProfile scalarProfile_3 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(0);

    scalarProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38000.0);

    ScalarProfile scalarProfile_4 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(1);

    scalarProfile_4.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38.0);

    ScalarProfile scalarProfile_5 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(2);

    scalarProfile_5.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38000.0);

    VolumePorosityProfile volumePorosityProfile_0 = 
      region_1.getValues().get(VolumePorosityProfile.class);

    volumePorosityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.7);

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 13");

    scene_0.setTransparencyOverrideMode(1);

    MeshPartFactory meshPartFactory_0 = 
      simulation_0.get(MeshPartFactory.class);

    SimpleBlockPart simpleBlockPart_8 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_8.setDoNotRetessellate(true);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    simpleBlockPart_8.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_8 = 
      simpleBlockPart_8.getCorner1();

    coordinate_8.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_8.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.26, 0.46, 0.005}));

    Coordinate coordinate_9 = 
      simpleBlockPart_8.getCorner2();

    coordinate_9.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_9.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.26, 0.74, 0.1}));

    simpleBlockPart_8.rebuildSimpleShapePart();

    simpleBlockPart_8.setDoNotRetessellate(false);

    scene_0.setTransparencyOverrideMode(0);

    simpleBlockPart_8.setPresentationName("Verf_FL");

    scene_0.setTransparencyOverrideMode(1);

    SimpleBlockPart simpleBlockPart_9 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_9.setDoNotRetessellate(true);

    simpleBlockPart_9.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_10 = 
      simpleBlockPart_9.getCorner1();

    coordinate_10.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_10.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {0.26, -0.46, 0.005}));

    Coordinate coordinate_11 = 
      simpleBlockPart_9.getCorner2();

    coordinate_11.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_11.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.26, -0.74, 0.1}));

    simpleBlockPart_9.rebuildSimpleShapePart();

    simpleBlockPart_9.setDoNotRetessellate(false);

    SimpleBlockPart simpleBlockPart_10 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_10.setDoNotRetessellate(true);

    simpleBlockPart_10.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_12 = 
      simpleBlockPart_10.getCorner1();

    coordinate_12.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_12.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.26, 0.46, 0.005}));

    Coordinate coordinate_13 = 
      simpleBlockPart_10.getCorner2();

    coordinate_13.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_13.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.78, 0.74, 0.1}));

    simpleBlockPart_10.rebuildSimpleShapePart();

    simpleBlockPart_10.setDoNotRetessellate(false);

    SimpleBlockPart simpleBlockPart_11 = 
      meshPartFactory_0.createNewBlockPart(simulation_0.get(SimulationPartManager.class));

    simpleBlockPart_11.setDoNotRetessellate(true);

    simpleBlockPart_11.setCoordinateSystem(labCoordinateSystem_0);

    Coordinate coordinate_14 = 
      simpleBlockPart_11.getCorner1();

    coordinate_14.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_14.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.26, -0.46, 0.005}));

    Coordinate coordinate_15 = 
      simpleBlockPart_11.getCorner2();

    coordinate_15.setCoordinateSystem(labCoordinateSystem_0);

    coordinate_15.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-1.78, -0.74, 0.1}));

    simpleBlockPart_11.rebuildSimpleShapePart();

    simpleBlockPart_11.setDoNotRetessellate(false);

    scene_0.setTransparencyOverrideMode(0);

    simpleBlockPart_9.setPresentationName("Verf_FR");

    simpleBlockPart_10.setPresentationName("Verf_RL");

    simpleBlockPart_11.setPresentationName("Verf_RR");

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    VolumeSource volumeSource_0 = 
      ((VolumeSource) meshContinuum_1.getVolumeSources().getObject("Volumetric Control 5"));

    volumeSource_0.getPartGroup().setObjects(simpleBlockPart_8, simpleBlockPart_9, simpleBlockPart_10, simpleBlockPart_11);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    boundary_2.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    boundary_3.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    boundary_4.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    boundary_5.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    boundary_6.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface");

    boundary_7.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 2");

    boundary_8.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 3");

    boundary_9.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 4");

    boundary_10.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 5");

    boundary_11.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 6");

    boundary_12.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 7");

    boundary_13.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 8");

    boundary_14.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 9");

    boundary_15.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 10");

    boundary_16.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 11");

    boundary_17.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 12");

    boundary_18.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner_YAW.Surface");

    boundary_19.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    boundary_20.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    boundary_21.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    boundary_22.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface");

    boundary_23.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface");

    boundary_24.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    boundary_25.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    boundary_26.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.CUSTOM_VALUES);

    boundary_26.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Inlet");

    boundary_27.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Outlet");

    boundary_28.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    boundary_29.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    boundary_30.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    boundary_31.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    boundary_32.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    boundary_33.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    boundary_34.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 7");

    boundary_35.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");

    boundary_36.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 9");

    boundary_37.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");

    boundary_38.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 11");

    boundary_39.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_40 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 12");

    boundary_40.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_41 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

    boundary_41.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    boundary_42.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_43 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    boundary_43.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    boundary_44.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    boundary_45.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    boundary_46.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front_Right.Surface");

    boundary_47.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_48 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    boundary_48.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_49 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear_Right.Surface");

    boundary_49.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_23, boundary_24}));

    MeshPart meshPart_21 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Rear_Yaw"));

    PartSurface partSurface_2 = 
      ((PartSurface) meshPart_21.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_21.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_2}), 89.0);

    MeshPart meshPart_22 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_Yaw"));

    PartSurface partSurface_3 = 
      ((PartSurface) meshPart_22.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_22.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_3}), 89.0);

    FeatureCurve featureCurve_4 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_21, meshPart_22}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_4, true);

    Boundary boundary_50 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface");

    boundary_50.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_51 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 2");

    boundary_51.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_52 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 3");

    boundary_52.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_53 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 4");

    boundary_53.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_54 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 5");

    boundary_54.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_55 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 6");

    boundary_55.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_56 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface");

    boundary_56.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_57 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 2");

    boundary_57.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_58 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 3");

    boundary_58.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_59 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 4");

    boundary_59.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_60 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 5");

    boundary_60.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_61 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 6");

    boundary_61.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_62 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    boundary_62.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.VECTOR);

    boundary_62.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    WallRelativeVelocityProfile wallRelativeVelocityProfile_0 = 
      boundary_62.getValues().get(WallRelativeVelocityProfile.class);

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("YAW"));

    wallRelativeVelocityProfile_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    Units units_3 = 
      ((Units) simulation_0.getUnitsManager().getObject("kph"));

    wallRelativeVelocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setUnits(units_3);

    wallRelativeVelocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(-40.0, 0.0, 0.0);

    RoughnessHeightProfile roughnessHeightProfile_0 = 
      boundary_62.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.001);

    boundary_27.setBoundaryType(InletBoundary.class);

    VelocityMagnitudeProfile velocityMagnitudeProfile_0 = 
      boundary_27.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setUnits(units_3);

    velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(40.0);

    boundary_28.setBoundaryType(PressureBoundary.class);

    Boundary boundary_63 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    boundary_63.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.LOCAL_ROTATION_RATE);

    boundary_63.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    ReferenceFrame referenceFrame_0 = 
      boundary_63.getValues().get(ReferenceFrame.class);

    CartesianCoordinateSystem cartesianCoordinateSystem_4 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("FL"));

    referenceFrame_0.setCoordinateSystem(cartesianCoordinateSystem_4);

    referenceFrame_0.getAxisVector().setComponents(0.0, 1.0, 0.0);

    RoughnessHeightProfile roughnessHeightProfile_1 = 
      boundary_63.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    WallRelativeRotationProfile wallRelativeRotationProfile_0 = 
      boundary_63.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    Boundary boundary_64 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front_Right.Surface");

    boundary_64.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.LOCAL_ROTATION_RATE);

    boundary_64.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    WallRelativeRotationProfile wallRelativeRotationProfile_1 = 
      boundary_64.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    RoughnessHeightProfile roughnessHeightProfile_2 = 
      boundary_64.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    ReferenceFrame referenceFrame_1 = 
      boundary_64.getValues().get(ReferenceFrame.class);

    CartesianCoordinateSystem cartesianCoordinateSystem_7 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("FR"));

    referenceFrame_1.setCoordinateSystem(cartesianCoordinateSystem_7);

    referenceFrame_1.getAxisVector().setComponents(0.0, 1.0, 0.0);

    Boundary boundary_65 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    boundary_65.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.LOCAL_ROTATION_RATE);
  }

  private void execute1() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_65 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    boundary_65.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    ReferenceFrame referenceFrame_2 = 
      boundary_65.getValues().get(ReferenceFrame.class);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_6 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("RL"));

    referenceFrame_2.setCoordinateSystem(cartesianCoordinateSystem_6);

    referenceFrame_2.getAxisVector().setComponents(0.0, 1.0, 0.0);

    RoughnessHeightProfile roughnessHeightProfile_3 = 
      boundary_65.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    WallRelativeRotationProfile wallRelativeRotationProfile_2 = 
      boundary_65.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    Boundary boundary_66 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear_Right.Surface");

    boundary_66.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.Type.LOCAL_ROTATION_RATE);

    boundary_66.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.Type.ROUGH);

    RoughnessHeightProfile roughnessHeightProfile_4 = 
      boundary_66.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_4.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    ReferenceFrame referenceFrame_3 = 
      boundary_66.getValues().get(ReferenceFrame.class);

    CartesianCoordinateSystem cartesianCoordinateSystem_5 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("RR"));

    referenceFrame_3.setCoordinateSystem(cartesianCoordinateSystem_5);

    referenceFrame_3.getAxisVector().setComponents(0.0, 1.0, 0.0);

    WallRelativeRotationProfile wallRelativeRotationProfile_3 = 
      boundary_66.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    Boundary boundary_52 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 3");

    boundary_52.setBoundaryType(InletBoundary.class);

    Boundary boundary_55 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Rear_Yaw.Surface 6");

    boundary_55.setBoundaryType(InletBoundary.class);

    Boundary boundary_56 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface");

    boundary_56.setBoundaryType(InletBoundary.class);

    Boundary boundary_59 = 
      region_0.getBoundaryManager().getBoundary("Outlet_Yaw.Surface 4");

    boundary_59.setBoundaryType(InletBoundary.class);

    VelocityMagnitudeProfile velocityMagnitudeProfile_1 = 
      boundary_59.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    VelocityMagnitudeProfile velocityMagnitudeProfile_2 = 
      boundary_56.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    VelocityMagnitudeProfile velocityMagnitudeProfile_3 = 
      boundary_55.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    VelocityMagnitudeProfile velocityMagnitudeProfile_4 = 
      boundary_52.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_4.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(10.0);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 3");

    BoundaryInterface boundaryInterface_0 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_7, boundary_9, "Interface");

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 7");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Fan_Yaw.Surface 9");

    BoundaryInterface boundaryInterface_1 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_13, boundary_15, "Interface");

    boundaryInterface_0.setInterfaceType(FanInterface.class);

    boundaryInterface_0.getTopology().setSelected(InterfaceConfigurationOption.Type.PERIODIC);

    boundaryInterface_1.setInterfaceType(FanInterface.class);

    boundaryInterface_1.getTopology().setSelected(InterfaceConfigurationOption.Type.PERIODIC);

    FileTable fileTable_0 = 
      (FileTable) simulation_0.getTableManager().createFromFile(resolvePath("Z:\\StarCCM\\Auto 2016\\Aero\\Fan-tables\\Fan-curve-kuehlung.csv"));

    FanCurveTable fanCurveTable_0 = 
      boundaryInterface_0.getValues().get(FanCurveTable.class);

    fanCurveTable_0.setActiveTable(fileTable_0);

    fanCurveTable_0.setActiveTableX("column1");

    fanCurveTable_0.setActiveTableP("column0");

    fanCurveTable_0.getOperatingRotationRate().setValue(11000.0);

    fanCurveTable_0.getDataRotationRate().setValue(11000.0);

    FanCurveTable fanCurveTable_1 = 
      boundaryInterface_1.getValues().get(FanCurveTable.class);

    fanCurveTable_1.setActiveTable(fileTable_0);

    fanCurveTable_1.setActiveTableX("column1");

    fanCurveTable_1.setActiveTableP("column0");

    fanCurveTable_1.getOperatingRotationRate().setValue(11000.0);

    fanCurveTable_1.getDataRotationRate().setValue(11000.0);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    Boundary boundary_67 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 2");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    BoundaryInterface boundaryInterface_2 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_67, boundary_30, "Interface");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_68 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 4");

    BoundaryInterface boundaryInterface_3 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_32, boundary_68, "Interface");

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 8");

    Boundary boundary_69 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 8");

    BoundaryInterface boundaryInterface_4 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_36, boundary_69, "Interface");

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 10");

    Boundary boundary_70 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 10");

    BoundaryInterface boundaryInterface_5 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_38, boundary_70, "Interface");
  }
}
