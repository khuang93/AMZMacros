// STAR-CCM+ macro: MeshAndSaveRun.java
// Written by STAR-CCM+ 8.06.005
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;
import star.flow.*;
import star.surfacewrapper.*;
import star.prismmesher.*;
import star.meshing.*;
import star.base.report.*;

import java.io.File;

public class MeshAndRunAndPostAndSave extends StarMacro {

    public void execute() {
        execute0();
    }

    private void execute0() {

//        int maxSteps = 2000;

        Simulation simulation = getActiveSimulation();

        //get the path of the simulation
        String path = simulation.getAbsolutePath(simulation.getSessionDirFile());

        String postprocessingPath = path + File.separator + getSimulation().getPresentationName() + File.separator;
        File dir = new File(postprocessingPath);
        simulation.println("Path is " + postprocessingPath);
        dir.mkdir();

        MeshPipelineController meshPipelineController_0
                = simulation.get(MeshPipelineController.class);

        meshPipelineController_0.generateSurfaceMesh();

        meshPipelineController_0.generateVolumeMesh();
        int iteration = simulation.getSimulationIterator().getCurrentIteration();

//        simulation.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps").get
//        
//        if(iteration < maxSteps)
        simulation.getSimulationIterator().run();
//        else{
//            simulation.println("MaxStep satisfied");
//            new StarScript(getActiveSimulation(), new java.io.File(resolvePath(path+File.separator+"Macros2017"+File.separator+"PostProcess"+File.separator+"TotPressCoeffx.java"))).play();
//        }

        int i = 0;
        do {
            iteration = simulation.getSimulationIterator().getCurrentIteration();
            simulation.println("i=" + i + "iteration=" + iteration);
            if (!simulation.getSimulationIterator().isIterating()) {
                //test, ein skript ausführen
                //new StarScript(getActiveSimulation(), new java.io.File(resolvePath(path+File.separator+"Macros2017"+File.separator+"PostProcess"+File.separator+"TotPressCoeffx.java"))).play();
                //all postprocessing stuffs
                totPressCoeffx(postprocessingPath);
                totPressCoeffy(postprocessingPath);
                Velo_i_and_j(postprocessingPath);
                SurfacePressure(postprocessingPath);
                Plots(postprocessingPath);
            }
        } while (simulation.getSimulationIterator().isIterating());
        iteration = simulation.getSimulationIterator().getCurrentIteration();
        simulation.saveState(resolvePath(getSimulation().getPresentationName()+"_"+iteration)+".sim");

    }

