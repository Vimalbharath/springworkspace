package com.htc.dao;

import java.util.ArrayList;
import java.util.List;

import com.htc.entity.Policy;
import com.htc.exceptions.PolicyNotFoundException;

public interface PolicyProviderInterface {
	public boolean addPolicy(Policy policy);

	public boolean removePolicy(Policy policy) throws PolicyNotFoundException;

	public ArrayList<Policy> showAllPolicy();

	public boolean updatePremiumAmount(String policyId, double newCost) throws PolicyNotFoundException;

}