/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpm.fsr.mock;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.process.WorkflowProcessInstance;

/**
 *
 * @author ab19041
 */
public class MockVOHelper {

    private MockVOHelper() {

    }

    public static KnownOutageVO getKnownOutageVO(boolean outageExists, String outageType, String outageStatus, boolean isCongestionOutagePresent) {
        KnownOutageVO knownOutageVO = new KnownOutageVO();
        knownOutageVO.setOutageExists(outageExists);
        knownOutageVO.setOutageType(outageType);
        knownOutageVO.setProductAffected(outageType);
        knownOutageVO.setOutageStatus(outageStatus);
        knownOutageVO.setOutageId("123456");
        knownOutageVO.setCongestionOutagePresent(isCongestionOutagePresent);

        return knownOutageVO;
    }

    public static ASSIABasicsVO getASSIABasicsVO(boolean isErrored,boolean supported,boolean monitored,boolean optimized,
            String lineStability,String optimizerStartTime,String optimizerEndTime) {
        ASSIABasicsVO assiaBasicsVO = new ASSIABasicsVO();
        assiaBasicsVO.setErrored(isErrored);
        assiaBasicsVO.setSupported(supported);
        assiaBasicsVO.setMonitored(monitored);
        assiaBasicsVO.setOptimized(optimized);
        assiaBasicsVO.setLineStability(lineStability);
        assiaBasicsVO.setOptimizerStartTime(optimizerStartTime);
        assiaBasicsVO.setOptimizerEndTime(optimizerEndTime);
        

        return assiaBasicsVO;
    }

    public static PollDSLAMActualsVO getPollDSLAMActualsVO(
            boolean isErrored,
            boolean isPollDSLAMSupported,
            boolean isModemTrained,
            boolean isNoiseMarginAvailable,
            int noiseMarginUp,
            int noiseMarginDown,
            boolean provisionedSpeedAvailable,
            boolean actualSpeedAvailable,
            int provisionedSpeedUp,
            int provisionedSpeedDown,
            int actualSpeedUp,
            int actualSpeedDown,
            String portAdminStatus,
            String portOpStatus,
            String crossConnectStatus,
            int provisionedSpeedUp_2,
            int provisionedSpeedDown_2,
            String portAdminStatus_2,
            String portOpStatus_2,
            String actualsSubscriberVPI,
            String actualsSubscriberVCI,
            String actualsSubscriberVLAN,
            String actualsNetworkVPI,
            String actualsNetworkVCI,
            String actualsNetworkVLAN) {
        PollDSLAMActualsVO pollDSLAMActualsVO = new PollDSLAMActualsVO();
        pollDSLAMActualsVO.setErrored(isErrored);
        pollDSLAMActualsVO.setPollDSLAMSupported(isPollDSLAMSupported);
        pollDSLAMActualsVO.setModemTrained(isModemTrained);
        pollDSLAMActualsVO.setNoiseMarginAvailable(isNoiseMarginAvailable);
        pollDSLAMActualsVO.setNoiseMarginUp(noiseMarginUp);
        pollDSLAMActualsVO.setNoiseMarginDown(noiseMarginDown);
        pollDSLAMActualsVO.setProvisionedSpeedAvailable(provisionedSpeedAvailable);
        pollDSLAMActualsVO.setActualSpeedAvailable(actualSpeedAvailable);
        pollDSLAMActualsVO.setProvisionedSpeedUp(provisionedSpeedUp);
        pollDSLAMActualsVO.setProvisionedSpeedDown(provisionedSpeedDown);
        pollDSLAMActualsVO.setActualSpeedUp(actualSpeedUp);
        pollDSLAMActualsVO.setActualSpeedDown(actualSpeedDown);
        pollDSLAMActualsVO.setPortAdminStatus(portAdminStatus);
        pollDSLAMActualsVO.setPortOpStatus(portOpStatus);
        pollDSLAMActualsVO.setCrossConnectStatus(crossConnectStatus);
        pollDSLAMActualsVO.setPortAdminStatus_2(portAdminStatus_2);
        pollDSLAMActualsVO.setPortOpStatus_2(portOpStatus_2);
        pollDSLAMActualsVO.setActualsSubscriberVPI(actualsSubscriberVPI);
        pollDSLAMActualsVO.setActualsSubscriberVCI(actualsSubscriberVCI);
        pollDSLAMActualsVO.setActualsSubscriberVLAN(actualsSubscriberVLAN);
        pollDSLAMActualsVO.setActualsNetworkVPI(actualsNetworkVPI);
        pollDSLAMActualsVO.setActualsNetworkVCI(actualsNetworkVCI);
        pollDSLAMActualsVO.setActualsNetworkVLAN(actualsNetworkVLAN);
        return pollDSLAMActualsVO;
    }

