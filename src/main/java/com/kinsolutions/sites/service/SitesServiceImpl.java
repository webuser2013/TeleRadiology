package com.kinsolutions.sites.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kinsolutions.constants.AppConstants;
import com.kinsolutions.model.Sites;
import com.kinsolutions.sites.dao.SitesDao;

@Service
public class SitesServiceImpl implements SitesService {
	
	@Autowired
	private SitesDao siteDao;

	@Override
	public Sites getSiteBySiteId(Integer siteId) {
		return siteDao.getSiteBySiteId(siteId);
	}

	@Override
	public Sites saveOrUpdateSites(Sites site) {
		if(site != null){			
			if(site.getSiteId() != null && site.getSiteId() > 0) {
				//Update object
				site.setModifiedDate(new Date());
  			} else {
  				site.setPrivilegeCd(AppConstants.PRIVILEGECD_STATUS_ACTIVE);
  				site.setCreatedDate(new Date());
  				site.setModifiedDate(new Date());
 			}
		}
		return siteDao.saveOrUpdateSites(site);
	}

	@Override
	public boolean isSiteExists(String siteName) {
		return siteDao.isSiteExists(siteName);
	}

	@Override
	public List<Sites> getAllSites() {
		return siteDao.getAllSites();
	}

	@Override
	public List<Sites> getSiteBySiteInfo(String siteName, String memberShiptype, int privilegeCd) {
		return siteDao.getSiteBySiteInfo(siteName,memberShiptype,privilegeCd);
	}

}
