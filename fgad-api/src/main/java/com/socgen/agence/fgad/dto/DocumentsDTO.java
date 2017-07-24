package com.socgen.agence.fgad.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentsDTO {

	private String docType;
	private String businessReference;
	private String clientReference;
	private String collectionType;
	private String branchReference;
	private String pageCount;
	private String validityDate;
	private String caseReference;
	private String accountReference;
	private String addData;
	private String documentDate;
	private String scope;
	private String fileName;
	private String clientId;
	private String docElectronicSign;
	private String clientRestit;
	private String probativeDoc;
	private String cacheCopy;
	private String docContent;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getBusinessReference() {
		return businessReference;
	}

	public void setBusinessReference(String businessReference) {
		this.businessReference = businessReference;
	}

	public String getClientReference() {
		return clientReference;
	}

	public void setClientReference(String clientReference) {
		this.clientReference = clientReference;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getBranchReference() {
		return branchReference;
	}

	public void setBranchReference(String branchReference) {
		this.branchReference = branchReference;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(String validityDate) {
		this.validityDate = validityDate;
	}

	public String getCaseReference() {
		return caseReference;
	}

	public void setCaseReference(String caseReference) {
		this.caseReference = caseReference;
	}

	public String getAccountReference() {
		return accountReference;
	}

	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}

	public String getAddData() {
		return addData;
	}

	public void setAddData(String addData) {
		this.addData = addData;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getClientId() {
		return clientId;
	}
}