    public static ModemInfoVO getModemInfoVO(boolean isErrored,
            String modemSerialNumber,
            boolean modemWanIpPresent,
            String modemWanIP,
            String modemFirmwareLatest,
            boolean modemConnectedDevicesPresent,
            boolean modemActiveConnectedDevicePresent,
            boolean modemEthernetConnectedDevicePresent,
            String modemMake,
            String modemModel,
            String modemFirmware,
            String modemAuthenticatedPPPusername) {
        ModemInfoVO modemInfoVO = new ModemInfoVO();
        modemInfoVO.setErrored(isErrored);
        modemInfoVO.setModemSerialNumber(modemSerialNumber);
        modemInfoVO.setModemWanIpPresent(modemWanIpPresent);
        modemInfoVO.setModemWanIP(modemWanIP);
        modemInfoVO.setModemFirmwareLatest(modemFirmwareLatest);
        modemInfoVO.setModemConnectedDevicesPresent(modemConnectedDevicesPresent);
        modemInfoVO.setModemActiveConnectedDevicePresent(modemActiveConnectedDevicePresent);
        modemInfoVO.setModemEthernetConnectedDevicePresent(modemEthernetConnectedDevicePresent);
        modemInfoVO.setModemMake(modemMake);
        modemInfoVO.setModemModel(modemModel);
        modemInfoVO.setModemFirmware(modemFirmware);
        modemInfoVO.setModemAuthenticatedPPPusername(modemAuthenticatedPPPusername);

        return modemInfoVO;
    }

    public static StaticIPVO getStaticIPVO(boolean hasStaticIP, int IPQuantity, String startIP, String endIP, List ipAddressList, boolean errored) {
        StaticIPVO staticIPVO = new StaticIPVO();
        staticIPVO.setHasStaticIP(hasStaticIP);
        staticIPVO.setIPQuantity(IPQuantity);
        staticIPVO.setStartIP(startIP);
        staticIPVO.setEndIP(endIP);
        staticIPVO.setIpAddressList(ipAddressList);
        staticIPVO.setErrored(errored);

        return staticIPVO;
    }

    public static ProductsFeaturesVO getProductsFeaturesVO(boolean hasPRISMonAccount, boolean hasGPON, boolean isMadisonRiverCustomer, boolean hasAtEaseFeature, String atEaseLevel, boolean hasTechInstallUSOC, String marketUnit, String accessTech, boolean isErrored) {
        ProductsFeaturesVO productsFeaturesVO = new ProductsFeaturesVO();
        productsFeaturesVO.setHasPRISMonAccount(hasPRISMonAccount);
        productsFeaturesVO.setHasGPON(hasGPON);
        productsFeaturesVO.setMadisonRiverCustomer(isMadisonRiverCustomer);
        productsFeaturesVO.setHasPRISMonAccount(hasAtEaseFeature);
        productsFeaturesVO.setAtEaseLevel(atEaseLevel);
        productsFeaturesVO.setHasTechInstallUSOC(hasTechInstallUSOC);
        productsFeaturesVO.setMarketUnit(marketUnit);
        productsFeaturesVO.setAccessTech(accessTech);
        productsFeaturesVO.setErrored(isErrored);

        return productsFeaturesVO;
    }

