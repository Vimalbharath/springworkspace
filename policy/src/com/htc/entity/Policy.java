package com.htc.entity;

import java.util.Objects;

public class Policy {
	public String policyNo;
	public String policyHolderName;
	public double premiumAmount;
	public String status;
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Policy(String policyNo, String policyHolderName, double premiumAmount, String status) {
		super();
		this.policyNo = policyNo;
		this.policyHolderName = policyHolderName;
		this.premiumAmount = premiumAmount;
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(policyHolderName, policyNo, premiumAmount, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		return Objects.equals(policyHolderName, other.policyHolderName) && Objects.equals(policyNo, other.policyNo)
				&& Double.doubleToLongBits(premiumAmount) == Double.doubleToLongBits(other.premiumAmount)
				&& Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "Policy [policyNo=" + policyNo + ", policyHolderName=" + policyHolderName + ", premiumAmount="
				+ premiumAmount + ", status=" + status + "]";
	}
	
}
