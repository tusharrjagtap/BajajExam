package com.app.service;

import java.util.List;

import com.app.pojos.Staff;

public interface IStaffService {
	List<Staff> getAllStaffs();
	Staff addOrUpdateStaffDetails(Staff transientStaff);
	String deleteStaffDetails(int id);
	Staff fetchStaffDetails(int StaffId);
}