    public static AuthenticationVO getAuthenticationVO(String sourceSystem, boolean isAuthenticated, String wanIP, String macAddress, String authenticatedUserName,String sessionStartTime) {
        AuthenticationVO authenticationVO = new AuthenticationVO();
        authenticationVO.setAuthenticated(isAuthenticated);
        authenticationVO.setAuthenticatedUserName(authenticatedUserName);
        authenticationVO.setMacAddress(macAddress);
        authenticationVO.setSourceSystem(sourceSystem);
        authenticationVO.setWanIP(wanIP);
        authenticationVO.setSessionStartTime(sessionStartTime);

        return authenticationVO;
    }

    public static OntVO getOntVO(String ontAdminStatus, String ontOpStatus, String ethernetPortAdminStatus, String ethernetPortOpStatus) {

        OntVO ontVO = new OntVO();

        ontVO.setOntAdminStatus(ontAdminStatus);
        ontVO.setOntOpStatus(ontOpStatus);
        ontVO.setEthernetPortAdminStatus(ethernetPortAdminStatus);
        ontVO.setEthernetPortOpStatus(ethernetPortOpStatus);

        return ontVO;
    }

    public static NconVO checkCrossConnect(boolean crossConnectOK) {

        NconVO nconVO = new NconVO();

        nconVO.setCrossConnectOK(crossConnectOK);

        return nconVO;
    }

    public static ServiceOrderVO getServiceOrderVO(boolean serviceOrderPresent, String serviceOrderStatus, String wfadoStatus, boolean isPastDueOrder, boolean isFutureOrder, boolean isDueTodayOrder, int currentHourInCustomerTZ) {
        ServiceOrderVO ServiceOrderVO = new ServiceOrderVO();

        ServiceOrderVO.setServiceOrderPresent(serviceOrderPresent);
        ServiceOrderVO.setServiceOrderStatus(serviceOrderStatus);
        ServiceOrderVO.setWfadoStatus(wfadoStatus);
        ServiceOrderVO.setPastDueOrder(isPastDueOrder);
        ServiceOrderVO.setFutureOrder(isFutureOrder);
        ServiceOrderVO.setDueTodayOrder(isDueTodayOrder);
        ServiceOrderVO.setCurrentHourInCustomerTZ(currentHourInCustomerTZ);

        return ServiceOrderVO;
    }

    public static WalledGardenVO getWalledGardenVO(boolean inWalledGarden, String walledGardenType) {
        WalledGardenVO walledGardenVO = new WalledGardenVO();
        walledGardenVO.setInWalledGarden(inWalledGarden);
        walledGardenVO.setWalledGardenType(walledGardenType);

        return walledGardenVO;
    }

    public static SpeedsVO getSpeedsVO(boolean purchasedSpeedAvailable, boolean provisionedSpeedAvailable, boolean actualSpeedAvailable, int purchasedSpeedUp, int purchasedSpeedDown, int provisionedSpeedUp, int provisionedSpeedDown, int actualSpeedUp, int actualSpeedDown) {
        SpeedsVO speedsVO = new SpeedsVO();
        speedsVO.setPurchasedSpeedAvailable(purchasedSpeedAvailable);
        speedsVO.setProvisionedSpeedAvailable(provisionedSpeedAvailable);
        speedsVO.setActualSpeedAvailable(actualSpeedAvailable);
        speedsVO.setPurchasedSpeedUp(purchasedSpeedUp);
        speedsVO.setPurchasedSpeedDown(purchasedSpeedDown);
        speedsVO.setProvisionedSpeedUp(provisionedSpeedUp);
        speedsVO.setProvisionedSpeedDown(provisionedSpeedDown);
        speedsVO.setActualSpeedUp(actualSpeedUp);
        speedsVO.setActualSpeedDown(actualSpeedDown);

        return speedsVO;
    }


