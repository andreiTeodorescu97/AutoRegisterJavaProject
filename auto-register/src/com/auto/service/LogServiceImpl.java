package com.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auto.dao.LogDAO;
import com.auto.entity.Log;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDAO logDAO;
	
	@Override
	@Transactional
	public void addLogToDatabase(String logType, String logMessage) {
		logDAO.addLogToDatabase(logType,logMessage);

	}

	@Override
	@Transactional
	public List<Log> getLogsFromDatabase() {
		return logDAO.getLogsFromDatabase();
	}

}
