package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月17日
 */
public class Export implements Serializable {
	private String id;
	private Date inputDate;
	
	private String epnum;
	private String extnum;
	
	private String contractIds;			//打断设计，合同的ID集合
	private String customerContract;	//合同或确认书号
	private String lcno;				//信用证号
	private String consignee;			//收货人及地址
	private String marks;				//唛头
	private String remark;
	private String shipmentPort;		//装运港
	private String destinationPort;		//目的港
	private String transportMode;		//运输方式
	private String priceCondition;		//价格条件
	private Integer state;				//0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务
	private Double grossWeight;			//毛重	
	private Double netWeight;			//净重
	private Double measurement;			//体积
	
	private String createBy;
	private String createDept;
	private java.util.Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getContractIds() {
		return contractIds;
	}
	public void setContractIds(String contractIds) {
		this.contractIds = contractIds;
	}
	public String getCustomerContract() {
		return customerContract;
	}
	public void setCustomerContract(String customerContract) {
		this.customerContract = customerContract;
	}
	public String getLcno() {
		return lcno;
	}
	public void setLcno(String lcno) {
		this.lcno = lcno;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getShipmentPort() {
		return shipmentPort;
	}
	public void setShipmentPort(String shipmentPort) {
		this.shipmentPort = shipmentPort;
	}
	public String getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(String destinationPort) {
		this.destinationPort = destinationPort;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getPriceCondition() {
		return priceCondition;
	}
	public void setPriceCondition(String priceCondition) {
		this.priceCondition = priceCondition;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(Double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public Double getNetWeight() {
		return netWeight;
	}
	public void setNetWeight(Double netWeight) {
		this.netWeight = netWeight;
	}
	public Double getMeasurement() {
		return measurement;
	}
	public void setMeasurement(Double measurement) {
		this.measurement = measurement;
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
	public String getEpnum() {
		return epnum;
	}
	public void setEpnum(String epnum) {
		this.epnum = epnum;
	}
	public String getExtnum() {
		return extnum;
	}
	public void setExtnum(String extnum) {
		this.extnum = extnum;
	}
	
	
}