    /* public static String getMockCode(String processMock, WorkflowProcessInstance processInstance, List mockValues) {

     String parts[], code = null;
     if (null != processMock) {
     parts = processMock.split(" ", 2);
     code = parts[0];
     if (parts.length > 1 && mockValues != null && mockValues.contains(code)) {
     processInstance.setVariable("processMock", parts[1]);
     }
     } else {
     System.out.println("Process Mock is NULL.No Mock Data to Process.Re-Verify..!!");
     }
     return code;
     }*/
    public static String getMockCode(String processMock, WorkflowProcessInstance processInstance) {

        String parts[], code = null;
        if (null != processMock) {
            parts = processMock.split(" ", 2);
            code = parts[0];
            if (parts.length > 1) {
                processInstance.setVariable("processMock", parts[1]);
            }
        } else {
            System.out.println("Process Mock is NULL.No Mock Data to Process.Re-Verify..!!");
        }
        System.out.println("code-->  " + code + " Remaining code--> " + (String) processInstance.getVariable("processMock"));
        return code;
    }

    /*public static String getMockCode(String processMock, WorkflowProcessInstance processInstance) {

     return processMock;
     }*/
    public static ASSIADiagnosticsVO getASSIADiagnosticsVO(boolean messagesPresent, String messages) {
        ASSIADiagnosticsVO assiaDiagnosticsVO = new ASSIADiagnosticsVO();
        List messagesList = new ArrayList();
        messagesList.add(messages);
        assiaDiagnosticsVO.setMessages(messagesList);
        assiaDiagnosticsVO.setMessagesPresent(messagesPresent);

        return assiaDiagnosticsVO;
    }

    public static IclVO getIclVO(String sourceSystem, boolean translated,
            boolean isVPIVCIPresent, String subscriberVPI,
            String subscriberVCI, String subscriberVLAN, String networkVPI,
            String networkVCI, String networkVLAN) {
        IclVO iclVo = new IclVO();
        iclVo.setSourceSystem(sourceSystem);
        iclVo.setTranslated(translated);
        iclVo.setVPIVCIPresent(isVPIVCIPresent);
        iclVo.setSubscriberVPI(subscriberVPI);
        iclVo.setSubscriberVCI(subscriberVCI);
        iclVo.setSubscriberVLAN(subscriberVLAN);
        iclVo.setNetworkVPI(networkVPI);
        iclVo.setNetworkVCI(networkVCI);
        iclVo.setNetworkVLAN(networkVLAN);

        return iclVo;
    }

    public static ICLStaticIPVO getICLStaticIPVO(boolean isErrored, boolean hasStaticIP, int iPQuantity, String startIP, String endIP, List<String> ipAddressList) {

        ICLStaticIPVO iCLStaticIPVO = new ICLStaticIPVO();
        iCLStaticIPVO.setErrored(isErrored);
        iCLStaticIPVO.setHasStaticIP(hasStaticIP);
        iCLStaticIPVO.setIPQuantity(iPQuantity);
        iCLStaticIPVO.setStartIP(startIP);
        iCLStaticIPVO.setEndIP(endIP);
        iCLStaticIPVO.setIpAddressList(ipAddressList);
        return iCLStaticIPVO;

    }

    public static EnsembleStaticIPVO getEnsStaticIPVO(boolean isErrored, boolean hasStaticIP, int iPQuantity, String startIP, String endIP, List<String> ipAddressList) {

        EnsembleStaticIPVO ensembleStaticIPVO = new EnsembleStaticIPVO();
        ensembleStaticIPVO.setErrored(isErrored);
        ensembleStaticIPVO.setHasStaticIP(hasStaticIP);
        ensembleStaticIPVO.setIPQuantity(iPQuantity);
        ensembleStaticIPVO.setStartIP(startIP);
        ensembleStaticIPVO.setEndIP(endIP);
        ensembleStaticIPVO.setIpAddressList(ipAddressList);
        return ensembleStaticIPVO;

    }

