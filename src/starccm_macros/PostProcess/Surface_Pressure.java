// STAR-CCM+ macro: Surface_Pressure.java
// Written by STAR-CCM+ 9.02.007
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.base.report.*;
import java.io.File;

public class Surface_Pressure extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

	String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
    File dir = new File(Path+getSimulation().getPresentationName());
    dir.mkdir();
/*
    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 1");

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 2");

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 3");

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 4");

    Scene scene_4 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 5");

    Scene scene_5 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 6");

    Scene scene_6 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 7");

    Scene scene_7 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 8");

    Scene scene_8 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 9");

    Scene scene_9 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 10");

    Scene scene_10 = 
      simulation_0.getSceneManager().getScene("Geometry Scene 11");

    Scene scene_11 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 1");

    Scene scene_12 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 2");

    Scene scene_13 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 3");

   Scene scene_14 =
      simulation_0.getSceneManager().getScene("Mesh Scene 4");

    Scene scene_15 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 5");

    Scene scene_16 = 
      simulation_0.getSceneManager().getScene("Mesh Scene 6");

    Scene scene_17 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 1");

    Scene scene_18 = 
      simulation_0.getSceneManager().getScene("Scalar Scene 2");

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_0, scene_1, scene_2, scene_3, scene_4, scene_5, scene_6, scene_7, scene_8, scene_9, scene_10, scene_11, scene_12, scene_13, scene_14, scene_15, scene_16, scene_17, scene_18}));
*/
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

    scene_19.open(true);

    CurrentView currentView_0 = 
      scene_19.getCurrentView();

    PressureCoefficientFunction pressureCoefficientFunction_0 = 
      ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

    pressureCoefficientFunction_0.getReferenceDensity().setValue(1.225);

    Units units_0 = 
      ((Units) simulation_0.getUnitsManager().getObject("kph"));

    pressureCoefficientFunction_0.getReferenceVelocity().setUnits(units_0);

    pressureCoefficientFunction_0.getReferenceVelocity().setValue(40.0);

    partDisplayer_0.setVisibilityOverrideMode(2);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Region");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

    scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2);

    scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(pressureCoefficientFunction_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(0);

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-3.0, 0.0}));

    scalarDisplayer_0.setFillMode(1);
      
    Legend legend_1 =
    scalarDisplayer_0.getLegend();
      
    SpectrumLookupTable spectrumLookupTable_0 =
    ((SpectrumLookupTable) simulation_0.get(LookupTableManager.class).getObject("spectrum"));
      
    legend_1.setLookupTable(spectrumLookupTable_0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5718394368886948, 0.3524731397628784, 0.16807507909834385}), new DoubleVector(new double[] {0.5718394368886948, 0.3524731397628784, -1.685007621890084}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.48375165765773576, 1);
      

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_FW.png"), 1, 1920, 1080);

    Units units_1 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    scene_19.setTransparencyOverrideMode(1);

    scene_19.getCreatorGroup().setObjects(boundary_0, boundary_1, boundary_2);

    StreamDisplayer streamDisplayer_0 = 
      scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

    streamDisplayer_0.initialize();

    scene_19.setTransparencyOverrideMode(1);

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("CellRelativeVelocity"));

    ConstrainedStreamPart constrainedStreamPart_0 = 
      simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2}), new NeoObjectVector(new Object[] {boundary_0, boundary_1, boundary_2}), primitiveFieldFunction_0, 15, 15);

    streamDisplayer_0.getParts().addParts(constrainedStreamPart_0);

    scene_19.setTransparencyOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {0.5900618051205453, 0.2928601859576604, 0.18627519404314352}), new DoubleVector(new double[] {0.5900618051205453, 0.2928601859576604, -1.685007621890084}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.4885028410611597, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_FW_SL.png"), 1, 1920, 1080);
 
    currentView_0.setInput(new DoubleVector(new double[] {0.6360874153762377, 0.3144707194963105, 0.14778449293827842}), new DoubleVector(new double[] {-0.3833799384445631, 0.3144707194963105, 0.14778449293827842}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 0.26613438357376235, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_FW_SL2.png"), 1, 1920, 1080);

    simulation_0.getPartManager().removeObjects(constrainedStreamPart_0);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

    scalarDisplayer_0.getParts().setObjects(boundary_3, boundary_4, boundary_5, boundary_6);

    scene_19.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[] {streamDisplayer_0}));

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-3.0, 0.0}));

    currentView_0.setInput(new DoubleVector(new double[] {-1.7645188167679138, 0.25121406776043015, 0.8452549240481342}), new DoubleVector(new double[] {-1.7645188167679138, 0.25121406776043015, -0.5740331151593243}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.37050852684242563, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_RW.png"), 1, 1920, 1080);

    scene_19.setTransparencyOverrideMode(1);

    scene_19.getCreatorGroup().setObjects();

    scene_19.getCreatorGroup().setObjects(boundary_3, boundary_4, boundary_5, boundary_6);

    StreamDisplayer streamDisplayer_1 = 
      scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

    streamDisplayer_1.initialize();

    scene_19.setTransparencyOverrideMode(1);

    ConstrainedStreamPart constrainedStreamPart_1 = 
      simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[] {boundary_3, boundary_4, boundary_5, boundary_6}), new NeoObjectVector(new Object[] {boundary_3, boundary_4, boundary_5, boundary_6}), primitiveFieldFunction_0, 15,15);

    streamDisplayer_1.getParts().addParts(constrainedStreamPart_1);

    scene_19.setTransparencyOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {-1.7645188167679138, 0.25121406776043015, 0.8452549240481342}), new DoubleVector(new double[] {-1.7645188167679138, 0.25121406776043015, -0.5740331151593243}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.37050852684242563, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_RW_SL.png"), 1, 1920, 1080);

    currentView_0.setInput(new DoubleVector(new double[] {-1.6257864996698341, 0.2733458485214459, 0.8045079474752603}), new DoubleVector(new double[] {-3.6304986044671974, 0.27334584852144583, 0.8045079474752603}), new DoubleVector(new double[] {0.0, 0.0, 1.0}), 0.5233348750732896, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_RW_SL2.png"), 1, 1920, 1080);

    simulation_0.getPartManager().removeObjects(constrainedStreamPart_1);

    scene_19.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[] {streamDisplayer_1}));

    scalarDisplayer_0.getParts().addParts(boundary_3, boundary_4, boundary_5, boundary_6);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

    Boundary boundary_10 = 
      region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

    Boundary boundary_11 = 
      region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

    Boundary boundary_12 = 
      region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

	Boundary boundary_13 = 
      region_0.getBoundaryManager().getBoundary("Airduct.Surface");

    Boundary boundary_14 = 
      region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

    Boundary boundary_15 = 
      region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

    Boundary boundary_16 = 
      region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

    Boundary boundary_17 = 
      region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

    Boundary boundary_18 = 
      region_0.getBoundaryManager().getBoundary("Headrest.Surface");

    Boundary boundary_19 = 
      region_0.getBoundaryManager().getBoundary("MRH.Surface");

    Boundary boundary_20 = 
      region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

    Boundary boundary_21 = 
      region_0.getBoundaryManager().getBoundary("Sidepod.Surface");
