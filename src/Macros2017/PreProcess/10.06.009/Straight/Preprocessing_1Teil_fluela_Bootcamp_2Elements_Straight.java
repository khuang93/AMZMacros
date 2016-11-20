// STAR-CCM+ macro: Preprocessing_1Teil.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.turbulence.*;
import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.prismmesher.*;
import star.surfacewrapper.*;
import star.meshing.*;

public class Preprocessing_1Teil_fluela_Bootcamp_2Elements_Straight extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MeshPart meshPart_0 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Radiator"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_0.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_0.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    MeshActionManager meshActionManager_0 = 
      simulation_0.get(MeshActionManager.class);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("BlockKanal"));

    MeshPart meshPart_1 = 
      meshActionManager_0.subtractParts(new NeoObjectVector(new Object[] {simpleBlockPart_0, meshPart_0}), simpleBlockPart_0, "Discrete");

    Region region_0 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_0.setPresentationName("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Default");

    region_0.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_0}));

    FeatureCurve featureCurve_0 = 
      ((FeatureCurve) region_0.getFeatureCurveManager().getObject("Default"));

    region_0.getFeatureCurveManager().removeObjects(featureCurve_0);

    FeatureCurve featureCurve_1 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_0}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_1, true);

    region_0.setPresentationName("RegionRadiator");

    region_0.setRegionType(PorousRegion.class);

    VolumePorosityProfile volumePorosityProfile_0 = 
      region_0.getValues().get(VolumePorosityProfile.class);

    volumePorosityProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.7);

    PorousInertialResistance porousInertialResistance_0 = 
      region_0.getValues().get(PorousInertialResistance.class);

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
      region_0.getValues().get(PorousViscousResistance.class);

    ScalarProfile scalarProfile_3 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(0);

    scalarProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38000.0);

    ScalarProfile scalarProfile_4 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(1);

    scalarProfile_4.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38.0);

    ScalarProfile scalarProfile_5 = 
      porousViscousResistance_0.getMethod(PrincipalTensorProfileMethod.class).getProfile(2);

    scalarProfile_5.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(38000.0);

    MeshContinuum meshContinuum_0 = 
      simulation_0.getContinuumManager().createContinuum(MeshContinuum.class);

    meshContinuum_0.setPresentationName("Copy of Mesh 1");

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    meshContinuum_0.copyProperties(meshContinuum_1);

    meshContinuum_0.setPresentationName("MeshRadiator");

    meshContinuum_0.add(region_0);

    SurfaceWrapperMeshingModel surfaceWrapperMeshingModel_0 = 
      meshContinuum_0.getModelManager().getModel(SurfaceWrapperMeshingModel.class);

    meshContinuum_0.disableModel(surfaceWrapperMeshingModel_0);

    PrismMesherModel prismMesherModel_0 = 
      meshContinuum_0.getModelManager().getModel(PrismMesherModel.class);

    meshContinuum_0.disableModel(prismMesherModel_0);

    VolumeSource volumeSource_0 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 1"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_0);

    VolumeSource volumeSource_1 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 2"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_1);

    VolumeSource volumeSource_2 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 3"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_2);

    VolumeSource volumeSource_3 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 4"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_3);

    VolumeSource volumeSource_4 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 5"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_4);

    VolumeSource volumeSource_5 = 
      ((VolumeSource) meshContinuum_0.getVolumeSources().getObject("Volumetric Control 6"));

    meshContinuum_0.getVolumeSources().remove(volumeSource_5);

    MaximumCellSize maximumCellSize_0 = 
      meshContinuum_0.getReferenceValues().get(MaximumCellSize.class);

    GenericRelativeSize genericRelativeSize_0 = 
      ((GenericRelativeSize) maximumCellSize_0.getRelativeSize());

    genericRelativeSize_0.setPercentage(0.5);

    Region region_1 = 
      simulation_0.getRegionManager().createEmptyRegion();

    region_1.setPresentationName("Region");

    Boundary boundary_1 = 
      region_1.getBoundaryManager().getBoundary("Default");

    region_1.getBoundaryManager().removeBoundaries(new NeoObjectVector(new Object[] {boundary_1}));

    FeatureCurve featureCurve_2 = 
      ((FeatureCurve) region_1.getFeatureCurveManager().getObject("Default"));

    region_1.getFeatureCurveManager().removeObjects(featureCurve_2);

    FeatureCurve featureCurve_3 = 
      region_1.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_2 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Airduct"));

    MeshPart meshPart_3 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_Driver"));

    MeshPart meshPart_4 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_MC"));

    MeshPart meshPart_5 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Body_QJ"));

    MeshPart meshPart_6 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Drivetrain"));

    MeshPart meshPart_7 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Endplates"));

  /*MeshPart meshPart_8 = 
     ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_FLap2"));
*/
    MeshPart meshPart_9 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Flap1"));

    MeshPart meshPart_10 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FW_Main"));

    MeshPart meshPart_11 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Headrest"));

    MeshPart meshPart_12 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("MRH"));

    MeshPart meshPart_13 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Endplates"));

    MeshPart meshPart_14 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Flap1"));

    MeshPart meshPart_15 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Flap2"));

    MeshPart meshPart_16 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Main"));

    MeshPart meshPart_17 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("RW_Support"));

    MeshPart meshPart_18 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Sidepod"));

    MeshPart meshPart_19 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Susp_Brackets"));

    MeshPart meshPart_20 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Susp_Legs"));

    MeshPart meshPart_21 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Front"));

    MeshPart meshPart_22 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tire_Rear"));

    MeshPart meshPart_23 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("TSAL"));

    MeshPart meshPart_24 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Tubes"));

    MeshPart meshPart_25 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_Diffusor"));

    MeshPart meshPart_26 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_F1"));

    MeshPart meshPart_27 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_F2"));

    MeshPart meshPart_28 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_hor"));

    MeshPart meshPart_29 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_MC"));

    MeshPart meshPart_30 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("UB_ver"));

    MeshPart meshPart_31 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Front"));

    MeshPart meshPart_32 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Wheel_Rear"));
      
      MeshPart meshPart_33 =
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("ContactP_FT_straight_1.5"));
      
      MeshPart meshPart_34 =
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("ContactP_RT_straight_1.5"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_2, meshPart_3, meshPart_4, meshPart_5, meshPart_6, meshPart_7, /*meshPart_8,*/ meshPart_9, meshPart_10, meshPart_11, meshPart_12, meshPart_13, meshPart_14, meshPart_15, meshPart_16, meshPart_17, meshPart_18, meshPart_1, meshPart_19, meshPart_20, meshPart_21, meshPart_22, meshPart_23, meshPart_24, meshPart_25, meshPart_26, meshPart_27, meshPart_28, meshPart_29, meshPart_30, meshPart_31, meshPart_32, meshPart_33, meshPart_34}), "OneRegion", region_1, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_3, true);

    Boundary boundary_2 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Radiator.Surface");

    BoundaryInterface boundaryInterface_0 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_2, boundary_3, "Interface", true);

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("Radiator.Surface 3");

    Boundary boundary_5 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface 3");

    BoundaryInterface boundaryInterface_1 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_4, boundary_5, "Interface", true);

    Boundary boundary_6 = 
      region_1.getBoundaryManager().getBoundary("Airduct.Surface");

    boundary_6.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_7 = 
      region_1.getBoundaryManager().getBoundary("Body_Driver.Surface");

    boundary_7.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_8 = 
      region_1.getBoundaryManager().getBoundary("Body_MC.Surface");

    boundary_8.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_9 = 
      region_1.getBoundaryManager().getBoundary("Body_QJ.Surface");

    boundary_9.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_10 = 
      region_1.getBoundaryManager().getBoundary("Drivetrain.Surface");

    boundary_10.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_11 = 
      region_1.getBoundaryManager().getBoundary("Headrest.Surface");

    boundary_11.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_12 = 
      region_1.getBoundaryManager().getBoundary("MRH.Surface");

    boundary_12.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_13 = 
      region_1.getBoundaryManager().getBoundary("RW_Support.Surface");

    boundary_13.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_14 = 
      region_1.getBoundaryManager().getBoundary("Sidepod.Surface");

    boundary_14.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    boundary_2.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_15 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface 2");

    boundary_15.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    boundary_5.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_16 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface 4");

    boundary_16.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_17 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Floor");

    boundary_17.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.VECTOR);

    boundary_17.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.ROUGH);

    RoughnessHeightProfile roughnessHeightProfile_0 = 
      boundary_17.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.001);

    WallVelocityProfile wallVelocityProfile_0 = 
      boundary_17.getValues().get(WallVelocityProfile.class);

    Units units_2 = 
      ((Units) simulation_0.getUnitsManager().getObject("kph"));

    wallVelocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setUnits(units_2);

    wallVelocityProfile_0.getMethod(ConstantVectorProfileMethod.class).getQuantity().setComponents(-40.0, 0.0, 0.0);

    Boundary boundary_18 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Inlet");

    boundary_18.setBoundaryType(InletBoundary.class);

    VelocityMagnitudeProfile velocityMagnitudeProfile_0 = 
      boundary_18.getValues().get(VelocityMagnitudeProfile.class);

    velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setUnits(units_2);

    velocityMagnitudeProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(40.0);

    Boundary boundary_19 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Outlet");

    boundary_19.setBoundaryType(PressureBoundary.class);

    Boundary boundary_20 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Symmetry");

    boundary_20.setBoundaryType(SymmetryBoundary.class);

    Boundary boundary_21 = 
      region_1.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    boundary_21.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_22 = 
      region_1.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    boundary_22.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_23 = 
      region_1.getBoundaryManager().getBoundary("Tire_Front.Surface");

    boundary_23.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.LOCAL_ROTATION_RATE);

    boundary_23.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.ROUGH);

    RoughnessHeightProfile roughnessHeightProfile_1 = 
      boundary_23.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    WallRotationProfile wallRotationProfile_0 = 
      boundary_23.getValues().get(WallRotationProfile.class);

    wallRotationProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.8103);

    ReferenceFrame referenceFrame_0 = 
      boundary_23.getValues().get(ReferenceFrame.class);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("frtwe_coord"));

    referenceFrame_0.setCoordinateSystem(cartesianCoordinateSystem_0);

    referenceFrame_0.getAxisVector().setComponents(0.0, 1.0, 0.013952642);

    boundary_23.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DEFAULT);

    Boundary boundary_24 = 
      region_1.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    boundary_24.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.LOCAL_ROTATION_RATE);

    boundary_24.getConditions().get(WallSurfaceOption.class).setSelected(WallSurfaceOption.ROUGH);

    ReferenceFrame referenceFrame_1 = 
      boundary_24.getValues().get(ReferenceFrame.class);

    CartesianCoordinateSystem cartesianCoordinateSystem_1 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("rewe_coord"));

    referenceFrame_1.setCoordinateSystem(cartesianCoordinateSystem_1);

    Units units_3 = 
      simulation_0.getUnitsManager().getInternalUnits(new IntVector(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    referenceFrame_1.getAxisVector().setComponents(0.0, 1.0, 0.013892446);

    RoughnessHeightProfile roughnessHeightProfile_2 = 
      boundary_24.getValues().get(RoughnessHeightProfile.class);

    roughnessHeightProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(5.0E-4);

    WallRotationProfile wallRotationProfile_1 = 
      boundary_24.getValues().get(WallRotationProfile.class);

    wallRotationProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.8103);

    boundary_24.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DEFAULT);

    Boundary boundary_25 = 
      region_1.getBoundaryManager().getBoundary("TSAL.Surface");

    boundary_25.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_26 = 
      region_1.getBoundaryManager().getBoundary("Tubes.Surface");

    boundary_26.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_27 = 
      region_1.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    boundary_27.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.LOCAL_ROTATION_RATE);

    ReferenceFrame referenceFrame_2 = 
      boundary_27.getValues().get(ReferenceFrame.class);

    referenceFrame_2.setCoordinateSystem(cartesianCoordinateSystem_0);

    referenceFrame_2.getAxisVector().setComponents(0.0, 1.0, 0.013952642);

    WallRotationProfile wallRotationProfile_2 = 
      boundary_27.getValues().get(WallRotationProfile.class);

    wallRotationProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.8103);

    boundary_27.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_28 = 
      region_1.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    boundary_28.getConditions().get(WallSlidingOption.class).setSelected(WallSlidingOption.LOCAL_ROTATION_RATE);

    ReferenceFrame referenceFrame_3 = 
      boundary_28.getValues().get(ReferenceFrame.class);

    referenceFrame_3.setCoordinateSystem(cartesianCoordinateSystem_1);

    referenceFrame_3.getAxisVector().setComponents(0.0, 1.0, 0.013892446);

    WallRotationProfile wallRotationProfile_3 = 
      boundary_28.getValues().get(WallRotationProfile.class);

    wallRotationProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.8103);

    boundary_28.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);
	
	Boundary boundary_29 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface 5");

    boundary_29.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_30 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Surface 6");

    boundary_30.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);
	
	Boundary boundary_31 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Inlet");

    boundary_31.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_32 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Outlet");

    boundary_32.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_33 = 
      region_1.getBoundaryManager().getBoundary("Subtract.Symmetry");

    boundary_33.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);
	
    Boundary boundary_34 = 
      region_1.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    boundary_34.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);
		
    Boundary boundary_35 = 
      region_1.getBoundaryManager().getBoundary("UB_ver.Surface");

    boundary_35.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

    Boundary boundary_36 = 
      region_1.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    boundary_36.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.DISABLE);

	
	}
	
  }
