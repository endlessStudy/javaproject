package cn.itcast.jk.vo;

import java.util.List;

import cn.itcast.jk.domain.ContractProduct;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月11日
 */
public class ContractVO {
	private String id;
	
	private List<ContractProductVO> contractProducts;		//货物的集合
	
	private String cpnum;
	private String extnum;
	
	private String offeror;
	private String contractNo;
	private java.util.Date signingDate;
	private String inputBy;
	private String checkBy;
	private String inspector;
	private Double totalAmount;
	private Integer importNum;
	private String crequest;
	private String customName;
	private java.util.Date deliveryPeriod;
	private java.util.Date shipTime;
	private String tradeTerms;
	private String remark;
	private String printStyle;
	private Integer oldState;
	private Integer state;
	private Integer outState;

	private String createBy;
	private String createDept;
	private java.util.Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOfferor() {
		return offeror;
	}
	public void setOfferor(String offeror) {
		this.offeror = offeror;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public java.util.Date getSigningDate() {
		return signingDate;
	}
	public void setSigningDate(java.util.Date signingDate) {
		this.signingDate = signingDate;
	}
	public String getInputBy() {
		return inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}
	public String getCheckBy() {
		return checkBy;
	}
	public void setCheckBy(String checkBy) {
		this.checkBy = checkBy;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getImportNum() {
		return importNum;
	}
	public void setImportNum(Integer importNum) {
		this.importNum = importNum;
	}
	public String getCrequest() {
		return crequest;
	}
	public void setCrequest(String crequest) {
		this.crequest = crequest;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public java.util.Date getDeliveryPeriod() {
		return deliveryPeriod;
	}
	public void setDeliveryPeriod(java.util.Date deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}
	public java.util.Date getShipTime() {
		return shipTime;
	}
	public void setShipTime(java.util.Date shipTime) {
		this.shipTime = shipTime;
	}
	public String getTradeTerms() {
		return tradeTerms;
	}
	public void setTradeTerms(String tradeTerms) {
		this.tradeTerms = tradeTerms;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPrintStyle() {
		return printStyle;
	}
	public void setPrintStyle(String printStyle) {
		this.printStyle = printStyle;
	}
	public Integer getOldState() {
		return oldState;
	}
	public void setOldState(Integer oldState) {
		this.oldState = oldState;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOutState() {
		return outState;
	}
	public void setOutState(Integer outState) {
		this.outState = outState;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDept() {
		return createDept;
	}
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getCpnum() {
		return cpnum;
	}
	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}
	public String getExtnum() {
		return extnum;
	}
	public void setExtnum(String extnum) {
		this.extnum = extnum;
	}
	public List<ContractProductVO> getContractProducts() {
		return contractProducts;
	}
	public void setContractProducts(List<ContractProductVO> contractProducts) {
		this.contractProducts = contractProducts;
	}
	
}
