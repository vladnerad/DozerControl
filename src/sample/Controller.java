package sample;

import database.*;
import entitiesToSave.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    private Stage stage;
    private Brands brands;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Label stateLabel;
    @FXML
    private ComboBox<String> cbConcrHMtype;
    @FXML
    private ComboBox<String> cbConcrHPtype;
    @FXML
    private ComboBox<String> cbPumpType;
    @FXML
    private TextField tfPumpLsn;
    @FXML
    private TextField tfPumpRsn;
    @FXML
    private ComboBox<String> cbHMotType;
    @FXML
    private TextField tfHMLsn;
    @FXML
    private TextField tfHMRsn;
    @FXML
    private TextField tfDozSerial;
    @FXML
    private Button btnSearch;
    @FXML
    private MenuItem newPassp;
    @FXML
    private MenuItem passView;
    @FXML
    private Button btnAdd;
    @FXML
    private ComboBox<String> cbPlanetReduct;
    @FXML
    private ComboBox<String> cbPumpReduct;
    @FXML
    private ButtonBar bbView;
    @FXML
    private ButtonBar bbAdd;
    @FXML
    private ComboBox<String> cbConcrPlRed;
    @FXML
    private Button btnSave;
    @FXML
    private TextField tfHPRedSN;
    @FXML
    private TextField tfPlRsnR;
    @FXML
    private TextField tfPlRsnL;
    @FXML
    private Button btnCancel;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabTransmission;
    @FXML
    private Tab tabDisel;
    @FXML
    private ComboBox<String> cbDiselType;
    @FXML
    private TextField tfDiselSN;
    @FXML
    private TextField tfTurboCompSN;
    @FXML
    private TextField tfTNVDSN;
    //Coolant tab
    @FXML
    private ComboBox<String> cbDiselCooler;
    @FXML
    private ComboBox<String> cbDiselOilCooler;
    @FXML
    private ComboBox<String> cbHydOilCooler;
    @FXML
    private ComboBox<String> cbAirCondCooler;
    @FXML
    private ComboBox<String> cbWingDrive;
    @FXML
    private ComboBox<String> cbPreHeater;
    @FXML
    private TextField tfPreHeaterSN;
    @FXML
    private ComboBox<String> cbWing;
    @FXML
    private ComboBox<String> cbCoolantDoc;
    @FXML
    private Tab tabCoolant;
    //Attachments tab
    @FXML
    private Tab tabAttachments;
    @FXML
    private ComboBox<String> cbAttachPump;
    @FXML
    private ComboBox<String> cbFanPump;
    @FXML
    private ComboBox<String> cbFanHMot;
    @FXML
    private ComboBox<String> cbHydDistrib;
    @FXML
    private ComboBox<String> cbFrontAttachDoc;
    @FXML
    private ComboBox<String> cbBackAttachDoc;
    @FXML
    private ComboBox<String> cbWinch;
    @FXML
    private ComboBox<String> cbHydLockSkew;
    @FXML
    private ComboBox<String> cbHCOtvLift;
    @FXML
    private ComboBox<String> cbHCOtvSkew;
    @FXML
    private ComboBox<String> cbHCRipper;
    @FXML
    private ComboBox<String> cbHCExtra;
    @FXML
    private TextField tfAttachPump;
    @FXML
    private TextField tfFanPump;
    @FXML
    private TextField tfFanMot;
    @FXML
    private TextField tfHydDistributor;
    //Bogies tab
    @FXML
    private Tab tabBogies;
    @FXML
    private ComboBox<String> cbBogiesDoc;
    @FXML
    private ComboBox<String> cbPullOnWheel;
    @FXML
    private ComboBox<String> cbOneFlangeRollers;
    @FXML
    private ComboBox<String> cbTwoFlangeRollers;
    @FXML
    private ComboBox<String> cbCaterpillar;
    @FXML
    private ComboBox<String> cbCaterWidth;
    @FXML
    private ComboBox<String> cbGrouserQuant;
    @FXML
    private ComboBox<String> cbJointHinge;
    @FXML
    private ComboBox<String> cbCaterStep;
    @FXML
    private ComboBox<String> cbLeaderWheel;
    //Bogies tab
    @FXML
    private Tab tabCabin;
    @FXML
    private ComboBox<String> cbCabinDoc;
    @FXML
    private ComboBox<String> cbFVU;
    @FXML
    private ComboBox<String> cbRadio;
    @FXML
    private ComboBox<String> cbRops;
    @FXML
    private ComboBox<String> cbAntivandalLattice;
    @FXML
    private ComboBox<String> cbAirCond;
    @FXML
    private ComboBox<String> cbAirHeater;
    //Electrics tab
    @FXML
    private Tab tabElectrics;
    @FXML
    private ComboBox<String> cbJoyMove;
    @FXML
    private ComboBox<String> cbJoyAttach;
    @FXML
    private ComboBox<String> cbController;
    @FXML
    private TextField tfControllerSN;
    @FXML
    private ComboBox<String> cbProgramVer;
    @FXML
    private ComboBox<String> cbLighters;
    @FXML
    private ComboBox<String> cbBattery;


    @FXML
    void onBtnAddClicked(ActionEvent event) {

    }

    @FXML
    void onSearchClicked(MouseEvent event) {

        DozerEntity dozerEntity1 = new DozerEntity(Integer.parseInt(tfDozSerial.getText()));
        DBHelper.getDataFromDB(dozerEntity1);
        cbPumpType.setValue(dozerEntity1.getPumpsBrand());
        cbPumpType.setDisable(true);
        cbPumpType.setStyle("-fx-opacity: 1.0;");
        cbConcrHPtype.setValue(dozerEntity1.getPumpsType());
        //cbPumpType.setEditable(true);
        cbHMotType.setValue(dozerEntity1.getMotorsBrand());
        cbConcrHMtype.setValue(dozerEntity1.getMotorsType());
        //cbHMotType.setDisable(true);
//        System.out.println(dozerEntity1.getMotorsBrand());
//        System.out.println(dozerEntity1.getMotorsType());

        tfPumpLsn.setText(dozerEntity1.getPumpLserial());
        tfPumpLsn.setDisable(true);
        tfPumpLsn.setStyle("-fx-opacity: 1.0;");
        tfPumpRsn.setText(dozerEntity1.getPumpRserial());
        tfHMLsn.setText(dozerEntity1.getMotLserial());
        tfHMRsn.setText(dozerEntity1.getMotRserial());

    }

    @FXML
    void onNewPasspClicked(ActionEvent event) {
        stage.setTitle("Dozer Control - Добавление пасспорта");
        stateLabel.setText("Заполните все поля, затем нажмите кнопку \"Сохранить\"");
        btnSearch.setVisible(false);
        btnAdd.setVisible(true);

        bbAdd.setVisible(true);
        bbView.setVisible(false);

        ObservableList<String> brandsList = FXCollections.observableList(brands.getTypes());
        cbPumpType.setItems(brandsList);
        cbHMotType.setItems(brandsList);
        cbPlanetReduct.setItems(brandsList);
        cbPumpReduct.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.pumpReductorTypesTable)));

        cbDiselType.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.diselTypesTable)));

        cbCoolantDoc.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.coolantSysDocTable)));
        cbDiselCooler.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.waterCoolerDvsTable)));
        cbDiselOilCooler.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.oilCoolDvsTable)));
        cbHydOilCooler.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.oilCoolHstTable)));
        cbAirCondCooler.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.airCondCoolTable)));
        cbPreHeater.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.preHeaterTypeTable)));
        cbWing.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.wingTable)));
        cbWingDrive.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.wingDriveTable)));


        ObservableList<String> hydCylList = FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.hydCylinderTypesTable));
        cbAttachPump.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.attachPumpTypesTable)));
        cbFanPump.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.fanPumpTypesTable)));
        cbFanHMot.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.fanMotorTypesTable)));
        cbHydDistrib.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.hydDistributorTypeTable)));
        cbFrontAttachDoc.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.frontAttachmentsTable)));
        cbBackAttachDoc.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.backAttachmentsTable)));
        cbWinch.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.winchTable)));
        cbHydLockSkew.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.hydLockSkewTable)));
        cbHCOtvLift.setItems(hydCylList);
        cbHCOtvSkew.setItems(hydCylList);
        cbHCRipper.setItems(hydCylList);
        cbHCExtra.setItems(hydCylList);

        cbBogiesDoc.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.bogiesTypesTable)));
        cbPullOnWheel.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.pullOnWheelTable)));
        cbOneFlangeRollers.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.oneFlangeRollersTable)));
        cbTwoFlangeRollers.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.twoFlangeRollersTable)));
        cbLeaderWheel.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.leaderWheelTable)));
        cbCaterpillar.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.caterBrandTable)));
        cbCaterWidth.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.caterWidthTable)));
        cbGrouserQuant.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.grouserQuantTable)));
        cbJointHinge.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.jointHingeTable)));
        cbCaterStep.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.caterStepTable)));

        cbCabinDoc.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.cabinDocTable)));
        cbFVU.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.fvuTable)));
        cbRadio.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.radioPlayerTable)));
        cbRops.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.ropsTable)));
        cbAntivandalLattice.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.antivandLatticeTable)));
        cbAirCond.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.airConditionerTable)));
        cbAirHeater.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.airHeaterTable)));

        cbJoyMove.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.motionJoyTable)));
        cbJoyAttach.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.attachJoyTable)));
        cbController.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.controllerTypesTable)));
        //cbProgramVer.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.pr)));
        cbLighters.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.lightersTable)));
        cbBattery.setItems(FXCollections.observableList(DBHelper.getModelsFromTable(TableNames.batteryTable)));
    }

    @FXML
    void onPassViewClicked(ActionEvent event) {
        stage.setTitle("Dozer Control - Просмотр пасспорта");
        btnSearch.setVisible(true);
        btnAdd.setVisible(false);
        stateLabel.setText("Введите номер машины");

        bbAdd.setVisible(false);
        bbView.setVisible(true);
    }

    @FXML
    void onPumpBrandChoosen(ActionEvent event) {
        cbConcrHPtype.setItems(FXCollections.observableList(DBHelper.getModelsFromField(TableNames.hydPumpMotionTypesTable, "id_brands", DBHelper.getIdFromModel(cbPumpType.getValue(), TableNames.brandTable))));

    }

    @FXML
    void onConcrPumpChoosen(ActionEvent event) {
        tfPumpLsn.setEditable(true);
        tfPumpRsn.setEditable(true);
    }

    @FXML
    void onPlanetReductChoosen(ActionEvent event) {
        cbConcrPlRed.setItems(FXCollections.observableList(DBHelper.getModelsFromField(TableNames.planetReductorTypesTable, "id_brands", DBHelper.getIdFromModel(cbPlanetReduct.getValue(), TableNames.brandTable))));

    }

    @FXML
    void onMotBrandChoosen(ActionEvent event) {
        cbConcrHMtype.setItems(FXCollections.observableList(DBHelper.getModelsFromField(TableNames.hydMotorMotionTypesTable, "id_brands", DBHelper.getIdFromModel(cbHMotType.getValue(), TableNames.brandTable))));

    }

    @FXML
    void onControllerChoosen(ActionEvent event) {
        cbProgramVer.setItems(FXCollections.observableList(DBHelper.getModelsFromField(TableNames.softwareTable, "id_controller_types", DBHelper.getIdFromModel(cbController.getValue(), TableNames.controllerTypesTable))));
    }

    @FXML
    void onBtnSaveClicked(ActionEvent event) {

        SavableToDB savable;

        if(tabTransmission.isSelected()) {
            TransmissionEntityToSave tets = new TransmissionEntityToSave();

            tets.setId_hyd_pumps_motion_types(DBHelper.getIdFromModel(cbConcrHPtype.getValue(), TableNames.hydPumpMotionTypesTable));
            tets.setSerial_hyd_pumps_motion_L(tfPumpLsn.getText());
            tets.setSerial_hyd_pumps_motion_R(tfPumpRsn.getText());

            tets.setId_hyd_mot_motion_types(DBHelper.getIdFromModel(cbConcrHMtype.getValue(), TableNames.hydMotorMotionTypesTable));
            tets.setSerial_hyd_mot_motion_L(tfHMLsn.getText());
            tets.setSerial_hyd_mot_motion_R(tfHMRsn.getText());

            tets.setId_planet_reductor_types(DBHelper.getIdFromModel(cbConcrPlRed.getValue(), TableNames.planetReductorTypesTable));
            tets.setSerial_planet_reductor_L(tfPlRsnL.getText());
            tets.setSerial_planet_reductor_R(tfPlRsnR.getText());

            tets.setId_pump_reductor_types(DBHelper.getIdFromModel(cbPumpReduct.getValue(), TableNames.pumpReductorTypesTable));
            tets.setSerial_pump_reductor(tfHPRedSN.getText());

            savable = tets;

            stateLabel.setText("Конфигурация трансмиссии успешно сохранена, заполните остальные вкладки");//сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbPumpType, cbHMotType, cbPlanetReduct, cbPumpReduct, cbConcrHPtype, cbConcrHMtype, cbConcrPlRed)),
                    new ArrayList<>(List.of(tfPumpLsn, tfPumpRsn, tfHMLsn, tfHMRsn, tfPlRsnL, tfPlRsnR, tfHPRedSN)));
        }
        else if(tabDisel.isSelected()){
            DiselEntityToSave dets = new DiselEntityToSave();

            dets.setId_disel_types(DBHelper.getIdFromModel(cbDiselType.getValue(), TableNames.diselTypesTable));
            dets.setSerial_dvs(tfDiselSN.getText());
            dets.setSerial_tnvd(tfTNVDSN.getText());
            dets.setSerial_turbocomp(tfTurboCompSN.getText());

            savable = dets;

//            dets.saveToDB();

            stateLabel.setText("Конфигурация двигателя успешно сохранена, заполните остальные вкладки");//сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbDiselType)),
                    new ArrayList<>(List.of(tfDiselSN, tfTNVDSN, tfTurboCompSN)));
        }
        else if(tabCoolant.isSelected()){
            CoolSysEntityToSave csets = new CoolSysEntityToSave();

            csets.setId_coolant_system_docs(DBHelper.getIdFromModel(cbCoolantDoc.getValue(), TableNames.coolantSysDocTable));
            csets.setId_water_cooler_dvs(DBHelper.getIdFromModel(cbDiselCooler.getValue(), TableNames.waterCoolerDvsTable));
            csets.setId_oil_cooler_dvs(DBHelper.getIdFromModel(cbDiselOilCooler.getValue(), TableNames.oilCoolDvsTable));
            csets.setId_oil_cooler_hst(DBHelper.getIdFromModel(cbHydOilCooler.getValue(), TableNames.oilCoolHstTable));
            csets.setId_air_cond_cooler(DBHelper.getIdFromModel(cbAirCondCooler.getValue(), TableNames.airCondCoolTable));
            csets.setId_pre_heater_types(DBHelper.getIdFromModel(cbPreHeater.getValue(), TableNames.preHeaterTypeTable));
            csets.setId_wing(DBHelper.getIdFromModel(cbWing.getValue(), TableNames.wingTable));
            csets.setId_wing_drive(DBHelper.getIdFromModel(cbWingDrive.getValue(), TableNames.wingDriveTable));
            csets.setSerial_pre_heater(tfPreHeaterSN.getText());

            savable = csets;

            stateLabel.setText("Конфигурация системы охлаждения успешно сохранена, заполните остальные вкладки");//сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbCoolantDoc, cbDiselCooler, cbDiselOilCooler, cbHydOilCooler, cbAirCondCooler, cbPreHeater, cbWing, cbWingDrive)),
                    new ArrayList<>(List.of(tfPreHeaterSN)));
        }
        else if(tabAttachments.isSelected()){
            HydCylEntityToSave hcets = new HydCylEntityToSave();

            hcets.setId_hyd_cyl_otv_lift(DBHelper.getIdFromModel(cbHCOtvLift.getValue(), TableNames.hydCylinderTypesTable));
            hcets.setId_hyd_cyl_skew(DBHelper.getIdFromModel(cbHCOtvSkew.getValue(), TableNames.hydCylinderTypesTable));
            hcets.setId_hyd_cyl_ripper(DBHelper.getIdFromModel(cbHCRipper.getValue(), TableNames.hydCylinderTypesTable));
            hcets.setId_extra_hyd_cyl(DBHelper.getIdFromModel(cbHCExtra.getValue(), TableNames.hydCylinderTypesTable));
            hcets.setId_hyd_lock_skew(DBHelper.getIdFromModel(cbHydLockSkew.getValue(), TableNames.hydLockSkewTable));
            hcets.setId_front_attach_type(DBHelper.getIdFromModel(cbFrontAttachDoc.getValue(), TableNames.frontAttachmentsTable));
            hcets.setId_back_attach_type(DBHelper.getIdFromModel(cbBackAttachDoc.getValue(), TableNames.backAttachmentsTable));
            hcets.setId_winch(DBHelper.getIdFromModel(cbWinch.getValue(), TableNames.winchTable));

            AttachEntityToSave aets = new AttachEntityToSave(hcets);

            aets.setId_attach_pump_types(DBHelper.getIdFromModel(cbAttachPump.getValue(), TableNames.attachPumpTypesTable));
            aets.setId_fan_pump_types(DBHelper.getIdFromModel(cbFanPump.getValue(), TableNames.fanPumpTypesTable));
            aets.setId_fan_mot_types(DBHelper.getIdFromModel(cbFanHMot.getValue(), TableNames.fanMotorTypesTable));
            aets.setId_hyd_distributor_types(DBHelper.getIdFromModel(cbHydDistrib.getValue(), TableNames.hydDistributorTypeTable));

            aets.setSerial_attach_pump(tfAttachPump.getText());
            aets.setSerial_fan_pump(tfFanPump.getText());
            aets.setSerial_fan_motor(tfFanMot.getText());
            aets.setSerial_hyd_distributor(tfHydDistributor.getText());


            stateLabel.setText("Конфигурация навесного оборудования успешно сохранена, заполните остальные вкладки");//сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbAttachPump, cbFanPump, cbFanHMot, cbHydDistrib, cbFrontAttachDoc, cbBackAttachDoc, cbWinch, cbHydLockSkew, cbHCOtvLift, cbHCOtvSkew, cbHCRipper, cbHCExtra)),
                    new ArrayList<>(List.of(tfAttachPump, tfFanPump, tfFanMot, tfHydDistributor)));
            savable = aets;
        }
        else if(tabBogies.isSelected()){
            BogiesEntityToSave bets = new BogiesEntityToSave();

            bets.setId_bogies_types(DBHelper.getIdFromModel(cbBogiesDoc.getValue(), TableNames.bogiesTypesTable));
            bets.setId_pull_on_wheel_types(DBHelper.getIdFromModel(cbPullOnWheel.getValue(), TableNames.pullOnWheelTable));
            bets.setId_leader_wheel_types(DBHelper.getIdFromModel(cbLeaderWheel.getValue(), TableNames.leaderWheelTable));
            bets.setId_one_flange_rollers(DBHelper.getIdFromModel(cbOneFlangeRollers.getValue(), TableNames.oneFlangeRollersTable));
            bets.setId_two_flange_rollers(DBHelper.getIdFromModel(cbTwoFlangeRollers.getValue(), TableNames.twoFlangeRollersTable));

            HashMap<String, String> fields = new HashMap<>();
            fields.put("id_cater_width", String.valueOf(DBHelper.getIdFromModel(cbCaterWidth.getValue(), TableNames.caterWidthTable)));
            fields.put("id_grouser_quant", String.valueOf(DBHelper.getIdFromModel(cbGrouserQuant.getValue(), TableNames.grouserQuantTable)));
            fields.put("id_joint_hinge", String.valueOf(DBHelper.getIdFromModel(cbJointHinge.getValue(), TableNames.jointHingeTable)));
            fields.put("id_cater_step", String.valueOf(DBHelper.getIdFromModel(cbCaterStep.getValue(), TableNames.caterStepTable)));
            fields.put("id_cater_brand", String.valueOf(DBHelper.getIdFromModel(cbCaterpillar.getValue(), TableNames.caterBrandTable)));
            bets.setId_caterpillar_types(DBHelper.getIdFromFields(TableNames.caterpillarTypesTable, fields));

            stateLabel.setText("Конфигурация ходовой части успешно сохранена, заполните остальные вкладки");//сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbBogiesDoc, cbPullOnWheel, cbOneFlangeRollers, cbTwoFlangeRollers, cbCaterpillar, cbCaterWidth, cbGrouserQuant, cbJointHinge, cbCaterStep, cbLeaderWheel)),
                    new ArrayList<>());
            savable = bets;
        }
        else if(tabCabin.isSelected()){
            CabinEntityToSave cets = new CabinEntityToSave();

            cets.setId_cabin_type(DBHelper.getIdFromModel(cbCabinDoc.getValue(), TableNames.cabinDocTable));
            cets.setId_air_conditioner(DBHelper.getIdFromModel(cbAirCond.getValue(), TableNames.airConditionerTable));
            cets.setId_air_heater(DBHelper.getIdFromModel(cbAirHeater.getValue(), TableNames.airHeaterTable));
            cets.setId_filt_vent_set(DBHelper.getIdFromModel(cbFVU.getValue(), TableNames.fvuTable));
            cets.setId_radio_player(DBHelper.getIdFromModel(cbRadio.getValue(), TableNames.radioPlayerTable));
            cets.setId_rops(DBHelper.getIdFromModel(cbRops.getValue(), TableNames.ropsTable));
            cets.setId_antivandal_lattice(DBHelper.getIdFromModel(cbAntivandalLattice.getValue(), TableNames.antivandLatticeTable));

            stateLabel.setText("Конфигурация кабины успешно сохранена, заполните остальные вкладки"); //сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbCabinDoc, cbFVU, cbRadio, cbRops, cbAirCond, cbAirHeater, cbAntivandalLattice)),
                    new ArrayList<>());
            savable = cets;
        }
        else if(tabElectrics.isSelected()){
            ElectricsEntityToSave eets = new ElectricsEntityToSave();

            eets.setId_motion_joystick(DBHelper.getIdFromModel(cbJoyMove.getValue(), TableNames.motionJoyTable));
            eets.setId_attach_joystick(DBHelper.getIdFromModel(cbJoyAttach.getValue(), TableNames.attachJoyTable));
            eets.setSerial_controller(tfControllerSN.getText());
            eets.setId_software_ver(DBHelper.getIdFromModel(cbProgramVer.getValue(), TableNames.softwareTable));
            eets.setId_lighters(DBHelper.getIdFromModel(cbLighters.getValue(), TableNames.lightersTable));
            eets.setId_battery(DBHelper.getIdFromModel(cbBattery.getValue(), TableNames.batteryTable));

            stateLabel.setText("Конфигурация электрооборудования успешно сохранена, заполните остальные вкладки"); //сделать текстовую константу с 1 переменной
            ControllerHelper.setUneditableFields(
                    new ArrayList<>(List.of(cbJoyMove, cbJoyAttach, cbController, cbProgramVer, cbLighters, cbBattery)),
                    new ArrayList<>(List.of(tfControllerSN)));
            savable = eets;
        }

        else savable = null;
        savable.saveToDB();
    }

    @FXML
    void onBtnCancelClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {

        btnAdd.setVisible(false);
        brands = Brands.getInstance();
        DBHelper.getDataFromDB(brands);

        stateLabel.setText("Введите номер машины");

        tfPumpLsn.setEditable(false);
        tfPumpRsn.setEditable(false);
        bbAdd.setVisible(false);
        bbView.setVisible(true);
    }

}
