package com.kiwisense.dal.model.persistence;



import java.util.HashMap;

import com.kiwisense.common.utils.StrUtil;


public class ObjectType {
	// private final static Logger _LOG = Logger.getLogger(ObjectType.class);

	public static long NULL_SEQUENCE_NUMBER = -1;

	public static HashMap<String, Short> OBJECT_CLASS_TO_TYPE_MAP = new HashMap<String, Short>();
	public static HashMap<Short, String> OBJECT_TYPE_TO_CLASS_MAP = new HashMap<Short, String>();

	

	// class name

	// full class name
	public static final String USER_CLASS    = "com.kiwisense.dal.model.User";
	public static final String ROLE_CLASS    = "com.kiwisense.dal.model.Role";
	public static final String DEVICE_CLASS  = "com.kiwisense.dal.model.Device";
	public static final String PRODUCT_CLASS  = "com.kiwisense.dal.model.Product";
	public static final String PRODUCT_PARAMETER_CLASS  = "com.kiwisense.dal.model.ProductParameter";
	public static final String DEVICE_USER_PARAMETER_CLASS  = "com.kiwisense.dal.model.DeviceUserParamter";
	
	

	public static final short USER_TYPE   = 1;
	public static final short ROLE_TYPE   = 2;
	public static final short DEVICE_TYPE = 3;
	public static final short PRODUCT_TYPE= 4;
	public static final short PRODUCT_PARAMETER_TYPE= 5;
	public static final short DEVICE_USER_PARAMETER_TYPE= 6;

	static {
		//
		// map from object class name to type
		//
		OBJECT_CLASS_TO_TYPE_MAP.put(USER_CLASS, USER_TYPE);
		OBJECT_CLASS_TO_TYPE_MAP.put(ROLE_CLASS, ROLE_TYPE);
		OBJECT_CLASS_TO_TYPE_MAP.put(DEVICE_CLASS, DEVICE_TYPE);
		OBJECT_CLASS_TO_TYPE_MAP.put(PRODUCT_CLASS, PRODUCT_TYPE);
		OBJECT_CLASS_TO_TYPE_MAP.put(PRODUCT_PARAMETER_CLASS, PRODUCT_PARAMETER_TYPE);
		OBJECT_CLASS_TO_TYPE_MAP.put(DEVICE_USER_PARAMETER_CLASS, DEVICE_USER_PARAMETER_TYPE);

		//
		// map from object type to class name
		//
		OBJECT_TYPE_TO_CLASS_MAP.put(USER_TYPE, USER_CLASS);
		OBJECT_TYPE_TO_CLASS_MAP.put(ROLE_TYPE, ROLE_CLASS);
		OBJECT_TYPE_TO_CLASS_MAP.put(DEVICE_TYPE, DEVICE_CLASS);
		OBJECT_TYPE_TO_CLASS_MAP.put(PRODUCT_TYPE, PRODUCT_CLASS);
		OBJECT_TYPE_TO_CLASS_MAP.put(PRODUCT_PARAMETER_TYPE, PRODUCT_PARAMETER_CLASS);
		OBJECT_TYPE_TO_CLASS_MAP.put(DEVICE_USER_PARAMETER_TYPE, DEVICE_USER_PARAMETER_CLASS);
	}

	/**
	 * The initial sequence number is a 64 bit (long) number. If we are encoding the
	 * object type in the id then the high 12 bits contain the object tpe.
	 * 
	 * @param className class name
	 * @return initial sequence number for this object type
	 */
	public static long getInitialSequenceNumber(String className) {

		boolean encodeTypeInId = true; // ap.getBooleanValue(ENCODE_OBJECT_TYPE_IN_ID, true);

		if (encodeTypeInId) {
			if (OBJECT_CLASS_TO_TYPE_MAP.get(className) == null) {
				// _LOG.error("The class " + className + " is unknown!");
				return NULL_SEQUENCE_NUMBER;
			} else {
				long objectType = OBJECT_CLASS_TO_TYPE_MAP.get(className);
				return objectType << 52;
			}
		} else {
			return 0;
		}
	}