/*
    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface [Interface 1]"));
*/
    Boundary boundary_23 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
/*
    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 3 [Interface 2]"));
*/
    Boundary boundary_25 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

    Boundary boundary_26 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

    Boundary boundary_27 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

    Boundary boundary_28 = 
      region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

    Boundary boundary_29 = 
      region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

    Boundary boundary_30 = 
      region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

    Boundary boundary_31 = 
      region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

    Boundary boundary_32 = 
      region_0.getBoundaryManager().getBoundary("TSAL.Surface");
/*
    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");
*/
    Boundary boundary_34 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

    Boundary boundary_35 = 
      region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

    scalarDisplayer_0.getParts().setObjects(boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_0, boundary_1, boundary_2, boundary_18, boundary_19, boundary_3, boundary_4, boundary_5, boundary_6, boundary_20, boundary_21,/* boundary_22, interfaceBoundary_0,*/ boundary_23,/* boundary_24, interfaceBoundary_1,*/ boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, /*boundary_33,*/ boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_34, boundary_35);

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-3.5, 1.0}));

    currentView_0.setInput(new DoubleVector(new double[] {-0.6539756629546167, 0.30506438117607154, 0.073234228377554}), new DoubleVector(new double[] {-0.6539756629546167, 0.30506438117607154, -3.243514390702036}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.8658451355991463, 1);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_UB.png"), 1, 1920, 1080);

    scene_19.setTransparencyOverrideMode(1);

    scene_19.getCreatorGroup().setObjects();

    scene_19.getCreatorGroup().setObjects(boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12);

    StreamDisplayer streamDisplayer_2 = 
      scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

    streamDisplayer_2.initialize();

    scene_19.setTransparencyOverrideMode(1);

    ConstrainedStreamPart constrainedStreamPart_2 = 
      simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[] {boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12}), new NeoObjectVector(new Object[] {boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12}), primitiveFieldFunction_0, 15, 15);

    streamDisplayer_2.getParts().addParts(constrainedStreamPart_2);

    scene_19.setTransparencyOverrideMode(0);

    scene_19.printAndWait(resolvePath(Path+getSimulation().getPresentationName()+ "\\PC_UB_SL.png"), 1, 1920, 1080);

    simulation_0.getPartManager().removeObjects(constrainedStreamPart_2);

    simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[] {scene_19}));
  }
}