    public static RadLogVO getRadLogVO(boolean isErrored, boolean logWasFound, String lastEvent, String lastEventTimeStamp, int stopUserError, int stopUserRequest, int stopLostCarrier, int stopPortError, int stopAdminRequest, int startOk, int aliveOk, int stopNasRequest, boolean ipAddressFound, String lastLoggedIP) {

        RadLogVO radLogVO = new RadLogVO();
        radLogVO.setErrored(isErrored);
        radLogVO.setLogWasFound(logWasFound);
        radLogVO.setLastEvent(lastEvent);
        radLogVO.setLastEventTimeStamp(lastEventTimeStamp);
        radLogVO.setStopUserError(stopUserError);
        radLogVO.setStopUserRequest(stopUserRequest);
        radLogVO.setStopLostCarrier(stopLostCarrier);
        radLogVO.setStopPortError(stopPortError);
        radLogVO.setStopAdminRequest(stopAdminRequest);
        radLogVO.setStartOk(startOk);
        radLogVO.setAliveOk(aliveOk);
        radLogVO.setStopNasRequest(stopNasRequest);
        radLogVO.setIpAddressFound(ipAddressFound);
        radLogVO.setLastLoggedIP(lastLoggedIP);
        return radLogVO;
    }

    public static CredentailsVO getCredentailsVO(boolean isErrored, String sourceSystem, boolean credentailsPresent, String userName, String initialPassword) {
        CredentailsVO credentailsVO = new CredentailsVO();
        credentailsVO.setErrored(isErrored);
        credentailsVO.setSourceSystem(sourceSystem);
        credentailsVO.setCredentailsPresent(credentailsPresent);
        credentailsVO.setUserName(userName);
        credentailsVO.setInitialPassword(initialPassword);
        return credentailsVO;
    }

    public static ModemPushCredentialsVO getModemPushCredentialsVO(boolean isErrored, boolean isCredentialPushInitiated) {
        ModemPushCredentialsVO modemPushCredentialsVO = new ModemPushCredentialsVO();
        modemPushCredentialsVO.setErrored(isErrored);
        return modemPushCredentialsVO;
    }

    public static ProtocolVO getProtocolVO(boolean isErrored, String protocol, boolean bbcosPresent) {
        ProtocolVO protocolVO = new ProtocolVO();
        protocolVO.setErrored(isErrored);
        protocolVO.setProtocol(protocol);
        protocolVO.setBbcosPresent(bbcosPresent);
        return protocolVO;

    }
    
    public static LoopQualUpsellVO getLoopQualUpsellVO(boolean isErrored, int maximumSpeedUp, int maximumSpeedDown) {
    	LoopQualUpsellVO loopQualUpsellVO = new LoopQualUpsellVO();
		loopQualUpsellVO.setErrored(isErrored);
		loopQualUpsellVO.setMaximumSpeedUp(maximumSpeedUp);
		loopQualUpsellVO.setMaximumSpeedDown(maximumSpeedDown);

        return loopQualUpsellVO;
    }
    
    public static CustomerExperienceVO getCustomerExperienceVO(boolean isErrored, int actualLineError, boolean congestionIncidentReported, int cesPortTrainUp, int cesPortTrainDown) {
    	
    	CustomerExperienceVO customerExperienceVO = new CustomerExperienceVO();
    	customerExperienceVO.setErrored(isErrored);
    	customerExperienceVO.setActualLineError(actualLineError);
    	customerExperienceVO.setCongestionIncidentReported(congestionIncidentReported);
    	customerExperienceVO.setCesPortTrainUp(cesPortTrainUp);
    	customerExperienceVO.setCesPortTrainDown(cesPortTrainDown);
    	
    	return customerExperienceVO;
    
    }
    
    public static PollDSLAMInitialsVO getPollDSLAMInitialsVO(boolean isErrored,boolean isPollDSLAMSupported,float customerExpScore,String deviceTID,boolean isNetworkCongested){
    
    	PollDSLAMInitialsVO pollDSLAMInitialsVO =new PollDSLAMInitialsVO();
    	pollDSLAMInitialsVO.setErrored(isErrored);
    	pollDSLAMInitialsVO.setPollDSLAMSupported(isPollDSLAMSupported);
    	pollDSLAMInitialsVO.setCustomerExpScore(customerExpScore);
    	pollDSLAMInitialsVO.setDeviceTID(deviceTID);
    	pollDSLAMInitialsVO.setNetworkCongested(isNetworkCongested);
    	
    	return pollDSLAMInitialsVO;
    	
    } 	
}