	private static void populateObjectTypeVsDelPermMapForAttachments() {
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(GENERIC_ASSET_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(COMPUTER_SYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(ACCOUNT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(APPLICATIONSYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(GROUP_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(ORGANIZATIONAL_UNIT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(DATA_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(DEVICE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(DOMAIN_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(FINANCIAL_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(INTANGIBLE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(LOCATION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(PHYSICAL_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(PERSON_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(PROJECT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(PROCESS_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_UPDATEALL });
//		ATTACHMENTS_DELETE_PC_MAP.put(ENTITY_COLLECTION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(ATTACHMENT_COLLECTION_TYPE,
//				new String[] { Privilege.OBJECT_DOCUMENTREPOSITORY_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(AUDIT_PROJECT_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(GAP_TYPE,
//				new String[] { Privilege.OBJECT_FINDING_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(FINDING_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(INCIDENT_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(INCIDENT_ACTION_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(POLICY_TYPE,
//				new String[] { Privilege.OBJECT_CONTROL_AUTHOR, Privilege.OBJECT_POLICY_AUTHOR, Privilege.OBJECT_CONTROL_MANAGE});
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(POLICY_SET_TYPE,
//				new String[] { Privilege.OBJECT_CONTROL_AUTHOR, Privilege.OBJECT_POLICY_AUTHOR, Privilege.OBJECT_CONTROL_MANAGE, Privilege.OBJECT_POLICY_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(TICKET_TYPE, new String[] {
//				Privilege.OBJECT_TICKET_UPDATE, Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_TICKET_CLASSIFY });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(EXCEPTION_REQUEST_TYPE, new String[] {
//				Privilege.OBJECT_EXCEPTION_APPROVE,
//				Privilege.OBJECT_EXCEPTION_MANAGE });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(RAMITIGATION_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
//		ATTACHMENTS_DELETE_PC_MAP.put(EVIDENCE_TYPE, new String[] {
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
	}

	/**
	 * API to populate forbidden object types from property file.
	 */
	private static void populateForbiddenObjectTypes() {
//		String forbiddenObjectTypes = AgilianceProperties.getInstance()
//				.getProperty("com.agiliance.dal.persistence.ObjectType.forbidden.objects",
//						"");
//		List<String> objectTypesList = StrUtil.splitToList(
//				forbiddenObjectTypes, ",");
//		FORBIDDEN_OBJECT_TYPES.addAll(objectTypesList);
//	
	}

	/**
	 * Helper API to populate Object type vs permission checks.
	 */
	private static void populateObjectTypeVsPermissionMap() {

//		OBJECT_TYPE_TO_PC_MAP.put(GENERIC_ASSET_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(COMPUTER_SYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(ACCOUNT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(APPLICATIONSYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(GROUP_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(ORGANIZATIONAL_UNIT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(DATA_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(DEVICE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(DOMAIN_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(FINANCIAL_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(INTANGIBLE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(LOCATION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(PHYSICAL_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(PERSON_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(PROJECT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(PROCESS_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(ENTITY_COLLECTION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VENDOR_TYPE,
//				new String[] { Privilege.OBJECT_VENDOR_CREATE,
//				Privilege.OBJECT_VENDOR_UPDATE });
//
//		OBJECT_TYPE_TO_PC_MAP.put(VENDOR_SERVICE_TYPE, new String[] {
//				Privilege.OBJECT_VENDOR_CREATE, Privilege.OBJECT_ASSET_CREATE,
//				Privilege.OBJECT_VENDORSERVICE_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_RELATIONSHIP_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE });
//
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_RELATIONSHIP_TYPE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SCHEDULED_JOB_TYPE,
//				new String[] { Privilege.OBJECT_SCHEDULEDJOB_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAMATRIX_TYPE,
//				new String[] { Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(CLASSIFICATION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//				Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VIRTUAL_GROUP_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(AGENTCUSTOMCONFIGURATION_TYPE,
//				new String[] { Privilege.OBJECT_TENANT_CONFIGUREUI });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(APPLICATION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PATCH_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(OPERATING_SYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(END_POINT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//				Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_TYPE,
//				new String[] { Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FILTER_TYPE,
//				new String[] { Privilege.OBJECT_SYSTEMUSER_MANAGE,
//				Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_FILTER_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ADDRESS_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_CREATE, Privilege.OBJECT_ASSET_UPDATE, 
//				Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_DELETE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_VENDOR_UPDATE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(VIRTUAL_GROUP_INSTANCE_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(NETWORK_RELATIONSHIP_TYPE, new String[] {
//				Privilege.OBJECT_CONNECTOR_MANAGE,
//				Privilege.OBJECT_SYSTEMUSER_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(LOCAL_ACCOUNT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SHARE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		OBJECT_TYPE_TO_PC_MAP.put(SHARE_PERMISSION_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_VULNERABILITY_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PORT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SERVICE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(LOCAL_GROUP_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TAG_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL,
//						Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE,
//						Privilege.OBJECT_VENDOR_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_CATEGORY_TYPE, new String[] {
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE,
//				Privilege.OBJECT_ASSET_MANAGE, Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PORTNAME_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_AGENT_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_MANAGE, Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_CONNECTOR_MANAGE,
//				Privilege.OBJECT_SYSTEMUSER_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_TAG_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_POLICY_AUTHOR,
//				Privilege.OBJECT_CONTROL_AUTHOR,
//				Privilege.OBJECT_PROFILE_AUTHOR,
//				Privilege.OBJECT_POLICY_MANAGE,
//				Privilege.OBJECT_CONTROL_MANAGE,
//				Privilege.OBJECT_VENDOR_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULN_COMPENSATING_CONTROL_TYPE, new String[] {
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_DATA_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(COMPUTERSYSTEM_TO_PORT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(COMPUTERSYSTEM_TO_SERVICE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(CPE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SURVEY_SECTION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SURVEY_QUESTION_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SURVEY_QUESTION_CHOICE_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(QUESTION_TO_SECTION_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SECTION_TO_SECTION_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(EVIDENCE_TYPE, new String[] {
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(EXCEPTION_REQUEST_TYPE, new String[] {
//				Privilege.OBJECT_EXCEPTION_REQUEST,
//				Privilege.OBJECT_EXCEPTION_APPROVE,
//				Privilege.OBJECT_EXCEPTION_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ERHISTORY_ENTRY_TYPE, new String[] {
//				Privilege.OBJECT_EXCEPTION_APPROVE,
//				Privilege.OBJECT_EXCEPTION_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_POLICY_COMPLIANCE_ARCHIVE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SURVEYQUESTION_RESULT_ARCHIVE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(EVIDENCE_ARCHIVE_TYPE, new String[] {
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(DASHBOARD_PARAMETER_INSTANCE_TYPE,
//				new String[] { Privilege.OBJECT_REPORT_SAVE,
//						Privilege.OBJECT_REPORT_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(DASHBOARD_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR,
//				Privilege.OBJECT_DASHBOARDTEMPLATE_MANAGE, Privilege.OBJECT_VENDOR_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(REPORT_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(REPORT_PARAMETER_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SAVED_REPORT_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FUSION_REPORT_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CUSTOM_ATTRIBUTES_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(OBJECT_GROUP_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(REPORT_PARAMETER_INSTANCE_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(DASHBOARD_TO_FUSIONREPORT_TYPE, new String[] {
//				Privilege.OBJECT_REPORT_SAVE, Privilege.OBJECT_REPORT_AUTHOR,
//				Privilege.OBJECT_CUSTOMREPORT_AUTHOR,
//				Privilege.OBJECT_DASHBOARDTEMPLATE_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAPROJECT_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAMITIGATION_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAMITIGATIONITEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAUSERINPUT_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAHISTORY_ENTRY_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RASTOKEHOLDER_TYPE, new String[] {
//				Privilege.OBJECT_WORKFLOW_UPDATE,
//				Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_POLICY_MANAGE,
//				Privilege.OBJECT_EXCEPTION_MANAGE,
//				Privilege.OBJECT_POLICY_AUTHOR,
//				Privilege.OBJECT_FINDING_MANAGE,
//				Privilege.OBJECT_INCIDENT_CREATE,
//				Privilege.OBJECT_INCIDENT_UPDATE,
//				Privilege.OBJECT_TICKET_UPDATE,
//				Privilege.OBJECT_EXCEPTION_APPROVE,
//				Privilege.OBJECT_EXCEPTION_REQUEST,
//				Privilege.OBJECT_FINDING_UPDATE,
//				Privilege.OBJECT_SURVEY_ANSWER,
//				Privilege.OBJECT_ASSESSMENT_CREATE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(POLICYTARGETHISTORY_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAMITIGATION_TO_CONTROL_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(OPERATING_SYSTEM_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAVULNERABILITY_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAMATRIX_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAOVERWRITE_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RARISKSCORE_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAWORKFLOW_TYPE, new String[] {
//				Privilege.OBJECT_WORKFLOW_UPDATE,
//				Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_POLICY_MANAGE,
//				Privilege.OBJECT_EXCEPTION_MANAGE,
//				Privilege.OBJECT_FINDING_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(THREAT_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(CATEGORY_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE,
//				Privilege.OBJECT_RISK_AUTHOR });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LOSSTYPE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAUSERINPUT_HISTORY_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAUSERINPUT_TO_SYSTEMUSER_HISTORY_TYPE,
//				new String[] { Privilege.OBJECT_ASSESSMENT_WORKON,
//						Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_PERMISSION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_USER_TYPE,
//				new String[] { Privilege.OBJECT_SYSTEMUSER_MANAGE,Privilege.OBJECT_VENDORUSER_UPDATE });
//				
//		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_ROLE_TYPE,
//				new String[] { Privilege.OBJECT_SYSTEMUSER_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CONFIGVALUE_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_USER_GROUP_TYPE, new String[] {
//				Privilege.OBJECT_TEAM_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_USER_ACTION_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_DOMAIN_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAWORKFLOW_STAKEHOLDER_TYPE, new String[] {
//				Privilege.OBJECT_WORKFLOW_UPDATE,
//				Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_POLICY_MANAGE,
//				Privilege.OBJECT_EXCEPTION_MANAGE,
//				Privilege.OBJECT_POLICY_AUTHOR,
//				Privilege.OBJECT_FINDING_MANAGE,
//				Privilege.OBJECT_INCIDENT_CREATE,
//				Privilege.OBJECT_INCIDENT_UPDATE,
//				Privilege.OBJECT_TICKET_UPDATE,
//				Privilege.OBJECT_EXCEPTION_APPROVE,
//				Privilege.OBJECT_EXCEPTION_REQUEST,
//				Privilege.OBJECT_FINDING_UPDATE,
//				Privilege.OBJECT_SURVEY_ANSWER,
//				Privilege.OBJECT_ASSESSMENT_CREATE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_TENANT_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(NOTIFICATION_TYPE, new String[] {
//				Privilege.OBJECT_ALERTRULE_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_WORKON });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TICKET_TYPE, new String[] {
//				Privilege.OBJECT_TICKET_CREATE, Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_TICKET_UPDATE,
//				Privilege.OBJECT_TICKET_CLASSIFY,
//				Privilege.OBJECT_TICKET_MANAGEOBJECTS });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TICKET_OBJECT_TYPE, new String[] {
//				Privilege.OBJECT_TICKET_CREATE, Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_TICKET_UPDATE, Privilege.OBJECT_TICKET_CLASSIFY,
//				Privilege.OBJECT_TICKET_MANAGEOBJECTS });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ATTACHMENT_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TEMPLATE_TYPE, new String[] {
//	            Privilege.OBJECT_EMAILTEMPLATE_MANAGE,
//				Privilege.OBJECT_POLICY_AUTHOR,
//				Privilege.OBJECT_PROFILE_AUTHOR,
//				Privilege.OBJECT_CONTROL_AUTHOR,
//				Privilege.OBJECT_DASHBOARDTEMPLATE_MANAGE});
//		
////		OBJECT_TYPE_TO_PC_MAP.put(VIEW_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(GRID_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ATTACHMENT_COLLECTION_TYPE, new String[] {
//				Privilege.OBJECT_DOCUMENTREPOSITORY_CREATE,
//				Privilege.OBJECT_DOCUMENTREPOSITORY_UPDATE,
//				Privilege.OBJECT_DOCUMENTREPOSITORY_MANAGE,
//				Privilege.OBJECT_DOCUMENTREPOSITORY_DELETE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(TARGET_TYPE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(TARGET_TYPE_PARAMETER_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(TARGET_PARAMETER_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(GROUP_POLICY_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(GPO_PROPERTY_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(EXCEPTION_TEMPLATE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(POLICY_TYPE, new String[] {
//						Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(POLICY_SET_TYPE, new String[] {
//						Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(POLICY_VALUE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(POLICY_TO_POLICY_SET_TYPE, new String[] {
//						Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(POLICY_SET_TO_POLICY_SET_TYPE, new String[] {
//						Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VG_POLICY_SET_TARGET_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(OU_POLICY_SET_TARGET_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(OU_POLICY_TARGET_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SURVEYQUESTION_RESULT_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SURVEYQUESTION_CHOICE_RISK_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_POLICY_COMPLIANCE_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(POLICY_TO_POLICY_VALUE_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(POLICY_SET_TO_POLICY_VALUE_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(POLICY_VALUE_SELECTOR_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSIGNED_POLICY_CACHE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PROFILE_TYPE, new String[] {
//				Privilege.OBJECT_PROFILE_AUTHOR, Privilege.OBJECT_PROFILE_VIEW,
//				Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PROFILE_VARIABLE_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_POLICY_SET_TARGET_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PREFERENCES_TYPE,
//				new String[] { Privilege.OBJECT_SYSTEMUSER_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(TABLE_QUESTION_TO_CELL_QUESTION_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(TABLE_QUESTION_HEADER_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RAUSERINPUT_TO_SYSTEMUSER_TYPE, new String[] {
//				Privilege.OBJECT_ASSESSMENT_WORKON,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SURVEYLOCK_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_KEY_RISK_TARGET_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(VG_KEY_RISK_TARGET_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(VGPARAMETER_LIST_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TIME_SERIES_SCORE_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(PROCESSDEFINITION_REFERENCE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(OBJECT_FIELD_CHANGE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(DATAPOINT_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(DATAPOINTTYPE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(INFODATA_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_DATA_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(COMMENT_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(BINARYOBJECT_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(JOB_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(AUDIT_PROJECT_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RISKPROFILE_TYPE,
//				new String[] { Privilege.OBJECT_RISK_AUTHOR });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RISKPROFILE_TO_ASSET_TYPE, new String[] {
//				Privilege.OBJECT_RISK_AUTHOR, Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RISKPROFILE_TO_CATEGORY_TYPE, new String[] {
//				Privilege.OBJECT_RISK_AUTHOR,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_WORKON });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RISKPROFILE_TO_THREAT_TYPE, new String[] {
//				Privilege.OBJECT_RISK_AUTHOR,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_WORKON });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(RISKPROFILE_TO_RAMATRIX_TYPE, new String[] {
//				Privilege.OBJECT_RISK_AUTHOR,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_WORKON });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_THREAT_TYPE, new String[] {
//				Privilege.OBJECT_RISK_AUTHOR,
//				Privilege.OBJECT_ASSESSMENT_CREATE,
//				Privilege.OBJECT_ASSESSMENT_WORKON });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_RAMATRIX_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_RAMATRIXARCHIVE_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_CATEGORY_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL,
//						Privilege.OBJECT_ASSET_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(REFERENCE_KEY_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(EXCEPTED_POLICY_TYPE,
////				new String[] { });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(COMPENSATING_CONTROL_TYPE, new String[] {
//				Privilege.OBJECT_EXCEPTION_REQUEST,
//				Privilege.OBJECT_EXCEPTION_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(DEPLOYMENT_TYPE,
//				new String[] { Privilege.OBJECT_SERVER_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(INCIDENT_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_CREATE,
//						Privilege.OBJECT_INCIDENT_MANAGE,
//						Privilege.OBJECT_INCIDENT_UPDATE,
//						Privilege.OBJECT_ASSET_CREATE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(INCIDENT_DETAIL_TYPE, new String[] {
//						Privilege.OBJECT_INCIDENT_CREATE,
//						Privilege.OBJECT_INCIDENT_MANAGE,
//						Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(INCIDENT_DATA_TYPE, new String[] {
//						Privilege.OBJECT_INCIDENT_CREATE,
//						Privilege.OBJECT_INCIDENT_MANAGE,
//						Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(INCIDENT_SUBMITTER_TYPE, new String[] {
//						Privilege.OBJECT_INCIDENT_CREATE,
//						Privilege.OBJECT_INCIDENT_MANAGE,
//						Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(INCIDENT_TYPE_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_CREATE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(INCIDENT_SUBTYPE_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_CREATE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(INCIDENT_ACTION_TYPE,
//				new String[] { Privilege.OBJECT_INCIDENT_CREATE,
//				Privilege.OBJECT_INCIDENT_MANAGE,
//				Privilege.OBJECT_INCIDENT_UPDATE });
//		
//		// No real class
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_BATCH_EDIT_TYPE,
////				new String[] {  });
//		
//		// No real class
////		OBJECT_TYPE_TO_PC_MAP.put(DIFFABLE_OBJECT_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(OWNERSHIP_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(OWNERSHIP_TYPE_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_TENANT_CONFIGURE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(USER_PROFILE_TYPE, new String[] {
//				Privilege.OBJECT_CONTROL_AUTHOR,
//				Privilege.OBJECT_PROFILE_AUTHOR,
//				Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LANDINGPAGE_CONFIGURATION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(NAMEVALUE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(NAMEVALUETYPE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SCALE_TYPE,
//				new String[] { Privilege.OBJECT_TENANT_CONFIGURE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CACHE_VERSION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PORT_TO_ENDPOINT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SERVICE_TO_ENDPOINT_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_TO_ENDPOINT_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_MANAGE, Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_POLICY_COMPLIANCE_LINKED_SCORE_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSETINFORMATION_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_UPDATE, Privilege.OBJECT_ASSET_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDING_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDING_DETAIL_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDING_TYPE_FIELD_MAP_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSETPOLICYCOMPLIANCE_TO_FINDING_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDING_TYPE_FIELD_MAP_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDINGKEY_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SCAN_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSETPOLICYCOMPLIANCEHISTORY_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(FINDINGIDENTIFIERMAP_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(FINDINGTEMPLATE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_TENANT_CUSTOMIZATION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(FINDINGARCHIVE_TYPE,
//				new String[] { Privilege.OBJECT_DATAFEED_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSETPOLICYCOMPLIANCEARCHIVE_TO_FINDINGARCHIVE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(AGENTSTATISTICS_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CPE_EXTENSION_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SUMMARY_TABLE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CUSTOM_QUERY_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CWE_VIEW_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CWE_CATEGORY_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CWE_WEAKNESS_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CWE_RELATIONSHIP_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(USER_OBJECT_TEMPLATE_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_EXTENSION_TYPE, new String[] {
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE,
//				Privilege.OBJECT_TENANT_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP
//				.put(HIERARCHY_TYPE, new String[] {
//						Privilege.OBJECT_ASSET_MANAGE,
//						Privilege.OBJECT_INCIDENT_CREATE,
//						Privilege.OBJECT_INCIDENT_MANAGE,
//						Privilege.OBJECT_ASSET_CREATE,
//						Privilege.OBJECT_VENDOR_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ALERT_RULE_TYPE,
//				new String[] { Privilege.OBJECT_ALERTRULE_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ALERT_RECIPIENT_TYPE,
//				new String[] { Privilege.OBJECT_ALERTRULE_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(RABRANCHSURVEY_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIWORKSPACE_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIAPPLICATION_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIPAGE_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIPARAMETER_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIAPPLICATION_TO_UIPAGE_TYPE,
////				new String[] { });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UIWORKSPACE_TO_UIAPPLICATION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ASSET_TO_PATCH_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PATCH_TO_CPE_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ADDRESS_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ADDRESSLINK_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(SURVEY_CHANGE_NOTIFICATION_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(CCE_TYPE,
//				new String[] { Privilege.OBJECT_POLICY_AUTHOR,
//						Privilege.OBJECT_CONTROL_AUTHOR,
//						Privilege.OBJECT_PROFILE_AUTHOR,
//						Privilege.OBJECT_POLICY_MANAGE,
//						Privilege.OBJECT_CONTROL_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SURVEY_SUBMISSION_HISTORY_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(GAP_TYPE, new String[] {
//				Privilege.OBJECT_FINDING_CREATE,
//				Privilege.OBJECT_FINDING_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(GAP_OBJECT_TYPE,
//				new String[] { Privilege.OBJECT_FINDING_CREATE,
//				Privilege.OBJECT_FINDING_UPDATE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LOCK_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LOCKEVENT_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LOCKRECOVERY_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(ASSET_SCORE_CHANGE_EVENT_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(WORKFLOW_HISTORY_ENTRY_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(VULNERABILITY_SCAN_TYPE, new String[] {
//				Privilege.OBJECT_ASSET_MANAGE, Privilege.OBJECT_ASSET_UPDATE,
//				Privilege.OBJECT_ASSET_UPDATEALL,
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(AGL_CRITERION_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(QUANTITATIVE_LABEL_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(IMPACT_DEFINITION_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(LIKELIHOOD_DEFINITION_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(AUDIT_PROJECT_TO_POLICY_SET_TYPE,
//				new String[] { Privilege.OBJECT_ASSET_MANAGE,
//				Privilege.OBJECT_ASSET_UPDATEALL });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(UPDATE_OBJECT_TYPE,
////				new String[] {  }); 	
//		
//		OBJECT_TYPE_TO_PC_MAP.put(WORKFLOW_SELECTION_CRITERIA_TYPE,
//				new String[] { Privilege.OBJECT_WORKFLOW_UPDATE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(ECTOCONTROLMAP_TYPE, new String[] {
//				Privilege.OBJECT_PROJECT_UPDATE,
//				Privilege.OBJECT_PROJECT_MANAGE,
//				Privilege.OBJECT_SURVEY_ANSWER, Privilege.OBJECT_SURVEY_AUTHOR,
//				Privilege.OBJECT_SURVEY_REVIEW });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(LDAP_TEAM_HOST_TYPE,
//				new String[] { Privilege.OBJECT_TEAM_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(LDAP_TEAM_USER_TYPE,
//				new String[] { Privilege.OBJECT_TEAM_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(LDAP_TEAM_SYNC_TYPE,
//				new String[] { Privilege.OBJECT_TEAM_MANAGE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(DEPLOYMENT_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(CONNECTED_AGENT_TYPE,
////				new String[] {  });
//		
//		// No real class.
////		OBJECT_TYPE_TO_PC_MAP.put(CPE_BATCH_EDIT_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(CPEIDENTIFICATION_TYPE, new String[] {
//				Privilege.OBJECT_VULNERABILITY_CREATE,
//				Privilege.OBJECT_VULNERABILITY_MANAGE,
//				Privilege.OBJECT_VULNERABILITY_UPDATE });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(QUESTIONNAIRE_TYPE,
////				new String[] {  });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(APPLICATION_ACCESS_DELEGATION_TYPE,
//				new String[] { Privilege.OBJECT_SYSTEMUSER_MANAGE,
//						Privilege.OBJECT_SYSTEMUSER_ACCESSDELEGATION });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(AGENT_TYPE, new String[] {
//				Privilege.OBJECT_CONNECTOR_MANAGE,
//				Privilege.OBJECT_SYSTEMUSER_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PUBLISHED_ASSET_POLICY_COMPLIANCE_TYPE,
//				new String[] { Privilege.OBJECT_PROJECT_UPDATE,
//						Privilege.OBJECT_PROJECT_MANAGE,
//						Privilege.OBJECT_ASSESSMENT_CREATE,
//						Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(PUBLISHED_ASSET_POLICY_COMPLIANCE_ARCHIVE_TYPE,
//				new String[] { Privilege.OBJECT_PROJECT_UPDATE,
//						Privilege.OBJECT_PROJECT_MANAGE,
//						Privilege.OBJECT_ASSESSMENT_CREATE,
//						Privilege.OBJECT_ASSESSMENT_MANAGE });
//		
//		OBJECT_TYPE_TO_PC_MAP.put(TICKET_CHANGE_TYPE,
//				new String[] { Privilege.OBJECT_TICKET_CREATE,
//				Privilege.OBJECT_TICKET_MANAGE,
//				Privilege.OBJECT_TICKET_UPDATE,
//				Privilege.OBJECT_TICKET_CLASSIFY,
//				Privilege.OBJECT_TICKET_MANAGEOBJECTS });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(AUDITLOGCONFIG_TYPE,
////				new String[] {  });
//		
////		OBJECT_TYPE_TO_PC_MAP.put(SYSTEM_USER_ACTION_ARCHIVE_TYPE,
////				new String[] {  });

	}

	/**
	 * Get the object type from the id. The type of the object is encoded in the
	 * high 12 bits of the id.
	 * 
	 * @param id id
	 * @return object type
	 */
	public static short getObjectTypeFromId(long id) {
		return new Long(id >> 52).shortValue();
	}

	// Get objectType from idString. Returns -1 if unknown...
	public static short getObjectTypeFromIdString(String idString) {
		if (StrUtil.isEmpty(idString) || "null".equals(idString)) {
			return -1; // Invalid Id
		}

		long objID;
		try {
			objID = Long.parseLong(idString);
			return getObjectTypeFromId(objID);
		} catch (NumberFormatException ex) {
			try {
				// Attempt parse of GUID for agents
				String[] parts = idString.split("[-,_]");
				for (String s : parts) {
					Long.parseLong(s, 16);
				}
				// Following dosen't work - Causes overflow
//                idString = idString.replace("-", "");
//                objID = Long.valueOf(idString, 16).longValue();
			} catch (NumberFormatException ex2) {
				return -1;
			}

			return USER_TYPE;
		}
	}

	public static Short getObjectTypeFromObjectClass(String objectClass) {
		// if the object type doesn't have real class type
		Short objectType = OBJECT_CLASS_TO_TYPE_MAP.get(objectClass);
		if (objectType != null)
			return objectType;
		if (!objectClass.startsWith("com.agiliance.dal.model.")) {
			objectClass = "com.agiliance.dal.model." + objectClass;
		}
		return OBJECT_CLASS_TO_TYPE_MAP.get(objectClass);
	}

	public static String getObjectClassNameFromId(long id) {
		return OBJECT_TYPE_TO_CLASS_MAP.get(getObjectTypeFromId(id));
	}

	public static String getObjectClassNameFromObjectType(short type) {
		return OBJECT_TYPE_TO_CLASS_MAP.get(type);
	}

	public static String getObjectSimpleClassNameFromId(long id) {
		return getObjectSimpleClassNameFromObjectType(getObjectTypeFromId(id));
	}

	public static String getObjectSimpleClassNameFromObjectType(short objectType) {
		String className = OBJECT_TYPE_TO_CLASS_MAP.get(objectType);

		if (StrUtil.isEmpty(className)) {
			return null;
		}

		if (className.startsWith("com.agiliance.dal.model.")) {
			className = className.substring(24);
		} else if (className.startsWith("com.agiliance.platform.")) {
			className = className.substring(23);
		} else if (className.startsWith("com.agiliance.admin.scheduler.")) {
			className = className.substring(30);
		}
		return className;
	}

	public static String getDAOClassNameFromId(String idString) {
		if (StrUtil.isEmpty(idString) || "null".equals(idString)) {
			return null; // Invalid Id
		}

		long objID;
		try {
			objID = Long.parseLong(idString);
			String simpleClassName = getObjectSimpleClassNameFromId(objID);
			if (StrUtil.isEmpty(simpleClassName)) {
				return null;
			}
			return "com.agiliance.dal.dao." + simpleClassName + "DAO";
		} catch (NumberFormatException ex) {
			return null;
		}
	}

	public static String getObjectTypeNameFromObjectType(short objectType) {
		String fullName = OBJECT_TYPE_TO_CLASS_MAP.get(objectType);
		if (StrUtil.isEmpty(fullName)) {
			return null;
		}
		int idx = fullName.lastIndexOf('.');
		return fullName.substring(idx + 1);
	}

	public static String getObjectTypeNameFromObjectId(long objId) {
		return getObjectTypeNameFromObjectType(getObjectTypeFromId(objId));
	}

	public static String getObjectTypeNameFromObjectIdString(String idString) {
		return getObjectTypeNameFromObjectType(getObjectTypeFromIdString(idString));
	}

	// ==========================================================================
	// private helpers
	// ==========================================================================
	// print the info of the class
	private static void printInfo(String cName) {
		Short type = OBJECT_CLASS_TO_TYPE_MAP.get(cName);

		if (null == type) {
			System.out.println("Invalid object class name [" + cName + "]");
		} else {
			System.out.println(cName + "\t" + type + "\t" + getInitialSequenceNumber(cName));
		}
	}

	// ==========================================================================
	// main driver
	// ==========================================================================
	/**
	 * Prints the object class names, IDs, and starting sequence numbers. If a class
	 * name is provided, the info for that object is printed. Otherwise all objects
	 * info are printed
	 *
	 * @param args arguments
	 * @throws Exception exception
	 */
	/*
	 * public static void main(String[] args) throws Exception {
	 * 
	 * }
	 */
}