    //TPC_X
    private void totPressCoeffx(String postprocessingPath) {

        Simulation simulation_0
                = getActiveSimulation();
//        String path = simulation_0.getAbsolutePath(simulation_0.getSessionDirFile());
//        
//        String postprocessingPath = path + File.separator + getSimulation().getPresentationName() + File.separator;
//        File dir = new File(postprocessingPath);
//        simulation_0.println("Path is " + postprocessingPath);
//
//	//String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
//        //File dir = new File(Path+getSimulation().getPresentationName());
//    dir.mkdir();

        simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

        Scene scene_19
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        scene_19.initializeAndWait();

        PartDisplayer partDisplayer_1
                = ((PartDisplayer) scene_19.getCreatorDisplayer());

        partDisplayer_1.initialize();

        PartDisplayer partDisplayer_0
                = ((PartDisplayer) scene_19.getDisplayerManager().getDisplayer("Outline 1"));

        partDisplayer_0.initialize();

        ScalarDisplayer scalarDisplayer_0
                = ((ScalarDisplayer) scene_19.getDisplayerManager().getDisplayer("Scalar 1"));

        scalarDisplayer_0.initialize();

        scalarDisplayer_0.setFillMode(1);

        scene_19.open(true);

        CurrentView currentView_0
                = scene_19.getCurrentView();

        currentView_0.setInput(new DoubleVector(new double[]{-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[]{-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 32.093782750985234, 1);

        TotalPressureCoefficientFunction totalPressureCoefficientFunction_0
                = ((TotalPressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressureCoefficient"));

        totalPressureCoefficientFunction_0.getReferenceDensity().setValue(1.225);

        Units units_0
                = ((Units) simulation_0.getUnitsManager().getObject("kph"));

        totalPressureCoefficientFunction_0.getReferenceVelocity().setUnits(units_0);

        totalPressureCoefficientFunction_0.getReferenceVelocity().setValue(40.0);

        scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(totalPressureCoefficientFunction_0);

        Region region_0
                = simulation_0.getRegionManager().getRegion("Region");

        Boundary boundary_0
                = region_0.getBoundaryManager().getBoundary("Subtract.Floor");

        Boundary boundary_1
                = region_0.getBoundaryManager().getBoundary("Subtract.Inlet");

        Boundary boundary_2
                = region_0.getBoundaryManager().getBoundary("Subtract.Outlet");

        Boundary boundary_3
                = region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

        scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

        Units units_1
                = simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        scene_19.setTransparencyOverrideMode(1);

        Region region_1
                = simulation_0.getRegionManager().getRegion("RegionRadiator");

        scene_19.getCreatorGroup().setObjects(region_1, region_0);

        PartDisplayer partDisplayer_2
                = scene_19.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

        partDisplayer_2.initialize();

        partDisplayer_2.setVisibilityOverrideMode(2);

        scene_19.setTransparencyOverrideMode(1);

// Ebene wird eingefügt
        PlaneSection planeSection_0
                = (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[]{region_1, region_0}), new DoubleVector(new double[]{1.0, 0.0, 0.0}), new DoubleVector(new double[]{0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[]{0.0}));

        LabCoordinateSystem labCoordinateSystem_0
                = simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

        planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

        Coordinate coordinate_0
                = planeSection_0.getOriginCoordinate();

        coordinate_0.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        Coordinate coordinate_1
                = planeSection_0.getOrientationCoordinate();

        coordinate_1.setCoordinate(units_1, units_1, units_1, new DoubleVector(new double[]{1.0, 0.0, 0.0}));

        coordinate_1.setValue(new DoubleVector(new double[]{1.0, 0.0, 0.0}));

        coordinate_0.setValue(new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        SingleValue singleValue_0
                = planeSection_0.getSingleValue();

        singleValue_0.getValueQuantity().setValue(0.0);

        singleValue_0.getValueQuantity().setUnits(units_1);

        RangeMultiValue rangeMultiValue_0
                = planeSection_0.getRangeMultiValue();

        rangeMultiValue_0.setNValues(2);

        rangeMultiValue_0.getStartQuantity().setValue(0.0);

        rangeMultiValue_0.getStartQuantity().setUnits(units_1);

        rangeMultiValue_0.getEndQuantity().setValue(1.0);

        rangeMultiValue_0.getEndQuantity().setUnits(units_1);

        DeltaMultiValue deltaMultiValue_0
                = planeSection_0.getDeltaMultiValue();

        deltaMultiValue_0.setNValues(2);

        deltaMultiValue_0.getStartQuantity().setValue(0.0);

        deltaMultiValue_0.getStartQuantity().setUnits(units_1);

        deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

        deltaMultiValue_0.getDeltaQuantity().setUnits(units_1);

        MultiValue multiValue_0
                = planeSection_0.getArbitraryMultiValue();

        multiValue_0.getValueQuantities().setUnits(units_1);

        multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[]{0.0}));

        planeSection_0.setValueMode(0);

        partDisplayer_2.getParts().addParts(planeSection_0);

        scene_19.setTransparencyOverrideMode(0);

        scalarDisplayer_0.getParts().setObjects(planeSection_0);

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-0.9, 1.4}));

        partDisplayer_0.setVisibilityOverrideMode(2);

        currentView_0.setInput(new DoubleVector(new double[]{0.7048695285137621, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[]{-4.202606419819978, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 1.2811082978949793, 1);

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
        double x = 1.00;
        for (int i = 1; x > -2.06; x = x - 0.04) {

            coordinate_0.setValue(new DoubleVector(new double[]{x, 0.0, 0.0}));
            scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "TPC_X" + (i) + "_x=" + (840 - i * 40) + ".png"), 1, 4096, 2160);
            i++;
        }

        Scene scene_14
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[]{scene_14}));

        PlaneSection planeSection_1
                = ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

        simulation_0.getPartManager().removeObjects(planeSection_0);

    }

