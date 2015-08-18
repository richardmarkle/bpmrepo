/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.mock;

/**
 *
 * @author ab19041
 */
public interface MockService {

    KnownOutageVO getKnownOutage(String processMock);

    boolean modemWarranty(String processMock);

    boolean refreshHealthCheckInitiated(String processMock);

    String modemStatus(String processMock);

    boolean modemConnected(String processMock);

    boolean modemSupported(String processMock);

    boolean modemReset(String processMock);

    boolean modemReboot(String processMock);

    ASSIABasicsVO getASSIABasics(String processMock);

    PollDSLAMActualsVO getPollDSLAMActuals(String processMock);

    ModemInfoVO getModemInfoVO(String processMock);

    StaticIPVO getStaticIPVO(String processMock);

    String legacyMarket(String processMock);

    ProductsFeaturesVO getProductsFeatures(String processMock);

    AuthenticationVO getAuthenticationVO(String processMock);

    OntVO getOntVO(String processMock);

    NconVO checkCrossConnect(String processMock);

    ServiceOrderVO getServiceOrderVO(String processMock);

    WalledGardenVO getWalledGardenVO(String processMock);

    SpeedsVO getSpeedsVO(String processMock);

    public ASSIADiagnosticsVO getASSIADiagnostics(String processMock);

    //String rebootOnt(String processMock);
    //String mockEthernetBouncePort(String processMock);
    IclVO getIclVO(String processMock);

    boolean isErrored(String processMock);

    boolean isModemProtocolPresent(String processMock);

    String modemProtocol(String processMock);

    boolean isFirmwareUpdateInitiated(String processMock);
    boolean isFirmwareUpdateNowInitiated(String processMock);
    
    ICLStaticIPVO getICLStaticIPVO(String processMock);

    RadLogVO getRadLogVO(String processMock);

    CredentailsVO getCredentailsVO(String processMock);

    ModemPushCredentialsVO getModemPushCredentialsVO(String processMock);

    ProtocolVO getProtocolVO(String processMock);

    EnsembleStaticIPVO getEnsStaticIPVO(String processMock);

	int modemNumberOfConnectedDevices(String processMock);

	int modemNumberOfActiveWirelessDevices(String processMock);
	
	int modemNumberOfActiveDevices(String processMock);
	
	LoopQualUpsellVO getLoopQualUpsellVO(String processMock);
	
	CustomerExperienceVO getCustomerExperienceVO(String processMock);
	
	PollDSLAMInitialsVO getPollDSLAMInitialsVO(String processMock);
	

}
