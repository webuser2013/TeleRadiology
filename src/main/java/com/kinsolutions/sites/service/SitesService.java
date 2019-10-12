package com.kinsolutions.sites.service;

import java.util.List;

import com.kinsolutions.model.Sites;

public interface SitesService {

	public Sites getSiteBySiteId(Integer siteId);

	public Sites saveOrUpdateSites(Sites site);

	public boolean isSiteExists(String siteName);

	public List<Sites> getAllSites();
	
	public List<Sites> getSiteBySiteInfo(String siteName,String memberShiptype,int privilegeCd);

}