    //TPC_Y
    private void totPressCoeffy(String postprocessingPath) {

        Simulation simulation_0
                = getActiveSimulation();

//	String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
//    File dir = new File(Path+getSimulation().getPresentationName());
//    dir.mkdir();
        simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

        Scene scene_1
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        scene_1.initializeAndWait();

        PartDisplayer partDisplayer_1
                = ((PartDisplayer) scene_1.getCreatorDisplayer());

        partDisplayer_1.initialize();

        PartDisplayer partDisplayer_0
                = ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

        partDisplayer_0.initialize();

        ScalarDisplayer scalarDisplayer_0
                = ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

        scalarDisplayer_0.initialize();

        scalarDisplayer_0.setFillMode(1);

        scene_1.open(true);

        CurrentView currentView_1
                = scene_1.getCurrentView();

        currentView_1.setInput(new DoubleVector(new double[]{-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[]{-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 32.093782750985234, 1);

        Region region_0
                = simulation_0.getRegionManager().getRegion("Region");

        Boundary boundary_0
                = region_0.getBoundaryManager().getBoundary("Subtract.Floor");

        Boundary boundary_1
                = region_0.getBoundaryManager().getBoundary("Subtract.Inlet");

        Boundary boundary_2
                = region_0.getBoundaryManager().getBoundary("Subtract.Outlet");

        Boundary boundary_3
                = region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

        scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

        TotalPressureCoefficientFunction totalPressureCoefficientFunction_0
                = ((TotalPressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("TotalPressureCoefficient"));

        scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(totalPressureCoefficientFunction_0);

        Units units_0
                = simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        scene_1.setTransparencyOverrideMode(1);

        Region region_1
                = simulation_0.getRegionManager().getRegion("RegionRadiator");

        scene_1.getCreatorGroup().setObjects(region_1, region_0);

        PartDisplayer partDisplayer_2
                = scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

        partDisplayer_2.setVisibilityOverrideMode(2);

        partDisplayer_2.initialize();

        scene_1.setTransparencyOverrideMode(1);

        PlaneSection planeSection_1
                = (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[]{region_1, region_0}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), new DoubleVector(new double[]{0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[]{0.0}));

        LabCoordinateSystem labCoordinateSystem_0
                = simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

        planeSection_1.setCoordinateSystem(labCoordinateSystem_0);

        Coordinate coordinate_0
                = planeSection_1.getOriginCoordinate();

        coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        Coordinate coordinate_1
                = planeSection_1.getOrientationCoordinate();

        coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[]{0.0, 1.0, 0.0}));

        coordinate_1.setValue(new DoubleVector(new double[]{0.0, 1.0, 0.0}));

        coordinate_0.setValue(new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        SingleValue singleValue_0
                = planeSection_1.getSingleValue();

        singleValue_0.getValueQuantity().setValue(0.0);

        singleValue_0.getValueQuantity().setUnits(units_0);

        RangeMultiValue rangeMultiValue_0
                = planeSection_1.getRangeMultiValue();

        rangeMultiValue_0.setNValues(2);

        rangeMultiValue_0.getStartQuantity().setValue(0.0);

        rangeMultiValue_0.getStartQuantity().setUnits(units_0);

        rangeMultiValue_0.getEndQuantity().setValue(1.0);

        rangeMultiValue_0.getEndQuantity().setUnits(units_0);

        DeltaMultiValue deltaMultiValue_0
                = planeSection_1.getDeltaMultiValue();

        deltaMultiValue_0.setNValues(2);

        deltaMultiValue_0.getStartQuantity().setValue(0.0);

        deltaMultiValue_0.getStartQuantity().setUnits(units_0);

        deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

        deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

        MultiValue multiValue_0
                = planeSection_1.getArbitraryMultiValue();

        multiValue_0.getValueQuantities().setUnits(units_0);

        multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[]{0.0}));

        planeSection_1.setValueMode(0);

        partDisplayer_2.getParts().addParts(planeSection_1);

        scene_1.setTransparencyOverrideMode(0);

        scalarDisplayer_0.getParts().setObjects(planeSection_1);

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-0.9, 1.4}));

        partDisplayer_0.setVisibilityOverrideMode(2);

        currentView_1.setInput(new DoubleVector(new double[]{-0.7581506549371939, 0.05092497124031237, 0.4818598847457906}), new DoubleVector(new double[]{-1.1038091190545234, -3.525637834448671, 0.23150441096690028}), new DoubleVector(new double[]{-0.012917526652369593, -0.06857982598891467, 0.9975620005656369}), 0.9402945681630441, 0);

        double y = 0.00;
        for (int i = 1; y < 0.90; y = y + 0.01) {
            coordinate_0.setValue(new DoubleVector(new double[]{0.0, y, 0.0}));
            scene_1.printAndWait(resolvePath(postprocessingPath + File.separator + "TPC_Y" + i + "_y=" + (i) + ".png"), 1, 1920, 1080);
            i = i + 1;
        }

        Scene scene_5
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[]{scene_5}));

        PlaneSection planeSection_0
                = ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

        simulation_0.getPartManager().removeObjects(planeSection_0);

    }

    //Vi und Vj
    private void Velo_i_and_j(String postprocessingPath) {

        Simulation simulation_0
                = getActiveSimulation();

//        String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
//        File dir = new File(Path + getSimulation().getPresentationName());
//        dir.mkdir();

        simulation_0.getSceneManager().createScalarScene("Scalar Scene", "Outline", "Scalar");

        Scene scene_1
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        scene_1.initializeAndWait();

        PartDisplayer partDisplayer_1
                = ((PartDisplayer) scene_1.getCreatorDisplayer());

        partDisplayer_1.initialize();

        PartDisplayer partDisplayer_0
                = ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

        partDisplayer_0.initialize();

        ScalarDisplayer scalarDisplayer_0
                = ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

        scalarDisplayer_0.initialize();

        scene_1.open(true);

        CurrentView currentView_0
                = scene_1.getCurrentView();

        currentView_0.setInput(new DoubleVector(new double[]{-10.0, 7.5, 7.502499999944121}), new DoubleVector(new double[]{-10.0, 7.5, 130.44250998996569}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 32.093782750985234, 1);

        PrimitiveFieldFunction primitiveFieldFunction_0
                = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("Velocity"));

        VectorComponentFieldFunction vectorComponentFieldFunction_i
                = ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(0));

        scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_i);

        partDisplayer_0.setVisibilityOverrideMode(2);

        Region region_0
                = simulation_0.getRegionManager().getRegion("Region");

        Boundary boundary_0
                = region_0.getBoundaryManager().getBoundary("Subtract.Floor");

        Boundary boundary_1
                = region_0.getBoundaryManager().getBoundary("Subtract.Inlet");

        Boundary boundary_2
                = region_0.getBoundaryManager().getBoundary("Subtract.Outlet");

        Boundary boundary_3
                = region_0.getBoundaryManager().getBoundary("Subtract.Symmetry");

        scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3);

        Units units_0
                = simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        scene_1.setTransparencyOverrideMode(1);

        Region region_1
                = simulation_0.getRegionManager().getRegion("RegionRadiator");

        scene_1.getCreatorGroup().setObjects(region_1, region_0);

        PartDisplayer partDisplayer_2
                = scene_1.getDisplayerManager().createPartDisplayer("Section Geometry", -1, 1);

        partDisplayer_2.setVisibilityOverrideMode(2);

        partDisplayer_2.initialize();

        scene_1.setTransparencyOverrideMode(1);

        PlaneSection planeSection_0
                = (PlaneSection) simulation_0.getPartManager().createImplicitPart(new NeoObjectVector(new Object[]{region_1, region_0}), new DoubleVector(new double[]{1.0, 0.0, 0.0}), new DoubleVector(new double[]{0.0, 0.0, 0.0}), 0, 1, new DoubleVector(new double[]{0.0}));

        LabCoordinateSystem labCoordinateSystem_0
                = simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

        planeSection_0.setCoordinateSystem(labCoordinateSystem_0);

        Coordinate coordinate_0
                = planeSection_0.getOriginCoordinate();

        coordinate_0.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        Coordinate coordinate_1
                = planeSection_0.getOrientationCoordinate();

        coordinate_1.setCoordinate(units_0, units_0, units_0, new DoubleVector(new double[]{1.0, 0.0, 0.0}));

        coordinate_1.setValue(new DoubleVector(new double[]{1.0, 0.0, 0.0}));

        coordinate_0.setValue(new DoubleVector(new double[]{0.0, 0.0, 0.0}));

        SingleValue singleValue_0
                = planeSection_0.getSingleValue();

        singleValue_0.getValueQuantity().setValue(0.0);

        singleValue_0.getValueQuantity().setUnits(units_0);

        RangeMultiValue rangeMultiValue_0
                = planeSection_0.getRangeMultiValue();

        rangeMultiValue_0.setNValues(2);

        rangeMultiValue_0.getStartQuantity().setValue(0.0);

        rangeMultiValue_0.getStartQuantity().setUnits(units_0);

        rangeMultiValue_0.getEndQuantity().setValue(1.0);

        rangeMultiValue_0.getEndQuantity().setUnits(units_0);

        DeltaMultiValue deltaMultiValue_0
                = planeSection_0.getDeltaMultiValue();

        deltaMultiValue_0.setNValues(2);

        deltaMultiValue_0.getStartQuantity().setValue(0.0);

        deltaMultiValue_0.getStartQuantity().setUnits(units_0);

        deltaMultiValue_0.getDeltaQuantity().setValue(1.0);

        deltaMultiValue_0.getDeltaQuantity().setUnits(units_0);

        MultiValue multiValue_0
                = planeSection_0.getArbitraryMultiValue();

        multiValue_0.getValueQuantities().setUnits(units_0);

        multiValue_0.getValueQuantities().setArray(new DoubleVector(new double[]{0.0}));

        planeSection_0.setValueMode(0);

        partDisplayer_2.getParts().addParts(planeSection_0);

        scene_1.setTransparencyOverrideMode(0);

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-20.0, 5.0}));

        scalarDisplayer_0.getParts().setObjects(planeSection_0);

        scalarDisplayer_0.setFillMode(1);

        currentView_0.setInput(new DoubleVector(new double[]{0.7048695285137621, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[]{-4.202606419819978, 0.2736022990136666, 0.578489882867487}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 1.2811082978949793, 1);

        double x = 0.80;
        for (int i = 1; x > -2.06; x = x - 0.04) {

            coordinate_0.setValue(new DoubleVector(new double[]{x, 0.0, 0.0}));
            scene_1.printAndWait(resolvePath(postprocessingPath + File.separator + "Vi_X" + (i) + "_x=" + (840 - i * 40) + ".png"), 1, 1920, 1080);
            i++;

        }

        //set Fieldfunction to Vj
        VectorComponentFieldFunction vectorComponentFieldFunction_j
                = ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(1));

        scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_j);
        for (int i = 1; x > -2.06; x = x - 0.04) {

            coordinate_0.setValue(new DoubleVector(new double[]{x, 0.0, 0.0}));
            scene_1.printAndWait(resolvePath(postprocessingPath + File.separator + "Vj_X" + (i) + "_x=" + (840 - i * 40) + ".png"), 1, 1920, 1080);
            i++;
        }

        Scene scene_16
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[]{scene_16}));

        PlaneSection planeSection_1
                = ((PlaneSection) simulation_0.getPartManager().getObject("plane section"));

        simulation_0.getPartManager().removeObjects(planeSection_1);
    }

    private void SurfacePressure(String postprocessingPath) {

        Simulation simulation_0
                = getActiveSimulation();

//        String Path = "Z:\\StarCCM\\Auto 2016\\Aero\\PostProcess\\";
//        File dir = new File(Path + getSimulation().getPresentationName());
//        dir.mkdir();
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

        Scene scene_19
                = simulation_0.getSceneManager().getScene("Scalar Scene 1");

        scene_19.initializeAndWait();

        PartDisplayer partDisplayer_1
                = ((PartDisplayer) scene_19.getCreatorDisplayer());

        partDisplayer_1.initialize();

        PartDisplayer partDisplayer_0
                = ((PartDisplayer) scene_19.getDisplayerManager().getDisplayer("Outline 1"));

        partDisplayer_0.initialize();

        ScalarDisplayer scalarDisplayer_0
                = ((ScalarDisplayer) scene_19.getDisplayerManager().getDisplayer("Scalar 1"));

        scalarDisplayer_0.initialize();

        scene_19.open(true);

        CurrentView currentView_0
                = scene_19.getCurrentView();

        PressureCoefficientFunction pressureCoefficientFunction_0
                = ((PressureCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("PressureCoefficient"));

        pressureCoefficientFunction_0.getReferenceDensity().setValue(1.225);

        Units units_0
                = ((Units) simulation_0.getUnitsManager().getObject("kph"));

        pressureCoefficientFunction_0.getReferenceVelocity().setUnits(units_0);

        pressureCoefficientFunction_0.getReferenceVelocity().setValue(40.0);

        partDisplayer_0.setVisibilityOverrideMode(2);

        Region region_0
                = simulation_0.getRegionManager().getRegion("Region");

        Boundary boundary_0
                = region_0.getBoundaryManager().getBoundary("FW_Endplates.Surface");

        Boundary boundary_1
                = region_0.getBoundaryManager().getBoundary("FW_Flap1.Surface");

        Boundary boundary_2
                = region_0.getBoundaryManager().getBoundary("FW_Main.Surface");

        scalarDisplayer_0.getParts().setObjects(boundary_0, boundary_1, boundary_2);

        scalarDisplayer_0.getScalarDisplayQuantity().setFieldFunction(pressureCoefficientFunction_0);

        scalarDisplayer_0.getScalarDisplayQuantity().setClip(0);

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-3.0, 0.0}));

        scalarDisplayer_0.setFillMode(1);

        Legend legend_1
                = scalarDisplayer_0.getLegend();

        SpectrumLookupTable spectrumLookupTable_0
                = ((SpectrumLookupTable) simulation_0.get(LookupTableManager.class).getObject("spectrum"));

        legend_1.setLookupTable(spectrumLookupTable_0);

        currentView_0.setInput(new DoubleVector(new double[]{0.5718394368886948, 0.3524731397628784, 0.16807507909834385}), new DoubleVector(new double[]{0.5718394368886948, 0.3524731397628784, -1.685007621890084}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 0.48375165765773576, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_FW.png"), 1, 1920, 1080);

        Units units_1
                = simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        scene_19.setTransparencyOverrideMode(1);

        scene_19.getCreatorGroup().setObjects(boundary_0, boundary_1, boundary_2);

        StreamDisplayer streamDisplayer_0
                = scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

        streamDisplayer_0.initialize();

        scene_19.setTransparencyOverrideMode(1);

        PrimitiveFieldFunction primitiveFieldFunction_0
                = ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("CellRelativeVelocity"));

        ConstrainedStreamPart constrainedStreamPart_0
                = simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[]{boundary_0, boundary_1, boundary_2}), new NeoObjectVector(new Object[]{boundary_0, boundary_1, boundary_2}), primitiveFieldFunction_0, 15, 15);

        streamDisplayer_0.getParts().addParts(constrainedStreamPart_0);

        scene_19.setTransparencyOverrideMode(0);

        currentView_0.setInput(new DoubleVector(new double[]{0.5900618051205453, 0.2928601859576604, 0.18627519404314352}), new DoubleVector(new double[]{0.5900618051205453, 0.2928601859576604, -1.685007621890084}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 0.4885028410611597, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_FW_SL.png"), 1, 1920, 1080);

        currentView_0.setInput(new DoubleVector(new double[]{0.6360874153762377, 0.3144707194963105, 0.14778449293827842}), new DoubleVector(new double[]{-0.3833799384445631, 0.3144707194963105, 0.14778449293827842}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 0.26613438357376235, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_FW_SL2.png"), 1, 1920, 1080);

        simulation_0.getPartManager().removeObjects(constrainedStreamPart_0);

        Boundary boundary_3
                = region_0.getBoundaryManager().getBoundary("RW_Endplates.Surface");

        Boundary boundary_4
                = region_0.getBoundaryManager().getBoundary("RW_Flap1.Surface");

        Boundary boundary_5
                = region_0.getBoundaryManager().getBoundary("RW_Flap2.Surface");

        Boundary boundary_6
                = region_0.getBoundaryManager().getBoundary("RW_Main.Surface");

        scalarDisplayer_0.getParts().setObjects(boundary_3, boundary_4, boundary_5, boundary_6);

        scene_19.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[]{streamDisplayer_0}));

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-3.0, 0.0}));

        currentView_0.setInput(new DoubleVector(new double[]{-1.7645188167679138, 0.25121406776043015, 0.8452549240481342}), new DoubleVector(new double[]{-1.7645188167679138, 0.25121406776043015, -0.5740331151593243}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 0.37050852684242563, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_RW.png"), 1, 1920, 1080);

        scene_19.setTransparencyOverrideMode(1);

        scene_19.getCreatorGroup().setObjects();

        scene_19.getCreatorGroup().setObjects(boundary_3, boundary_4, boundary_5, boundary_6);

        StreamDisplayer streamDisplayer_1
                = scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

        streamDisplayer_1.initialize();

        scene_19.setTransparencyOverrideMode(1);

        ConstrainedStreamPart constrainedStreamPart_1
                = simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[]{boundary_3, boundary_4, boundary_5, boundary_6}), new NeoObjectVector(new Object[]{boundary_3, boundary_4, boundary_5, boundary_6}), primitiveFieldFunction_0, 15, 15);

        streamDisplayer_1.getParts().addParts(constrainedStreamPart_1);

        scene_19.setTransparencyOverrideMode(0);

        currentView_0.setInput(new DoubleVector(new double[]{-1.7645188167679138, 0.25121406776043015, 0.8452549240481342}), new DoubleVector(new double[]{-1.7645188167679138, 0.25121406776043015, -0.5740331151593243}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 0.37050852684242563, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_RW_SL.png"), 1, 1920, 1080);

        currentView_0.setInput(new DoubleVector(new double[]{-1.6257864996698341, 0.2733458485214459, 0.8045079474752603}), new DoubleVector(new double[]{-3.6304986044671974, 0.27334584852144583, 0.8045079474752603}), new DoubleVector(new double[]{0.0, 0.0, 1.0}), 0.5233348750732896, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_RW_SL2.png"), 1, 1920, 1080);

        simulation_0.getPartManager().removeObjects(constrainedStreamPart_1);

        scene_19.getDisplayerManager().deleteDisplayers(new NeoObjectVector(new Object[]{streamDisplayer_1}));

        scalarDisplayer_0.getParts().addParts(boundary_3, boundary_4, boundary_5, boundary_6);

        Boundary boundary_7
                = region_0.getBoundaryManager().getBoundary("UB_Diffusor.Surface");

        Boundary boundary_8
                = region_0.getBoundaryManager().getBoundary("UB_F1.Surface");

        Boundary boundary_9
                = region_0.getBoundaryManager().getBoundary("UB_F2.Surface");

        Boundary boundary_10
                = region_0.getBoundaryManager().getBoundary("UB_hor.Surface");

        Boundary boundary_11
                = region_0.getBoundaryManager().getBoundary("UB_MC.Surface");

        Boundary boundary_12
                = region_0.getBoundaryManager().getBoundary("UB_ver.Surface");

        Boundary boundary_13
                = region_0.getBoundaryManager().getBoundary("Airduct.Surface");

        Boundary boundary_14
                = region_0.getBoundaryManager().getBoundary("Body_Driver.Surface");

        Boundary boundary_15
                = region_0.getBoundaryManager().getBoundary("Body_MC.Surface");

        Boundary boundary_16
                = region_0.getBoundaryManager().getBoundary("Body_QJ.Surface");

        Boundary boundary_17
                = region_0.getBoundaryManager().getBoundary("Drivetrain.Surface");

        Boundary boundary_18
                = region_0.getBoundaryManager().getBoundary("Headrest.Surface");

        Boundary boundary_19
                = region_0.getBoundaryManager().getBoundary("MRH.Surface");

        Boundary boundary_20
                = region_0.getBoundaryManager().getBoundary("RW_Support.Surface");

        Boundary boundary_21
                = region_0.getBoundaryManager().getBoundary("Sidepod.Surface");
        /*
    Boundary boundary_22 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface");

    InterfaceBoundary interfaceBoundary_0 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface [Interface 1]"));
         */
        Boundary boundary_23
                = region_0.getBoundaryManager().getBoundary("Subtract.Surface 2");
        /*
    Boundary boundary_24 = 
      region_0.getBoundaryManager().getBoundary("Subtract.Surface 3");

    InterfaceBoundary interfaceBoundary_1 = 
      ((InterfaceBoundary) region_0.getBoundaryManager().getBoundary("Subtract.Surface 3 [Interface 2]"));
         */
        Boundary boundary_25
                = region_0.getBoundaryManager().getBoundary("Subtract.Surface 4");

        Boundary boundary_26
                = region_0.getBoundaryManager().getBoundary("Subtract.Surface 5");

        Boundary boundary_27
                = region_0.getBoundaryManager().getBoundary("Subtract.Surface 6");

        Boundary boundary_28
                = region_0.getBoundaryManager().getBoundary("Susp_Brackets.Surface");

        Boundary boundary_29
                = region_0.getBoundaryManager().getBoundary("Susp_Legs.Surface");

        Boundary boundary_30
                = region_0.getBoundaryManager().getBoundary("Tire_Front.Surface");

        Boundary boundary_31
                = region_0.getBoundaryManager().getBoundary("Tire_Rear.Surface");

        Boundary boundary_32
                = region_0.getBoundaryManager().getBoundary("TSAL.Surface");
        /*
    Boundary boundary_33 = 
      region_0.getBoundaryManager().getBoundary("Tubes.Surface");
         */
        Boundary boundary_34
                = region_0.getBoundaryManager().getBoundary("Wheel_Front.Surface");

        Boundary boundary_35
                = region_0.getBoundaryManager().getBoundary("Wheel_Rear.Surface");

        scalarDisplayer_0.getParts().setObjects(boundary_13, boundary_14, boundary_15, boundary_16, boundary_17, boundary_0, boundary_1, boundary_2, boundary_18, boundary_19, boundary_3, boundary_4, boundary_5, boundary_6, boundary_20, boundary_21,/* boundary_22, interfaceBoundary_0,*/ boundary_23,/* boundary_24, interfaceBoundary_1,*/ boundary_25, boundary_26, boundary_27, boundary_28, boundary_29, boundary_30, boundary_31, boundary_32, /*boundary_33,*/ boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12, boundary_34, boundary_35);

        scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[]{-3.5, 1.0}));

        currentView_0.setInput(new DoubleVector(new double[]{-0.6539756629546167, 0.30506438117607154, 0.073234228377554}), new DoubleVector(new double[]{-0.6539756629546167, 0.30506438117607154, -3.243514390702036}), new DoubleVector(new double[]{0.0, 1.0, 0.0}), 0.8658451355991463, 1);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator+ "PC_UB.png"), 1, 1920, 1080);

    scene_19.setTransparencyOverrideMode(1);

        scene_19.getCreatorGroup().setObjects();

        scene_19.getCreatorGroup().setObjects(boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12);

        StreamDisplayer streamDisplayer_2
                = scene_19.getDisplayerManager().createStreamDisplayer("ConstrainedStreamline Stream");

        streamDisplayer_2.initialize();

        scene_19.setTransparencyOverrideMode(1);

        ConstrainedStreamPart constrainedStreamPart_2
                = simulation_0.getPartManager().createConstrainedStreamPart(new NeoObjectVector(new Object[]{boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12}), new NeoObjectVector(new Object[]{boundary_7, boundary_8, boundary_9, boundary_10, boundary_11, boundary_12}), primitiveFieldFunction_0, 15, 15);

        streamDisplayer_2.getParts().addParts(constrainedStreamPart_2);

        scene_19.setTransparencyOverrideMode(0);

        scene_19.printAndWait(resolvePath(postprocessingPath + File.separator + "PC_UB_SL.png"), 1, 1920, 1080);

        simulation_0.getPartManager().removeObjects(constrainedStreamPart_2);

        simulation_0.getSceneManager().deleteScenes(new NeoObjectVector(new Object[]{scene_19}));
    }

    private void Plots(String postprocessingPath) {

        Simulation simulation_0
                = getActiveSimulation();

//        String Path = "Z:\\StarCCM\\Auto 2017\\Aero\\PostProcess\\";
//        File dir = new File(Path + getSimulation().getPresentationName());
//        dir.mkdir();

        ReportMonitor reportMonitor_0
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag FW Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator + "DragFW.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_0}));

        ReportMonitor reportMonitor_1
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"Drag.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_1}));

        ReportMonitor reportMonitor_2
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag RW Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator + "DragRW.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_2}));

        ReportMonitor reportMonitor_3
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Drag UB Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator + "DragUB.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_3}));

        ReportMonitor reportMonitor_4
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift FW Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"LiftFW.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_4}));

        ReportMonitor reportMonitor_5
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"Lift.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_5}));

        ReportMonitor reportMonitor_6
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift RW Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"LiftRW.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_6}));

        ReportMonitor reportMonitor_10
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Force 35 Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"LiftFC.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_10}));

        ReportMonitor reportMonitor_7
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Lift UB Monitor"));

        MonitorPlot monitorPlot_0
                = simulation_0.getPlotManager().createMonitorPlot(new NeoObjectVector(new Object[]{reportMonitor_7}), "Lift UB Monitor Plot");

        monitorPlot_0.open();

        simulation_0.getPlotManager().deletePlots(new NeoObjectVector(new Object[]{monitorPlot_0}));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"LiftUB.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_7}));

        ReportMonitor reportMonitor_8
                = ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("Moment pitch Monitor"));

        simulation_0.getMonitorManager().export(resolvePath(postprocessingPath + File.separator +"MomentPitch.csv"), ",", new NeoObjectVector(new Object[]{reportMonitor_8}));
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
        MonitorPlot monitorPlot_1
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag FW Monitor Plot"));

        Axes axes_1
                = monitorPlot_1.getAxes();

        Axis axis_1
                = axes_1.getYAxis();

        AxisLabels axisLabels_1
                = axis_1.getLabels();

        axisLabels_1.setMin(-10.0);

        axisLabels_1.setMax(0.0);

        monitorPlot_1.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Drag FW Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_2
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag Monitor Plot"));

        Axes axes_2
                = monitorPlot_2.getAxes();

        Axis axis_2
                = axes_2.getYAxis();

        AxisLabels axisLabels_2
                = axis_2.getLabels();

        axisLabels_2.setMin(-60.0);

        axisLabels_2.setMax(-50.0);

        monitorPlot_2.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Drag Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_3
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag RW Monitor Plot"));

        Axes axes_3
                = monitorPlot_3.getAxes();

        Axis axis_3
                = axes_3.getYAxis();

        AxisLabels axisLabels_3
                = axis_3.getLabels();

        axisLabels_3.setMin(-30.0);

        axisLabels_3.setMax(-10.0);

        monitorPlot_3.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Drag RW Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_4
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Drag UB Monitor Plot"));

        Axes axes_4
                = monitorPlot_4.getAxes();

        Axis axis_4
                = axes_4.getYAxis();

        AxisLabels axisLabels_4
                = axis_4.getLabels();

        axisLabels_4.setMin(-10.0);

        axisLabels_4.setMax(0.0);

        monitorPlot_4.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Drag UB Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_5
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift FW Monitor Plot"));

        Axes axes_5
                = monitorPlot_5.getAxes();

        Axis axis_5
                = axes_5.getYAxis();

        AxisLabels axisLabels_5
                = axis_5.getLabels();

        axisLabels_5.setMin(-50.0);

        axisLabels_5.setMax(-30.0);

        monitorPlot_5.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Lift FW Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_6
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift Monitor Plot"));

        //Verstellen der Axen
        Axes axes_6
                = monitorPlot_6.getAxes();

        Axis axis_6
                = axes_6.getYAxis();

        AxisLabels axisLabels_6
                = axis_6.getLabels();

        axisLabels_6.setMin(-130.0);

        axisLabels_6.setMax(-100.0);

        monitorPlot_6.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Lift Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_7
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift RW Monitor Plot"));

        Axes axes_7
                = monitorPlot_7.getAxes();

        Axis axis_7
                = axes_7.getYAxis();

        AxisLabels axisLabels_7
                = axis_7.getLabels();

        axisLabels_7.setMin(-60.0);

        axisLabels_7.setMax(-40.0);

        monitorPlot_7.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Lift RW Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_8
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Lift UB Monitor Plot"));

        Axes axes_8
                = monitorPlot_8.getAxes();

        Axis axis_8
                = axes_8.getYAxis();

        AxisLabels axisLabels_8
                = axis_8.getLabels();

        axisLabels_8.setMin(-60.0);

        axisLabels_8.setMax(-40.0);

        monitorPlot_8.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Lift UB Monitor Plot.png"), "png", 1089, 500);

        MonitorPlot monitorPlot_9
                = ((MonitorPlot) simulation_0.getPlotManager().getPlot("Moment pitch Monitor Plot"));

        Axes axes_9
                = monitorPlot_9.getAxes();

        Axis axis_9
                = axes_9.getYAxis();

        AxisLabels axisLabels_9
                = axis_9.getLabels();

        axisLabels_9.setMin(-120.0);

        axisLabels_9.setMax(-80.0);

        monitorPlot_9.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Moment pitch Monitor Plot.png"), "png", 1089, 500);

        ResidualPlot residualPlot_0
                = ((ResidualPlot) simulation_0.getPlotManager().getPlot("Residuals"));

        Axes axes_0
                = residualPlot_0.getAxes();

        Axis axis_0
                = axes_0.getYAxis();

        AxisLabels axisLabels_0
                = axis_0.getLabels();

        axisLabels_0.setMin(0.000001);

        axisLabels_0.setMax(1.0);

        residualPlot_0.encode(resolvePath(postprocessingPath + File.separator + getSimulation().getPresentationName() + "_Residuals.png"), "png", 1089, 500);

    }

}
