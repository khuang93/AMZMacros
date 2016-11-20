// STAR-CCM+ macro: update_s.java
// Written by STAR-CCM+ 10.06.009
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.prismmesher.*;
import star.meshing.*;

public class update_s extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    PartImportManager partImportManager_0 = 
      simulation_0.get(PartImportManager.class);

    Units units_1 = 
      ((Units) simulation_0.getUnitsManager().getObject("mm"));

    partImportManager_0.importStlPart(resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\FC6_inner.stl"), "OneSurfacePerPatch", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_19 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 16");

    scene_19.initializeAndWait();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_19.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_4.initialize();

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_19.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_5.initialize();

    scene_19.open(true);

    CurrentView currentView_2 = 
      scene_19.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {-10.0, 7.499947779484501, 7.5}), new DoubleVector(new double[] {-10.0, 7.499947779484501, 130.44233389712304}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.09438941247529, 0);

    scene_19.close(true);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    FeatureCurve featureCurve_2 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    MeshPart meshPart_1 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("FC6_inner"));

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_1}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_2, true);

    Boundary boundary_44 = 
      region_0.getBoundaryManager().getBoundary("FC6_inner.Surface");

    boundary_44.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface");

    boundary_7.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 2");

    boundary_8.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3");

    boundary_9.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 4");

    boundary_10.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 5");

    boundary_11.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("Fan_final.Surface 6");

    boundary_12.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    partImportManager_0.importStlParts(new StringVector(new String[] {resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final.stl"), resolvePath("Z:\\CAD Daten\\Auto 2016\\Aero\\Simulationen-ToDo\\Outlet_final_Rear_V2.stl")}), "OneSurfacePerPatch", "OnePartPerFile", units_1, true, 1.0E-5);

    simulation_0.getSceneManager().createGeometryScene("Geometry Scene", "Outline", "Geometry", 1);

    Scene scene_20 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 17");

    scene_20.initializeAndWait();

    PartDisplayer partDisplayer_6 = 
      ((PartDisplayer) scene_20.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_6.initialize();

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_20.getDisplayerManager().getDisplayer("Geometry 1"));

    partDisplayer_7.initialize();

    scene_20.open(true);

    CurrentView currentView_3 = 
      scene_20.getCurrentView();

    currentView_3.setInput(new DoubleVector(new double[] {-10.0, 7.499930372097879, 7.5}), new DoubleVector(new double[] {-10.0, 7.499930372097879, 130.4423497498662}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 32.094393550871686, 0);

    MeshPart meshPart_2 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final"));

    PartSurface partSurface_0 = 
      ((PartSurface) meshPart_2.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_2.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_0}), 89.0);

    MeshPart meshPart_3 = 
      ((MeshPart) simulation_0.get(SimulationPartManager.class).getPart("Outlet_final_Rear_V2"));

    PartSurface partSurface_1 = 
      ((PartSurface) meshPart_3.getPartSurfaceManager().getPartSurface("Surface"));

    meshPart_3.getPartSurfaceManager().splitPartSurfacesByAngle(new NeoObjectVector(new Object[] {partSurface_1}), 89.0);

    FeatureCurve featureCurve_3 = 
      region_0.getFeatureCurveManager().createEmptyFeatureCurveWithName("Feature Curve");

    simulation_0.getRegionManager().newRegionsFromParts(new NeoObjectVector(new Object[] {meshPart_2, meshPart_3}), "OneRegion", region_0, "OneBoundaryPerPartSurface", null, "OneFeatureCurve", featureCurve_3, true);

    partDisplayer_7.setVisibilityOverrideMode(2);

    partDisplayer_6.getInputParts().setQuery(null);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("ContactP_FT_straight_1.5.Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("ContactP_RT_straight_1.5.Surface");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Fan_final.Surface [Interface 3]"));

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Fan_final.Surface 3 [Interface 3]"));

    Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_45 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface");

    Boundary boundary_46 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 2");

    Boundary boundary_47 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final.Surface 3");

    Boundary boundary_48 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface");

    Boundary boundary_49 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 2");

    Boundary boundary_50 = 
      region_0.getBoundaryManager().getBoundary("Outlet_final_Rear_V2.Surface 3");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");

    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    InterfaceBoundary interfaceBoundary_2 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface [Interface 1]"));

    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    InterfaceBoundary interfaceBoundary_3 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 3 [Interface 2]"));

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");

    Boundary boundary_36 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    Boundary boundary_37 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_38 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_39 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_40 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_41 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

    Boundary boundary_42 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_43 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    partDisplayer_6.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5, boundary_6, boundary_7, interfaceBoundary_0, boundary_8, boundary_9, interfaceBoundary_1, boundary_10, boundary_11, boundary_12, boundary_44, boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_45, boundary_46, boundary_47, boundary_48, boundary_49, boundary_50, boundary_18, boundary_19, boundary_20, boundary_21, boundary_22, boundary_23, boundary_24, interfaceBoundary_2, boundary_25, boundary_26, interfaceBoundary_3, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, boundary_33, boundary_34, boundary_35, boundary_36, boundary_37, boundary_38, boundary_39, boundary_40, boundary_41, boundary_42, boundary_43);

    currentView_3.setInput(new DoubleVector(new double[] {-0.9388689771294594, 0.15364529937505722, 0.2189304195344448}), new DoubleVector(new double[] {-0.9388689771294594, 0.15364529937505722, 4.2562920989307775}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1.053962893253512, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.9388689771294594, 0.15364529937505722, 0.2189304195344448}), new DoubleVector(new double[] {-0.9388689771294594, 0.15364529937505722, 4.2562920989307775}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 1.053962893253512, 0);

    PartRepresentation partRepresentation_0 = 
      ((PartRepresentation) simulation_0.getRepresentationManager().getObject("Geometry"));

    partDisplayer_6.setRepresentation(partRepresentation_0);

    partDisplayer_7.setRepresentation(partRepresentation_0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.9345750282332206, 0.12863242293399063, 0.3000304259924809}), new DoubleVector(new double[] {-0.4502138553646298, -2.6928418103588228, 3.17475003396228}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 1.0590923040471003, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.9345750282332206, 0.12863242293399063, 0.3000304259924809}), new DoubleVector(new double[] {-0.4502138553646298, -2.6928418103588228, 3.17475003396228}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 1.0590923040471003, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.3241926773711752, 0.34141440943465695, -0.23533249023247582}), new DoubleVector(new double[] {0.02068089659387956, -1.6675242858847514, 1.8115178373369074}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.7540921290045323, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.24105608242476392, 0.48639507470870713, -0.43563355238194656}), new DoubleVector(new double[] {0.09712759842730731, -1.4835740208593868, 1.5715117616884844}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.7394641722075477, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.14147546439154332, 0.47266057391802807, -0.46896581968608086}), new DoubleVector(new double[] {0.16592963007739228, -1.3180187823365586, 1.3555062936049036}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.6721644673720577, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.23989146581317075, 0.565579145557995, -0.6689186468605167}), new DoubleVector(new double[] {0.351307429128908, -0.0834350349368902, -0.007656612813271346}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.2436194226652127, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.2575076693576387, 0.5808809925865719, -0.6897701804017772}), new DoubleVector(new double[] {0.3605654149802532, -0.019445354988650673, -0.07811479039620602}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.22534354811087842, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.29206308856580937, 0.5946216095162993, -0.7125371116618884}), new DoubleVector(new double[] {0.377083625535126, 0.09936462403384144, -0.20793389737384887}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.18590382845279116, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.2951890790191315, 0.5930514630772001, -0.7191767314366697}), new DoubleVector(new double[] {0.38909843295588875, 0.04601582678018988, -0.16181772692576488}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.20533989841386083, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.299049284410451, 0.5888683281380369, -0.7239779914885788}), new DoubleVector(new double[] {0.40231472111872785, -0.012667850198826831, -0.11108993943287249}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.2257976803633492, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.30753469558197694, 0.5797064443108544, -0.7345825506182111}), new DoubleVector(new double[] {0.4313905550769738, -0.1417719395526636, 5.111930514907909E-4}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.27082019565155874, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.31263016926032194, 0.5741846912682824, -0.740920198682238}), new DoubleVector(new double[] {0.4488360554519214, -0.21923439316496568, 0.06747187254210876}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.29782446222330694, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.32487780600327776, 0.5514406161837861, -0.7723034087047366}), new DoubleVector(new double[] {0.5161579513218023, -0.5627940326433252, 0.3629584891593577}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.4182484913563087, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.33871957865873614, 0.5395003287608925, -0.7959893845173924}), new DoubleVector(new double[] {0.5690708106829958, -0.8023290790641476, 0.5711623206829668}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.5036803747497111, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.44655323987337214, 0.47981585101201096, -0.8913647757556793}), new DoubleVector(new double[] {0.8627612796500286, -1.9446564760416374, 1.5788609152396609}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.910070328716414, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.21095686991059756, 0.7659656747667659, -0.6841537352451291}), new DoubleVector(new double[] {0.6367526008246014, -1.71435634672169, 1.8429756161828954}), new DoubleVector(new double[] {0.04859567384470189, 0.7169231365299271, 0.6954564521173637}), 0.931034539858706, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.19014131239648624, 0.8279230076525393, -0.7465689997866705}), new DoubleVector(new double[] {1.2551583169613034, -1.5948589777344515, 1.6765780374715402}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.9367298493762273, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.11490990531708045, 0.8552636708816008, -0.7662815769527132}), new DoubleVector(new double[] {1.0894826033470075, -1.3617687014810524, 1.4510848460265315}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.857180056955792, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.007691663848280239, 0.8403292390458357, -0.7376069247813193}), new DoubleVector(new double[] {0.7912663188412749, -0.9422062042249344, 1.045197101425516}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.689188778583437, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.04866122155641228, 0.8603660460978007, -0.753378294548824}), new DoubleVector(new double[] {0.6686966742280915, -0.771534458337797, 0.8787680959534448}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.6309481921761835, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.08857090922573996, 0.8538125155321843, -0.742982165840826}), new DoubleVector(new double[] {0.5583839940762265, -0.6179298870393732, 0.7289819910285809}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.5690256273146483, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.12448938753188193, 0.8479137906964058, -0.7336251025944365}), new DoubleVector(new double[] {0.45910258193954806, -0.4796857728707919, 0.5941744965962032}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.5132951073241555, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.16792128674909007, 0.8636616104413439, -0.7464718087959707}), new DoubleVector(new double[] {0.36686824492025244, -0.35291844203534284, 0.4702915514761858}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.4703711915410251, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.1985023037877885, 0.8584807003887793, -0.7386769804046805}), new DoubleVector(new double[] {0.2838573416028864, -0.23882784428343867, 0.35879690086817007}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.4242567733992253, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.22602503513724712, 0.8538174627975064, -0.7316612162454905}), new DoubleVector(new double[] {0.20914752861725697, -0.13614630630672492, 0.2584517153209559}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.3827536352482852, 0);

    boundary_46.setBoundaryType(MassFlowBoundary.class);

      MassFlowRateProfile massFlowRateProfile_0 =
      boundary_46.getValues().get(MassFlowRateProfile.class);

    massFlowRateProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.01685);

    currentView_3.setInput(new DoubleVector(new double[] {-0.20469463013124073, 0.9020619681894471, -0.7694853352487894}), new DoubleVector(new double[] {0.2893654233309919, -0.2218635579731556, 0.35460953801929435}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.4345478029729636, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.16447452599929685, 0.9170115978762706, -0.7729667962912815}), new DoubleVector(new double[] {0.3776051075161004, -0.3161525348062294, 0.46038314298746663}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.47678316052830205, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.0762688719881296, 0.9505345070436629, -0.7812598299272766}), new DoubleVector(new double[] {0.571732412723339, -0.5235882838389917, 0.6930850739174457}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.5699459663288723, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.025039026572659995, 1.08199518053457, -0.8776902447797371}), new DoubleVector(new double[] {0.8393883482799308, -0.7705488239160324, 0.9751328911236411}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.7162564674487872, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.18929986151011902, 1.142630431524867, -0.896274552248213}), new DoubleVector(new double[] {1.1605754709478409, -1.0669014720084813, 1.3135902717710755}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.8542801208166333, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.23870536465336767, 1.305695665162088, -1.0308802499021197}), new DoubleVector(new double[] {1.3624135606889503, -1.2506015230684249, 1.5258021075584698}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 0.9883513640661142, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.2957922556710446, 1.4971186608966665, -1.1887791168426611}), new DoubleVector(new double[] {1.596851167640445, -1.462629474894552, 1.771414978016201}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 1.1443392109374744, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.42943353953116725, 1.5465187409740642, -1.2012783717313242}), new DoubleVector(new double[] {1.8547325352870894, -1.6958602219032919, 2.0415891355197053}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 1.253613893381998, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.5764363052185197, 1.6008648496531581, -1.2150335736099618}), new DoubleVector(new double[] {2.138402039698398, -1.9524140436129058, 2.33878070877356}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 1.3738183718371966, 0);

    currentView_3.setInput(new DoubleVector(new double[] {-0.13839373769425145, 1.940377564916793, -1.1402219562314777}), new DoubleVector(new double[] {1.5395870853743905, -1.8768213084633782, 2.677552072321527}), new DoubleVector(new double[] {0.048595671424346745, 0.7169231361688905, 0.6954564526586688}), 1.4758588049883354, 0);


      boundary_48.setBoundaryType(MassFlowBoundary.class);
      
      MassFlowRateProfile massFlowRateProfile_1 =
      boundary_48.getValues().get(MassFlowRateProfile.class);
      
      massFlowRateProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(0.05);

    BoundaryInterface boundaryInterface_0 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 1"));

    BoundaryInterface boundaryInterface_1 = 
      ((BoundaryInterface) simulation_0.getInterfaceManager().getInterface("Interface 2"));

    simulation_0.getInterfaceManager().deleteInterfaces(boundaryInterface_0, boundaryInterface_1);

    Region region_1 = 
      simulation_0.getRegionManager().getRegion("RegionRadiator");

    Boundary boundary_51 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 2");

    BoundaryInterface boundaryInterface_2 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_51, boundary_25, "Interface");

    Boundary boundary_52 = 
      region_1.getBoundaryManager().getBoundary("Radiator.Surface 4");

    BoundaryInterface boundaryInterface_3 = 
      simulation_0.getInterfaceManager().createBoundaryInterface(boundary_52, boundary_27, "Interface");

    boundary_45.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_46.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_47.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_48.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_49.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    boundary_50.get(MeshConditionManager.class).get(CustomizeBoundaryPrismsOption.class).setSelected(CustomizeBoundaryPrismsOption.Type.DISABLE);

    WallRelativeRotationProfile wallRelativeRotationProfile_0 = 
      boundary_32.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_0.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_1 = 
      boundary_33.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_1.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_2 = 
      boundary_42.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_2.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    WallRelativeRotationProfile wallRelativeRotationProfile_3 = 
      boundary_43.getValues().get(WallRelativeRotationProfile.class);

    wallRelativeRotationProfile_3.getMethod(ConstantScalarProfileMethod.class).getQuantity().setValue(47.2672);

    SimpleBlockPart simpleBlockPart_0 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block_4Verf"));

    Coordinate coordinate_0 = 
      simpleBlockPart_0.getCorner2();

    coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.4, 1.4, 1.6}));

    SimpleBlockPart simpleBlockPart_1 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block"));

    Coordinate coordinate_1 = 
      simpleBlockPart_1.getCorner2();

    coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {1.1, 1.2, 0.93}));

    SimpleBlockPart simpleBlockPart_2 = 
      ((SimpleBlockPart) simulation_0.get(SimulationPartManager.class).getPart("Block 3"));

    Coordinate coordinate_2 = 
      simpleBlockPart_2.getCorner2();

    coordinate_2.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[] {-0.23252013325691223, 1.2, 1.4}));

    MeshContinuum meshContinuum_0 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("Mesh 1"));

    meshContinuum_0.setMeshInParallel(true);

    MeshContinuum meshContinuum_1 = 
      ((MeshContinuum) simulation_0.getContinuumManager().getContinuum("MeshRadiator"));

    meshContinuum_1.setMeshInParallel(true);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_0 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 1"));

    oneGroupContactPreventionSet_0.getFloor().setValue(0.001);

    Boundary boundary_53 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Floor");

    oneGroupContactPreventionSet_0.getBoundaryGroup().setObjects(boundary_4, boundary_5, boundary_53, boundary_32, boundary_33);

    HighlightDisplayer highlightDisplayer_0 = 
      scene_20.getHighlightDisplayer();

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_4, boundary_5, boundary_53, boundary_32, boundary_33);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_1 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 3"));

    oneGroupContactPreventionSet_1.getFloor().setValue(0.005);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_2 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 5"));

    oneGroupContactPreventionSet_2.getBoundaryGroup().setObjects(boundary_13, boundary_14, boundary_15);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_13, boundary_14, boundary_15);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_3 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 7"));

    oneGroupContactPreventionSet_3.getFloor().setValue(0.001);

    oneGroupContactPreventionSet_3.getBoundaryGroup().setObjects(boundary_0, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_36);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_0, boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_36);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_4 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 8"));

    oneGroupContactPreventionSet_4.getBoundaryGroup().setObjects(boundary_0, boundary_3, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_36);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_0, boundary_3, boundary_24, boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_36);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_5 = 
      ((OneGroupContactPreventionSet) region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).getObject("Contact Prevention 10"));

    Boundary boundary_54 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

    oneGroupContactPreventionSet_5.getBoundaryGroup().setObjects(boundary_13, boundary_14, boundary_15, boundary_53, boundary_54, boundary_36, boundary_39, boundary_40, boundary_41);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_13, boundary_14, boundary_15, boundary_53, boundary_54, boundary_36, boundary_39, boundary_40, boundary_41);

    OneGroupContactPreventionSet oneGroupContactPreventionSet_6 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    OneGroupContactPreventionSet oneGroupContactPreventionSet_7 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    OneGroupContactPreventionSet oneGroupContactPreventionSet_8 = 
      region_0.get(MeshValueManager.class).get(ContactPreventionSetManager.class).createOneGroupContactPreventionSet();

    oneGroupContactPreventionSet_6.getFloor().setValue(0.01);

    oneGroupContactPreventionSet_6.getFloor().setValue(0.001);

    oneGroupContactPreventionSet_6.getBoundaryGroup().setObjects(boundary_37, boundary_38);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_37, boundary_38);

    oneGroupContactPreventionSet_7.getFloor().setValue(0.001);

    oneGroupContactPreventionSet_7.getBoundaryGroup().setObjects(boundary_6, boundary_42, boundary_43);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_6, boundary_42, boundary_43);

    oneGroupContactPreventionSet_8.getFloor().setValue(0.001);

    oneGroupContactPreventionSet_8.getBoundaryGroup().setObjects(boundary_0, boundary_2);

    highlightDisplayer_0.getVisibleParts().setObjects(boundary_0, boundary_2);
  }
}
